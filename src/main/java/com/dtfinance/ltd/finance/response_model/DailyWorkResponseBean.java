package com.dtfinance.ltd.finance.response_model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dtfinance.ltd.finance.model.DailyWork;

@Component
public class DailyWorkResponseBean {
	
	public List<DailyWork> getDataList() {
		return dataList;
	}

	public void setDataList(List<DailyWork> dataList) {
		this.dataList = dataList;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}

	private List<DailyWork> dataList = new ArrayList<>();
	
	int dataSize;
	

}
