package com.dtfinance.ltd.finance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dtfinance.ltd.finance.model.MonthlyReport;

@Repository
public interface MonthlyReportRepository extends JpaRepository<MonthlyReport, Integer>{

	@Query(value = "select * from monthly_report where agent_id=:id order by customer_id offset :offset ROWS FETCH FIRST :limit ROWS ONLY", 
			  nativeQuery = true)
	public List<MonthlyReport> getCustomerDetails(@Param("id") int agent_id,@Param("offset") int offset,@Param("limit") int limit);
	
	@Query(value = "select * from monthly_report where agent_id=:id and customer_id= :cust_id",nativeQuery = true)
	public MonthlyReport getSingleCustomerData(@Param("id") int agent_id,@Param("cust_id") int cust_id);
	
	@Query(value = "select * from monthly_report where customer_id= :cust_id",nativeQuery = true)
	public MonthlyReport getCustomerById(@Param("cust_id") int cust_id);
}
