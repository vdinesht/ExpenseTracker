package com.home.expensetrack.datamigrate.mapper.Impl;

import java.util.Map;

public class Map2015TypeTo2024CreditAccounts {
    public static Map<String, String> map = Map.ofEntries(Map.entry("CASH - $","Cash"),
        Map.entry("CEFCU Checking A/c [D] - Check Payment","Bank"),
        Map.entry("Shell Charge Card","CreditCard"),
        Map.entry("CEFCU Credit Card [D]","CreditCard"),
        Map.entry("CEFCU Debit Card [D] - Payment","Bank"),
        Map.entry("CEFCU Checking A/c [D] - Withdraw","Bank"),
        Map.entry("Lend Cash","Cash"),
        Map.entry("CEFCU Checking A/c [D] - Check Deposit","DigitalPay"),
        Map.entry("CEFCU Checking A/c [D] - ACH Payment","Bank"),
        Map.entry("CEFCU Checking A/c [D] -> Savings A/c [D]","Bank"),
        Map.entry("CEFCU Checking A/c [D] - ACH Deposit","DigitalPay"),
        Map.entry("Cash Received","CashPay"),
        Map.entry("Bergner's Card [D]","CreditCard"),
        Map.entry("CEFCU Checking A/c [D] - Credit Card Check Payment","Bank"),
        Map.entry("JCPenney Card","CreditCard"),
        Map.entry("Paid for with CEFCU Credit Card","CreditCard"),
        Map.entry("Chase Credit Card","CreditCard"),
        Map.entry("Sears Charge Card","CreditCard"),
        Map.entry("Cash - INR","Cash"),
        Map.entry("CEFCU Checking A/c [D] - Credit Card ACH Payment","Bank"),
        Map.entry("Famous Baar / Macy's Card","CreditCard"),
        Map.entry("Online Payment - CEFCU","Bank"),
        Map.entry("CEFCU Checking A/c [D] - M2I Transfer","Bank"),
        Map.entry("Kohl's Card [D] & [S]","CreditCard"),
        Map.entry("Providian CreditCard Deposit","DigitalPay"),
        Map.entry("Mail In Rebate - Checks","DigitalPay"),
        Map.entry("Gift Card - Received","CashPay"),
        Map.entry("Gift Card - Payment","CreditCard"),
        Map.entry("Refund","CashPay"),
        Map.entry("CEFCU Debit Card [D] - Withdraw","Bank"),
        Map.entry("Sears Master Card","CreditCard"),
        Map.entry("Sam's Club Discover Card","CreditCard"),
        Map.entry("CEFCU Checking A/c [S] - Check Deposit","DigitalPay"),
        Map.entry("CAT Health Insurance - Payment","DigitalPay"),
        Map.entry("CEFCU Saving A/c [S] -> Checking A/c [D]","Bank"),
        Map.entry("CEFCU Saving A/c [S] - Check Deposit","DigitalPay"),
        Map.entry("CEFCU Checking A/c [S] - ACH Deposit","DigitalPay"),
        Map.entry("CEFCU Check Card [S] - Payment","Bank"),
        Map.entry("CEFCU Checking A/c [S] - Withdraw","Bank"),
        Map.entry("ICICI Res A/c - M2I Deposit","DigitalPay"),
        Map.entry("CEFCU Saving A/c [S] - ACH Deposit","DigitalPay"),
        Map.entry("CEFCU Saving A/c [D] - ACH Deposit","DigitalPay"),
        Map.entry("CEFCU Checking A/c [S] -> Savings A/c [S]","Bank"),
        Map.entry("CEFCU Savings A/c [D] -> Checking A/c [D]","Bank"),
        Map.entry("Bergner's Card [S]","CreditCard"),
        Map.entry("SBI Remit Express Transfer","Bank"),
        Map.entry("CEFCU Saving A/c [D] - Check Deposit","DigitalPay"),
        Map.entry("Joint ICICI NGL Savings A/c","Bank"),
        Map.entry("CEFCU Checking A/c [S] -> Checking A/c [D]","Bank"),
        Map.entry("CEFCU Checking A/c [D] - SBI Remit Express","Bank"),
        Map.entry("ICICI Res A/c - Credit","DigitalPay"),
        Map.entry("CEFCU Saving A/c [S] -> Saving A/c [D]","Bank"),
        Map.entry("Tambaram Project - Cash Payment","Cash"),
        Map.entry("Tambaram Project - Mama Cash Payment","Cash"),
        Map.entry("CEFCU Saving A/c [S] -> Santa Saver A/c [S]","Bank"),
        Map.entry("ICICI Res A/c - Tambaram Project Payment","Bank"),
        Map.entry("CEFCU Checking A/c [S] -> Savings A/c [D]","Bank"),
        Map.entry("ICICI Res A/c - Withdraw","Bank"),
        Map.entry("SBI NRE A/c - Credit","DigitalPay"),
        Map.entry("Cash Received - Rs","CashPay"),
        Map.entry("Tambaram Apt - Maintanence","Cash"),
        Map.entry("Tambaram Apt - Rent","CashPay"),
        Map.entry("ICICI Res A/c - Tambaram Apt Maintanence","Bank"),
        Map.entry("SBI NRE A/c - Check Payment","Bank"),
        Map.entry("ICICI NRE A/c - M2I Deposit","DigitalPay"),
        Map.entry("ICICI NRE A/c - Credit","DigitalPay"),
        Map.entry("ICICI NRE A/c - Debit Card","Bank"),
        Map.entry("Tambaram Apt - Bank Saving","CashPay"),
        Map.entry("ICICI NRE A/c - Tambaram Apt Maintanence","Bank"),
        Map.entry("CEFCU Checking A/c [S] - Check Payment","Bank"),
        Map.entry("Mama Cash Payment","Cash"),
        Map.entry("CEFCU Savings A/c [S] -> Checking A/c [S]","Bank"),
        Map.entry("SBI NRE A/c - Internet Payment","Bank"),
        Map.entry("Sodexo","CreditCard"),
        Map.entry("ICICI NRE A/c - Withdraw","Bank"),
        Map.entry("ICICI Cat Salary A/c [D] - Credit","DigitalPay"),
        Map.entry("ICICI Cat Salary A/c [S] - Credit","DigitalPay"),
        Map.entry("ICICI Cat Salary A/c [D] - Withdraw","Bank"),
        Map.entry("ICICI Res A/c ->ICICI Cat Sal A/c [D]","Bank"),
        Map.entry("Dinesh - ICICI Perungudi Savings","Bank"),
        Map.entry("SBI Advantage Credit Card [D]","CreditCard"),
        Map.entry("SBI Advantage Credit Card [S]","CreditCard"),
        Map.entry("ICICI Cat Salary A/c [S] - Check Payment","Bank"),
        Map.entry("Sebi - ICICI Perungudi Savings","Bank"),
        Map.entry("ICICI Cat Salary A/c [S] - Cash Withdraw","Bank"),
        Map.entry("Cash Lend","Cash"),
        Map.entry("ICICI Cat Salary A/c [D] -> ICICI Res A/c","Bank"),
        Map.entry("SBI Perungudi A/c [D] - Credit","DigitalPay"),
        Map.entry("ICICI NRE A/c ->ICICI Cat Sal A/c [D]","Bank"),
        Map.entry("ICICI NRE A/c ->ICICI Cat Sal A/c [S]","Bank"),
        Map.entry("SBI NRE A/c -> SBI Velachery A/c [D]","Bank"),
        Map.entry("SBI Perungudi A/c [D] - Withdraw","Bank"),
        Map.entry("SBI Perungudi A/c [D] - Check Payment","Bank"),
        Map.entry("SBI Perungudi A/c [D] - Debit Card","Bank"),
        Map.entry("SBI Perungudi A/c [S] - Credit","DigitalPay"),
        Map.entry("ICICI Cat Salary A/c [S] -> ICICI Cat Salary A/c [D]","Bank"),
        Map.entry("ICICI Cat Salary A/c [D] - Check Payment","Bank"),
        Map.entry("HSBC Home Loan - Debit","Bank"),
        Map.entry("ICICI Cat Salary A/c [D] -> HSBC Home Loan","Bank"),
        Map.entry("Cash Lend Refund","CashPay"),
        Map.entry("ICICI Cat Salary A/c [D] -> SBI Perungudi A/c [D]","Bank"),
        Map.entry("ICICI Cat Salary A/c [S] -> SBI Perungudi A/c [S]","Bank"),
        Map.entry("For Records","Cash"),
        Map.entry("SBI Perungudi A/c [D] -> ICICI Cat Salary A/c [D]","Bank"),
        Map.entry("ICICI Res A/c ->ICICI Cat Sal A/c [S]","Bank"),
        Map.entry("Canara Bank Adyar A/c [D] - Credit","Cash"),
        Map.entry("SBI Perungudi A/c [D] -> HSBC Home Loan","Bank"),
        Map.entry("Rams Dwaraka Income","CashPay"),
        Map.entry("Rams Dwaraka Expense","Cash"),
        Map.entry("HSBC Credit Card [D]","CreditCard"),
        Map.entry("Sebi - HSBC","CreditCard"),
        Map.entry("Canara Bank Adyar A/c [D] - Debit Card","Bank"),
        Map.entry("Dinesh - SBI GM","CreditCard"),
        Map.entry("ICICI Cat Salary A/c [D] -> ICICI Cat Salary A/c [S]","Bank"),
        Map.entry("HSBC Home Loan -> ICICI Cat Salary A/c [S]","Bank"),
        Map.entry("HSBC Home Loan -> ICICI Cat Salary A/c [D]","Bank"),
        Map.entry("Dinesh - AMEX","CreditCard"),
        Map.entry("Cash - $","Cash"),
        Map.entry("Dinesh - HDFC Savings A/c","Bank"));

}