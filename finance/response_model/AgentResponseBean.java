package com.dtfinance.ltd.finance.response_model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dtfinance.ltd.finance.model.AgentDetails;

@Component
public class AgentResponseBean {
	
	private List<AgentDetails> dataList = new ArrayList<>();
	
	int dataSize;

	public List<AgentDetails> getDataList() {
		return dataList;
	}

	public void setDataList(List<AgentDetails> dataList) {
		this.dataList = dataList;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}
	

}
