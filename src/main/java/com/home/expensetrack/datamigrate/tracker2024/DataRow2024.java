package com.home.expensetrack.datamigrate.tracker2024;

import java.time.LocalDate;

public interface DataRow2024 {
    LocalDate date();
    double amount();
    String currency();
    String description();
    PrimaryAccountType debitAccount();
    PrimaryAccountType creditAccount();
    String debitSubAccount();
    String creditSubAccount();
    String transType2015();

    GroupTag groupTag();
    String gdriveLink();
    int id();
}
