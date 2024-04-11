package com.home.expensetrack.tracker2024.impl;

import com.home.expensetrack.excel.ExcelCell;
import com.home.expensetrack.excel.ExcelWriterRequest;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker2024ExcelWriterRequestImpl implements ExcelWriterRequest {
    private String fileName;
    private final String sheetName = "Transactions";
    private final int colCount = 12;

    private List<ExcelCell[]> rowData;

    @Override
    public String fileName() {
        return this.fileName;
    }

    @Override
    public String sheetName() {
        return this.sheetName;
    }

    @Override
    public int colCount() {
        return this.colCount;
    }

    @Override
    public List<String> colHeaders() {
        List<String> colHeader = new ArrayList<>();
        colHeader.add("Date");
        colHeader.add("Amount");
        colHeader.add("Currency");
        colHeader.add("Description");
        colHeader.add("DebitAccount");
        colHeader.add("CreditAccount");
        colHeader.add("DebitSubAccount");
        colHeader.add("CreditSubAccount");
        colHeader.add("Type");
        colHeader.add("GroupTag");
        colHeader.add("GLinkDrive");
        colHeader.add("ID");
        return colHeader;
    }

    @Override
    public List<ExcelCell[]> rowData() {
        return this.rowData;
    }

    @Override
    public List<Integer> colSizes() {
        List<Integer> listSize = new ArrayList<>();
        listSize.add(3);
        listSize.add(3);
        listSize.add(2);
        listSize.add(20);
        listSize.add(5);
        listSize.add(5);
        listSize.add(5);
        listSize.add(5);
        listSize.add(5); //Type
        listSize.add(3);
        listSize.add(5);
        listSize.add(2);
        return listSize;
    }

    public ExpenseTracker2024ExcelWriterRequestImpl(String fileName, List<ExcelCell[]> rowData) {
        this.fileName = fileName;
        this.rowData = rowData;
    }

    @Override
    public String toString() {
        return "ExpenseTracker2024ExcelWriterRequestImpl{" +
                "fileName='" + fileName + '\'' +
                ", sheetName='" + sheetName + '\'' +
                ", colCount=" + colCount +
                ", rowData=" + rowData.size() +
                '}';
    }
}
