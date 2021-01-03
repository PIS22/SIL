package com.sil.gpc.services;


import com.sil.gpc.domains.TypCorres;

import com.sil.gpc.repositories.TypCorresRepository;
import java.util.List;

public class TypCorresService {

	// @Autowired
    private final TypCorresRepository typCorresRepository;

    public TypCorresService(TypCorresRepository typCorresRepository) {
        this.typCorresRepository = typCorresRepository;
    }

    // Liste Uniter
    public List<TypCorres> findAll() {
        return  this.typCorresRepository.findAll();
    }
    
    // Renvoie un Uniter par son code
    public TypCorres findById(String codetypCorres) {
        return this.typCorresRepository.getOne(codetypCorres);
    }
    
    // Sauvegarder un Uniter
    public TypCorres save(TypCorres typCorres) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.typCorresRepository.save(typCorres);
    }
    
    // Editer un Uniter
    public TypCorres edit(TypCorres typCorres) {
        return   this.typCorresRepository.save(typCorres);
    }
    
    // Supprimer un Uniter
    public void delete(TypCorres typCorres) {
         this.typCorresRepository.delete(typCorres);
    }   

}
