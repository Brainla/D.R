package com.dtfinance.ltd.finance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtfinance.ltd.finance.model.AdminApproval;

public interface AdminDataRepository  extends JpaRepository<AdminApproval, Integer>{
	
}
