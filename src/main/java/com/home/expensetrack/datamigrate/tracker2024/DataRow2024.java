package com.home.expensetrack.datamigrate.tracker2024;

import org.springframework.context.annotation.Primary;

import java.time.LocalDate;

public interface DataRow2024 {
    LocalDate date();
    double amount();
    String description();
    PrimaryAccountType debitAccount();
    PrimaryAccountType creditAccount();
    SecondaryAccountType debitSubAccount();
    SecondaryAccountType creditSubAccount();
    GroupTag groupTag();
    String gdriveLink();
}
