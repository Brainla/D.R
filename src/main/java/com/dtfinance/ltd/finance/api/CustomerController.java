package com.dtfinance.ltd.finance.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dtfinance.ltd.finance.model.Customer;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.CustomerResponseBean;

@RequestMapping("/customer")
public interface CustomerController {
	
	@PostMapping
	@RequestMapping("/insert")
	public ResponseEntity<FinanceStatus> insertCustomerDetails(@RequestBody Customer customer);
	
	@PostMapping
	@RequestMapping("/update")
	public ResponseEntity<FinanceStatus> updateCustomerDetails(@RequestBody Customer customer);
	
	@DeleteMapping
	@RequestMapping("/delete")
	public ResponseEntity<FinanceStatus> deleteCustomerDetails(@RequestParam(name="cust_id")int cust_id);
	
	@GetMapping
	@RequestMapping("/single-customer-details")
	public Customer getCustomerDetails(@RequestParam(name="cust_id")int cust_id);
	
	@GetMapping
	@RequestMapping("/all-customer-details")
	public CustomerResponseBean getAllCustomerDetails(@RequestParam(name="offset")int offset,
			@RequestParam(name="limit")int limit);



}
