package com.sil.gpc.encapsuleurs;

import  com.sil.gpc.domains.DemandeApprovisionnement;
import  com.sil.gpc.domains.LigneDemandeAppro;

import java.util.List;

public class EncapDemandeApprovisionnement {

    private  DemandeApprovisionnement demandeApprovisionnement;
    private List<LigneDemandeAppro> ligneDemandeAppros;

    public EncapDemandeApprovisionnement (DemandeApprovisionnement demandeApprovisionnement,List<LigneDemandeAppro> ligneDemandeAppros ){
        super();
        this.demandeApprovisionnement = demandeApprovisionnement;
        this.ligneDemandeAppros = ligneDemandeAppros;

    }

    public DemandeApprovisionnement getDemandeApprovisionnement() {
        return demandeApprovisionnement;
    }

    public void setDemandeApprovisionnement(DemandeApprovisionnement demandeApprovisionnement) {
        this.demandeApprovisionnement = demandeApprovisionnement;
    }

    public List<LigneDemandeAppro> getLigneDemandeAppros() {
        return ligneDemandeAppros;
    }

    public void setLigneDemandeAppros(List<LigneDemandeAppro> ligneDemandeAppros) {
        this.ligneDemandeAppros = ligneDemandeAppros;
    }
}
