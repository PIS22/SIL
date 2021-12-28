package com.sil.gpc.encapsuleurs;


import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.LigneCommande;

import java.util.List;

public class EncapCommande {

    private Commande commande;
    private List<LigneCommande> ligneCommandes;

    public EncapCommande(Commande commande, List<LigneCommande> ligneCommandes) {
        super();
        this.commande = commande;
        this.ligneCommandes = ligneCommandes;
    }

    public EncapCommande() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }
}
