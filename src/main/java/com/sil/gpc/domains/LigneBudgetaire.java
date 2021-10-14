package com.sil.gpc.domains;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LigneBudgetaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLigBdg;
    private double debit;
    private double credit;
    @ManyToOne(targetEntity = Budget.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idBdg", referencedColumnName = "idBdg")
    private Budget bdg;
    @ManyToOne(targetEntity = Compte.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idCpte", referencedColumnName = "idCpte")
    private Compte cpte;

    public LigneBudgetaire() {
    }

    public LigneBudgetaire(Long idLigBdg, double debit, double credit, Budget bdg, Compte cpte) {
        this.idLigBdg = idLigBdg;
        this.debit = debit;
        this.credit = credit;
        this.bdg = bdg;
        this.cpte = cpte;
    }

    public Long getIdLigBdg() {
        return idLigBdg;
    }

    public void setIdLigBdg(Long idLigBdg) {
        this.idLigBdg = idLigBdg;
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

    public Budget getBdg() {
        return bdg;
    }

    public void setBdg(Budget bdg) {
        this.bdg = bdg;
    }

    public Compte getCpte() {
        return cpte;
    }

    public void setCpte(Compte cpte) {
        this.cpte = cpte;
    }

    @Override
    public String toString() {
        return "LigneBudgetaire{" +
                "idLigBdg=" + idLigBdg +
                ", debit=" + debit +
                ", credit=" + credit +
                ", bdg=" + bdg +
                ", cpte=" + cpte +
                '}';
    }
}
