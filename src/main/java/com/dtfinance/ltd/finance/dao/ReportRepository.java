package com.dtfinance.ltd.finance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtfinance.ltd.finance.model.MonthlyReport;

@Repository
public interface ReportRepository extends JpaRepository<MonthlyReport, Integer>{
	
}
