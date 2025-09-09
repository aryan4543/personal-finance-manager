package com.aryan.personal_finance_manager.service.impl;

import com.aryan.personal_finance_manager.entity.Transaction;
import com.aryan.personal_finance_manager.repository.TransactionRepository;
import com.aryan.personal_finance_manager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImplement implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImplement(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        // auto-set timestamps here
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Transaction existing = getTransactionById(id);
        existing.setTitle(updatedTransaction.getTitle());
        existing.setAmount(updatedTransaction.getAmount());
        existing.setCategory(updatedTransaction.getCategory());
        return transactionRepository.save(existing);
    }

    @Override
    public void deleteTransaction(Long id) {
        Transaction existing = getTransactionById(id);
        transactionRepository.delete(existing);
    }

    @Override
    public void deleteTransactions(List<Long> ids) {
        transactionRepository.deleteAllById(ids);
    }
}

