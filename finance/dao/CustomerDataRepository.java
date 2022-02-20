package com.dtfinance.ltd.finance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dtfinance.ltd.finance.model.Customer;

@Repository
public interface CustomerDataRepository  extends JpaRepository<Customer, Integer>{
	
	@Query(value = "select * from CUSTOMER order by customer_id offset :offset ROWS FETCH FIRST :limit ROWS ONLY", 
			  nativeQuery = true)
	public List<Customer> getAllCustomerDetails(@Param("offset") int offset,@Param("limit") int limit);
	
	@Query(value = "select coalesce(Max(customer_id),0) from customer", 
			  nativeQuery = true)
	public int findMaxId();

}
