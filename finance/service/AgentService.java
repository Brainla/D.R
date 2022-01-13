package com.dtfinance.ltd.finance.service;

import org.springframework.http.ResponseEntity;

import com.dtfinance.ltd.finance.model.AgentDetails;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AgentResponseBean;

public interface AgentService {

	public ResponseEntity<FinanceStatus> insertAgentDetails(AgentDetails agentDetails);
	
	public ResponseEntity<FinanceStatus> updateAgentDetails(AgentDetails agentDetails);
	
	public ResponseEntity<FinanceStatus> freezeAgentDetails(int agent_id);
	
	public ResponseEntity<FinanceStatus> deleteAgentData(int id);
	
	public AgentResponseBean getAllAgentDetails();
	
	public AgentDetails getSingleAgentDetails(int id);
}
