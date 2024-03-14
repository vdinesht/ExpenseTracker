package com.home.expensetrack.datamigrate.excel;

import com.home.expensetrack.datamigrate.tracker2015.HomeExpenseTracker2015;
import com.home.expensetrack.datamigrate.tracker2015.impl.HomeExpenseTracker2025Impl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestDataReadFromExpenseTracker2015 {

    @Test
    void testAbleToReadFromExcelFile(){
        HomeExpenseTracker2015 homeExpenseTracker2015 = new HomeExpenseTracker2025Impl();

        homeExpenseTracker2015.getDistinctType().forEach(System.out::println);
        assertTrue(homeExpenseTracker2015.getAllRows().size() > 0);
    }

}
