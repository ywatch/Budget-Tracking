package com.example.apibudgettracking.Service;

import com.example.apibudgettracking.Dao.Model.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction saveT(Transaction user);
    public List<Transaction> getAllT();
    public Transaction get(Long id);
    public void delete(Long id);
}
