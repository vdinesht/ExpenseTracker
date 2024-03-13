package com.home.expensetrack.service.Impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.expensetrack.data.models.HomeExpense;
import com.home.expensetrack.data.repository.HomeExpenseRepository;
import com.home.expensetrack.service.ExpenseSheetDataLoader;
import com.home.expensetrack.service.models.ExpenseGSheetItem;

@Service
public class ExpenseSheetLoaderService implements ExpenseSheetDataLoader{

	private final static Logger  logger = LoggerFactory.getLogger(ExpenseSheetLoaderService.class);
	
	@Autowired
	private HomeExpenseRepository homeExpenseRepo;
	
	@Override
	public void loadDataIntoDB(Path p) {
		
		logger.info(p.getFileName().toString());
		
		//Identify list of items to update
		Stream<Integer> gSheetListInExpenseSheet = getListGSheetIdFromExpenseSheet(p).stream();
		
		List<Integer> gSheetListInDB = homeExpenseRepo.findDistinctGsheetId();
		logger.info("Count of GSheet Ids in DB: " + gSheetListInDB.size() );
		
		List<Integer> addList = gSheetListInExpenseSheet.filter(element -> !gSheetListInDB.contains(element))
				   .collect(Collectors.toList());
		logger.info("Count of GSheet Ids to Add: " + addList.size() );
		
		//if there are items available to add perform addition
		if (addList.size() > 0) {
			addExpenseDataToDB(getListGSheetItemFromExpenseSheetForGSheetIdList(p, addList));
		}
		
		
		
		//update reset of the records already in DB
		if (gSheetListInDB.size() > 0) {
			updateExpenseDataToDB(p, gSheetListInDB);

		}

		return;

	}
	
	
	private void updateExpenseDataToDB(Path p, List<Integer> gSheetListInDB) {
		
		Integer count = 0;
		
		//Get All items in database 100 at a time and update
		
		//Identify list of items to update

		final AtomicInteger counter = new AtomicInteger(0);
		Collection<List<Integer>> partitionGSheetIdList = gSheetListInDB.stream()
															.collect(Collectors.groupingBy(s -> counter.getAndIncrement()/100))
															.values();
		
		for(List<Integer> l: partitionGSheetIdList ) {
			
			List<HomeExpense> listHomeExpenseItems = l.stream()
													  .map(i -> homeExpenseRepo.findByGsheetId(i).get(0))
													  .collect(Collectors.toList());
			
			List<ExpenseGSheetItem> listGSheetItems = getListGSheetItemFromExpenseSheetForGSheetIdList(p, l);
			
            Map<Integer, ExpenseGSheetItem> mapGSheetItem = listGSheetItems.stream()
            													.collect(Collectors.toMap( e-> Integer.parseInt(e.getgSheetId()), Function.identity()));
			listHomeExpenseItems.forEach(i -> copyGSheeetToHomeExpenseItem(mapGSheetItem.get(i.getGsheetId()), i));
			
			//save to DB
			homeExpenseRepo.saveAll(listHomeExpenseItems);
			count = count + listHomeExpenseItems.size();
			logger.info("Records updated to DB: " + count);

		}
		
		return ;
	}

	private void addExpenseDataToDB(List<ExpenseGSheetItem> listExpenseTrackerItems) {
		
		Integer count = 0;
		
		//Translate ExpenseTracker to ExpenseItems
		
		List<HomeExpense> listExpenseItems = new ArrayList<HomeExpense>();
		
		for(ExpenseGSheetItem item: listExpenseTrackerItems) {
			listExpenseItems.add(getHomeExpenseFromGSheetItem(item));			
		}
		
		homeExpenseRepo.saveAll(listExpenseItems);
		
		count = listExpenseItems.size();
		logger.info("Records added to DB: " + count);
		logger.info("Records in DB: " + homeExpenseRepo.count());
		
		return ;
	}
	
	private HomeExpense copyGSheeetToHomeExpenseItem(ExpenseGSheetItem item, HomeExpense updateDBItem) {
		
		//convert date
		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		try {
			java.util.Date javaDate = dateFormat.parse(item.getDate());
			java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
			
			logger.info("Date read from CSV: " + item.getDate());
			logger.info("Date converted to JavaDate: " + javaDate.toString());
			logger.info("Date converted to SqlDate: " + sqlDate.toString());
			updateDBItem.setDate(sqlDate);

			
		} catch (ParseException e) {
			logger.info("Unable to parse Date string : " + item.getDate());
			updateDBItem.setDate(java.sql.Date.valueOf("2000-01-01"));
			e.printStackTrace();
		}
		
		//Convert amount to Float
		try {
			Float amount = Float.parseFloat(item.getAmount());
			updateDBItem.setAmount(amount);
		} catch (NumberFormatException e) {
			logger.info("Unbale to parse Float string : " + item.getAmount());
			updateDBItem.setAmount(0.00F);
		}
		
		updateDBItem.setCurrency(item.getCurrency());
		updateDBItem.setCategory(item.getCategory());
		updateDBItem.setDescription(item.getDescription());
		updateDBItem.setType(item.getType());
		updateDBItem.setGoogleDriveLink(item.getGoogleDriveLink());

		updateDBItem.setUpdatedTime(Timestamp.from(Instant.now()));
		return updateDBItem;
	}


