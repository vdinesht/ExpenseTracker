package com.home.expensetrack.service.Impl;

import org.springframework.stereotype.Service;

import com.home.expensetrack.service.ExpenseItemChecker;

@Service
public class ExpenseItemCheckerService implements ExpenseItemChecker {

	@Override
	public Boolean isRecordInDB(String date, String amount, String description) {
		Boolean recordFound = false;
		
		
		return recordFound;
	}
	

}
