package com.home.expensetrack.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.home.expensetrack.data.models.ProcessedGsheetCsvFile;

public interface ProcessedGsheetCsvFileRepository extends CrudRepository<ProcessedGsheetCsvFile, Long>  {
	List<ProcessedGsheetCsvFile> findByCsvFileName(String csvFileName);
}
