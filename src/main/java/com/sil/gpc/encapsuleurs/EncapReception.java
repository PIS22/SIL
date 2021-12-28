package com.sil.gpc.encapsuleurs;

import  com.sil.gpc.domains.Reception;
import  com.sil.gpc.domains.LigneReception;

import java.util.List;

public class EncapReception {

    private Reception reception;
    private List<LigneReception> ligneReceptions;

    public  EncapReception(Reception reception, List<LigneReception> ligneReceptions){
        super();
        this.reception = reception;
        this.ligneReceptions = ligneReceptions;
    }

    public  Reception getReception(){
        return  reception;
    }

    public  void setReception (Reception reception){

        this.reception = reception;

    }

    public List<LigneReception> getLigneReceptions() {
        return ligneReceptions;
    }

    public void setLigneReceptions(List<LigneReception> ligneReceptions) {

        this.ligneReceptions = ligneReceptions;
    }
}
