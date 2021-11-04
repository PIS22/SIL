package com.sil.gpc.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Ecriture implements Serializable {
    @Id
    private String numEcri;
    private Timestamp datEcri;
    private String descript;
    private String refIntern;
    private String refExtern;
    private Timestamp datSaisie;
    private  boolean valide;
    private int ordre;
    @ManyToOne(targetEntity = Journal.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idJrn", referencedColumnName = "idJrn", nullable = false)
    private Journal journal;
    @ManyToOne(targetEntity = Utilisateur.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur", nullable = false)
    private Utilisateur user;
    @ManyToOne(targetEntity = Exercice.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
    private Exercice exo;

    public Ecriture() {
    }

    public Ecriture(String numEcri, Timestamp datEcri, String descript, String refInterne, String refExterne, Journal journal, Utilisateur user, Exercice exo) {
        this.numEcri = numEcri;
        this.datEcri = datEcri;
        this.descript = descript;
        this.refIntern = refInterne;
        this.refExtern = refExterne;
        this.journal = journal;
        this.user = user;
        this.exo = exo;
    }

    public String getNumEcri() {
        return numEcri;
    }

    public void setNumEcri(String numEcri) {
        this.numEcri = numEcri;
    }

    public Timestamp getDatEcri() {
        return datEcri;
    }

    public void setDatEcri(Timestamp datEcri) {
        this.datEcri = datEcri;
    }

    public String getDescipt() {
        return descript;
    }

    public void setDescipt(String descript) {
        this.descript = descript;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public String getRefIntern() {
        return refIntern;
    }

    public void setRefIntern(String refInterne) {
        this.refIntern = refInterne;
    }

    public String getRefExtern() {
        return refExtern;
    }

    public void setRefExtern(String refExterne) {
        this.refExtern = refExterne;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Exercice getExo() {
        return exo;
    }

    public void setExo(Exercice exo) {
        this.exo = exo;
    }

    public Timestamp getDatSaisie() {
        return datSaisie;
    }

    public void setDatSaisie(Timestamp datSaisie) {
        this.datSaisie = datSaisie;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    @Override
    public String toString() {
        return "Ecriture{" +
                "numEcri='" + numEcri + '\'' +
                ", datEcri=" + datEcri +
                ", descript='" + descript + '\'' +
                ", refInterne='" + refIntern + '\'' +
                ", refExterne='" + refExtern + '\'' +
                ", journal=" + journal +
                ", user=" + user +
                ", exo=" + exo +
                '}';
    }
}
