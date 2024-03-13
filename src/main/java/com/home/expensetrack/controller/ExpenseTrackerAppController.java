package com.home.expensetrack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExpenseTrackerAppController {
	private final Logger logger = LoggerFactory.getLogger(ExpenseTrackerAppController.class);
	
	public ExpenseTrackerAppController() {
		
	}
	 
	@GetMapping("/")
	public ResponseEntity<String> greeting() {
		logger.info("Expense Tracker is Working!");
		return new ResponseEntity<>("Expense Tracker is Working!", HttpStatus.OK);
	}
	
}
