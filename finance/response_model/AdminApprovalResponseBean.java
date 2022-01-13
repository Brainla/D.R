package com.dtfinance.ltd.finance.response_model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dtfinance.ltd.finance.model.AdminApproval;

@Component
public class AdminApprovalResponseBean {

	private List<AdminApproval> dataList = new ArrayList<>();

	public List<AdminApproval> getDataList() {
		return dataList;
	}

	public void setDataList(List<AdminApproval> dataList) {
		this.dataList = dataList;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}

	int dataSize;
}
