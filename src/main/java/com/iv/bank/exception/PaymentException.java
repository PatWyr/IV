package com.iv.bank.exception;

public class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super("Payment failed");
    }
}
