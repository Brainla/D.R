package com.dtfinance.ltd.finance.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.dtfinance.ltd.finance.model.DailyWork;
import com.dtfinance.ltd.finance.model.MonthlyReport;

@Service
public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "CUSTOMER_ID", "CUSTOMER_NAME", "EMI", "COLLECTION_DATE","PREVIOUS_BALANCE","CURRENT_BALANCE",
		  "RECEIVED_AMOUNT","BALANCE","STATUS","GIVEN_DATE","AGENT_ID"};
  static String[] MONTHLY_HEADERS = { "CUSTOMER_ID", "CUSTOMER_NAME", "EMI", "COLLECTION_DATE","PREVIOUS_BALANCE","CURRENT_BALANCE",
		  "RECEIVED_AMOUNT","BALANCE","GIVEN_DATE","AGENT_ID","DATE_1","DATE_2","DATE_3","DATE_4","DATE_5","DATE_6","DATE_7","DATE_8",
		  "DATE_9","DATE_10","DATE_11","DATE_12","DATE_13","DATE_14","DATE_15","DATE_16","DATE_17","DATE_18","DATE_19","DATE_20","DATE_21","DATE_22",
		  "DATE_23","DATE_24","DATE_25","DATE_26","DATE_27","DATE_28","DATE_29","DATE_30","DATE_31",};
  static String SHEET = "daily_work";
  static String MONTHLY_SHEET = "monthly_report";

  public ByteArrayInputStream tutorialsToExcel(List<DailyWork> dailywork) {

    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
      Sheet sheet = workbook.createSheet(SHEET);

      // Header
      Row headerRow = sheet.createRow(0);

      for (int col = 0; col < HEADERs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(HEADERs[col]);
      }

      int rowIdx = 1;
      for (DailyWork data : dailywork) {
        Row row = sheet.createRow(rowIdx++);

        row.createCell(0).setCellValue(data.getCustomer_id());
        row.createCell(1).setCellValue(data.getCustomer_name());
        row.createCell(2).setCellValue(data.getEmi());
        row.createCell(3).setCellValue(data.getCollection_date().substring(0, 10));
        row.createCell(4).setCellValue(data.getPrevious_balance());
        row.createCell(5).setCellValue(data.getCurrent_balance());
        row.createCell(6).setCellValue(data.getReceived_amount());
        row.createCell(7).setCellValue(data.getBalance());
        row.createCell(8).setCellValue(data.getStatus());
        if(data.getGiven_date() !=null) {
        	row.createCell(9).setCellValue(data.getGiven_date().substring(0, 10));
        }
        row.createCell(10).setCellValue(data.getAgent_id());
      }

      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
    }
  }
  
  public ByteArrayInputStream tutorialsToExcelMonthly(List<MonthlyReport> monthlyReport) {

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(MONTHLY_SHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < MONTHLY_HEADERS.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(MONTHLY_HEADERS[col]);
	      }

	      int rowIdx = 1;
	      for (MonthlyReport data : monthlyReport) {
	        Row row = sheet.createRow(rowIdx++);
	        row.createCell(0).setCellValue(data.getCustomer_id());
	        row.createCell(1).setCellValue(data.getCustomer_name());
	        row.createCell(2).setCellValue(data.getEmi());
	        row.createCell(3).setCellValue(data.getCollection_date().substring(0, 10));
	        row.createCell(4).setCellValue(data.getPrevious_balance());
	        row.createCell(5).setCellValue(data.getCurrent_balance());
	        row.createCell(6).setCellValue(data.getReceived_amount());
	        row.createCell(7).setCellValue(data.getBalance());
	        row.createCell(8).setCellValue(data.getGiven_date());
	        row.createCell(9).setCellValue(data.getAgent_id());
	        row.createCell(10).setCellValue(data.getDate_1());
	        row.createCell(11).setCellValue(data.getDate_2());
	        row.createCell(12).setCellValue(data.getDate_3());
	        row.createCell(13).setCellValue(data.getDate_4());
	        row.createCell(14).setCellValue(data.getDate_5());
	        row.createCell(15).setCellValue(data.getDate_6());
	        row.createCell(16).setCellValue(data.getDate_7());
	        row.createCell(17).setCellValue(data.getDate_8());
	        row.createCell(18).setCellValue(data.getDate_9());
	        row.createCell(19).setCellValue(data.getDate_10());
	        row.createCell(20).setCellValue(data.getDate_11());
	        row.createCell(21).setCellValue(data.getDate_12());
	        row.createCell(22).setCellValue(data.getDate_13());
	        row.createCell(23).setCellValue(data.getDate_14());
	        row.createCell(24).setCellValue(data.getDate_15());
	        row.createCell(25).setCellValue(data.getDate_16());
	        row.createCell(26).setCellValue(data.getDate_17());
	        row.createCell(27).setCellValue(data.getDate_18());
	        row.createCell(28).setCellValue(data.getDate_19());
	        row.createCell(29).setCellValue(data.getDate_20());
	        row.createCell(30).setCellValue(data.getDate_21());
	        row.createCell(31).setCellValue(data.getDate_22());
	        row.createCell(32).setCellValue(data.getDate_23());
	        row.createCell(33).setCellValue(data.getDate_24());
	        row.createCell(34).setCellValue(data.getDate_25());
	        row.createCell(35).setCellValue(data.getDate_26());
	        row.createCell(36).setCellValue(data.getDate_27());
	        row.createCell(37).setCellValue(data.getDate_28());
	        row.createCell(38).setCellValue(data.getDate_29());
	        row.createCell(39).setCellValue(data.getDate_30());
	        row.createCell(40).setCellValue(data.getDate_31());
	        if(data.getGiven_date() !=null) {
	        	row.createCell(9).setCellValue(data.getGiven_date().substring(0, 10));
	        }
	        row.createCell(10).setCellValue(data.getAgent_id());
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }

}