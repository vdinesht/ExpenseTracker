package com.home.expensetrack.datamigrate.tracker2015.impl;

import com.home.expensetrack.datamigrate.tracker2015.DataRow2015;

import java.time.LocalDate;

public class DataRow2025Impl implements DataRow2015 {
    private LocalDate localDate;
    private double amount;
    private String currency;
    private String description;
    private String transactionType;
    private String category;
    private String gdlink;

    private int rowNo;

    @Override
    public LocalDate date() {
        return this.localDate;
    }

    @Override
    public double amount() {
        return this.amount;
    }

    @Override
    public String currency() {
        return this.currency;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public String type() {
        return this.transactionType;
    }

    @Override
    public String category() {
        return this.category;
    }

    @Override
    public String gdrivelink() {
        return this.gdlink;
    }

    @Override
    public int id() {
        return this.rowNo;
    }

    public DataRow2025Impl(LocalDate localDate, double amount, String currency, String description, String transactionType, String category, String gdlink, int rowNo) {
        this.localDate = localDate;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.transactionType = transactionType;
        this.category = category;
        this.gdlink = gdlink;
        this.rowNo = rowNo;
    }

    @Override
    public String toString() {
        return "DataRow2025Impl{" +
                "localDate=" + localDate +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", description='" + description + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", category='" + category + '\'' +
                ", gdlink='" + gdlink + '\'' +
                ", rowNo=" + rowNo +
                '}';
    }
}
