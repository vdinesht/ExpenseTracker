package com.home.expensetrack.datamigrate.excel;

public interface ExcelReader {
    ExcelReadResponse readFile(ExcelReadRequest request);
}
