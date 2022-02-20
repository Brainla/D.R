package com.dtfinance.ltd.finance.api;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.model.MonthlyReport;
import com.dtfinance.ltd.finance.response_model.MonthlyReportResponseBean;

@RequestMapping("/monthly-report")
public interface MonthlyReportController {

	@GetMapping
	@RequestMapping("/customer-details")
	public MonthlyReportResponseBean getCustomerDetails(@RequestParam(name="agent_id") int agent_id,@RequestParam(name="offset")int offset,
			@RequestParam(name="limit")int limit);
	
	@GetMapping
	@RequestMapping(value = "/single-custromer-details")
	public MonthlyReport getSingleCustomerData(@RequestParam(name="agent_id") int agent_id,@RequestParam(name="cust_id") int customer_id);
	
	@GetMapping
	@RequestMapping("/customer-details/download")
	public ResponseEntity<Resource> customerDetailsDownload();
	
	@PostMapping
	@RequestMapping("/insert")
	public ResponseEntity<FinanceStatus> insertReportData(@RequestBody MonthlyReport MonthlyReport);
	
	@PostMapping
	@RequestMapping(value = "/report-update")
	public ResponseEntity<FinanceStatus> updateMonthlyReportData(@RequestBody MonthlyReport reportData);
}
