package com.dtfinance.ltd.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dtfinance.ltd.finance.dao.CustomerDao;
import com.dtfinance.ltd.finance.model.Customer;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.CustomerResponseBean;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public ResponseEntity<FinanceStatus> insertCustomerDetails(Customer customer) {
		return customerDao.insertCustomerDetails(customer);
	}

	@Override
	public ResponseEntity<FinanceStatus> updateCustomerDetails(Customer customer) {
		return customerDao.updateCustomerDetails(customer);
	}

	@Override
	public ResponseEntity<FinanceStatus> deleteCustomerDetails(int cust_id) {
		return customerDao.deleteCustomerDetails(cust_id);
	}

	@Override
	public Customer getCustomerDetails(int cust_id) {
		return customerDao.getCustomerDetails(cust_id);
	}

	@Override
	public CustomerResponseBean getAllCustomerDetails(int offset, int limit) {
		return customerDao.getAllCustomerDetails(offset,limit);
	}

}
