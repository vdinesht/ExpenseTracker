package com.home.expensetrack.excel;

import java.util.List;

public interface ExcelReadResponse {
    int colCount();
    ExcelCellType[] colTypes();
    List<ExcelCell[]> rowData();

}
