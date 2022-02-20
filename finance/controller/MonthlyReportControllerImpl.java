package com.dtfinance.ltd.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.dtfinance.ltd.finance.api.MonthlyReportController;
import com.dtfinance.ltd.finance.model.MonthlyReport;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.MonthlyReportResponseBean;
import com.dtfinance.ltd.finance.service.MonthlyReportService;

@RestController
@CrossOrigin
public class MonthlyReportControllerImpl implements MonthlyReportController{
	@Autowired
	private MonthlyReportService MonthlyReportService;

	@Override
	public MonthlyReportResponseBean getCustomerDetails(int agent_id, int offset, int limit) {
		return MonthlyReportService.getCustomerDetails(agent_id,offset,limit);
	}

	@Override
	public ResponseEntity<Resource> customerDetailsDownload() {
		String filename = "monthly_report.xlsx";
		InputStreamResource file = new InputStreamResource(MonthlyReportService.customerDetailsDownload());
		 return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(file);
	}

	@Override
	public ResponseEntity<FinanceStatus> insertReportData(MonthlyReport MonthlyReport) {
		return MonthlyReportService.insertReportData(MonthlyReport);
	}

	@Override
	public MonthlyReport getSingleCustomerData(int agent_id, int customer_id) {
		return MonthlyReportService.getSingleCustomerData(agent_id,customer_id);
	}
	
	@Override
	public ResponseEntity<FinanceStatus> updateMonthlyReportData(MonthlyReport reportData) {
		return MonthlyReportService.updateMonthlyReportData(reportData);
	}

}
