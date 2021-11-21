package fr.cc1.domain.service;

import fr.cc1.domain.model.BankAccount;

import java.util.function.Predicate;

public class BankAccountValidatorService implements Predicate<BankAccount> {

    private static final BankAccountValidatorService INSTANCE = new BankAccountValidatorService();

    private BankAccountValidatorService() {
    }

    public static BankAccountValidatorService getInstance() {
        return INSTANCE;
    }


    @Override
    public boolean test(BankAccount bankAccount) {
        if(bankAccount.getMoney() > 15){
            return true;
        }
        return false;
    }




}
