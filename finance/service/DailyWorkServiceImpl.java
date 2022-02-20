package com.dtfinance.ltd.finance.service;

import java.io.ByteArrayInputStream;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dtfinance.ltd.finance.dao.DailyWorkDao;
import com.dtfinance.ltd.finance.helper.ExcelHelper;
import com.dtfinance.ltd.finance.model.AdminApproval;
import com.dtfinance.ltd.finance.model.AdminWork;
import com.dtfinance.ltd.finance.model.DailyWork;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.model.MonthlyReport;
import com.dtfinance.ltd.finance.response_model.DailyWorkResponseBean;

@Service
public class DailyWorkServiceImpl implements DailyWorkService{
	
	@Autowired
	private DailyWorkDao dailyWorkDao;
	
	@Autowired
	private DailyWorkResponseBean dailyWorkResponseBean;
	
	@Autowired
	private ExcelHelper excelHelper;
	
	@Override
	public DailyWorkResponseBean getCustomerDetails(int agent_id,int offset,int limit){
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis);
		dailyWorkDao.updateNewCustomers(date.toString(),agent_id);
		return dailyWorkDao.getAllCustomerDetails(date.toString(),agent_id,offset,limit);
	}

	@Override
	public DailyWork getSingleCustomerData(int agent_id,int cust_id) {
		return dailyWorkDao.getSingleCustomerData(agent_id,cust_id);
	}
	
	@Override
	public ResponseEntity<FinanceStatus> adminStausUpdate(AdminApproval adminApproval) {
		return dailyWorkDao.adminStausUpdate(adminApproval);
	}

	@Override
	public ResponseEntity<FinanceStatus> updateDailyWork(DailyWork dailyWork) {
		/*if(dailyWork.getBalance()==0) {
			LocalDate date = LocalDate.parse(dailyWork.getCollection_date());
				date = date.plusMonths(1);
			dailyWork.setCollection_date(date.toString());
		}*/
		return dailyWorkDao.updateDailyWork(dailyWork);
	}

	@Override
	public ByteArrayInputStream  customerDataDownload(int agent_id) {
		 List<DailyWork> dailyWorkList = dailyWorkDao.customerDataDownload(agent_id);
		 return excelHelper.tutorialsToExcel(dailyWorkList);
	}
	
	@Override
	public ResponseEntity<FinanceStatus> adminWorkUpdate(AdminWork adminWork) {
		return dailyWorkDao.adminWorkUpdate(adminWork);
	}

	@Override
	public void updateEMIandDate(DailyWork dailyWork) {
		//return dailyWorkDao.updateEMIandDate(dailyWork);
	}

}
