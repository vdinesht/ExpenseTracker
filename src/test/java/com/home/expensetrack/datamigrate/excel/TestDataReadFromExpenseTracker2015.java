package com.home.expensetrack.datamigrate.excel;

import com.home.expensetrack.datamigrate.tracker2015.ExpenseTracker2015Reader;
import com.home.expensetrack.datamigrate.tracker2015.impl.ExpenseTracker2015ReaderImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestDataReadFromExpenseTracker2015 {

    @Test
    void testAbleToReadFromExcelFile(){
        ExpenseTracker2015Reader homeExpenseTracker2015 = new ExpenseTracker2015ReaderImpl();

        homeExpenseTracker2015.getDistinctType().forEach(System.out::println);
        assertTrue(homeExpenseTracker2015.getAllRows().size() > 0);
    }

}
