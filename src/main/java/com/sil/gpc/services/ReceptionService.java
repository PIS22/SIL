package com.sil.gpc.services;


import com.sil.gpc.domains.Reception;

import com.sil.gpc.repositories.ReceptionRepository;
import java.util.List;

public class ReceptionService {

	private final ReceptionRepository receptionRepository;

    public ReceptionService(ReceptionRepository receptionRepository) {
        this.receptionRepository = receptionRepository;
    }

    // Liste Uniter
    public List<Reception> findAll() {
        return  this.receptionRepository.findAll();
    }
    
    // Renvoie un Uniter par son code
    public Reception findById(String numReception) {
        return this.receptionRepository.getOne(numReception);
    }
    
    // Sauvegarder un Uniter
    public Reception save(Reception rep) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.receptionRepository.save(rep);
    }
    
    // Editer un Uniter
    public Reception edit(Reception rep) {
        return   this.receptionRepository.save(rep);
    }
    
    // Supprimer un Uniter
    public void delete(Reception  rep) {
         this.receptionRepository.delete(rep);
    }   

}
