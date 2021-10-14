package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TypeBudget implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTypBdg;
    private String codTypBdg;
    private String libTypBdg;

    public TypeBudget() {
    }

    public TypeBudget(Long idTypBdg, String codTypBudg, String libTypBudg) {
        this.idTypBdg = idTypBdg;
        this.codTypBdg = codTypBudg;
        this.libTypBdg = libTypBudg;
    }

    public Long getIdTypBudg() {
        return idTypBdg;
    }

    public void setIdTypBdg(Long idTypBudg) {
        this.idTypBdg = idTypBudg;
    }

    public String getCodTypBudg() {
        return codTypBdg;
    }

    public void setCodTypBudg(String codTypBudg) {
        this.codTypBdg = codTypBudg;
    }

    public String getLibTypBudg() {
        return libTypBdg;
    }

    public void setLibTypBudg(String libTypBudg) {
        this.libTypBdg = libTypBudg;
    }

    @Override
    public String toString() {
        return "TypeBudget{" +
                "idTypBudg=" + idTypBdg +
                ", codTypBudg='" + codTypBdg + '\'' +
                ", libTypBudg='" + libTypBdg + '\'' +
                '}';
    }
}
