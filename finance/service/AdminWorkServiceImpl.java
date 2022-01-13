package com.dtfinance.ltd.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dtfinance.ltd.finance.dao.AdminWorkDao;
import com.dtfinance.ltd.finance.model.AdminWork;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AdminWorkResponseBean;

@Service
public class AdminWorkServiceImpl implements AdminWorkService{
	
	@Autowired
	private AdminWorkDao adminWorkDao;

	@Override
	public AdminWorkResponseBean getAllCustomerDetails(int offset, int limit) {
		return adminWorkDao.getAllCustomerDetails(offset,limit);
	}

	@Override
	public AdminWork getSingleCustomerData(int customer_id) {
		return adminWorkDao.getSingleCustomerData(customer_id);
	}

	@Override
	public ResponseEntity<FinanceStatus> deleteCustomerData(int cust_id) {
		 return adminWorkDao.deleteCustomerData(cust_id);
	}

	@Override
	public ResponseEntity<FinanceStatus> insertAdminWorkData(AdminWork adminWork) {
		return adminWorkDao.insertAdminWorkData(adminWork);
	}

	

}
