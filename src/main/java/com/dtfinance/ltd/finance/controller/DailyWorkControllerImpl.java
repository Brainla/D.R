package com.dtfinance.ltd.finance.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.dtfinance.ltd.finance.api.DailyWorkController;
import com.dtfinance.ltd.finance.model.AdminApproval;
import com.dtfinance.ltd.finance.model.AdminWork;
import com.dtfinance.ltd.finance.model.DailyWork;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.model.MonthlyReport;
import com.dtfinance.ltd.finance.response_model.DailyWorkResponseBean;
import com.dtfinance.ltd.finance.service.DailyWorkService;

@RestController
@CrossOrigin
public class DailyWorkControllerImpl implements DailyWorkController{

	@Autowired
	private DailyWorkService dailyService;

	@Override
	public DailyWorkResponseBean getAllCustomerDetails(int agent_id,int offset,int limit) {
		 return dailyService.getCustomerDetails(agent_id,offset,limit);
	}

	@Override
	public DailyWork getSingleCustomerData(int agent_id,int cust_id) {
		return dailyService.getSingleCustomerData(agent_id,cust_id);
	}

	@Override
	public ResponseEntity<FinanceStatus> adminStausUpdate(AdminApproval adminApproval) {
		return dailyService.adminStausUpdate(adminApproval);
	}

	@Override
	public ResponseEntity<FinanceStatus> updateDailyWork(DailyWork dailyWork) {
		return dailyService.updateDailyWork(dailyWork);
	}

	@Override
	public  ResponseEntity<Resource> customerDataDownload(int agent_id) {
		String filename = "daily_work.xlsx";
		InputStreamResource file = new InputStreamResource(dailyService.customerDataDownload(agent_id));
		 return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(file);
	}

	@Override
	public ResponseEntity<FinanceStatus> adminWorkUpdate(AdminWork adminWork) {
		return dailyService.adminWorkUpdate(adminWork);
	}

	@Override
	public void updateEMIandDate(DailyWork dailyWork) {
	//	return dailyService.updateEMIandDate(dailyWork);
	}

}
