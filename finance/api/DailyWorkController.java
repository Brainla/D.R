package com.dtfinance.ltd.finance.api;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dtfinance.ltd.finance.model.AdminApproval;
import com.dtfinance.ltd.finance.model.AdminWork;
import com.dtfinance.ltd.finance.model.DailyWork;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.model.MonthlyReport;
import com.dtfinance.ltd.finance.response_model.DailyWorkResponseBean;

@RequestMapping("/daily-work")
public interface DailyWorkController {
	
	@GetMapping
	@RequestMapping("/all-customer-details")
	public DailyWorkResponseBean getAllCustomerDetails(@RequestParam(name="agent_id") int agent_id,@RequestParam(name="offset")int offset,
			@RequestParam(name="limit")int limit);
	
	@GetMapping
	@RequestMapping("/customer-details/download")
	public ResponseEntity<Resource> customerDataDownload(@RequestParam(name="agent_id") int agent_id);
	
	@GetMapping
	@RequestMapping(value = "/single-custromer-details")
	public DailyWork getSingleCustomerData(@RequestParam(name="agent_id") int agent_id,@RequestParam(name="cust_id") int customer_id);
	
	@PostMapping
	@RequestMapping(value = "/payment-approval")
	public ResponseEntity<FinanceStatus> adminStausUpdate(@RequestBody AdminApproval adminApproval);
	
	@PostMapping
	@RequestMapping(value = "/update")
	public ResponseEntity<FinanceStatus> updateDailyWork(@RequestBody DailyWork dailyWork);
	
	@PostMapping
	@RequestMapping(value = "/admin-work")
	public ResponseEntity<FinanceStatus> adminWorkUpdate(@RequestBody AdminWork adminWork);

	@PostMapping
	@RequestMapping(value = "/update-emi-date")
	public void updateEMIandDate(@RequestBody DailyWork dailyWork);
		
}
