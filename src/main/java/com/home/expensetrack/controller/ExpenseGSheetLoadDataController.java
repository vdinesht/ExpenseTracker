package com.home.expensetrack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.expensetrack.controller.models.LoadGSheetRequest;
import com.home.expensetrack.controller.models.LoadGSheetResponse;
import com.home.expensetrack.service.ExpenseDB;
import com.home.expensetrack.service.ExpenseGSheetParser;

@RestController
public class ExpenseGSheetLoadDataController {
	
	private final Logger logger = LoggerFactory.getLogger(ExpenseGSheetLoadDataController.class);
	
	@Autowired
	private ExpenseGSheetParser expenseGSheetParserService;

	@Autowired
	private ExpenseDB expenseDBService;

	public ExpenseGSheetLoadDataController() {
		super();
	}
	
	@GetMapping("/loaddata")
	public String loadGsheetData(@RequestParam(value = "filepath", defaultValue = "/Users/dineshvincent/Downloads/Our Home Expense Tracker - 2015 - Transactions.csv") String value) {
		
		Integer count = 0; //expenseTrackerData.loadDataFromFile(value);
		logger.info("Number of rows saved to database :" + count.toString());
		
		String returnMessage; 
		if (count > 1) {
			returnMessage = "Successfully loaded data from file. Rows loaded are :" + count.toString();
		}
		else {
			returnMessage = "Load data failed. Data loaded is :" + count.toString();
		}
		return returnMessage;
	}
	
	@PostMapping(path = "/loaddata", 
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoadGSheetResponse> handleLoadDataRequest(@RequestBody LoadGSheetRequest newRequest) {
		
		logger.info("Post Request received: " + newRequest.toString());
		LoadGSheetResponse response = new LoadGSheetResponse();
		
	
		if (newRequest.getDryRun()) {
			response.setTotalRecordsInGSheet(expenseGSheetParserService.getRecordCount(newRequest.getFilePath()));
			response.setTotalRecordsInDB(expenseDBService.getRecordCount());
			response.setNewRecordAddedToDB(0);
			response.setModifiedRecordInDB(0);
			
			logger.info("Response returned: " + response.toString());
		}
		else {
			response.setTotalRecordsInGSheet(expenseGSheetParserService.getRecordCount(newRequest.getFilePath()));
			response.setTotalRecordsInDB(expenseDBService.getRecordCount());
			
			response.setNewRecordAddedToDB(1);
			response.setModifiedRecordInDB(1);
			
		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
