package com.home.expensetrack.datamigrate.excel;

import com.home.expensetrack.datamigrate.excel.impl.ExcelReaderImpl;
import com.home.expensetrack.datamigrate.excel.impl.ExpenseTracker2015ExcelReadRequestImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestDataReadFromExpenseTracker2015 {

    @Test
    void testAbleToReadFromExcelFile(){
        ExcelReadRequest readRequest = new ExpenseTracker2015ExcelReadRequestImpl("C:\\Temp\\ExpenseTracker\\Our Home Expense Tracker - 2015.xlsx");

        ExcelReader excelReader = new ExcelReaderImpl();

        ExcelReadResponse response = excelReader.readFile(readRequest);

        assertTrue(response.colCount() > 0);
    }

}
