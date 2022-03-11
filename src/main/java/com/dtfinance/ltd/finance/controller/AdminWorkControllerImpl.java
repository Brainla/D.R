package com.dtfinance.ltd.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.dtfinance.ltd.finance.api.AdminWorkController;
import com.dtfinance.ltd.finance.model.AdminWork;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AdminWorkResponseBean;
import com.dtfinance.ltd.finance.service.AdminWorkService;

@RestController
@CrossOrigin
public class AdminWorkControllerImpl implements AdminWorkController{
	
	@Autowired
	private AdminWorkService adminWorkService;

	@Override
	public AdminWorkResponseBean getAllCustomerDetails(int offset, int limit) {
		return adminWorkService.getAllCustomerDetails(offset,limit);
	}

	@Override
	public AdminWork getSingleCustomerData(int customer_id) {
		return adminWorkService.getSingleCustomerData(customer_id);
	}

	@Override
	public ResponseEntity<FinanceStatus> deleteCustomerData(int cust_id) {
		 return adminWorkService.deleteCustomerData(cust_id);
	}

	@Override
	public ResponseEntity<FinanceStatus> insertAdminWorkData(AdminWork adminWork) {
		return adminWorkService.insertAdminWorkData(adminWork);
	}

}
