package com.home.expensetrack.service;

import java.util.List;


public interface ExpenseItemsBetweenDates {
	public List<String> getExpenseItemBetweenForGivenPageAndSize(String fromDate, String toDate, Integer page, Integer size);

}
