package com.dtfinance.ltd.finance.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dtfinance.ltd.finance.model.AgentDetails;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.AgentResponseBean;

@RequestMapping("/agent-details")
public interface AgentController {
	
	@PostMapping
	@RequestMapping("/insert")
	public ResponseEntity<FinanceStatus> insertAgentDetails(@RequestBody AgentDetails agentDetails);
	
	@PostMapping
	@RequestMapping("/update")
	public ResponseEntity<FinanceStatus> updateAgentDetails(@RequestBody AgentDetails agentDetails);
	
	@PostMapping
	@RequestMapping("/freeze")
	public ResponseEntity<FinanceStatus> freezeAgentDetails(@RequestParam(name="agent_id") int agent_id);
	
	@PostMapping
	@RequestMapping("/delete")
	public ResponseEntity<FinanceStatus> deleteAgentData(@RequestParam(name="agent_id") int agent_id);
	
	@GetMapping
	@RequestMapping("/all-agent-details")
	public AgentResponseBean getAllAgentDetails();
	
	@GetMapping
	@RequestMapping("/single-agent-details")
	public AgentDetails getSingleAgentDetails(@RequestParam(name="agent_id") int agent_id);


}
