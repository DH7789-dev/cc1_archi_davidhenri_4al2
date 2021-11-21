package fr.cc1.domain.model;

import java.util.Objects;

public class BankAccount {

    private int money;

    private BankAccount(int money) {
        this.money = Objects.requireNonNull(money);
    }

    public  static BankAccount of(int money) {
        return new BankAccount(money);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}
