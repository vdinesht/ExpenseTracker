package com.home.expensetrack.datamigrate.mapper.Impl;

import com.home.expensetrack.datamigrate.mapper.MapExpenseTracker2015To2024;
import com.home.expensetrack.datamigrate.tracker2015.DataRow2015;
import com.home.expensetrack.datamigrate.tracker2015.ExpenseTracker2015Reader;
import com.home.expensetrack.tracker2024.DataRow2024;
import com.home.expensetrack.tracker2024.ExpenseTracker2024Writer;
import com.home.expensetrack.tracker2024.impl.DataRow2024Impl;
import com.home.expensetrack.tracker2024.impl.ExpenseTracker2024ExcelWriterImpl;

import java.util.ArrayList;
import java.util.List;

public class MapExpenseTracker2015To2024Impl implements MapExpenseTracker2015To2024 {
    @Override
    public ExpenseTracker2024Writer transform(ExpenseTracker2015Reader tracker2015) {

        List<DataRow2024> newRows = new ArrayList<>();
        for(DataRow2015 row : tracker2015.getAllRows()) {
            if (row.id()>0) { //skip header row
                DataRow2024 newRow = new DataRow2024Impl(row.date(), row.amount(), row.currency(), row.description(), row.type(), row.gdrivelink(), row.id());
                newRows.add(newRow);
            }
        }
        return new ExpenseTracker2024ExcelWriterImpl(newRows);
    }
}
