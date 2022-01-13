package com.dtfinance.ltd.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.dtfinance.ltd.finance.api.AgentController;
import com.dtfinance.ltd.finance.model.AgentDetails;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AgentResponseBean;
import com.dtfinance.ltd.finance.service.AgentService;

@RestController
@CrossOrigin
public class AgentControllerImpl implements AgentController {
	
	@Autowired
	private AgentService agentService;
	
	@Override
	public ResponseEntity<FinanceStatus> insertAgentDetails(AgentDetails agentDetails) {
		 return agentService.insertAgentDetails(agentDetails);
	}
	
	@Override
	public ResponseEntity<FinanceStatus> updateAgentDetails(AgentDetails agentDetails) {
		 return agentService.updateAgentDetails(agentDetails);
	}
	
	@Override
	public ResponseEntity<FinanceStatus> deleteAgentData(int id) {
		return agentService.deleteAgentData(id);
	}
	
	@Override
	public AgentResponseBean getAllAgentDetails() {
		 return agentService.getAllAgentDetails();
	}
	
	@Override
	public AgentDetails getSingleAgentDetails(int id) {
		 return agentService.getSingleAgentDetails(id);
	}

	@Override
	public ResponseEntity<FinanceStatus> freezeAgentDetails(int agent_id) {
		return agentService.freezeAgentDetails(agent_id);
	}

}
