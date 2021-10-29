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

    public TypeBudget(Long idTypBdg, String codTypBdg, String libTypBdg) {
        this.idTypBdg = idTypBdg;
        this.codTypBdg = codTypBdg;
        this.libTypBdg = libTypBdg;
    }

    public Long getIdTypBdg() {
        return idTypBdg;
    }

    public void setIdTypBdg(Long idTypBdg) {
        this.idTypBdg = idTypBdg;
    }

    public String getCodTypBdg() {
        return codTypBdg;
    }

    public void setCodTypBdg(String codTypBdg) {
        this.codTypBdg = codTypBdg;
    }

    public String getLibTypBdg() {
        return libTypBdg;
    }

    public void setLibTypBdg(String libTypBdg) {
        this.libTypBdg = libTypBdg;
    }

    @Override
    public String toString() {
        return "TypeBudget{" +
                "idTypBdg=" + idTypBdg +
                ", codTypBdg='" + codTypBdg + '\'' +
                ", libTypBdg='" + libTypBdg + '\'' +
                '}';
    }
}
