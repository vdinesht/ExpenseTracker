package com.home.expensetrack.data.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.home.expensetrack.data.models.ExpenseItem;

public interface ExpenseItemPagingRepository extends PagingAndSortingRepository<ExpenseItem, Integer> {
	Page<ExpenseItem> findAllByOrderByDateAsc(Pageable pageable);
	Page<ExpenseItem> findAllByDateGreaterThanEqualAndDateLessThanEqualOrderByDateAsc(Date fromDate, Date toDate, Pageable pageable);
}
