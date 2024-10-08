package com.example.apibudgettracking.Dao.Model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectifEpargne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal montantCible;
    private BigDecimal montantAtteint;
    private String nomObjectif;
    @ManyToOne
    private Utilisateur utilisateur;
}

