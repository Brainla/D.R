package com.dtfinance.ltd.finance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtfinance.ltd.finance.model.AgentDetails;

public interface AgentRepository extends JpaRepository<AgentDetails, Integer>{
	
}
