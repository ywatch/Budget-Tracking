package com.example.apibudgettracking.Dao.Model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal montant;
    private String description;
    private String categorie; // Logement, Alimentation, etc.
    private LocalDate date;
    @ManyToOne
    private Utilisateur utilisateur;
}
