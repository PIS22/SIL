package com.sil.gpc.services;


import com.sil.gpc.domains.Reversement;

import com.sil.gpc.repositories.ReversementRepository;
import java.util.List;

public class ReversementService {

	private final ReversementRepository reversementRepository;

    public ReversementService(ReversementRepository reversementRepository) {
        this.reversementRepository = reversementRepository;
    }

    // Liste Uniter
    public List<Reversement> findAll() {
        return  this.reversementRepository.findAll();
    }
    
    // Renvoie un Uniter par son code
    public Reversement findById(String numReversement) {
        return this.reversementRepository.getOne(numReversement);
    }
    
    // Sauvegarder un Uniter
    public Reversement save(Reversement rev) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.reversementRepository.save(rev);
    }
    
    // Editer un Uniter
    public Reversement edit(Reversement rev) {
        return   this.reversementRepository.save(rev);
    }
    
    // Supprimer un Uniter
    public void delete(Reversement  rev) {
         this.reversementRepository.delete(rev);
    }   

}
