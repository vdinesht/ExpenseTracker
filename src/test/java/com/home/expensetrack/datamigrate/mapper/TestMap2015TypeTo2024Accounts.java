package com.home.expensetrack.datamigrate.mapper;

import com.home.expensetrack.datamigrate.mapper.Impl.Map2015TypeTo2024CreditAccounts;
import com.home.expensetrack.datamigrate.mapper.Impl.Map2015TypeTo2024CreditSubAccounts;
import com.home.expensetrack.datamigrate.mapper.Impl.Map2015TypeTo2024DebitAccounts;
import com.home.expensetrack.datamigrate.mapper.Impl.Map2015TypeTo2024DebitSubAccounts;
import com.home.expensetrack.datamigrate.tracker2024.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMap2015TypeTo2024Accounts {

    @Test
    void testMapperOfTypeToDebitAccounts(){
        Set<String> debitAccounts = Map2015TypeTo2024DebitAccounts.map.values().stream().collect(Collectors.toSet());
        Set<String> types = Map2015TypeTo2024DebitAccounts.map.keySet().stream().collect(Collectors.toSet());
        debitAccounts.stream().forEach(e-> System.out.println(getPrimaryAccount(e)));
        assertTrue(debitAccounts.size() == 5);
        assertTrue(types.size() == 119);
    }

    @Test
    void testMapOfDebitAccounts(){
        Set<String> listDebitAccounts = Map2015TypeTo2024DebitAccounts.map.keySet();
        listDebitAccounts.forEach(e->{System.out.println(e); System.out.println(Map2015TypeTo2024DebitAccounts.map.get(e));});

        assertTrue(true);
    }
    @Test
    void testMapperOfTypeToCreditAccounts(){
        Set<String> creditAccounts = Map2015TypeTo2024CreditAccounts.map.values().stream().collect(Collectors.toSet());
        Set<String> types = Map2015TypeTo2024CreditAccounts.map.keySet().stream().collect(Collectors.toSet());
        creditAccounts.stream().forEach(e-> System.out.println(getPrimaryAccount(e)));
        assertTrue(creditAccounts.size() == 5);
        assertTrue(types.size() == 119);
    }

    @Test
    void testMapperOfTypeToDebitSubAccounts(){
       Map2015TypeTo2024DebitSubAccounts.map.keySet().stream().forEach(e-> {    System.out.println(e);
                                                                                String primeAccount = Map2015TypeTo2024DebitAccounts.map.get(e);
                                                                                String subAccount = Map2015TypeTo2024DebitSubAccounts.map.get(e);
                                                                                validateSubAccount(primeAccount, subAccount); });
    }

    @Test
    void testMapperOfTypeToCreditSubAccounts(){
        Map2015TypeTo2024CreditSubAccounts.map.keySet().stream().forEach(e-> {    System.out.println(e);
            String primeAccount = Map2015TypeTo2024CreditAccounts.map.get(e);
            String subAccount = Map2015TypeTo2024CreditSubAccounts.map.get(e);
            validateSubAccount(primeAccount, subAccount); });
    }

    private void validateSubAccount(String primaryAccount, String subAccount){
        try {
            PrimaryAccountType account = getPrimaryAccount(primaryAccount);
            Set<String> subAccountSet = getSetSecondaryAccounts(account);
            System.out.println(primaryAccount);
            System.out.println(subAccount);
            System.out.println(subAccountSet);
            assertTrue(subAccountSet.stream().anyMatch(e->e.contains(subAccount)));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertTrue(false);
        }
    }

    private PrimaryAccountType getPrimaryAccount(String account) throws IllegalArgumentException{
        Map<String, PrimaryAccountType> mapAccountToValue = EnumSet.allOf(PrimaryAccountType.class).stream().collect(Collectors.toMap(e->e.getValue(),e->e));

        if (mapAccountToValue.keySet().contains(account))
            return mapAccountToValue.get(account);
        else
            throw new IllegalArgumentException("Invalid Primary Account Value: " + account );
    }

    private Set<String> getSetSecondaryAccounts(PrimaryAccountType primeAccount){
        if (primeAccount == PrimaryAccountType.BankAsset) {
            return EnumSet.allOf(BankAccount.class).stream().map(e->e.getValue()).collect(Collectors.toSet());
        }
        else if(primeAccount == PrimaryAccountType.CashAsset){
            return Set.of("CashAsset");
        }
        else if (primeAccount == PrimaryAccountType.CashPay){
            return EnumSet.allOf(CashPay.class).stream().map(e->e.getValue()).collect(Collectors.toSet());
        }
        else if (primeAccount == PrimaryAccountType.CreditCard){
            return EnumSet.allOf(CreditCard.class).stream().map(e->e.getValue()).collect(Collectors.toSet());
        }
        else if (primeAccount == PrimaryAccountType.DigitalPay) {
            return EnumSet.allOf(DigitalPay.class).stream().map(e->e.getValue()).collect(Collectors.toSet());
        }
        else
            return Set.of("");
    }
}
