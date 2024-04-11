package com.home.expensetrack.datamigrate.tracker2024;

import com.home.expensetrack.tracker2024.impl.ExpenseTracker2024ReaderImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpenseTracker2024ReaderTest {
    @Test
    void testReading(){
        ExpenseTracker2024ReaderImpl expenseTracker2024Reader = new ExpenseTracker2024ReaderImpl();
        expenseTracker2024Reader.getAllRows().stream().forEach(System.out::println);
        assertTrue(expenseTracker2024Reader.getAllRows().size() > 0);
    }
}
