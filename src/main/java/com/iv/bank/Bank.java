package com.iv.bank;

// TODO
// implement bank class in BankImpl.class that will contain different accounts, accounts id should be unique
// it needs to cover functionalities like
// 1 - create account
// 2 - remove account
// bank needs to be able to process concurrent requests

import com.iv.bank.exception.AccountCreationException;
import com.iv.bank.model.Account;

import java.util.Collection;
import java.util.UUID;

public abstract class Bank {
    private final PaymentService paymentService;

    protected Bank(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public abstract boolean createAccount(Account account) throws AccountCreationException;

    public abstract boolean removeAccount(UUID accountId);

    public abstract Collection<Account> getAccounts();

    public final double checkBalance(Account account) {
        return paymentService.checkBalance(account);
    }

    public final double makePayment(Account account, double amount) {
        return paymentService.makePayment(account, amount);
    }
}
