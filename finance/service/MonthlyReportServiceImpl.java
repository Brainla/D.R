package com.dtfinance.ltd.finance.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dtfinance.ltd.finance.dao.MonthlyReportDao;
import com.dtfinance.ltd.finance.helper.ExcelHelper;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.model.MonthlyReport;
import com.dtfinance.ltd.finance.response_model.MonthlyReportResponseBean;

@Service
public class MonthlyReportServiceImpl implements MonthlyReportService{
	
	@Autowired
	private MonthlyReportDao MonthlyReportDao;
	
	@Autowired
	private ExcelHelper excelHelper;

	@Override
	public MonthlyReportResponseBean getCustomerDetails(int agent_id, int offset, int limit) {
		return MonthlyReportDao.getCustomerDetails(agent_id,offset,limit);
	}

	@Override
	public ByteArrayInputStream customerDetailsDownload() {
		List<MonthlyReport> monthlyReportList =  MonthlyReportDao.customerDetailsDownload();
		return excelHelper.tutorialsToExcelMonthly(monthlyReportList);
	}
	
	@Override
	public ResponseEntity<FinanceStatus> insertReportData(MonthlyReport MonthlyReport) {
		return MonthlyReportDao.insertReportData(MonthlyReport);
	}

	@Override
	public MonthlyReport getSingleCustomerData(int agent_id, int cust_id) {
		return MonthlyReportDao.getSingleCustomerData(agent_id,cust_id);
	}

}
