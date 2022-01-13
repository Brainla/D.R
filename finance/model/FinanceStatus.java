package com.dtfinance.ltd.finance.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class FinanceStatus extends ResponseEntity{

	public FinanceStatus(HttpStatus status) {
		super(status);
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	private int status;
	private String message;
	private Object response;
	
}
