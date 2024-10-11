package com.example.apibudgettracking.Web;

import com.example.apibudgettracking.Dao.Model.ObjectifEpargne;
import com.example.apibudgettracking.Service.ObjectifEpargneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ObjectifEpargne")
@CrossOrigin(origins = "http://localhost:4200")
public class ObjectifEpargneController {
    @Autowired
    ObjectifEpargneService ObjectifEpargneService;
    @PostMapping("/add")
    public String add(@RequestBody ObjectifEpargne Transaction) {
        ObjectifEpargneService.saveT(Transaction);
        return "new Transaction is added";
    }
    @GetMapping("/getAll")
    public List<ObjectifEpargne> getAll() {
        return ObjectifEpargneService.getAllT();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<ObjectifEpargne> get(@PathVariable Long id) {
        try{
            ObjectifEpargne T = ObjectifEpargneService.get(id);
            return new ResponseEntity<ObjectifEpargne>(T, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<ObjectifEpargne>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        ObjectifEpargneService.delete(id);
        return "deleted Transaction";
    }
}
