package com.dtfinance.ltd.finance.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dtfinance.ltd.finance.model.AgentDetails;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AgentResponseBean;

@Repository
public class AgentDaoImpl implements AgentDao{

	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private AgentResponseBean agentResponseBean;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public ResponseEntity<FinanceStatus> insertAgentDetails(AgentDetails agentDetails) {
		entityManager.createNativeQuery("insert into agent_details(agent_id,agent_name,ph_no,status) values(?,?,?,?)")
			.setParameter(1, agentDetails.getAgent_id()).setParameter(2, agentDetails.getAgent_name()).setParameter(3, agentDetails.getPh_no()).
		setParameter(4, "A").executeUpdate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<FinanceStatus> updateAgentDetails(AgentDetails agentDetails) {
		entityManager.createNativeQuery("update agent_details set ph_no=? where agent_id=?")
		.setParameter(1, agentDetails.getPh_no()).setParameter(2, agentDetails.getAgent_id()).executeUpdate();
	return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}
	
	@Override
	@Transactional
	public ResponseEntity<FinanceStatus> freezeAgentDetails(int agent_id) {
		entityManager.createNativeQuery("update agent_details set status='F' where agent_id=?")
		.setParameter(1, agent_id).executeUpdate();
	return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

	public ResponseEntity<FinanceStatus> deleteAgentData(int id){
		agentRepository.deleteById(id);
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

	public AgentResponseBean getAllAgentDetails(){
		List<AgentDetails> agentList = agentRepository.findAll();
		 int dataSize = getCustomerCount();
		 agentResponseBean.setDataSize(dataSize);
		 agentResponseBean.setDataList(agentList);
		 return agentResponseBean;
	}
	
	private int getCustomerCount() {
		int count = (int) agentRepository.count();
		return count;
	}
	
	public AgentDetails getSingleAgentDetails(int id){
		Optional<AgentDetails> agentData = agentRepository.findById(id);
		if(agentData.isPresent()) {
			return agentData.get();
		}
		return null;
	}


}
