package com.home.expensetrack.datamigrate.tracker2024.impl;

import com.home.expensetrack.datamigrate.tracker2024.DataRow2024;
import com.home.expensetrack.datamigrate.tracker2024.GroupTag;
import com.home.expensetrack.datamigrate.tracker2024.PrimaryAccountType;
import com.home.expensetrack.datamigrate.tracker2024.SecondaryAccountType;

import java.time.LocalDate;

public class DataRow2024Impl implements DataRow2024 {

    private LocalDate localDate;
    private double amount;
    private String currency;
    private String description;
    private PrimaryAccountType debitAccount;
    private PrimaryAccountType creditAccount;
    private SecondaryAccountType debitSubAccount;
    private SecondaryAccountType creditSubAccount;
    private String transType;
    private GroupTag groupTag;
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
    public PrimaryAccountType debitAccount() {
        return this.debitAccount;
    }

    @Override
    public PrimaryAccountType creditAccount() {
        return this.creditAccount;
    }

    @Override
    public SecondaryAccountType debitSubAccount() {
        return this.debitSubAccount;
    }

    @Override
    public SecondaryAccountType creditSubAccount() {
        return this.creditSubAccount;
    }

    @Override
    public String transType2015() {
        return this.transType;
    }

    @Override
    public GroupTag groupTag() {
        return this.groupTag;
    }

    @Override
    public String gdriveLink() {
        return this.gdlink;
    }

    @Override
    public int id() {
        return this.rowNo;
    }

    public DataRow2024Impl(LocalDate localDate, double amount, String currency, String description,String type, String gdlink, int rowNo) {
        this.localDate = localDate;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.debitAccount = PrimaryAccountType.Bank;
        this.creditAccount = PrimaryAccountType.Cash;
        this.debitSubAccount = SecondaryAccountType.OtherExpense;
        this.creditSubAccount = SecondaryAccountType.OtherExpense;
        this.transType = type;
        this.groupTag = GroupTag.Christmas;
        this.gdlink = gdlink;
        this.rowNo = rowNo;
    }

    @Override
    public String toString() {
        return "DataRow2024Impl{" +
                "localDate=" + localDate +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", description='" + description + '\'' +
                ", debitAccount=" + debitAccount +
                ", creditAccount=" + creditAccount +
                ", debitSubAccount=" + debitSubAccount +
                ", creditSubAccount=" + creditSubAccount +
                ", groupTag=" + groupTag +
                ", gdlink='" + gdlink + '\'' +
                ", rowNo=" + rowNo +
                '}';
    }
}
