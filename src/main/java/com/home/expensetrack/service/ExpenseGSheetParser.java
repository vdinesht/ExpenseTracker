package com.home.expensetrack.service;

import java.util.List;

import com.home.expensetrack.service.models.ExpenseGSheetItem;

public interface ExpenseGSheetParser {
	Integer getRecordCount(String filePath);
	List<ExpenseGSheetItem> getRecords(Integer fromRow, Integer toRow, String filePath);

}
