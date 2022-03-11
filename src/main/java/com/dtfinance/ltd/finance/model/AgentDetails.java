package com.dtfinance.ltd.finance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGENT_DETAILS")
public class AgentDetails {
	
	@Id
	@Column(name="AGENT_ID")
	private int agent_id;
	@Column(name="AGENT_NAME")
	private String agent_name;
	@Column(name="PH_NO")
	private String ph_no;
	@Column(name="STATUS")
	private String status;
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
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
