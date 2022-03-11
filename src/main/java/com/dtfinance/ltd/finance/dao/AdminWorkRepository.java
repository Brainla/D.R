package com.dtfinance.ltd.finance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dtfinance.ltd.finance.model.AdminWork;

@Repository
public interface AdminWorkRepository extends JpaRepository<AdminWork, Integer>{

	@Query(value = "select * from admin_work order by customer_id offset :offset ROWS FETCH FIRST :limit ROWS ONLY", 
			nativeQuery = true)
	public List<AdminWork> getCustomerDetails(@Param("offset") int offset,@Param("limit") int limit);

	@Query(value = "select * from admin_work where customer_id= :cust_id",nativeQuery = true)
	public AdminWork getSingleCustomerData(@Param("cust_id") int cust_id);
	
	@Query(value = "delete from admin_work customer_id= :cust_id",nativeQuery = true)
	public int deleteCustomerData(@Param("cust_id") int cust_id);
	
	@Query(value = "select agent_name from agent_details where agent_id = :agent_id" ,nativeQuery = true)
	public String getAgentName(@Param("agent_id") int agent_id);

}
