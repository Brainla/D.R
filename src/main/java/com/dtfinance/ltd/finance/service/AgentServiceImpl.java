package com.dtfinance.ltd.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dtfinance.ltd.finance.dao.AgentDao;
import com.dtfinance.ltd.finance.model.AgentDetails;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AgentResponseBean;

@Service
public class AgentServiceImpl implements AgentService{
	
	@Autowired
	private AgentDao agentDao;
	
	@Override
	public ResponseEntity<FinanceStatus> insertAgentDetails(AgentDetails agentDetails) {
		 return agentDao.insertAgentDetails(agentDetails);
	}
	
	@Override
	public ResponseEntity<FinanceStatus> updateAgentDetails(AgentDetails agentDetails) {
		 return agentDao.updateAgentDetails(agentDetails);
	}
	
	@Override
	public ResponseEntity<FinanceStatus> deleteAgentData(int id) {
		return agentDao.deleteAgentData(id);
	}
	
	@Override
	public AgentResponseBean getAllAgentDetails() {
		return agentDao.getAllAgentDetails();
	}
	
	@Override
	public AgentDetails getSingleAgentDetails(int id) {
		return agentDao.getSingleAgentDetails(id);
	}

	@Override
	public ResponseEntity<FinanceStatus> freezeAgentDetails(int agent_id) {
		return agentDao.freezeAgentDetails(agent_id);
	}

}
