package com.dtfinance.ltd.finance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtfinance.ltd.finance.model.Investor;

public interface InvestorRepository extends JpaRepository<Investor, Long> {

}
