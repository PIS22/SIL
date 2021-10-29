package com.sil.gpc.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class LigneEcriture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idLigEcri;
    //private String reference;
    private String observation;
    private  double debit;
    private  double credit;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Ecriture.class)
    @JoinColumn(nullable = false, referencedColumnName = "numEcri", name = "numEcri")
    private Ecriture ecriture;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Compte.class)
    @JoinColumn(nullable = false, referencedColumnName = "idCpte", name = "idCpte")
    private Compte compte;

    public LigneEcriture() {
    }

    public LigneEcriture(Long idLigEcri, double debit, double credit, /*String reference,*/ String obs, Ecriture ecriture, Compte compte) {
        this.idLigEcri = idLigEcri;
        this.debit = debit;
        this.credit = credit;
        //this.reference = reference;
        this.observation = obs;
        this.ecriture = ecriture;
        this.compte = compte;
    }

    public Long getIdLigEcri() {
        return idLigEcri;
    }

    public void setIdLigEcri(Long idLigEcri) {
        this.idLigEcri = idLigEcri;
    }

    /*public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }*/

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
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

    @Override
    public String toString() {
        return "LigneEcriture{" +
                "idLigEcri=" + idLigEcri +
                //", reference='" + reference + '\'' +
                ", observation='" + observation + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", ecriture=" + ecriture +
                ", compte=" + compte +
                '}';
    }
}
