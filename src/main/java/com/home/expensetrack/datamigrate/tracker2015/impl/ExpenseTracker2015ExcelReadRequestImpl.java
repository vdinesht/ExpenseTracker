package com.home.expensetrack.datamigrate.tracker2015.impl;

import com.home.expensetrack.datamigrate.excel.ExcelCellType;
import com.home.expensetrack.datamigrate.excel.ExcelReadRequest;

public class ExpenseTracker2015ExcelReadRequestImpl implements ExcelReadRequest {

    private final int col = 8;
    private String fileName;
    @Override
    public int colCount() {
        return this.col;
    }

    @Override
    public ExcelCellType[] colTypes() {
        ExcelCellType[] cellTypes = new ExcelCellType[col];
        cellTypes[0] = ExcelCellType.date;
        cellTypes[1] = ExcelCellType.number;
        cellTypes[2] = ExcelCellType.string;
        cellTypes[3] = ExcelCellType.string;
        cellTypes[4] = ExcelCellType.string;
        cellTypes[5] = ExcelCellType.string;
        cellTypes[6] = ExcelCellType.string;
        cellTypes[7] = ExcelCellType.number;
        return cellTypes;
    }

    @Override
    public String fullFileName() {
        return this.fileName;
    }

    public ExpenseTracker2015ExcelReadRequestImpl(String fileName) {
        this.fileName = fileName;
    }
}
