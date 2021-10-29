package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class
NatureJournal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNat;
    private String codNat;
    private String libNat;

    public NatureJournal() {
    }

    public NatureJournal(String codeNat, String libNat) {
        this.codNat = codeNat;
        this.libNat = libNat;
    }

    public Long getIdNat() {
        return idNat;
    }

    public void setIdNat(Long idNat) {
        this.idNat = idNat;
    }

    public String getCodNat() {
        return codNat;
    }

    public void setCodNat(String codeNat) {
        this.codNat = codeNat;
    }

    public String getLibNat() {
        return libNat;
    }

    public void setLibNat(String libNat) {
        this.libNat = libNat;
    }

    @Override
    public String toString() {
        return "NatureJournal{" +
                "idNat=" + idNat +
                ", codeNat='" + codNat + '\'' +
                ", libNat='" + libNat + '\'' +
                '}';
    }
}
