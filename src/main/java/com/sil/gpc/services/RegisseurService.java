package com.sil.gpc.services;

import com.sil.gpc.domains.Regisseur;

import com.sil.gpc.repositories.RegisseurRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class RegisseurService {

	private final RegisseurRepository regisseurRepository;

    public RegisseurService(RegisseurRepository regisseurRepository) {
        this.regisseurRepository = regisseurRepository;
    }
    
    // Sauvegarder 
    public Regisseur save(Regisseur reg) {
        if(!regisseurRepository.existsById(reg.getIdRegisseur()))
        	return   this.regisseurRepository.save(reg);
		return null;
    }
    
 // Editer
    public Regisseur edit(String idRegisseur, Regisseur reg) {
       	
    	Regisseur regmod = this.regisseurRepository.getOne(idRegisseur);
   		if(regmod != null) {
   			regmod.setIdRegisseur(reg.getIdRegisseur());
   			regmod.setMagasinier(reg.getMagasinier());
   			regmod.setUtilisateur(reg.getUtilisateur());
   			return this.regisseurRepository.save(regmod);
       }
   		return null;
       }
    
    // Supprimer 
    public boolean delete(String  id) {
    	if(this.regisseurRepository.existsById(id))
            this.regisseurRepository.deleteById(id);
    	
    	return this.regisseurRepository.existsById(id);
    }   

    // Renvoie par id
    public Optional<Regisseur> findById(String numRegisseur) {
        return this.regisseurRepository.findById(numRegisseur);
    }
    
    // Liste 
    public List<Regisseur> getAll() {
        return  this.regisseurRepository.findAll();
    }
   
}
