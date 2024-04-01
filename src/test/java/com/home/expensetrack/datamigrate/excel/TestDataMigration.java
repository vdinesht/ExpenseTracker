package com.home.expensetrack.datamigrate.excel;

import com.home.expensetrack.datamigrate.mapper.Impl.MapExpenseTracker2015To2024Impl;
import com.home.expensetrack.datamigrate.mapper.MapExpenseTracker2015To2024;
import com.home.expensetrack.datamigrate.tracker2015.HomeExpenseTracker2015;
import com.home.expensetrack.datamigrate.tracker2015.impl.HomeExpenseTracker2015Impl;
import com.home.expensetrack.datamigrate.tracker2024.HomeExpenseTracker2024;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDataMigration {
    @Test
    void testMigrate2015To2024(){
        HomeExpenseTracker2015 homeExpenseTracker2015 = new HomeExpenseTracker2015Impl();
        MapExpenseTracker2015To2024 mapExpenseTracker2015To2024 = new MapExpenseTracker2015To2024Impl();

        HomeExpenseTracker2024 homeExpenseTracker2024 = mapExpenseTracker2015To2024.transform(homeExpenseTracker2015);
        assertTrue(homeExpenseTracker2024.getAllRows().size() > 0);
        assertTrue(homeExpenseTracker2024.SaveToExcelFile("C:\\Temp\\ExpenseTracker\\OurHomeExpense2024.xlsx"));
    }
}