	private HomeExpense getHomeExpenseFromGSheetItem(ExpenseGSheetItem item) {
		HomeExpense newDBItem = new HomeExpense();
		
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
		newDBItem.setGsheetId(Integer.parseInt(item.getgSheetId()));
		newDBItem.setCreatedBy("ExpenseTrackerJavaApp");
		newDBItem.setCreatedTime(Timestamp.from(Instant.now()));
		newDBItem.setUpdatedTime(Timestamp.from(Instant.now()));
		return newDBItem;
	}

	
	private static  String removeQuotesAndCommas(String line) {
		
		String flattenedLine;
		
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		Matcher m = p.matcher(line);
		
		if (m.find()) {
			
			String flatAmount = m.group().replaceAll("\"", "");
			flatAmount = flatAmount.replaceAll(",", "");
			flattenedLine = line.replace(m.group(), flatAmount);
		   
		   //look for , in Description
		   if (m.find()) {
			   String flatDescription = m.group().replaceAll("\"", "");
			   flatDescription = flatDescription.replaceAll(",", "?"); //replace comma with ?
			   flattenedLine = flattenedLine.replace(m.group(), flatDescription);
		   }
		}
		else {
			flattenedLine =  line;
		}
		
		return flattenedLine; 

	}

	private static Stream<ExpenseGSheetItem> lineToExpenseGSheetItem(String line){
		try {
			//identify the amounts inside double quotes
			
			String[] elements = removeQuotesAndCommas(line).split(",");
			
			ExpenseGSheetItem item = new ExpenseGSheetItem();
	    	item.setDate(elements[0]);
	    	item.setAmount(elements[1]);
	    	item.setCurrency(elements[2]);
	    	item.setDescription( elements[3].replace("?", ","));  //put back the comma's in description
	    	if (elements[4].isBlank()) {
	    		item.setType(elements[4]);
	    	} 
	    	else {
	    		item.setType(elements[4]);
	    	}
	    	
	    	
	    	if (elements[5].isBlank()) {
	    		item.setCategory(elements[5]);
	    	} 
	    	else {
	    		item.setCategory(elements[5]);
	    	}
	    	
	    	if (elements[6].isBlank()) {
	    		item.setGoogleDriveLink(elements[6]);
	    	} 
	    	else {
	    		item.setGoogleDriveLink(elements[6]);
	    	}
	    	
	    	
	    	item.setgSheetId(elements[7]);
			
			return Stream.of(item);
		}
		catch(Exception e) {
			logger.info("Parse failed: " + line);

		}
		return Stream.empty();
	}
	
	private List<ExpenseGSheetItem> getListGSheetItemFromExpenseSheetForGSheetIdList(Path p, List<Integer> listGSheetId){
		
		List<ExpenseGSheetItem> listGSheetItem = new ArrayList<ExpenseGSheetItem>();
		
		try(Stream<String> lines = Files.lines(p);	){
			Stream<ExpenseGSheetItem> streamItems = lines.filter(line -> !line.startsWith("Date"))
				 .flatMap(ExpenseSheetLoaderService::lineToExpenseGSheetItem);
			
			
			listGSheetItem = streamItems
								.filter(i -> listGSheetId.contains(Integer.parseInt(i.getgSheetId())))
								.collect(Collectors.toList());
			
			logger.info("Count of GSheet Items List read from file: " + listGSheetItem.size());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return listGSheetItem;		
	}
	
	private List<Integer> getListGSheetIdFromExpenseSheet(Path p){
		
		List<Integer> listGSheetId = new ArrayList<Integer>();
		try(Stream<String> lines = Files.lines(p);	){
			Stream<ExpenseGSheetItem> streamItems = lines.filter(line -> !line.startsWith("Date"))
				 .flatMap(ExpenseSheetLoaderService::lineToExpenseGSheetItem);
			
			
			listGSheetId = streamItems
								.map(i -> Integer.parseInt(i.getgSheetId()))
								.collect(Collectors.toList());
			
			logger.info("Count of GSheet Id List: " + listGSheetId.size());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return listGSheetId;
	}
	

}
