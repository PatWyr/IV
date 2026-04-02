package com.iv.bank.exception;

public class AccountCreationException extends RuntimeException {
    public AccountCreationException() {
        super("Account creation failed");
    }
}
