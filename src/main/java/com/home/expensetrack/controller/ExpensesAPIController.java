package com.home.expensetrack.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.expensetrack.controller.models.ExpenseRequestOptions;
import com.home.expensetrack.controller.models.ExpensesResponse;
import com.home.expensetrack.service.ExpenseItemsBetweenDates;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ExpensesAPIController {
	
	private final Logger logger = LoggerFactory.getLogger(ExpensesAPIController.class);

	public ExpensesAPIController() {
		super();
	}
	
	@Autowired
	private ExpenseItemsBetweenDates expenseItemsBetweenDateService;
	
	@PostMapping(path = "/api/expenses", 
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExpensesResponse> handleExpensesRequest(@RequestBody ExpenseRequestOptions newRequest) {
		
		logger.info("Post Request received: " + newRequest.toString());
		
		List<String> listExpenses = expenseItemsBetweenDateService.
														getExpenseItemBetweenForGivenPageAndSize(newRequest.getFromDate(), 
													    newRequest.getToDate(),
													    newRequest.getPage(),
													    newRequest.getSize());
		
		ExpensesResponse response = new ExpensesResponse(listExpenses.size(),
														 newRequest.getPage()+1,
														 newRequest.getPage()-1,
														 listExpenses);
		
		logger.info("Response returned: " + response.toString());
		 
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@GetMapping("/api/expenses")
	@ResponseBody
	public String getExpenses(@RequestParam Optional<String> page){
	    return "page: " + page.orElseGet(() -> "not provided");
	}
	
}
