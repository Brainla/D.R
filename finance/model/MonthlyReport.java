package com.dtfinance.ltd.finance.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monthly_report")
public class MonthlyReport {
	
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
	@Column(name="GIVEN_DATE")
	private String given_date;
	@Column(name="AGENT_ID")
	private int agent_id;
	@Column(name="DATE_1")
	private String date_1;
	@Column(name="DATE_2")
	private String date_2;
	@Column(name="DATE_3")
	private String date_3;
	@Column(name="DATE_4")
	private String date_4;
	@Column(name="DATE_5")
	private String date_5;
	@Column(name="DATE_6")
	private String date_6;
	@Column(name="DATE_7")
	private String date_7;
	@Column(name="DATE_8")
	private String date_8;
	@Column(name="DATE_9")
	private String date_9;
	@Column(name="DATE_10")
	private String date_10;
	@Column(name="DATE_11")
	private String date_11;
	@Column(name="DATE_12")
	private String date_12;
	@Column(name="DATE_13")
	private String date_13;
	@Column(name="DATE_14")
	private String date_14;
	@Column(name="DATE_15")
	private String date_15;
	@Column(name="DATE_16")
	private String date_16;
	@Column(name="DATE_17")
	private String date_17;
	@Column(name="DATE_18")
	private String date_18;
	@Column(name="DATE_19")
	private String date_19;
	@Column(name="DATE_20")
	private String date_20;
	@Column(name="DATE_21")
	private String date_21;
	@Column(name="DATE_22")
	private String date_22;
	@Column(name="DATE_23")
	private String date_23;
	@Column(name="DATE_24")
	private String date_24;
	@Column(name="DATE_25")
	private String date_25;
	@Column(name="DATE_26")
	private String date_26;
	@Column(name="DATE_27")
	private String date_27;
	@Column(name="DATE_28")
	private String date_28;
	@Column(name="DATE_29")
	private String date_29;
	@Column(name="DATE_30")
	private String date_30;
	@Column(name="DATE_31")
	private String date_31;

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
	public String getDate_1() {
		return date_1;
	}
	public void setDate_1(String date_1) {
		this.date_1 = date_1;
	}
	public String getDate_2() {
		return date_2;
	}
	public void setDate_2(String date_2) {
		this.date_2 = date_2;
	}
	public String getDate_3() {
		return date_3;
	}
	public void setDate_3(String date_3) {
		this.date_3 = date_3;
	}
	public String getDate_4() {
		return date_4;
	}
	public void setDate_4(String date_4) {
		this.date_4 = date_4;
	}
	public String getDate_5() {
		return date_5;
	}
	public void setDate_5(String date_5) {
		this.date_5 = date_5;
	}
	public String getDate_6() {
		return date_6;
	}
	public void setDate_6(String date_6) {
		this.date_6 = date_6;
	}
	public String getDate_7() {
		return date_7;
	}
	public void setDate_7(String date_7) {
		this.date_7 = date_7;
	}
	public String getDate_8() {
		return date_8;
	}
	public void setDate_8(String date_8) {
		this.date_8 = date_8;
	}
	public String getDate_9() {
		return date_9;
	}
	public void setDate_9(String date_9) {
		this.date_9 = date_9;
	}
	public String getDate_10() {
		return date_10;
	}
	public void setDate_10(String date_10) {
		this.date_10 = date_10;
	}
	public String getDate_11() {
		return date_11;
	}
	public void setDate_11(String date_11) {
		this.date_11 = date_11;
	}
	public String getDate_12() {
		return date_12;
	}
	public void setDate_12(String date_12) {
		this.date_12 = date_12;
	}
	public String getDate_13() {
		return date_13;
	}
	public void setDate_13(String date_13) {
		this.date_13 = date_13;
	}
	public String getDate_14() {
		return date_14;
	}
	public void setDate_14(String date_14) {
		this.date_14 = date_14;
	}
	public String getDate_15() {
		return date_15;
	}
	public void setDate_15(String date_15) {
		this.date_15 = date_15;
	}
	public String getDate_16() {
		return date_16;
	}
	public void setDate_16(String date_16) {
		this.date_16 = date_16;
	}
	public String getDate_17() {
		return date_17;
	}
	public void setDate_17(String date_17) {
		this.date_17 = date_17;
	}
	public String getDate_18() {
		return date_18;
	}
	public void setDate_18(String date_18) {
		this.date_18 = date_18;
	}
	public String getDate_19() {
		return date_19;
	}
	public void setDate_19(String date_19) {
		this.date_19 = date_19;
	}
	public String getDate_20() {
		return date_20;
	}
	public void setDate_20(String date_20) {
		this.date_20 = date_20;
	}
	public String getDate_21() {
		return date_21;
	}
	public void setDate_21(String date_21) {
		this.date_21 = date_21;
	}
	public String getDate_22() {
		return date_22;
	}
	public void setDate_22(String date_22) {
		this.date_22 = date_22;
	}
	public String getDate_23() {
		return date_23;
	}
	public void setDate_23(String date_23) {
		this.date_23 = date_23;
	}
	public String getDate_24() {
		return date_24;
	}
	public void setDate_24(String date_24) {
		this.date_24 = date_24;
	}
	public String getDate_25() {
		return date_25;
	}
	public void setDate_25(String date_25) {
		this.date_25 = date_25;
	}
	public String getDate_26() {
		return date_26;
	}
	public void setDate_26(String date_26) {
		this.date_26 = date_26;
	}
	public String getDate_27() {
		return date_27;
	}
	public void setDate_27(String date_27) {
		this.date_27 = date_27;
	}
	public String getDate_28() {
		return date_28;
	}
	public void setDate_28(String date_28) {
		this.date_28 = date_28;
	}
	public String getDate_29() {
		return date_29;
	}
	public void setDate_29(String date_29) {
		this.date_29 = date_29;
	}
	public String getDate_30() {
		return date_30;
	}
	public void setDate_30(String date_30) {
		this.date_30 = date_30;
	}
	public String getDate_31() {
		return date_31;
	}
	public void setDate_31(String date_31) {
		this.date_31 = date_31;
	}

}
