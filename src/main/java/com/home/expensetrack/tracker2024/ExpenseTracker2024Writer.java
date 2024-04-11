package com.home.expensetrack.tracker2024;

import java.util.List;

public interface ExpenseTracker2024Writer {
    boolean SaveToExcelFile(String fileName);
    List<DataRow2024> getAllRows();
}
