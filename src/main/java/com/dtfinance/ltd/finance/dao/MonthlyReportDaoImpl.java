package com.dtfinance.ltd.finance.dao;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	private MonthlyReport selectMonthlyReportData(int cust_id, MonthlyReport reportData) {
		MonthlyReport selectedMonthlyReport = MonthlyReportRepository.getCustomerById(cust_id);
		Class<? extends MonthlyReport> ghj = selectedMonthlyReport.getClass();
		Class<? extends MonthlyReport> gh = reportData.getClass();
		Field[] fieldArray = gh.getDeclaredFields();
		 Field[] tt = ghj.getDeclaredFields();
		for(int i=0; i < fieldArray.length; i++) {
			Field field = fieldArray[i];
			Field filed2 = tt[i];
			field.setAccessible(true);
			filed2.setAccessible(true);
			try {
				if(field.get(reportData) != null) {
					if(field.getName().equals(filed2.getName())) {
						filed2.set(selectedMonthlyReport, field.get(reportData));
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return selectedMonthlyReport;
	}
	
	@Override
	@Transactional
	public ResponseEntity<FinanceStatus> updateMonthlyReportData(MonthlyReport reportData) {
		MonthlyReport updateData = selectMonthlyReportData(reportData.getCustomer_id(),reportData);
		entityManager.createNativeQuery("update monthly_report set emi=?,collection_date=to_date(?,'yyyy/mm/dd'),previous_balance=?,"  
								+ "current_balance=?,received_amount=?,balance=?,given_date=to_date(?,'yyyy/mm/dd'),agent_id=?,date_1=?,date_2=?,date_3=?,date_4=?,date_5=?,"
								+ "date_6=?,date_7=?,date_8=?,date_9=?,date_10=?,date_11=?,date_12=?,date_13=?,date_14=?,date_15=?,date_16=?,date_17=?,date_18=?,date_19=?,date_20=?,date_21=?,"
								+ "date_22=?,date_23=?,date_24=?,date_25=?,date_26=?,date_27=?,date_28=?,date_29=?,date_30=?,date_31=? where customer_id=?")
		/*.setParameter(1, reportData.getEmi()).setParameter(2, reportData.getCollection_date()).setParameter(3, reportData.getPrevious_balance()).setParameter(4, reportData.getCurrent_balance()).
		setParameter(5, reportData.getReceived_amount()).setParameter(6, reportData.getBalance()).setParameter(7, reportData.getGiven_date()).setParameter(8, reportData.getAgent_id()).setParameter(9, reportData.getDate_1()).setParameter(10, reportData.getDate_2())
		.setParameter(11, reportData.getDate_3()).setParameter(12, reportData.getDate_4()).setParameter(13, reportData.getDate_5()).setParameter(14, reportData.getDate_6()).setParameter(15, reportData.getDate_7()).setParameter(16, reportData.getDate_8())
		.setParameter(17, reportData.getDate_9()).setParameter(18, reportData.getDate_10()).setParameter(19, reportData.getDate_11()).setParameter(20, reportData.getDate_12()).setParameter(21, reportData.getDate_13()).setParameter(22, reportData.getDate_14()).setParameter(23, reportData.getDate_15())
		.setParameter(24, reportData.getDate_16()).setParameter(25, reportData.getDate_17()).setParameter(26, reportData.getDate_18()).setParameter(27, reportData.getDate_19()).setParameter(28, reportData.getDate_20()).setParameter(29, reportData.getDate_21())
		.setParameter(30, reportData.getDate_22()).setParameter(31, reportData.getDate_23()).setParameter(32, reportData.getDate_24()).setParameter(33, reportData.getDate_25()).setParameter(34, reportData.getDate_26()).setParameter(35, reportData.getDate_27())
		.setParameter(36, reportData.getDate_28()).setParameter(37, reportData.getDate_29()).setParameter(38, reportData.getDate_30()).setParameter(39, reportData.getDate_31()).setParameter(40, reportData.getCustomer_id()).executeUpdate();*/
		.setParameter(1, updateData.getEmi()).setParameter(2, "2022/01/23").setParameter(3, updateData.getPrevious_balance()).setParameter(4, updateData.getCurrent_balance()).
		setParameter(5, updateData.getReceived_amount()).setParameter(6, updateData.getBalance()).setParameter(7, "2022/01/23").setParameter(8, updateData.getAgent_id()).setParameter(9, updateData.getDate_1()).setParameter(10, updateData.getDate_2())
		.setParameter(11, updateData.getDate_3()).setParameter(12, updateData.getDate_4()).setParameter(13, updateData.getDate_5()).setParameter(14, updateData.getDate_6()).setParameter(15, updateData.getDate_7()).setParameter(16, updateData.getDate_8())
		.setParameter(17, updateData.getDate_9()).setParameter(18, updateData.getDate_10()).setParameter(19, updateData.getDate_11()).setParameter(20, updateData.getDate_12()).setParameter(21, updateData.getDate_13()).setParameter(22, updateData.getDate_14()).setParameter(23, updateData.getDate_15())
		.setParameter(24, updateData.getDate_16()).setParameter(25, updateData.getDate_17()).setParameter(26, updateData.getDate_18()).setParameter(27, updateData.getDate_19()).setParameter(28, updateData.getDate_20()).setParameter(29, updateData.getDate_21())
		.setParameter(30, updateData.getDate_22()).setParameter(31, updateData.getDate_23()).setParameter(32, updateData.getDate_24()).setParameter(33, updateData.getDate_25()).setParameter(34, updateData.getDate_26()).setParameter(35, updateData.getDate_27())
		.setParameter(36, updateData.getDate_28()).setParameter(37, updateData.getDate_29()).setParameter(38, updateData.getDate_30()).setParameter(39, updateData.getDate_31()).setParameter(40, updateData.getCustomer_id()).executeUpdate();
		return new ResponseEntity<FinanceStatus>(HttpStatus.OK);
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
