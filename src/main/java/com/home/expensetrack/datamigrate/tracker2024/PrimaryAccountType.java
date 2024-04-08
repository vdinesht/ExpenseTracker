package com.home.expensetrack.datamigrate.tracker2024;

public enum PrimaryAccountType {
    CashAsset("CashAsset"),
    BankAsset("BankAsset"),
    CreditCard("CreditCard"),
    CashPay("CashPay"),
    DigitalPay("DigitalPay");

    private final String value;

    PrimaryAccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
