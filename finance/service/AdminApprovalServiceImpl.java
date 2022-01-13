package com.dtfinance.ltd.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dtfinance.ltd.finance.dao.AdminApprovalDao;
import com.dtfinance.ltd.finance.model.AdminApproval;
import com.dtfinance.ltd.finance.model.DailyReport;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AdminApprovalResponseBean;

@Service
public class AdminApprovalServiceImpl implements AdminApprovalService{
	
	@Autowired
	private AdminApprovalDao adminApprovalDao;

	@Override
	public AdminApprovalResponseBean getAllUserDetails() {
		return adminApprovalDao.getAllUserDetails();
	}

	@Override
	public ResponseEntity<FinanceStatus> adminApprove(int cust_id){
		return adminApprovalDao.adminApprove(cust_id);
	}

	@Override
	public ResponseEntity<FinanceStatus> insertApprovalData(AdminApproval adminApproval) {
		return adminApprovalDao.insertApprovalData(adminApproval);
	}

}
