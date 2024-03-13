package com.home.expensetrack.service.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.expensetrack.data.models.ExpenseItem;
import com.home.expensetrack.data.repository.ExpenseItemRepository;
import com.home.expensetrack.data.repository.ExpenseItemPagingRepository;
import com.home.expensetrack.service.LoadGSheetAndRefreshExpenseItems;
import com.home.expensetrack.service.models.ExpenseGSheetItem;

@Service
public class LoadGSheetAndRefreshExpenseItemsService implements LoadGSheetAndRefreshExpenseItems {

	private static final String[] HEADERS = {"Date", "Amount", "Currency", "Description", "Type", "Category", "GoogleDriveLink"};
	private final Logger logger = LoggerFactory.getLogger(LoadGSheetAndRefreshExpenseItemsService.class);
	
	@Autowired
	ExpenseItemRepository expenseItemRepo;
	
	@Autowired
	ExpenseItemPagingRepository expenseRepository;
	
	private void deleteAllData() {
		expenseItemRepo.deleteAll();
	}
	
	private Integer addExpenseData(List<ExpenseGSheetItem> listExpenseTrackerItems) {
		
		Integer count = 0;
		
		//Translate ExpenseTracker to ExpenseItems
		
		List<ExpenseItem> listExpenseItems = new ArrayList<ExpenseItem>();
		
		for(ExpenseGSheetItem item: listExpenseTrackerItems) {
			
			ExpenseItem newDBItem = new ExpenseItem();
			
			//convert date
			DateFormat dateFormat = new SimpleDateFormat("m/d/yyyy");
			try {
				java.util.Date javaDate = dateFormat.parse(item.getDate());
				java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
				
				
				
				newDBItem.setAmount(0.00F);
				
				newDBItem.setDate(sqlDate);

				
			} catch (ParseException e) {
				logger.info("Unable to parse Date string : " + item.getDate());
				newDBItem.setDate(java.sql.Date.valueOf("2000-01-01"));
				e.printStackTrace();
			}
			
			//Convert amount to Float
			try {
				Float amount = Float.parseFloat(item.getAmount());
				newDBItem.setAmount(amount);
			} catch (NumberFormatException e) {
				logger.info("Unbale to parse Float string : " + item.getAmount());
				newDBItem.setAmount(0.00F);
			}
			
			newDBItem.setCurrency(item.getCurrency());
			newDBItem.setCategory(item.getCategory());
			newDBItem.setDescription(item.getDescription());
			newDBItem.setType(item.getType());
			newDBItem.setGoogleDriveLink(item.getGoogleDriveLink());
			
			listExpenseItems.add(newDBItem);
			
		}
		
		expenseItemRepo.saveAll(listExpenseItems);
		
		count = listExpenseItems.size();
		
		return count;
	}

	@Override
	public Integer loadClearAndSave(String filePath) {
		
		Integer rowCount = 0;
		try {
			Path path = Paths.get(filePath);
	        BufferedReader reader;

			reader = Files.newBufferedReader(path);
			
			CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader(HEADERS).withSkipHeaderRecord());
			
			deleteAllData();
			
			List<ExpenseGSheetItem> listExpenseTrackerItems = new ArrayList<ExpenseGSheetItem>();
			
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
		    	
		    	listExpenseTrackerItems.add(item);
		    	++rowCount;
		    	//add to database every 100 records
		    	if (rowCount % 100 == 0) {
		    		addExpenseData(listExpenseTrackerItems);
		    		logger.info("Saved to Expense DB rows: " + Integer.toString(listExpenseTrackerItems.size()));
		    		listExpenseTrackerItems.clear();
		    	}
		    	
			 }
			 
			//add the residue list as well
			if (listExpenseTrackerItems.size() > 0) {
				addExpenseData(listExpenseTrackerItems);
				logger.info("Saved to Expense DB rows: " + Integer.toString(listExpenseTrackerItems.size()));
			}
			
 			parser.close();
			reader.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        		
		return rowCount;

	}

}
