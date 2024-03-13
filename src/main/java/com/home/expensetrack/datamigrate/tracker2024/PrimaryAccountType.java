package com.home.expensetrack.datamigrate.tracker2024;

public enum PrimaryAccountType {
    Cash("Cash"),
    BankAccount("BankAccount"),
    CreditCard("CreditCard"),
    CashPay("CashPay"),
    DigitalPay("DigitalPay("),
    Salary("Salary"),
    TenantRent("TenantRent"),
    BankInterest("BankInterest"),
    Gift("Gift"),
    CashLoan("CashLoan");

    private final String value;

    PrimaryAccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
