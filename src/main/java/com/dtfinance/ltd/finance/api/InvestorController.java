package com.dtfinance.ltd.finance.api;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtfinance.ltd.finance.model.Investor;
import com.dtfinance.ltd.finance.response_model.InvestorResponse;
import com.dtfinance.ltd.finance.service.InvestorService;

@RestController
@RequestMapping("/investor")
public class InvestorController {
	
	@Autowired
	private InvestorService investorService;
	
	@PostMapping("/add")
	public ResponseEntity<InvestorResponse<Investor>> saveInvestor(@RequestBody() Investor investor) {
		InvestorResponse<Investor> response = new InvestorResponse<>();
		try {
			Investor savedInvestor = investorService.saveInvestor(investor);
			response.setData(savedInvestor);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			response.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<InvestorResponse<List<Investor>>> getAllInvestors() {
		List<Investor> investorsList = investorService.getAllInvestors();
		InvestorResponse<List<Investor>> response = new InvestorResponse<>();
		response.setData(investorsList);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
