package com.example.apibudgettracking.Dao.Model;
import com.example.apibudgettracking.Dao.Model.enumeration.CategorieT;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    @Enumerated(EnumType.STRING)
    private CategorieT categorie; // Uses the enum

    private LocalDate date;

    @ManyToOne
    private Utilisateur utilisateur;
}
