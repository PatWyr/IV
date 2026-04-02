package com.iv.bank.model;

import java.util.UUID;

// TODO
// add account type there can be 2 types of accounts standard and vip
// bank in future may add more types of accounts
// simplify this class if possible, you can make any changes you want but be aware that they may break test cases

public class Account {
    public UUID id;
    public double balance;

    public Account(UUID id, double balance) {
        this.balance = balance;
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }
}
