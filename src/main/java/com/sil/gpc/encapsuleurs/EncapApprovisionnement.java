package com.sil.gpc.encapsuleurs;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.LigneAppro;

import java.util.List;

public class EncapApprovisionnement {

    private Approvisionnement approvisionnement;
    private List<LigneAppro> ligneAppros;

    public  EncapApprovisionnement(Approvisionnement approvisionnement, List<LigneAppro> ligneAppros){
        super();
        this.approvisionnement = approvisionnement;
        this.ligneAppros = ligneAppros;

    }

    public Approvisionnement getApprovisionnement() {
        return approvisionnement;
    }

    public void setApprovisionnement(Approvisionnement approvisionnement) {
        this.approvisionnement = approvisionnement;
    }

    public List<LigneAppro> getLigneAppros() {
        return ligneAppros;
    }


    public void setLigneAppros(List<LigneAppro> ligneAppros) {
        this.ligneAppros = ligneAppros;
    }
}
