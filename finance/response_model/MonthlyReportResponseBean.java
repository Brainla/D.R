package com.dtfinance.ltd.finance.response_model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dtfinance.ltd.finance.model.MonthlyReport;

@Component
public class MonthlyReportResponseBean {
	
private List<MonthlyReport> dataList = new ArrayList<>();
	
	int dataSize;

	public List<MonthlyReport> getDataList() {
		return dataList;
	}

	public void setDataList(List<MonthlyReport> dataList) {
		this.dataList = dataList;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}

}
