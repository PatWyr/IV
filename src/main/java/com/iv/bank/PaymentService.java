package com.iv.bank;


import com.iv.bank.exception.PaymentException;
import com.iv.bank.model.Account;


// implement payment service,
// make payment and check balance methods, both needs to return current balance after operation
// make sure that payment can be processed (balance is enough)
public interface PaymentService {
    default double makePayment(Account account, double amount) throws PaymentException {
        return 0;
    };
    default double checkBalance(Account account) {
        return 0;
    };
}
