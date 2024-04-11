package com.home.expensetrack.excel.impl;

import com.home.expensetrack.excel.ExcelCell;
import com.home.expensetrack.excel.ExcelCellType;
import com.home.expensetrack.excel.ExcelReadResponse;

import java.util.List;

public class ExcelReadResponseImpl implements ExcelReadResponse {
    private int colCount;
    private ExcelCellType[] cellTypes;
    private List<ExcelCell[]> rowCells;

    @Override
    public int colCount() {
        return colCount;
    }

    @Override
    public ExcelCellType[] colTypes() {
        return this.cellTypes;
    }

    @Override
    public List<ExcelCell[]> rowData() {
        return rowCells;
    }

    public ExcelReadResponseImpl(int colCount, ExcelCellType[] colTypes, List<ExcelCell[]> rowCells) {
        this.colCount = colCount;
        this.cellTypes = colTypes;
        this.rowCells = rowCells;
    }
    public ExcelReadResponseImpl()
    {
        this.colCount = 0;
    }

    @Override
    public String toString() {
        return "ExcelReadResponseImpl{" +
                "colCount=" + colCount +
                ", colHeaders=" + cellTypes +
                ", rowCells=" + rowCells.size() +
                '}';
    }
}
