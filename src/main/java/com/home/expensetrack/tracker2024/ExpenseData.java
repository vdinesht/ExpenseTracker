package com.home.expensetrack.tracker2024;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseData {
    List<DataRow2024> getAllRows(LocalDate from, LocalDate to);
    List<DataRow2024> getDebitRows(LocalDate from, LocalDate to, PrimaryAccountType type);
    List<DataRow2024> getCreditRows(LocalDate from, LocalDate to, PrimaryAccountType type);

    double getDebit(LocalDate from, LocalDate to, PrimaryAccountType type);
    double getCredit(LocalDate from, LocalDate to, PrimaryAccountType type);
}
