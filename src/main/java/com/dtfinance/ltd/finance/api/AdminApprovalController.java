package com.dtfinance.ltd.finance.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dtfinance.ltd.finance.model.AdminApproval;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AdminApprovalResponseBean;

@RequestMapping("/admin-approval")
public interface AdminApprovalController {
	
	@GetMapping
	@RequestMapping("/all-user-details")
	public AdminApprovalResponseBean getAllUserDetails();
	
	@PostMapping
	@RequestMapping("/delete")
	public ResponseEntity<FinanceStatus> adminApprove(@RequestParam(name="cust_id")int cust_id);
	
	@PostMapping
	@RequestMapping("/insert")
	public ResponseEntity<FinanceStatus> insertApprovalData(@RequestBody AdminApproval adminApproval);

}
