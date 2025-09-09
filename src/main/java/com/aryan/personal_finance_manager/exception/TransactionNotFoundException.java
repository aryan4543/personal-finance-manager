package com.aryan.personal_finance_manager.exception;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(Long id) {
        super("Transaction Not found with id: " + id);
    }
}
