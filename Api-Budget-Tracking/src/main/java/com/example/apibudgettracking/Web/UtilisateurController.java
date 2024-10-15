package com.example.apibudgettracking.Web;

import com.example.apibudgettracking.Dao.Model.Utilisateur;
import com.example.apibudgettracking.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173/")
public class UtilisateurController {
@Autowired
    UtilisateurService utilisateurService;
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Utilisateur user,@RequestParam("file") MultipartFile file) {
        try {
            utilisateurService.saveUser(user);
            utilisateurService.saveProfilePicture(user.getId(), file);
            return ResponseEntity.ok("File and user uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        if (utilisateurService.isvalideuser(username,password)) {
            return "login successful";
        }
        else {
            return"login failed";
        }

    }
    @GetMapping("/getAll")
    public List<Utilisateur> getAll() {
        return utilisateurService.getAllUsers();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Utilisateur> get(@PathVariable Long id) {
        try{
            Utilisateur user = utilisateurService.get(id);
            return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping(path = "/{Name}")
    public ResponseEntity<Utilisateur> get(@PathVariable String Name) {
        try{
            Utilisateur user = utilisateurService.getByName(Name);
            return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadProfilePicture(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            utilisateurService.saveProfilePicture(id, file);
            return ResponseEntity.ok("File uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }
    @GetMapping("/{Name}/profile-picture")
    public ResponseEntity<byte[]> getProfilePicture(@PathVariable String Name) {
        Utilisateur user = utilisateurService.getByName(Name);
        byte[] image = user.getProfilePicture();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
}
