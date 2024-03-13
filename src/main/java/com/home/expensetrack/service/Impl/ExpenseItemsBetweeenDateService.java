package com.home.expensetrack.service.Impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.expensetrack.data.models.HomeExpense;
import com.home.expensetrack.data.repository.HomeExpensePagingAndSortingRepository;
import com.home.expensetrack.service.ExpenseItemsBetweenDates;
import com.home.expensetrack.service.models.ExpenseGSheetItem;

@Service
public class ExpenseItemsBetweeenDateService implements ExpenseItemsBetweenDates{

	private final Logger  logger = LoggerFactory.getLogger(ExpenseItemsBetweeenDateService.class);
	
	@Autowired
	HomeExpensePagingAndSortingRepository expenseRepository;
	
	
	@Override
	public List<String> getExpenseItemBetweenForGivenPageAndSize(String fromDate, String toDate,
			Integer page, Integer size) {
		
		Pageable pageable = PageRequest.of(page, size);
	    
		Page<HomeExpense> pageExpenseItems = expenseRepository.findAllByDateGreaterThanEqualAndDateLessThanEqualOrderByDateAsc(Date.valueOf(fromDate), Date.valueOf(toDate), pageable);		

		logger.info("Number of Expense items available for given criteria: " + pageExpenseItems.getTotalElements());
		
		List<String> listExpenseItems = new ArrayList<String>();
		
		if (pageExpenseItems.getContent().size() > 0) {
			
			listExpenseItems = pageExpenseItems.getContent().stream()
													.map(p -> { String jsonValue = "";
																ExpenseGSheetItem expenseItem = new ExpenseGSheetItem(p.getDate().toLocalDate().toString(), 
												                         p.getCurrency(), 
												                         p.getAmount().toString(), 
												                         p.getDescription(), 
												                         p.getType(), 
												                         p.getCategory(),
												                         p.getGoogleDriveLink(), 
												                         p.getGsheetId().toString());
																ObjectMapper objMapper = new ObjectMapper();
																try {
																	jsonValue = objMapper.writeValueAsString(expenseItem);
																} catch (JsonProcessingException e) {
																	logger.info(e.toString());}
																return jsonValue; })
													.collect(Collectors.toList());}	
		return listExpenseItems;
	}

}
