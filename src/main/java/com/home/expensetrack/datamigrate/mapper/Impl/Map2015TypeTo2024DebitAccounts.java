package com.home.expensetrack.datamigrate.mapper.Impl;

import java.util.Map;

public class Map2015TypeTo2024DebitAccounts {
    public static Map<String, String> map = Map.ofEntries(Map.entry("CASH - $","CashPay"),
                    Map.entry("CEFCU Checking A/c [D] - Check Payment","DigitalPay"),
                    Map.entry("Shell Charge Card","DigitalPay"),
                    Map.entry("CEFCU Credit Card [D]","DigitalPay"),
                    Map.entry("CEFCU Debit Card [D] - Payment","DigitalPay"),
                    Map.entry("CEFCU Checking A/c [D] - Withdraw","CashAsset"),
                    Map.entry("Lend Cash","CashPay"),
                    Map.entry("CEFCU Checking A/c [D] - Check Deposit","BankAsset"),
                    Map.entry("CEFCU Checking A/c [D] - ACH Payment","DigitalPay"),
                    Map.entry("CEFCU Checking A/c [D] -> Savings A/c [D]","BankAsset"),
                    Map.entry("CEFCU Checking A/c [D] - ACH Deposit","BankAsset"),
                    Map.entry("Cash Received","CashAsset"),
                    Map.entry("Bergner's Card [D]","DigitalPay"),
                    Map.entry("CEFCU Checking A/c [D] - Credit Card Check Payment","DigitalPay"),
                    Map.entry("JCPenney Card","DigitalPay"),
                    Map.entry("Paid for with CEFCU Credit Card","DigitalPay"),
                    Map.entry("Chase Credit Card","DigitalPay"),
                    Map.entry("Sears Charge Card","DigitalPay"),
                    Map.entry("Cash - INR","CashPay"),
                    Map.entry("CEFCU Checking A/c [D] - Credit Card ACH Payment","DigitalPay"),
                    Map.entry("Famous Baar / Macy's Card","DigitalPay"),
                    Map.entry("Online Payment - CEFCU","DigitalPay"),
                    Map.entry("CEFCU Checking A/c [D] - M2I Transfer","DigitalPay"),
                    Map.entry("Kohl's Card [D] & [S]","DigitalPay"),
                    Map.entry("Providian CreditCard Deposit","CreditCard"),
                    Map.entry("Mail In Rebate - Checks","BankAsset"),
                    Map.entry("Gift Card - Received","CreditCard"),
                    Map.entry("Gift Card - Payment","DigitalPay"),
                    Map.entry("Refund","CashAsset"),
                    Map.entry("CEFCU Debit Card [D] - Withdraw","CashAsset"),
                    Map.entry("Sears Master Card","DigitalPay"),
                    Map.entry("Sam's Club Discover Card","DigitalPay"),
                    Map.entry("CEFCU Checking A/c [S] - Check Deposit","BankAsset"),
                    Map.entry("CAT Health Insurance - Payment","DigitalPay"),
                    Map.entry("CEFCU Saving A/c [S] -> Checking A/c [D]","BankAsset"),
                    Map.entry("CEFCU Saving A/c [S] - Check Deposit","BankAsset"),
                    Map.entry("CEFCU Checking A/c [S] - ACH Deposit","BankAsset"),
                    Map.entry("CEFCU Check Card [S] - Payment","DigitalPay"),
                    Map.entry("CEFCU Checking A/c [S] - Withdraw","CashAsset"),
                    Map.entry("ICICI Res A/c - M2I Deposit","BankAsset"),
                    Map.entry("CEFCU Saving A/c [S] - ACH Deposit","BankAsset"),
                    Map.entry("CEFCU Saving A/c [D] - ACH Deposit","BankAsset"),
                    Map.entry("CEFCU Checking A/c [S] -> Savings A/c [S]","BankAsset"),
                    Map.entry("CEFCU Savings A/c [D] -> Checking A/c [D]","BankAsset"),
                    Map.entry("Bergner's Card [S]","DigitalPay"),
                    Map.entry("SBI Remit Express Transfer","DigitalPay"),
                    Map.entry("CEFCU Saving A/c [D] - Check Deposit","BankAsset"),
                    Map.entry("Joint ICICI NGL Savings A/c","DigitalPay"),
                    Map.entry("CEFCU Checking A/c [S] -> Checking A/c [D]","BankAsset"),
                    Map.entry("CEFCU Checking A/c [D] - SBI Remit Express","DigitalPay"),
                    Map.entry("ICICI Res A/c - Credit","BankAsset"),
                    Map.entry("CEFCU Saving A/c [S] -> Saving A/c [D]","BankAsset"),
                    Map.entry("Tambaram Project - Cash Payment","CashPay"),
                    Map.entry("Tambaram Project - Mama Cash Payment","CashPay"),
                    Map.entry("CEFCU Saving A/c [S] -> Santa Saver A/c [S]","DigitalPay"),
                    Map.entry("ICICI Res A/c - Tambaram Project Payment","DigitalPay"),
                    Map.entry("CEFCU Checking A/c [S] -> Savings A/c [D]","BankAsset"),
                    Map.entry("ICICI Res A/c - Withdraw","CashAsset"),
                    Map.entry("SBI NRE A/c - Credit","BankAsset"),
                    Map.entry("Cash Received - Rs","CashAsset"),
                    Map.entry("Tambaram Apt - Maintanence","CashPay"),
                    Map.entry("Tambaram Apt - Rent","CashAsset"),
                    Map.entry("ICICI Res A/c - Tambaram Apt Maintanence","DigitalPay"),
                    Map.entry("SBI NRE A/c - Check Payment","DigitalPay"),
                    Map.entry("ICICI NRE A/c - M2I Deposit","BankAsset"),
                    Map.entry("ICICI NRE A/c - Credit","BankAsset"),
                    Map.entry("ICICI NRE A/c - Debit Card","DigitalPay"),
                    Map.entry("Tambaram Apt - Bank Saving","BankAsset"),
                    Map.entry("ICICI NRE A/c - Tambaram Apt Maintanence","DigitalPay"),
                    Map.entry("CEFCU Checking A/c [S] - Check Payment","DigitalPay"),
                    Map.entry("Mama Cash Payment","CashPay"),
                    Map.entry("CEFCU Savings A/c [S] -> Checking A/c [S]","BankAsset"),
                    Map.entry("SBI NRE A/c - Internet Payment","DigitalPay"),
                    Map.entry("Sodexo","DigitalPay"),
                    Map.entry("ICICI NRE A/c - Withdraw","CashAsset"),
                    Map.entry("ICICI Cat Salary A/c [D] - Credit","BankAsset"),
                    Map.entry("ICICI Cat Salary A/c [S] - Credit","BankAsset"),
                    Map.entry("ICICI Cat Salary A/c [D] - Withdraw","CashAsset"),
                    Map.entry("ICICI Res A/c ->ICICI Cat Sal A/c [D]","BankAsset"),
                    Map.entry("Dinesh - ICICI Perungudi Savings","DigitalPay"),
                    Map.entry("SBI Advantage Credit Card [D]","DigitalPay"),
                    Map.entry("SBI Advantage Credit Card [S]","DigitalPay"),
                    Map.entry("ICICI Cat Salary A/c [S] - Check Payment","DigitalPay"),
                    Map.entry("Sebi - ICICI Perungudi Savings","DigitalPay"),
                    Map.entry("ICICI Cat Salary A/c [S] - Cash Withdraw","CashAsset"),
                    Map.entry("Cash Lend","CashPay"),
                    Map.entry("ICICI Cat Salary A/c [D] -> ICICI Res A/c ","BankAsset"),
                    Map.entry("SBI Perungudi A/c [D] - Credit","BankAsset"),
                    Map.entry("ICICI NRE A/c ->ICICI Cat Sal A/c [D]","BankAsset"),
                    Map.entry("ICICI NRE A/c ->ICICI Cat Sal A/c [S]","BankAsset"),
                    Map.entry("SBI NRE A/c -> SBI Velachery A/c [D]","BankAsset"),
                    Map.entry("SBI Perungudi A/c [D] - Withdraw","CashAsset"),
                    Map.entry("SBI Perungudi A/c [D] - Check Payment","DigitalPay"),
                    Map.entry("SBI Perungudi A/c [D] - Debit Card","DigitalPay"),
                    Map.entry("SBI Perungudi A/c [S] - Credit","BankAsset"),
                    Map.entry("ICICI Cat Salary A/c [S] -> ICICI Cat Salary A/c [D]","BankAsset"),
                    Map.entry("ICICI Cat Salary A/c [D] - Check Payment","DigitalPay"),
                    Map.entry("HSBC Home Loan - Debit","DigitalPay"),
                    Map.entry("ICICI Cat Salary A/c [D] -> HSBC Home Loan","BankAsset"),
                    Map.entry("Cash Lend Refund","CashAsset"),
                    Map.entry("ICICI Cat Salary A/c [D] -> SBI Perungudi A/c [D]","BankAsset"),
                    Map.entry("ICICI Cat Salary A/c [S] -> SBI Perungudi A/c [S]","BankAsset"),
                    Map.entry("For Records","CashPay"),
                    Map.entry("SBI Perungudi A/c [D] -> ICICI Cat Salary A/c [D] ","BankAsset"),
                    Map.entry("ICICI Res A/c ->ICICI Cat Sal A/c [S]","BankAsset"),
                    Map.entry("Canara Bank Adyar A/c [D] - Credit","BankAsset"),
                    Map.entry("SBI Perungudi A/c [D] -> HSBC Home Loan","BankAsset"),
                    Map.entry("Rams Dwaraka Income","CashAsset"),
                    Map.entry("Rams Dwaraka Expense","CashPay"),
                    Map.entry("HSBC Credit Card [D]","DigitalPay"),
                    Map.entry("Sebi - HSBC","DigitalPay"),
                    Map.entry("Canara Bank Adyar A/c [D] - Debit Card","DigitalPay"),
                    Map.entry("Dinesh - SBI GM","DigitalPay"),
                    Map.entry("ICICI Cat Salary A/c [D] -> ICICI Cat Salary A/c [S]","BankAsset"),
                    Map.entry("HSBC Home Loan -> ICICI Cat Salary A/c [S]","BankAsset"),
                    Map.entry("HSBC Home Loan -> ICICI Cat Salary A/c [D]","BankAsset"),
                    Map.entry("Dinesh - AMEX","DigitalPay"),
                    Map.entry("Cash - $","CashPay"),
                    Map.entry("Dinesh - HDFC Savings A/c","DigitalPay"));
}
