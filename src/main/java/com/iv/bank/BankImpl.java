package com.iv.bank;

import com.iv.bank.exception.AccountCreationException;
import com.iv.bank.exception.AccountRemovalException;
import com.iv.bank.model.Account;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

// TODO
// implement bank class in BankImpl.class that will contain different accounts, accounts id should be unique
// it needs to cover functionalities like
// 1 - create account
// 2 - remove account
// bank needs to be able to process concurrent requests

public class BankImpl extends Bank {
    public BankImpl(PaymentService paymentService) {
        super(paymentService);
    }

    @Override
    public final boolean createAccount(Account account) throws AccountCreationException {
        return false;
    }

    @Override
    public final boolean removeAccount(UUID accountId) throws AccountRemovalException {
        return false;
    }

    @Override
    public Collection<Account> getAccounts() {
        return List.of();
    }
}
