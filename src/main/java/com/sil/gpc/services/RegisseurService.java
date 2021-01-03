package com.sil.gpc.services;


import com.sil.gpc.domains.Regisseur;

import com.sil.gpc.repositories.RegisseurRepository;
import java.util.List;

public class RegisseurService {

	private final RegisseurRepository regisseurRepository;

    public RegisseurService(RegisseurRepository regisseurRepository) {
        this.regisseurRepository = regisseurRepository;
    }

    // Liste Uniter
    public List<Regisseur> findAll() {
        return  this.regisseurRepository.findAll();
    }
    
    // Renvoie un Uniter par son code
    public Regisseur findById(String numRegisseur) {
        return this.regisseurRepository.getOne(numRegisseur);
    }
    
    // Sauvegarder un Uniter
    public Regisseur save(Regisseur reg) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.regisseurRepository.save(reg);
    }
    
    // Editer un Uniter
    public Regisseur edit(Regisseur reg) {
        return   this.regisseurRepository.save(reg);
    }
    
    // Supprimer un Uniter
    public void delete(Regisseur  reg) {
         this.regisseurRepository.delete(reg);
    }   

}
