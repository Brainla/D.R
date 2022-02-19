package com.dtfinance.ltd.finance.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN_WORK")
public class AdminWork {
	
	@Id
	@Column(name="CUSTOMER_ID")
	private int customer_id;
	@Column(name="CUSTOMER_NAME")
	private String customer_name;
	@Column(name="EMI")
	private int emi;
	@Column(name="COLLECTION_DATE")
	private String collection_date;
	@Column(name="PREVIOUS_BALANCE")
	private int previous_balance;
	@Column(name="CURRENT_BALANCE")
	private int current_balance;
	@Column(name="RECEIVED_AMOUNT")
	private int received_amount;
	@Column(name="BALANCE")
	private int balance;
	@Column(name="STATUS")
	private String status;
	@Column(name="GIVEN_DATE")
	private String given_date;
	@Column(name="AGENT_ID")
	private int agent_id;
	@Column(name="AGENT_NAME")
	private String agent_name;

	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getEmi() {
		return emi;
	}
	public void setEmi(int emi) {
		this.emi = emi;
	}
	public String getCollection_date() {
		return collection_date;
	}
	public void setCollection_date(String collection_date) {
		this.collection_date = collection_date;
	}
	public int getPrevious_balance() {
		return previous_balance;
	}
	public void setPrevious_balance(int previous_balance) {
		this.previous_balance = previous_balance;
	}
	public int getCurrent_balance() {
		return current_balance;
	}
	public void setCurrent_balance(int current_balance) {
		this.current_balance = current_balance;
	}
	public int getReceived_amount() {
		return received_amount;
	}
	public void setReceived_amount(int received_amount) {
		this.received_amount = received_amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGiven_date() {
		return given_date;
	}
	public void setGiven_date(String given_date) {
		this.given_date = given_date;
	}
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
	public String getAgent_name() {
		return agent_name;
	}
	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}

}
