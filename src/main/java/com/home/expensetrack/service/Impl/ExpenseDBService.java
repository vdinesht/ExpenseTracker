package com.home.expensetrack.service.Impl;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.home.expensetrack.data.models.ExpenseItem;
import com.home.expensetrack.data.repository.ExpenseItemRepository;
import com.home.expensetrack.data.repository.ExpenseItemPagingRepository;
import com.home.expensetrack.service.ExpenseDB;
import com.home.expensetrack.service.models.ExpenseGSheetItem;

@Service
public class ExpenseDBService implements ExpenseDB {
	
	private final Logger logger = LoggerFactory.getLogger(ExpenseDBService.class);

	@Autowired
	ExpenseItemRepository expenseItemRepo;
	
	@Autowired
	ExpenseItemPagingRepository expenseRepository;
	
	
	public void deleteAllData() {
		expenseItemRepo.deleteAll();
	}
	
	public Page<ExpenseItem> getExpensesFor(Pageable pageable){
		return expenseRepository.findAllByOrderByDateAsc(pageable);
	}
	
	public Page<ExpenseItem> getExpensesBetweenDateFor(Date fromDate, Date toDate, Pageable pageable){
		return expenseRepository.findAllByDateGreaterThanEqualAndDateLessThanEqualOrderByDateAsc(fromDate, toDate, pageable);
		
	}
	
	public Integer addExpenseData(List<ExpenseGSheetItem> listExpenseTrackerItems) {
		
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
	public Integer getRecordCount() {
		
		return Long.valueOf(expenseItemRepo.count()).intValue();
	}

}
