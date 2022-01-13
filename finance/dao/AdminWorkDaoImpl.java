package com.dtfinance.ltd.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dtfinance.ltd.finance.model.AdminWork;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AdminWorkResponseBean;

@Repository
public class AdminWorkDaoImpl implements AdminWorkDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private AdminWorkRepository adminWorkRepository;
	
	@Autowired
	private AdminWorkResponseBean adminWorkResponseBean;

	@Override
	public AdminWorkResponseBean getAllCustomerDetails(int offset, int limit) {
		List<AdminWork> adminWorkReportList = adminWorkRepository.getCustomerDetails(offset,limit);
		adminWorkReportList.stream().forEach(data -> {
			String dateValue = data.getCollection_date();
			data.setCollection_date(dateValue.substring(0, 10));
			if(data.getGiven_date() !=null) {
				String givenDate= data.getGiven_date();
				data.setGiven_date(givenDate.substring(0, 10));
			}
		});
		int dataSize = getDataCount();
		adminWorkResponseBean.setDataList(adminWorkReportList);
		adminWorkResponseBean.setDataSize(dataSize);
		return adminWorkResponseBean;
	}
	
	private int getDataCount() {
		return (int) adminWorkRepository.count();
	}

	@Override
	public AdminWork getSingleCustomerData(int customer_id) {
		return adminWorkRepository.getSingleCustomerData(customer_id);
	}

	@Override
	public ResponseEntity<FinanceStatus> deleteCustomerData(int cust_id) {
			adminWorkRepository.deleteCustomerData(cust_id);
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<FinanceStatus> insertAdminWorkData(AdminWork adminWork) {
		entityManager.createNativeQuery("insert into admin_work(customer_id,customer_name,emi,collection_date,previous_balance,current_balance,received_amount,"
				+ "balance,status,given_date,agent_id)values(?,?,?,to_date(?,'yyyy/mm/dd'),?,?,?,?,?,to_date(?,'yyyy/mm/dd'),?)").
		setParameter(1, adminWork.getCustomer_id()).setParameter(2, adminWork.getCustomer_name()).setParameter(3, adminWork.getEmi())
		.setParameter(4, adminWork.getCollection_date()).setParameter(5, adminWork.getPrevious_balance()).setParameter(6, adminWork.getCurrent_balance()).
		setParameter(7, adminWork.getReceived_amount()).setParameter(8, adminWork.getBalance()).setParameter(9,adminWork.getStatus())
		.setParameter(10, adminWork.getGiven_date()).setParameter(11, adminWork.getAgent_id()).executeUpdate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

}
