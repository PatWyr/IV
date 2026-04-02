package com.iv.bank.exception;

public class AccountRemovalException extends RuntimeException {
    public AccountRemovalException() {
        super("Account removal failed");
    }
}
