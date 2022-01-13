package com.dtfinance.ltd.finance.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dtfinance.ltd.finance.model.AdminApproval;
import com.dtfinance.ltd.finance.model.AdminWork;
import com.dtfinance.ltd.finance.model.DailyWork;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.model.MonthlyReport;
import com.dtfinance.ltd.finance.response_model.DailyWorkResponseBean;

public interface DailyWorkDao {
	
	public DailyWorkResponseBean getAllCustomerDetails(String date,int agent_id,int offset,int limit);
	
	public List<DailyWork> customerDataDownload(int agent_id);
	
	public DailyWork getSingleCustomerData(int agent_id,int cust_id);
	
	public ResponseEntity<FinanceStatus> adminStausUpdate(AdminApproval adminApproval);
	
	public ResponseEntity<FinanceStatus> updateDailyWork(DailyWork dailyWork);
	
	public ResponseEntity<FinanceStatus> updateMonthlyReportData(MonthlyReport reportData);
	
	public ResponseEntity<FinanceStatus> adminWorkUpdate(AdminWork adminWork);
	
	public ResponseEntity<FinanceStatus> updateNewCustomers(String date,int agent_id);
}
