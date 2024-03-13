package com.home.expensetrack.data.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.home.expensetrack.data.models.HomeExpense;

public interface HomeExpensePagingAndSortingRepository extends PagingAndSortingRepository<HomeExpense, Long> {
	Page<HomeExpense> findAllByOrderByDateAsc(Pageable pageable);
	Page<HomeExpense> findAllByDateGreaterThanEqualAndDateLessThanEqualOrderByDateAsc(Date fromDate, Date toDate, Pageable pageable);

}
