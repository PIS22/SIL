package com.sil.gpc.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class LigneEcriture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idLigEcri;
    private Date datEcri;
    private  double debit;
    private  double credit;
    private String obsLigEcri;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Ecriture.class)
    @JoinColumn(nullable = false, referencedColumnName = "numEcri", name = "numEcri")
    private Ecriture ecriture;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Compte.class)
    @JoinColumn(nullable = false, referencedColumnName = "idCpte", name = "idCpte")
    private Compte compte;

    public LigneEcriture() {
    }

    public LigneEcriture(Long idLigEcri, Date datEcri, double debit, double credit, String obsLigEcri, Ecriture ecriture, Compte compte) {
        this.idLigEcri = idLigEcri;
        this.datEcri = datEcri;
        this.debit = debit;
        this.credit = credit;
        this.obsLigEcri = obsLigEcri;
        this.ecriture = ecriture;
        this.compte = compte;
    }

    public Long getIdLigEcri() {
        return idLigEcri;
    }

    public void setIdLigEcri(Long idLigEcri) {
        this.idLigEcri = idLigEcri;
    }

    public Date getDatEcri() {
        return datEcri;
    }

    public void setDatEcri(Date datEcri) {
        this.datEcri = datEcri;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getObsLigEcri() {
        return obsLigEcri;
    }

    public void setObsLigEcri(String obsLigEcri) {
        this.obsLigEcri = obsLigEcri;
    }

    public Ecriture getEcriture() {
        return ecriture;
    }

    public void setEcriture(Ecriture ecriture) {
        this.ecriture = ecriture;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
