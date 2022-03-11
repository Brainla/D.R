package com.dtfinance.ltd.finance.dao;

import org.springframework.http.ResponseEntity;

import com.dtfinance.ltd.finance.model.Customer;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.CustomerResponseBean;

public interface CustomerDao {
	
public ResponseEntity<FinanceStatus> insertCustomerDetails(Customer customer);
	
	public ResponseEntity<FinanceStatus> updateCustomerDetails(Customer customer);
	
	public ResponseEntity<FinanceStatus> deleteCustomerDetails(int cust_id);
	
	public Customer getCustomerDetails(int cust_id);
	
	public CustomerResponseBean getAllCustomerDetails(int offset, int limit);

}
