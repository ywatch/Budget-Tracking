package com.example.apibudgettracking.Service;

import com.example.apibudgettracking.Dao.Model.Utilisateur;
import com.example.apibudgettracking.Dao.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository userRepository;

    @Override
    public List<Utilisateur> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Utilisateur saveUser(Utilisateur user) {
        return userRepository.save(user);
    }

    @Override
    public Utilisateur get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void  delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Utilisateur getByName(String name) {
        List<Utilisateur> us = userRepository.findAll();
        Utilisateur user = null;
        for (Object u : us) {
            if (((Utilisateur) u).getNom().equals(name)) {
                user = (Utilisateur) u;
            }
        }
        return user;
    }

    @Override
    public boolean isvalideuser(String username,String password) {
        Utilisateur user = getByName(username);
        if (user.getNom().equals(username)&&user.getMotDePasse().equals(user.getMotDePasse())){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public void saveProfilePicture(Long userId, MultipartFile file) throws IOException {
            Utilisateur user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
            user.setProfilePicture(file.getBytes());
            userRepository.save(user);}
}
