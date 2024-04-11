package com.home.expensetrack.datamigrate.tracker2015;

import java.util.List;

public interface ExpenseTracker2015Reader {
    List<DataRow2015> getAllRows();
    List<String> getDistinctType();
}
