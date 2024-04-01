package com.home.expensetrack.datamigrate.mapper;

import com.home.expensetrack.datamigrate.tracker2015.HomeExpenseTracker2015;
import com.home.expensetrack.datamigrate.tracker2024.HomeExpenseTracker2024;

public interface MapExpenseTracker2015To2024 {
    HomeExpenseTracker2024 transform(HomeExpenseTracker2015 tracker2015);
}
