package com.example.apibudgettracking.Dao.Repository;

import com.example.apibudgettracking.Dao.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
