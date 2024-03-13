package com.home.expensetrack.service;

public interface ExpenseItemChecker {
	Boolean isRecordInDB(String date, String amount, String description);
}
