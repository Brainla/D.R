package com.dtfinance.ltd.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dtfinance.ltd.finance.model.Customer;
import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.response_model.CustomerResponseBean;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private CustomerDataRepository customerDataRepository;
	
	@Autowired
	private CustomerResponseBean customerResponseBean;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public ResponseEntity<FinanceStatus> insertCustomerDetails(Customer customer) {
		int id = customerDataRepository.findMaxId();
		entityManager.createNativeQuery("insert into customer(CUSTOMER_ID,CUSTOMER_NAME,PH_NO_PRIMARY,RELATION_PRIMARY,PH_NO_SECONDARY,RELATION_SECONDARY,PH_NO_TERTIARY,RELATION_TERTIARY,HOUSE_ADDRESS,"
				+ "WORK_ADDRESS,AADHAR_NO,PAN_NO,GROSS_PAY,NET_PAY,MONTHLY_INCOME,"
				+ "OTHER_INCOME,CUSTOMER_HISTORY,LOAN_AMOUNT,RATE_OF_INTEREST,EMI_OR_MONTHLY,AMOUNT,COLLECTION_DATE,PROPERTY,AGENT_ID,AGENT_NAME)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)").setParameter(1, (id+1)).setParameter(2, customer.getCustomer_name()).setParameter(3, customer.getPh_no_primary()).
		setParameter(4, customer.getRelation_primary()).setParameter(5, customer.getPh_no_secondary()).setParameter(6, customer.getRelation_secondary()).setParameter(7, customer.getPh_no_tertiary()).setParameter(8, customer.getRelation_tertiary()).
		setParameter(9, customer.getHouse_address()).setParameter(10, customer.getWork_address()).setParameter(11, customer.getAadhar_no()).setParameter(12, customer.getPan_no()).setParameter(13, customer.getGross_pay()).
		setParameter(14, customer.getNet_pay()).setParameter(15, customer.getMonthly_income()).setParameter(16, customer.getOther_income()).setParameter(17, customer.getCustomer_history()).setParameter(18, customer.getLoan_amount()).
		setParameter(19, customer.getRate_of_interest()).setParameter(20, customer.getEmi_or_monthly()).setParameter(21, customer.getAmount()).setParameter(22, customer.getCollection_date()).setParameter(23, customer.getProperty()).
		setParameter(24, customer.getAgent_id()).setParameter(25, customer.getAgent_name()).executeUpdate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<FinanceStatus> updateCustomerDetails(Customer customer) {
		entityManager.createNativeQuery("update customer set PH_NO_PRIMARY=?,HOUSE_ADDRESS=?,WORK_ADDRESS=? where customer_id=?" )
		.setParameter(1, customer.getPh_no_primary()).setParameter(2, customer.getHouse_address()).setParameter(3, customer.getWork_address()).
		setParameter(4, customer.getCustomer_id()).executeUpdate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<FinanceStatus> deleteCustomerDetails(int cust_id) {
		 customerDataRepository.deleteById(cust_id);
		 return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}

	@Override
	public Customer getCustomerDetails(int cust_id) {
		return customerDataRepository.findById(cust_id).get();
	}

	@Override
	public CustomerResponseBean getAllCustomerDetails(int offset, int limit) {
		List<Customer> customerList = customerDataRepository.getAllCustomerDetails(offset,limit);
		int tableSize = getCustomerCount();
		customerResponseBean.setDataSize(tableSize);
		customerResponseBean.setDataList(customerList);
		return customerResponseBean;
	}
	
	private int getCustomerCount() {
		int count = (int) customerDataRepository.count();
		return count;
	}


}
