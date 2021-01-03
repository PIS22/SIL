package com.sil.gpc.services;


import com.sil.gpc.domains.Recollement;

import com.sil.gpc.repositories.RecollementRepository;
import java.util.List;

public class RecollementService {

	private final RecollementRepository recollementRepository;

    public RecollementService(RecollementRepository recollementRepository) {
        this.recollementRepository = recollementRepository;
    }

    // Liste Uniter
    public List<Recollement> findAll() {
        return  this.recollementRepository.findAll();
    }
    
    // Renvoie un Uniter par son code
    public Recollement findById(String numRecollement) {
        return this.recollementRepository.getOne(numRecollement);
    }
    
    // Sauvegarder un Uniter
    public Recollement save(Recollement recolle) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.recollementRepository.save(recolle);
    }
    
    // Editer un Uniter
    public Recollement edit(Recollement recolle) {
        return   this.recollementRepository.save(recolle);
    }
    
    // Supprimer un Uniter
    public void delete(Recollement  recolle) {
         this.recollementRepository.delete(recolle);
    }   

}
