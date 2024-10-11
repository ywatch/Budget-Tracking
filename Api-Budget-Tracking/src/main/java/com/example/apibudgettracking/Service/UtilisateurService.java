package com.example.apibudgettracking.Service;

import com.example.apibudgettracking.Dao.Model.Utilisateur;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UtilisateurService {
    public Utilisateur saveUser(Utilisateur user);
    public List<Utilisateur> getAllUsers();
    public Utilisateur get(Long id);
    public void delete(Long id);
    public Utilisateur getByName(String name);
    public boolean isvalideuser(String username,String password);
    public void saveProfilePicture(Long userId, MultipartFile file)throws IOException;
}
