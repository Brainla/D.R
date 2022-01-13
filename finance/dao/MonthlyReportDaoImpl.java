package com.dtfinance.ltd.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.dtfinance.ltd.finance.model.FinanceStatus;
import com.dtfinance.ltd.finance.model.MonthlyReport;
import com.dtfinance.ltd.finance.response_model.MonthlyReportResponseBean;

@Repository
public class MonthlyReportDaoImpl implements MonthlyReportDao{
	
	@Autowired
	private MonthlyReportRepository MonthlyReportRepository;
	
	@Autowired
	private MonthlyReportResponseBean MonthlyReportResponseBean;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public MonthlyReportResponseBean getCustomerDetails(int agent_id, int offset, int limit) {
		List<MonthlyReport> MonthlyReportList = MonthlyReportRepository.getCustomerDetails(agent_id,offset,limit);
		MonthlyReportList.stream().forEach(data -> {
			String dateValue = data.getCollection_date();
			data.setCollection_date(dateValue.substring(0, 10));
			if(data.getGiven_date() !=null) {
				String givenDate= data.getGiven_date();
				data.setGiven_date(givenDate.substring(0, 10));
			}
		});
		int dataSize = getDataCount();
		MonthlyReportResponseBean.setDataList(MonthlyReportList);
		MonthlyReportResponseBean.setDataSize(dataSize);
		return MonthlyReportResponseBean;
	}
	
	private int getDataCount() {
		return (int) MonthlyReportRepository.count();
	}
	

	@Override
	public List<MonthlyReport> customerDetailsDownload() {
		return MonthlyReportRepository.findAll();
	}

	@Override
	public ResponseEntity<FinanceStatus> insertReportData(MonthlyReport MonthlyReport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MonthlyReport getSingleCustomerData(int agent_id, int cust_id) {
		return MonthlyReportRepository.getSingleCustomerData(agent_id,cust_id);
	}
	
	/*@Override
	@Transactional
	public ResponseEntity<FinanceStatus> insertReportData(MonthlyReport MonthlyReport) {
		entityManager.createNativeQuery("insert into daily_report(customer_id,customer_name,emi,collection_date,previous_balance,current_balance,received_amount,"
				+ "balance,status,given_date,agent_id) values(?,?,?,to_date(?,'yyyy/mm/dd'),?,?,?,?,?,"
				+ "to_date(?,'yyyy/mm/dd'),?)").setParameter(1, MonthlyReport.getCustomer_id()).setParameter(2, MonthlyReport.getCustomer_name()).setParameter(3, MonthlyReport.getEmi()).
		setParameter(4, MonthlyReport.getCollection_date()).setParameter(5, MonthlyReport.getPrevious_balance()).setParameter(6, MonthlyReport.getCurrent_balance()).
		setParameter(7, MonthlyReport.getReceived_amount()).setParameter(8, MonthlyReport.getBalance()).setParameter(9,MonthlyReport.getStatus()).setParameter(10, MonthlyReport.getGiven_date())
		.setParameter(11, MonthlyReport.getAgent_id()).executeUpdate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
	}*/

}
