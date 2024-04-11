package com.home.expensetrack.datamigrate.excel;

import com.home.expensetrack.datamigrate.mapper.Impl.MapExpenseTracker2015To2024Impl;
import com.home.expensetrack.datamigrate.mapper.MapExpenseTracker2015To2024;
import com.home.expensetrack.datamigrate.tracker2015.ExpenseTracker2015Reader;
import com.home.expensetrack.datamigrate.tracker2015.impl.ExpenseTracker2015ReaderImpl;
import com.home.expensetrack.tracker2024.ExpenseTracker2024Writer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDataMigration {
    @Test
    void testMigrate2015To2024(){
        ExpenseTracker2015Reader homeExpenseTracker2015 = new ExpenseTracker2015ReaderImpl();
        MapExpenseTracker2015To2024 mapExpenseTracker2015To2024 = new MapExpenseTracker2015To2024Impl();

        ExpenseTracker2024Writer homeExpenseTracker2024 = mapExpenseTracker2015To2024.transform(homeExpenseTracker2015);
        assertTrue(homeExpenseTracker2024.getAllRows().size() > 0);
        assertTrue(homeExpenseTracker2024.SaveToExcelFile("C:\\Temp\\ExpenseTracker\\OurHomeExpense2024.xlsx"));
    }
}
