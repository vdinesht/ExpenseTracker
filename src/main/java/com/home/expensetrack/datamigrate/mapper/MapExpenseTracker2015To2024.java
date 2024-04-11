package com.home.expensetrack.datamigrate.mapper;

import com.home.expensetrack.datamigrate.tracker2015.ExpenseTracker2015Reader;
import com.home.expensetrack.tracker2024.ExpenseTracker2024Writer;

public interface MapExpenseTracker2015To2024 {
    ExpenseTracker2024Writer transform(ExpenseTracker2015Reader tracker2015);
}
