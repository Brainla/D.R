package com.dtfinance.ltd.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dtfinance.ltd.finance.model.AdminApproval;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AdminApprovalResponseBean;

@Repository
public class AdminApprovalDaoImpl implements AdminApprovalDao{
	
	@Autowired
	private AdminDataRepository adminDataRepository;
	
	@Autowired
	private AdminApprovalResponseBean adminApprovalResponseBean;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public AdminApprovalResponseBean getAllUserDetails() {
		List<AdminApproval> adminApprovalList = adminDataRepository.findAll();
		int dataCount = getDataCount();
		adminApprovalResponseBean.setDataList(adminApprovalList);
		adminApprovalResponseBean.setDataSize(dataCount);
		return adminApprovalResponseBean;
	}
	
	private int getDataCount() {
		return (int) adminDataRepository.count();
	}

	@Override
	public ResponseEntity<FinanceStatus> adminApprove(int cust_id) {
		adminDataRepository.deleteById(cust_id);
		updateEMIDate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}
	
	public void updateEMIDate() {
		
	}

	@Override
	@Transactional
	public ResponseEntity<FinanceStatus> insertApprovalData(AdminApproval adminApproval) {
		entityManager.createNativeQuery("insert into admin_approval(customer_id,customer_name,emi,collection_date,previous_balance,current_balance,received_amount,"
				+ "balance,status,given_date,agent_id) values(?,?,?,to_date(?,'yyyy/mm/dd'),?,?,?,?,?,to_date(?,'yyyy/mm/dd'),?)").
		setParameter(1, adminApproval.getCustomer_id()).setParameter(2, adminApproval.getCustomer_name()).setParameter(3, adminApproval.getEmi())
		.setParameter(4, adminApproval.getCollection_date()).setParameter(5, adminApproval.getPrevious_balance()).setParameter(6, adminApproval.getCurrent_balance()).
		setParameter(7, adminApproval.getReceived_amount()).setParameter(8, adminApproval.getBalance()).setParameter(9,adminApproval.getStatus())
		.setParameter(10, adminApproval.getGiven_date()).setParameter(11, adminApproval.getAgent_id()).executeUpdate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

}
