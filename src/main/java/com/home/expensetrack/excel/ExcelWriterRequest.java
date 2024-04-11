package com.home.expensetrack.excel;

import java.util.List;

public interface ExcelWriterRequest {
    String fileName();
    String sheetName();

    int colCount();
    List<String> colHeaders();
    List<ExcelCell[]> rowData();
    List<Integer> colSizes();
}
