package com.dtfinance.ltd.finance.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dtfinance.ltd.finance.model.AdminApproval;
import com.dtfinance.ltd.finance.model.AdminWork;
import com.dtfinance.ltd.finance.model.DailyWork;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.model.MonthlyReport;
import com.dtfinance.ltd.finance.response_model.DailyWorkResponseBean;

@Repository
public class DailyWorkDaoImpl implements DailyWorkDao{

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ReportRepository reportRepository;
	
	@Autowired
	private DailyWorkResponseBean dailyWorkResponseBean;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public DailyWorkResponseBean getAllCustomerDetails(String date,int agent_id,int offset,int limit) {
		List<Integer> customerIdList = new ArrayList<>();
		List<DailyWork> dailyWorks = customerRepository.getCustomerDetails(date,agent_id,offset,limit);
		dailyWorks.stream().forEach(data -> {
			String dateValue = data.getCollection_date();
			data.setCollection_date(dateValue.substring(0, 10));
			if(data.getGiven_date() !=null) {
				String givenDate= data.getGiven_date();
				data.setGiven_date(givenDate.substring(0, 10));
			}
			customerIdList.add(data.getCustomer_id());
		});
		int tableSize = getCustomerCount(date,agent_id);
		dailyWorkResponseBean.setDataSize(tableSize);
		dailyWorkResponseBean.setDataList(dailyWorks);
		return dailyWorkResponseBean;
	}
	
	@Override
	@Transactional
	public ResponseEntity<FinanceStatus> updateNewCustomers(String date,int agent_id) {
		entityManager.createNativeQuery("update daily_work set status=null where (collection_date=to_date(?,'yyyy/mm/dd') or given_date=to_date(?,'yyyy/mm/dd'))"
				+ "and agent_id=? and status='N'").setParameter(1, date).setParameter(2,date).setParameter(3,agent_id).executeUpdate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
				 
	}
	
	private int getCustomerCount(String date,int agent_id) {
		return customerRepository.getCustomerCount(date,agent_id);
	}


	@Override
	public DailyWork getSingleCustomerData(int agent_id,int cust_id) {
		return customerRepository.getSingleCustomerData(agent_id,cust_id);
	}

	@Override
	public ResponseEntity<FinanceStatus> adminStausUpdate(AdminApproval adminApproval) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("admin_approval");
		EntityManager em=emf.createEntityManager();  
		try {
			em.getTransaction().begin();
			em.persist(adminApproval);
			em.getTransaction().commit();	
		}finally {
			emf.close();  
			em.close();  			
		}
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<FinanceStatus> updateDailyWork(DailyWork dailyWork) {
		balanceAmountUpdate(dailyWork);
		entityManager.createNativeQuery("update daily_work set emi=?,collection_date=to_date(?,'yyyy/mm/dd'),previous_balance=?,"
				+ "current_balance=?,received_amount=?,balance=?,status=?,given_date=to_date(?,'yyyy/mm/dd'),agent_id=? where customer_id=?").
		setParameter(1, dailyWork.getEmi()).setParameter(2, dailyWork.getCollection_date()).setParameter(3, dailyWork.getPrevious_balance()).setParameter(4, dailyWork.getCurrent_balance()).
		setParameter(5, dailyWork.getReceived_amount()).setParameter(6, dailyWork.getBalance()).setParameter(7,dailyWork.getStatus()).setParameter(8, dailyWork.getGiven_date())
		.setParameter(9, dailyWork.getAgent_id()).setParameter(10, dailyWork.getCustomer_id()).executeUpdate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}
	
	private void balanceAmountUpdate(DailyWork dailyWork) {
		int emi = 5000;
		LocalDate currentdate = LocalDate.now();
		int month=currentdate.getMonth().getValue();
		int year=currentdate.getYear();
		String[] dateArray = dailyWork.getGiven_date().split("-");
		
		if(Integer.parseInt(dateArray[1]) > month
				|| Integer.parseInt(dateArray[0]) > year) {
			int previousBalance = dailyWork.getPrevious_balance()+dailyWork.getCurrent_balance();
			dailyWork.setPrevious_balance(previousBalance);
			if(Integer.parseInt(dateArray[1]) == currentdate.getDayOfMonth()) {
				dailyWork.setCurrent_balance(emi);
			}else {
				dailyWork.setCurrent_balance(0);
			}
			
		} 
	}

	@Override
	public List<DailyWork> customerDataDownload(int agent_id) {
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis);
		return customerRepository.customerDataDownload(date.toString(),agent_id);
		
	}
	
	@Override
	public ResponseEntity<FinanceStatus> adminWorkUpdate(AdminWork adminWork) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("admin_approval");
		EntityManager em=emf.createEntityManager();  
		try {
			em.getTransaction().begin();
			em.persist(adminWork);
			em.getTransaction().commit();	
		}finally {
			emf.close();  
			em.close();  			
		}
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

	@Override
	@Transactional
	public void updateEMIandDate(DailyWork dailyWork) {
		String collection_date="2022-02-15";
		entityManager.createNativeQuery("update daily_work set status=null,current_balance=?,previous_balance=0,received_amount=0,collection_date=to_date(?,'yyyy/mm/dd'),given_date=null"
				+ "where customer_id=?").setParameter(1, dailyWork.getEmi()).setParameter(2, collection_date).setParameter(3,dailyWork.getCustomer_id()).executeUpdate();
	}
}
