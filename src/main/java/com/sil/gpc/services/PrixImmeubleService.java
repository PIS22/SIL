package com.sil.gpc.services;


import com.sil.gpc.domains.PrixImmeuble;

import com.sil.gpc.repositories.PrixImmeubleRepository;
import java.util.List;

public class PrixImmeubleService {

	// @Autowired
    private final PrixImmeubleRepository prixImmeubleRepository;

    public PrixImmeubleService(PrixImmeubleRepository prixImmeubleRepository) {
        this.prixImmeubleRepository = prixImmeubleRepository;
    }

    // Liste Uniter
    public List<PrixImmeuble> findAll() {
        return  this.prixImmeubleRepository.findAll();
    }
    
    // Renvoie un Service par son code
    public PrixImmeuble findById(Long idPrixIm) {
        return this.prixImmeubleRepository.getOne(idPrixIm);
    }
    
    // Sauvegarder un Service
    public PrixImmeuble save(PrixImmeuble prixIm) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.prixImmeubleRepository.save(prixIm);
    }
    
    // Editer un Service
    public PrixImmeuble edit(PrixImmeuble prixIm) {
        return   this.prixImmeubleRepository.save(prixIm);
    }
    
    // Supprimer un Service
    public void delete(PrixImmeuble prixIm) {;
         this.prixImmeubleRepository.delete(prixIm);
    }   

}
