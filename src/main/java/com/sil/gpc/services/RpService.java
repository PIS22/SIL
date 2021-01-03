package com.sil.gpc.services;


import com.sil.gpc.domains.Rp;

import com.sil.gpc.repositories.RpRepository;
import java.util.List;

public class RpService {

	private final RpRepository rpRepository;

    public RpService(RpRepository rpRepository) {
        this.rpRepository = rpRepository;
    }

    // Liste Uniter
    public List<Rp> findAll() {
        return  this.rpRepository.findAll();
    }
    
    // Renvoie un Uniter par son code
    public Rp findById(String idRp) {
        return this.rpRepository.getOne(idRp);
    }
    
    // Sauvegarder un Uniter
    public Rp save(Rp receptPercep) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.rpRepository.save(receptPercep);
    }
    
    // Editer un Uniter
    public Rp edit(Rp receptPercep) {
        return   this.rpRepository.save(receptPercep);
    }
    
    // Supprimer un Uniter
    public void delete(Rp  receptPercep) {
         this.rpRepository.delete(receptPercep);
    }   

}
