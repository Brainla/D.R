package com.dtfinance.ltd.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.dtfinance.ltd.finance.api.CustomerController;
import com.dtfinance.ltd.finance.model.Customer;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.CustomerResponseBean;
import com.dtfinance.ltd.finance.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerControllerImpl implements CustomerController{
	
	@Autowired
	private CustomerService customerService;

	@Override
	public ResponseEntity<FinanceStatus> insertCustomerDetails(Customer customer) {
		return customerService.insertCustomerDetails(customer);
	}

	@Override
	public ResponseEntity<FinanceStatus> updateCustomerDetails(Customer customer) {
		return customerService.updateCustomerDetails(customer);
	}

	@Override
	public ResponseEntity<FinanceStatus> deleteCustomerDetails(int cust_id) {
		return customerService.deleteCustomerDetails(cust_id);
	}

	@Override
	public Customer getCustomerDetails(int cust_id) {
		return customerService.getCustomerDetails(cust_id);
	}

	@Override
	public CustomerResponseBean getAllCustomerDetails(int offset, int limit) {
		return customerService.getAllCustomerDetails(offset,limit);
	}

}
