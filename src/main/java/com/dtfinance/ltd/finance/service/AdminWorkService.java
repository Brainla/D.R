package com.dtfinance.ltd.finance.service;

import org.springframework.http.ResponseEntity;

import com.dtfinance.ltd.finance.model.AdminWork;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AdminWorkResponseBean;


public interface AdminWorkService {
	
	public AdminWorkResponseBean getAllCustomerDetails(int offset,int limit);
	
	public AdminWork getSingleCustomerData(int customer_id);
	
	public ResponseEntity<FinanceStatus> deleteCustomerData(int cust_id);
	
	public ResponseEntity<FinanceStatus> insertAdminWorkData(AdminWork adminWork);
	
}
