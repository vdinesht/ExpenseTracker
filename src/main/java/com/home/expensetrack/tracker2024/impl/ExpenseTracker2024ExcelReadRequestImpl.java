package com.home.expensetrack.tracker2024.impl;

import com.home.expensetrack.excel.ExcelCellType;
import com.home.expensetrack.excel.ExcelReadRequest;

public class ExpenseTracker2024ExcelReadRequestImpl implements ExcelReadRequest {

    private final int col = 12;
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
        cellTypes[7] = ExcelCellType.string;
        cellTypes[8] = ExcelCellType.string;
        cellTypes[9] = ExcelCellType.string;
        cellTypes[10] = ExcelCellType.string;
        cellTypes[11] = ExcelCellType.number;
        return cellTypes;
    }

    @Override
    public String fullFileName() {
        return this.fileName;
    }

    public ExpenseTracker2024ExcelReadRequestImpl(String fileName) {
        this.fileName = fileName;
    }

}
