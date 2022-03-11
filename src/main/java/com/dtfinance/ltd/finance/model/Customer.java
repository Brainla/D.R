package com.dtfinance.ltd.finance.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@Column(name="CUSTOMER_ID")
	int customer_id;
	@Column(name="CUSTOMER_NAME")
	String customer_name;
	@Column(name="PH_NO_PRIMARY")
	String ph_no_primary;
	@Column(name="RELATION_PRIMARY")
	String relation_primary;
	@Column(name="PH_NO_SECONDARY")
	String ph_no_secondary;
	@Column(name="RELATION_SECONDARY")
	String relation_secondary;
	@Column(name="PH_NO_TERTIARY")
	String ph_no_tertiary;
	@Column(name="RELATION_TERTIARY")
	String relation_tertiary;
	@Column(name="HOUSE_ADDRESS")
	String house_address;
	@Column(name="WORK_ADDRESS")
	String work_address;
	@Column(name="AADHAR_NO")
	String Aadhar_no;
	@Column(name="PAN_NO")
	String pan_no;
	@Column(name="GROSS_PAY")
	String gross_pay;
	@Column(name="NET_PAY")
	String net_pay;
	@Column(name="MONTHLY_INCOME")
	String monthly_income;
	@Column(name="OTHER_INCOME")
	String other_income;
	@Column(name="CUSTOMER_HISTORY")
	String customer_history;
	@Column(name="LOAN_AMOUNT")
	String loan_amount;
	@Column(name="RATE_OF_INTEREST")
	int rate_of_interest;
	@Column(name="EMI_OR_MONTHLY")
	String emi_or_monthly;
	@Column(name="AMOUNT")
	String amount;
	@Column(name="COLLECTION_DATE")
	int collection_date;
	@Column(name="PROPERTY")
	String property;
	@Column(name="AGENT_ID")
	int agent_id;
	@Column(name="AGENT_NAME")
	String agent_name;

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
	public String getPh_no_primary() {
		return ph_no_primary;
	}
	public void setPh_no_primary(String ph_no_primary) {
		this.ph_no_primary = ph_no_primary;
	}
	public String getRelation_primary() {
		return relation_primary;
	}
	public void setRelation_primary(String relation_primary) {
		this.relation_primary = relation_primary;
	}
	public String getPh_no_secondary() {
		return ph_no_secondary;
	}
	public void setPh_no_secondary(String ph_no_secondary) {
		this.ph_no_secondary = ph_no_secondary;
	}
	public String getRelation_secondary() {
		return relation_secondary;
	}
	public void setRelation_secondary(String relation_secondary) {
		this.relation_secondary = relation_secondary;
	}
	public String getPh_no_tertiary() {
		return ph_no_tertiary;
	}
	public void setPh_no_tertiary(String ph_no_tertiary) {
		this.ph_no_tertiary = ph_no_tertiary;
	}
	public String getRelation_tertiary() {
		return relation_tertiary;
	}
	public void setRelation_tertiary(String relation_tertiary) {
		this.relation_tertiary = relation_tertiary;
	}
	public String getHouse_address() {
		return house_address;
	}
	public void setHouse_address(String house_address) {
		this.house_address = house_address;
	}
	public String getWork_address() {
		return work_address;
	}
	public void setWork_address(String work_address) {
		this.work_address = work_address;
	}
	public String getAadhar_no() {
		return Aadhar_no;
	}
	public void setAadhar_no(String aadhar_no) {
		Aadhar_no = aadhar_no;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public String getGross_pay() {
		return gross_pay;
	}
	public void setGross_pay(String gross_pay) {
		this.gross_pay = gross_pay;
	}
	public String getNet_pay() {
		return net_pay;
	}
	public void setNet_pay(String net_pay) {
		this.net_pay = net_pay;
	}
	public String getMonthly_income() {
		return monthly_income;
	}
	public void setMonthly_income(String monthly_income) {
		this.monthly_income = monthly_income;
	}
	public String getOther_income() {
		return other_income;
	}
	public void setOther_income(String other_income) {
		this.other_income = other_income;
	}
	public String getCustomer_history() {
		return customer_history;
	}
	public void setCustomer_history(String customer_history) {
		this.customer_history = customer_history;
	}
	public String getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(String loan_amount) {
		this.loan_amount = loan_amount;
	}
	public int getRate_of_interest() {
		return rate_of_interest;
	}
	public void setRate_of_interest(int rate_of_interest) {
		this.rate_of_interest = rate_of_interest;
	}
	public String getEmi_or_monthly() {
		return emi_or_monthly;
	}
	public void setEmi_or_monthly(String emi_or_monthly) {
		this.emi_or_monthly = emi_or_monthly;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getCollection_date() {
		return collection_date;
	}
	public void setCollection_date(int collection_date) {
		this.collection_date = collection_date;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
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
