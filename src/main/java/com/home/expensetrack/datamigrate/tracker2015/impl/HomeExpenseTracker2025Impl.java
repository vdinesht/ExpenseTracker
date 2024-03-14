package com.home.expensetrack.datamigrate.tracker2015.impl;

import com.home.expensetrack.datamigrate.excel.*;
import com.home.expensetrack.datamigrate.excel.impl.ExcelReaderImpl;
import com.home.expensetrack.datamigrate.excel.impl.ExpenseTracker2015ExcelReadRequestImpl;
import com.home.expensetrack.datamigrate.tracker2015.DataRow2015;
import com.home.expensetrack.datamigrate.tracker2015.HomeExpenseTracker2015;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeExpenseTracker2025Impl implements HomeExpenseTracker2015 {

    private List<DataRow2015> allRowsInExpenseTracker2015;

    @Override
    public List<DataRow2015> getAllRows() {
        if (allRowsInExpenseTracker2015.isEmpty()) {
            loadAllrows();
        }
        return allRowsInExpenseTracker2015;
    }

    private void loadAllrows(){
        if (allRowsInExpenseTracker2015.isEmpty()) {
            ExcelReadRequest readRequest = new ExpenseTracker2015ExcelReadRequestImpl("C:\\Temp\\ExpenseTracker\\Our Home Expense Tracker - 2015.xlsx");

            ExcelReader excelReader = new ExcelReaderImpl();
            ExcelReadResponse response = excelReader.readFile(readRequest);
            List<ExcelCell[]> rows = response.rowData();

            for (ExcelCell[] row : rows) {
                allRowsInExpenseTracker2015.add(getDataRow2015(row));
            }
        }
    }

    private static DataRow2015 getDataRow2015(ExcelCell[] row) {
        LocalDate date = LocalDate.now();
        Double amount = 0D;
        String currency = "INR";
        String description = "";
        String type = "";
        String category="";
        String glink = "";
        Integer id = 0;

        if (row[0].getType() == ExcelCellType.date)
            date = row[0].getDate();

        if (row[1].getType() == ExcelCellType.number)
            amount = row[1].getNumber();

        if(row[2].getType()==ExcelCellType.string)
            currency = row[2].getText();

        if(row[3].getType()==ExcelCellType.string)
            description = row[3].getText();

        if(row[4].getType()==ExcelCellType.string)
            type = row[4].getText();

        if(row[5].getType()==ExcelCellType.string)
            category = row[5].getText();

        if(row[6].getType()==ExcelCellType.string)
            glink = row[6].getText();

        if (row[7].getType() == ExcelCellType.number)
            id = row[7].getNumber().intValue();

        DataRow2015 dataRow = new DataRow2025Impl(date,amount,currency,description,type,category,glink,id);
        return dataRow;
    }

    @Override
    public List<String> getDistinctType() {
        loadAllrows();
        return allRowsInExpenseTracker2015.stream().map(DataRow2015::type).distinct().collect(Collectors.toList());
    }

    public HomeExpenseTracker2025Impl() {
        allRowsInExpenseTracker2015 = new ArrayList<>();
    }
}
