package com.dtfinance.ltd.finance.response_model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dtfinance.ltd.finance.model.AdminWork;

@Component
public class AdminWorkResponseBean {
	
	private List<AdminWork> dataList = new ArrayList<>();
	
	int dataSize;

	public List<AdminWork> getDataList() {
		return dataList;
	}

	public void setDataList(List<AdminWork> dataList) {
		this.dataList = dataList;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}
	
	

}
