package com.dtfinance.ltd.finance.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dtfinance.ltd.finance.model.MonthlyReport;
import com.dtfinance.ltd.finance.model.DailyWork;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.MonthlyReportResponseBean;

public interface MonthlyReportDao {

	public MonthlyReportResponseBean getCustomerDetails(int agent_id, int offset, int limit);
	
	public MonthlyReport getSingleCustomerData(int agent_id,int cust_id);

	public List<MonthlyReport> customerDetailsDownload();
	
	public ResponseEntity<FinanceStatus> insertReportData(MonthlyReport MonthlyReport);
	
	public ResponseEntity<FinanceStatus> updateMonthlyReportData(MonthlyReport reportData);
}
