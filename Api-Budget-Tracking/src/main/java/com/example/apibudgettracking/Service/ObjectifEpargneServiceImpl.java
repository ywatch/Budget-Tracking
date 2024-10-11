package com.example.apibudgettracking.Service;

import com.example.apibudgettracking.Dao.Model.ObjectifEpargne;
import com.example.apibudgettracking.Dao.Repository.ObjectifEpargneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ObjectifEpargneServiceImpl implements ObjectifEpargneService{
    @Autowired
    ObjectifEpargneRepository objectifEpargneRepository;
    @Override
    public ObjectifEpargne saveT(ObjectifEpargne O) {
        objectifEpargneRepository.save(O);
        return null;
    }

    @Override
    public List<ObjectifEpargne> getAllT() {
        return objectifEpargneRepository.findAll();
    }

    @Override
    public ObjectifEpargne get(Long id) {
        return objectifEpargneRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
    objectifEpargneRepository.deleteById(id);
    }
}
