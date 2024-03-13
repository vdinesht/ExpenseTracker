package com.home.expensetrack.datamigrate.excel;

public interface ExcelReadRequest {
    int colCount();
    ExcelCellType[] colTypes();
    String fullFileName();
}
