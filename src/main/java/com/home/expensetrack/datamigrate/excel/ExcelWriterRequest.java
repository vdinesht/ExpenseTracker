package com.home.expensetrack.datamigrate.excel;

import java.util.List;

public interface ExcelWriterRequest {
    String fileName();
    int colCount();
    List<String> colHeaders();
    List<ExcelCell[]> rowData();
    List<Integer> colSizes();
}
