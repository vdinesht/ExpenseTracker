package com.home.expensetrack.metrics;

import com.home.expensetrack.tracker2024.BankAccount;

import java.time.LocalDate;

public interface ClosingBankBalance {
    double getTotalBalance(LocalDate asOfDate);
    double getBalance(BankAccount bank,LocalDate asOfDate);

}
