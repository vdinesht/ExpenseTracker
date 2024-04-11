package com.home.expensetrack.tracker2024.impl;

import com.home.expensetrack.tracker2024.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseDataImpl implements ExpenseData {

    private List<DataRow2024> allRows;
    private final int colCount = 12;
    @Override
    public List<DataRow2024> getAllRows(LocalDate from, LocalDate to) {
        return null;
    }

    @Override
    public List<DataRow2024> getDebitRows(LocalDate from, LocalDate to, PrimaryAccountType type) {
        return null;
    }

    @Override
    public List<DataRow2024> getCreditRows(LocalDate from, LocalDate to, PrimaryAccountType type) {
        return null;
    }

    @Override
    public double getDebit(LocalDate from, LocalDate to, PrimaryAccountType type) {
        return 0;
    }

    @Override
    public double getCredit(LocalDate from, LocalDate to, PrimaryAccountType type) {
        return 0;
    }

}
