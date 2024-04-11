package com.home.expensetrack.excel;

public interface ExcelReadRequest {
    int colCount();
    ExcelCellType[] colTypes();
    String fullFileName();
}
