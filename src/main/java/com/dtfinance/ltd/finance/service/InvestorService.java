package com.dtfinance.ltd.finance.service;

import java.util.List;

import javax.xml.bind.ValidationException;

import com.dtfinance.ltd.finance.model.Investor;

public interface InvestorService {
	Investor saveInvestor(Investor investor) throws ValidationException;
	List<Investor> getAllInvestors();
}
