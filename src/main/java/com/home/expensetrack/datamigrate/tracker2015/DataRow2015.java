package com.home.expensetrack.datamigrate.tracker2015;

import java.time.LocalDate;

public interface DataRow2015 {
    LocalDate date();
    double amount();
    String currency();
    String description();
    String type();
    String category();
    String gdrivelink();
    int id();
}
