package com.example.apibudgettracking.Web;

import com.example.apibudgettracking.Dao.Model.Transaction;
import com.example.apibudgettracking.Dao.Model.Utilisateur;
import com.example.apibudgettracking.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/Transaction")
@CrossOrigin(origins = "http://localhost:5173/")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/add")
    public String add(@RequestBody Transaction Transaction) {
        transactionService.saveT(Transaction);
        return "new Transaction is added";
    }
    @GetMapping("/getAll")
    public List<Transaction> getAll() {
        return transactionService.getAllT();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Transaction> get(@PathVariable Long id) {
        try{
            Transaction T = transactionService.get(id);
            return new ResponseEntity<Transaction>(T, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        transactionService.delete(id);
        return "deleted Transaction";
    }
}
