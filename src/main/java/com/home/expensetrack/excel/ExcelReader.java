package com.home.expensetrack.excel;

public interface ExcelReader {
    ExcelReadResponse readFile(ExcelReadRequest request);
}
