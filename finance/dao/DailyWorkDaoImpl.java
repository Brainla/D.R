package com.dtfinance.ltd.finance.dao;

import java.sql.Date;
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
		List<DailyWork> dailyWorks = customerRepository.getCustomerDetails(date,agent_id,offset,limit);
		dailyWorks.stream().forEach(data -> {
			String dateValue = data.getCollection_date();
			data.setCollection_date(dateValue.substring(0, 10));
			if(data.getGiven_date() !=null) {
				String givenDate= data.getGiven_date();
				data.setGiven_date(givenDate.substring(0, 10));
			}
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
		entityManager.createNativeQuery("update daily_work set emi=?,collection_date=to_date(?,'yyyy/mm/dd'),previous_balance=?,"
				+ "current_balance=?,received_amount=?,balance=?,status=?,given_date=to_date(?,'yyyy/mm/dd'),agent_id=? where customer_id=?").
		setParameter(1, dailyWork.getEmi()).setParameter(2, dailyWork.getCollection_date()).setParameter(3, dailyWork.getPrevious_balance()).setParameter(4, dailyWork.getCurrent_balance()).
		setParameter(5, dailyWork.getReceived_amount()).setParameter(6, dailyWork.getBalance()).setParameter(7,dailyWork.getStatus()).setParameter(8, dailyWork.getGiven_date())
		.setParameter(9, dailyWork.getAgent_id()).setParameter(10, dailyWork.getCustomer_id()).executeUpdate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<FinanceStatus> updateMonthlyReportData(MonthlyReport reportData) {
		entityManager.createNativeQuery("update monthly_report set emi=?,collection_date=to_date(?,'yyyy/mm/dd'),previous_balance=?,"  
								+ "current_balance=?,received_amount=?,balance=?,given_date=to_date(?,'yyyy/mm/dd'),agent_id=?,date_1=?,date_2=?,date_3=?,date_4=?,date_5=?,"
								+ "date_6=?,date_7=?,date_8=?,date_9=?,date_10=?,date_11=?,date_12=?,date_13=?,date_14=?,date_15=?,date_16=?,date_17=?,date_18=?,date_19=?,date_20=?,date_21=?,"
								+ "date_22=?,date_23=?,date_24=?,date_25=?,date_26=?,date_27=?,date_28=?,date_29=?,date_30=?,date_31=? where customer_id=?").setParameter(1, reportData.getEmi()).setParameter(2, reportData.getCollection_date()).setParameter(3, reportData.getPrevious_balance()).setParameter(4, reportData.getCurrent_balance()).
		setParameter(5, reportData.getReceived_amount()).setParameter(6, reportData.getBalance()).setParameter(7, reportData.getGiven_date()).setParameter(8, reportData.getAgent_id()).setParameter(9, reportData.getDate_1()).setParameter(10, reportData.getDate_2())
		.setParameter(11, reportData.getDate_3()).setParameter(12, reportData.getDate_4()).setParameter(13, reportData.getDate_5()).setParameter(14, reportData.getDate_6()).setParameter(15, reportData.getDate_7()).setParameter(16, reportData.getDate_8())
		.setParameter(17, reportData.getDate_9()).setParameter(18, reportData.getDate_10()).setParameter(19, reportData.getDate_11()).setParameter(20, reportData.getDate_12()).setParameter(21, reportData.getDate_13()).setParameter(22, reportData.getDate_14()).setParameter(23, reportData.getDate_15())
		.setParameter(24, reportData.getDate_16()).setParameter(25, reportData.getDate_17()).setParameter(26, reportData.getDate_18()).setParameter(27, reportData.getDate_19()).setParameter(28, reportData.getDate_20()).setParameter(29, reportData.getDate_21())
		.setParameter(30, reportData.getDate_22()).setParameter(31, reportData.getDate_23()).setParameter(32, reportData.getDate_24()).setParameter(33, reportData.getDate_25()).setParameter(34, reportData.getDate_26()).setParameter(35, reportData.getDate_27())
		.setParameter(36, reportData.getDate_28()).setParameter(37, reportData.getDate_29()).setParameter(38, reportData.getDate_30()).setParameter(39, reportData.getDate_31()).setParameter(40, reportData.getCustomer_id()).executeUpdate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
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
}
