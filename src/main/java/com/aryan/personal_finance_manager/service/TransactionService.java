package com.aryan.personal_finance_manager.service;

import com.aryan.personal_finance_manager.entity.Transaction;
import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(Long id);
    Transaction updateTransaction(Long id, Transaction transaction);
    void deleteTransaction(Long id);
    void deleteTransactions(List <Long> ids);
}

