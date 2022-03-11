package com.dtfinance.ltd.finance.service;

import org.springframework.http.ResponseEntity;

import com.dtfinance.ltd.finance.model.AdminApproval;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AdminApprovalResponseBean;

public interface AdminApprovalService {
	
	public AdminApprovalResponseBean getAllUserDetails();
	
	public ResponseEntity<FinanceStatus> adminApprove(int cust_id);
	
	public ResponseEntity<FinanceStatus> insertApprovalData(AdminApproval adminApproval);

}
