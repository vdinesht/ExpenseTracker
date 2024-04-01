package com.home.expensetrack.datamigrate.tracker2024;

import java.util.List;

public interface HomeExpenseTracker2024 {
    boolean SaveToExcelFile(String fileName);
    List<DataRow2024> getAllRows();
}
