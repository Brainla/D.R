package com.dtfinance.ltd.finance.service;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtfinance.ltd.finance.dao.InvestorRepository;
import com.dtfinance.ltd.finance.model.Investor;

@Service
public class InvestorServiceImpl implements InvestorService {

	@Autowired
	private InvestorRepository investorRepository;

	@Override
	public Investor saveInvestor(Investor investor) throws ValidationException {
		validateInvestor(investor);
		return investorRepository.save(investor);
	}

	private void validateInvestor(Investor investor) throws ValidationException {
		if (investor.getName() == null || investor.getLoanAmount() == null || investor.getPhoneNumber() == null
				|| investor.getRateOfInterest() == null || investor.getRecievedDate() == null
				|| investor.getRepayDetails() == null) {
			throw new ValidationException("Values should not be null");
		}
	}

	@Override
	public List<Investor> getAllInvestors() {
		return investorRepository.findAll();
	}

}
