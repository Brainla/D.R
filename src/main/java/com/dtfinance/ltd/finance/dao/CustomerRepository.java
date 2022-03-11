package com.dtfinance.ltd.finance.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dtfinance.ltd.finance.model.DailyWork;

@Repository
public interface CustomerRepository extends JpaRepository<DailyWork, Integer>{
	
	
	
	@Query(value = "select * from daily_work where (collection_date=to_date(:date,'yyyy/mm/dd') or given_date=to_date(:date,'yyyy/mm/dd'))"
			+ " and agent_id=:id or status is null order by customer_id offset :offset ROWS FETCH FIRST :limit ROWS ONLY", 
			  nativeQuery = true)
	public List<DailyWork> getCustomerDetails(@Param("date") String date,@Param("id") int agent_id, @Param("offset") int offset,@Param("limit") int limit);
	
	@Query(value = "select count(*) from daily_work where (collection_date=to_date(:date,'yyyy/mm/dd') or given_date=to_date(:date,'yyyy/mm/dd'))"
			+ " and agent_id=:id or status is null", 
			  nativeQuery = true)
	public int getCustomerCount(@Param("date") String date,@Param("id") int agent_id);
	
	@Query(value = "select * from daily_work where (collection_date=to_date(:date,'yyyy/mm/dd') or given_date=to_date(:date,'yyyy/mm/dd'))"
			+ " and agent_id=:id order by customer_id", nativeQuery = true)
	public List<DailyWork> customerDataDownload(@Param("date") String date,@Param("id") int agent_id);
	
	
	@Query(value = "select * from daily_work where agent_id=:id and customer_id= :cust_id",nativeQuery = true)
	public DailyWork getSingleCustomerData(@Param("id") int agent_id,@Param("cust_id") int cust_id);
	
	@Query(value = "update daily_work set status=null where (collection_date=to_date(:date,'yyyy/mm/dd') or given_date=to_date(:date,'yyyy/mm/dd'))"
			+ " and agent_id=:id and status='N'",nativeQuery = true)
	public void updateNewCustomers(@Param("date") String date,@Param("id") int agent_id);
	
	}