package com.home.expensetrack.metrics;

import java.time.LocalDate;

public interface ClosingCashBalance {
    double getBalance(LocalDate asOfDate);
}
