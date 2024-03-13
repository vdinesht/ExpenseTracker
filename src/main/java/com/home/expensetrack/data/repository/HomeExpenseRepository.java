package com.home.expensetrack.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.home.expensetrack.data.models.HomeExpense;

public interface HomeExpenseRepository extends CrudRepository<HomeExpense, Long> {
	@Query("SELECT DISTINCT a.gsheetId FROM HomeExpense a")
    List<Integer> findDistinctGsheetId();
	List<HomeExpense> findByGsheetId(Integer gsheetId);
}
