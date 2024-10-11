package com.example.apibudgettracking.Service;

import com.example.apibudgettracking.Dao.Model.ObjectifEpargne;

import java.util.List;

public interface ObjectifEpargneService {
    public ObjectifEpargne saveT(ObjectifEpargne O);
    public List<ObjectifEpargne> getAllT();
    public ObjectifEpargne get(Long id);
    public void delete(Long id);
}
