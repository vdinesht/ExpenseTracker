package com.home.expensetrack.datamigrate.tracker2024;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEnums {
    @Test
    void testBankAccounts(){
        EnumSet.allOf(BankAccount.class).stream().forEach( e-> { System.out.println(e.toString() + e.getValue()); });
        assertTrue(EnumSet.allOf(BankAccount.class).size() == 19);
    }

    @Test
    void testCreditCard(){
        EnumSet.allOf(CreditCard.class).stream().forEach( e-> { System.out.println(e.toString() + e.getValue()); });
        assertTrue(EnumSet.allOf(CreditCard.class).size() == 20);
    }

    @Test
    void testCashPay(){
        EnumSet.allOf(CashPay.class).stream().forEach( e-> { System.out.println(e.toString() + e.getValue()); });
        assertTrue(EnumSet.allOf(CashPay.class).size() == 10);
    }

    @Test
    void testDigitalPay(){
        EnumSet.allOf(DigitalPay.class).stream().forEach( e-> { System.out.println(e.toString() + e.getValue()); });
        assertTrue(EnumSet.allOf(DigitalPay.class).size() == 17);
    }

}
