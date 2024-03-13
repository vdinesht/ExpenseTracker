package com.home.expensetrack.datamigrate.tracker2015;

import java.util.List;

public interface HomeExpenseTracker2015 {
    List<DataRow2015> getAllRows();
    List<String> getDistinctType();
}
