package com.sil.gpc.domains;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Budget implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBdg;
    @ManyToOne(targetEntity = Exercice.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "codeExo", referencedColumnName = "codeExercice")
    private Exercice exo;
    @ManyToOne(targetEntity = TypeBudget.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idTypBdg", referencedColumnName = "idTypBdg")
    private TypeBudget typBdg;

    public Budget() {
    }

    public Budget(Long idBdg, Exercice exo, TypeBudget typBudg) {
        this.idBdg = idBdg;
        this.exo = exo;
        this.typBdg = typBudg;
    }

    public Long getIdBdg() {
        return idBdg;
    }

    public void setIdBdg(Long idBdg) {
        this.idBdg = idBdg;
    }

    public Exercice getExo() {
        return exo;
    }

    public void setExo(Exercice exo) {
        this.exo = exo;
    }

    public TypeBudget getTypBudg() {
        return typBdg;
    }

    public void setTypBudg(TypeBudget typBudg) {
        this.typBdg = typBudg;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "idBdg=" + idBdg +
                ", exo=" + exo +
                ", typBudg=" + typBdg +
                '}';
    }
}
