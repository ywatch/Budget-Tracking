package com.example.apibudgettracking.Service;

import com.example.apibudgettracking.Dao.Model.Transaction;
import com.example.apibudgettracking.Dao.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public Transaction saveT(Transaction Tr) {
        return transactionRepository.save(Tr);
    }

    @Override
    public List<Transaction> getAllT() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction get(Long id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }
}
