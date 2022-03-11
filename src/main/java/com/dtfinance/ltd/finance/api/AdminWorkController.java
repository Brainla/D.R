package com.dtfinance.ltd.finance.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dtfinance.ltd.finance.model.AdminWork;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AdminWorkResponseBean;

@RequestMapping("/admin-work")
public interface AdminWorkController {


	@GetMapping
	@RequestMapping("/all-customer-details")
	public AdminWorkResponseBean getAllCustomerDetails(@RequestParam(name="offset")int offset,
			@RequestParam(name="limit")int limit);
	
	@GetMapping
	@RequestMapping(value = "/single-custromer-details")
	public AdminWork getSingleCustomerData(@RequestParam(name="cust_id") int customer_id);
	
	@PostMapping
	@RequestMapping("/delete")
	public ResponseEntity<FinanceStatus> deleteCustomerData(@RequestParam(name="customer_id") int cust_id);
	
	@PostMapping
	@RequestMapping("/insert")
	public ResponseEntity<FinanceStatus> insertAdminWorkData(@RequestBody AdminWork adminWork);

}
