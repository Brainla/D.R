package com.dtfinance.ltd.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.dtfinance.ltd.finance.api.AdminApprovalController;
import com.dtfinance.ltd.finance.model.AdminApproval;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AdminApprovalResponseBean;
import com.dtfinance.ltd.finance.service.AdminApprovalService;

@RestController
@CrossOrigin
public class AdminApprovalControllerImpl implements AdminApprovalController{

	@Autowired
	private AdminApprovalService adminApprovalService;
	
	@Override
	public AdminApprovalResponseBean getAllUserDetails() {
		 return adminApprovalService.getAllUserDetails();
	}

	@Override
	public ResponseEntity<FinanceStatus> adminApprove(int cust_id){
		return adminApprovalService.adminApprove(cust_id);
	}

	@Override
	public ResponseEntity<FinanceStatus> insertApprovalData(AdminApproval adminApproval) {
		return adminApprovalService.insertApprovalData(adminApproval);
	}

}
