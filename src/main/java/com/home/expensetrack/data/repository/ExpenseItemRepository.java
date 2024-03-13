package com.home.expensetrack.data.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.home.expensetrack.data.models.ExpenseItem;

public interface ExpenseItemRepository extends CrudRepository<ExpenseItem, Integer> {
	List<ExpenseItem> findByDateAndAmountAndDescription(Date date, Float amount, String description);
	
}
