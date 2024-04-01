package com.home.expensetrack.datamigrate.mapper.Impl;

import com.home.expensetrack.datamigrate.mapper.MapExpenseTracker2015To2024;
import com.home.expensetrack.datamigrate.tracker2015.DataRow2015;
import com.home.expensetrack.datamigrate.tracker2015.HomeExpenseTracker2015;
import com.home.expensetrack.datamigrate.tracker2024.DataRow2024;
import com.home.expensetrack.datamigrate.tracker2024.HomeExpenseTracker2024;
import com.home.expensetrack.datamigrate.tracker2024.impl.DataRow2024Impl;
import com.home.expensetrack.datamigrate.tracker2024.impl.HomeExpenseTracker2024Impl;

import java.util.ArrayList;
import java.util.List;

public class MapExpenseTracker2015To2024Impl implements MapExpenseTracker2015To2024 {
    @Override
    public HomeExpenseTracker2024 transform(HomeExpenseTracker2015 tracker2015) {

        List<DataRow2024> newRows = new ArrayList<>();
        for(DataRow2015 row : tracker2015.getAllRows()) {
            if (row.id()>0) { //skip header row
                DataRow2024 newRow = new DataRow2024Impl(row.date(), row.amount(), row.currency(), row.description(), row.type(), row.gdrivelink(), row.id());
                newRows.add(newRow);
            }
        }
        return new HomeExpenseTracker2024Impl(newRows);
    }
}
