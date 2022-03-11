package com.dtfinance.ltd.finance.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.dtfinance.ltd.finance.model.Customer;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.CustomerResponseBean;

public interface CustomerService {
	
	public ResponseEntity<FinanceStatus> insertCustomerDetails(@RequestBody Customer customer);
	
	public ResponseEntity<FinanceStatus> updateCustomerDetails(@RequestBody Customer customer);
	
	public ResponseEntity<FinanceStatus> deleteCustomerDetails(@RequestParam(name="cust_id")int cust_id);
	
	public Customer getCustomerDetails(@RequestParam(name="cust_id")int cust_id);
	
	public CustomerResponseBean getAllCustomerDetails(int offset, int limit);


}
