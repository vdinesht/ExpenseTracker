package com.home.expensetrack.service.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.home.expensetrack.service.ExpenseGSheetParser;
import com.home.expensetrack.service.models.ExpenseGSheetItem;

@Service
public class ExpenseGSheetParserService implements ExpenseGSheetParser{
	
	private static final String[] HEADERS = {"Date", "Amount", "Currency", "Description", "Type", "Category", "GoogleDriveLink"};
	private final Logger logger = LoggerFactory.getLogger(ExpenseGSheetParserService.class);

	@Override
	public Integer getRecordCount(String filePath) {
		
		Integer rowCount = 0;
		try {
			Path path = Paths.get(filePath);
	        BufferedReader reader;

			reader = Files.newBufferedReader(path);
			
			CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader(HEADERS).withSkipHeaderRecord());
		
			for (CSVRecord csvRecord : parser) {
				
				ExpenseGSheetItem item = new ExpenseGSheetItem();
			   	 
		    	item.setDate(csvRecord.get(HEADERS[0]));
		    	String amountVal;
		    	amountVal = csvRecord.get(HEADERS[1]);
		    	item.setAmount(amountVal.replace(",", ""));
		    	item.setCurrency(csvRecord.get(HEADERS[2]));
		    	item.setDescription( csvRecord.get(HEADERS[3]));
		    	item.setType(csvRecord.get(HEADERS[4]));
		    	item.setCategory(csvRecord.get(HEADERS[5]));
		    	item.setGoogleDriveLink(csvRecord.get(HEADERS[6]));
		    	
		    	if (item.isValidRecord()) {
		    		++rowCount;
		    	}	
			 }
 			parser.close();
			reader.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info(e.toString());
		}        
        		
		return rowCount;
	}

	@Override
	public List<ExpenseGSheetItem> getRecords(Integer fromRow, Integer toRow, String filePath) {
		
		Integer rowCount = 0;
		List<ExpenseGSheetItem> listExpenseTrackerItems = new ArrayList<ExpenseGSheetItem>();
		
		try {
			Path path = Paths.get(filePath);
	        BufferedReader reader;

			reader = Files.newBufferedReader(path);
			
			CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader(HEADERS).withSkipHeaderRecord());
			
			
			for (CSVRecord csvRecord : parser) {
				
				ExpenseGSheetItem item = new ExpenseGSheetItem();
			   	 
		    	item.setDate(csvRecord.get(HEADERS[0]));
		    	String amountVal;
		    	amountVal = csvRecord.get(HEADERS[1]);
		    	item.setAmount(amountVal.replace(",", ""));
		    	item.setCurrency(csvRecord.get(HEADERS[2]));
		    	item.setDescription( csvRecord.get(HEADERS[3]));
		    	item.setType(csvRecord.get(HEADERS[4]));
		    	item.setCategory(csvRecord.get(HEADERS[5]));
		    	item.setGoogleDriveLink(csvRecord.get(HEADERS[6]));
		    	
		    	if (item.isValidRecord()) {
		    		++rowCount;
		    		if (fromRow <= rowCount && toRow >= rowCount) {
		    			listExpenseTrackerItems.add(item);
		    		}
		    	}	
			 }

 			parser.close();
			reader.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info(e.toString());
		}        
        		
		return listExpenseTrackerItems;

	}

}
