package com.home.expensetrack.tracker2024.impl;

import com.home.expensetrack.datamigrate.mapper.Impl.Map2015TypeTo2024CreditAccounts;
import com.home.expensetrack.datamigrate.mapper.Impl.Map2015TypeTo2024CreditSubAccounts;
import com.home.expensetrack.datamigrate.mapper.Impl.Map2015TypeTo2024DebitAccounts;
import com.home.expensetrack.datamigrate.mapper.Impl.Map2015TypeTo2024DebitSubAccounts;

import com.home.expensetrack.tracker2024.*;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DataRow2024Impl implements DataRow2024 {

    private LocalDate localDate;
    private double amount;
    private String currency;
    private String description;
    private PrimaryAccountType debitAccount;
    private PrimaryAccountType creditAccount;
    private String debitSubAccount;
    private String creditSubAccount;
    private String transType;
    private GroupTag groupTag;
    private String gdlink;

    private int rowNo;

    private final static Map<String, PrimaryAccountType> mapAccountToValue = EnumSet.allOf(PrimaryAccountType.class).stream().collect(Collectors.toMap(e->e.getValue(), e->e));
    private final static Set<String> setSubBankAccounts = EnumSet.allOf(BankAccount.class).stream().map(e->e.getValue()).collect(Collectors.toSet());
    private final static Set<String> setSubCashPay = EnumSet.allOf(CashPay.class).stream().map(e->e.getValue()).collect(Collectors.toSet());
    private final static Set<String> setSubCreditCard = EnumSet.allOf(CreditCard.class).stream().map(e->e.getValue()).collect(Collectors.toSet());
    private final static Set<String> setSubDigitalPay = EnumSet.allOf(DigitalPay.class).stream().map(e->e.getValue()).collect(Collectors.toSet());
    private final static Set<String> cashAssetSubAccount = Set.of("Cash");

    private final static Map<String, GroupTag> mapGroupTagToValue = EnumSet.allOf(GroupTag.class).stream().collect(Collectors.toMap(e->e.getValue(), e->e));

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
    public String debitSubAccount() {
        return this.debitSubAccount;
    }

    @Override
    public String creditSubAccount() {
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
        this.debitAccount = getPrimaryDebitAccount(type);
        this.creditAccount = getPrimaryCreditAccount(type);
        this.debitSubAccount = getSubDebitAccount(type, rowNo);
        this.creditSubAccount = getSubCreditAccount(type);
        this.transType = type;
        this.groupTag = GroupTag.None;
        this.gdlink = gdlink;
        this.rowNo = rowNo;
    }

    public DataRow2024Impl(LocalDate localDate, double amount, String currency, String description,String debitAc, String creditAc, String subDebitAc, String subCreditAc, String groupTag, String gdlink, int rowNo) {
        this.localDate = localDate;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.debitAccount = mapAccountToValue.get(debitAc);
        this.creditAccount = mapAccountToValue.get(creditAc);
        this.debitSubAccount = subDebitAc;
        this.creditSubAccount = subCreditAc;
        this.transType = "";
        this.groupTag = mapGroupTagToValue.get(groupTag);
        this.gdlink = gdlink;
        this.rowNo = rowNo;
    }
    private String getSubCreditAccount(String type) {
        PrimaryAccountType prime = getPrimaryCreditAccount(type);
        if (getSetSecondaryAccounts(prime).contains(Map2015TypeTo2024CreditSubAccounts.map.get(type)))
            return Map2015TypeTo2024CreditSubAccounts.map.get(type);
        else
            return "Error";

    }

    private String getSubDebitAccount(String type, int rowNo) {
        PrimaryAccountType prime = getPrimaryDebitAccount(type);
        if (getSetSecondaryAccounts(prime).contains(Map2015TypeTo2024DebitSubAccounts.map.get(type)))
            return Map2015TypeTo2024DebitSubAccounts.map.get(type);
        else
            return "Error";
    }

    private PrimaryAccountType getPrimaryCreditAccount(String type) {
        String primaryCreditAccount = Map2015TypeTo2024CreditAccounts.map.get(type);
        return mapAccountToValue.get(primaryCreditAccount);
    }

    private PrimaryAccountType getPrimaryDebitAccount(String type) {
       String primaryDebitAccount = Map2015TypeTo2024DebitAccounts.map.get(type);
       return mapAccountToValue.get(primaryDebitAccount);
    }

    private Set<String> getSetSecondaryAccounts(PrimaryAccountType primeAccount){
        if (primeAccount == PrimaryAccountType.BankAsset) {
            return setSubBankAccounts;
        }
        else if(primeAccount == PrimaryAccountType.CashAsset){
            return cashAssetSubAccount;
        }
        else if (primeAccount == PrimaryAccountType.CashPay){
            return setSubCashPay;
        }
        else if (primeAccount == PrimaryAccountType.CreditCard){
            return setSubCreditCard;
        }
        else if (primeAccount == PrimaryAccountType.DigitalPay) {
            return setSubDigitalPay;
        }
        else
            return Set.of("");
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
