package com.dtfinance.ltd.finance.response_model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dtfinance.ltd.finance.model.Customer;

@Component
public class CustomerResponseBean {
	
private List<Customer> dataList = new ArrayList<>();
	
	int dataSize;

	public List<Customer> getDataList() {
		return dataList;
	}

	public void setDataList(List<Customer> dataList) {
		this.dataList = dataList;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}
	

}
