package com.sil.gpc.services;

import com.sil.gpc.domains.Correspondant;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.Magasin;
import com.sil.gpc.domains.Placement;
import com.sil.gpc.domains.Recollement;
import com.sil.gpc.domains.Regisseur;
import com.sil.gpc.repositories.RecollementRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class RecollementService {

	private final RecollementRepository recollementRepository;

    public RecollementService(RecollementRepository recollementRepository) {
        this.recollementRepository = recollementRepository;
    }
    
    // Sauvegarder 
    public Recollement save(Recollement recolle) {
        return   this.recollementRepository.save(recolle);
    }
    
    //Editer
    public Recollement edit(String numRecollement, Recollement recoll) {
       	
	 Recollement receptmod = this.recollementRepository.getOne(numRecollement);
   		if(receptmod != null) {
   			receptmod.setNumRecollement(recoll.getNumRecollement());
   			receptmod.setDescriptionRecollement(recoll.getDescriptionRecollement());
   			receptmod.setDateRecollement(recoll.getDateRecollement());
   			receptmod.setMagasin(recoll.getMagasin());
   			receptmod.setRegisseur(recoll.getRegisseur());
   			receptmod.setExercice(recoll.getExercice());
   			return this.recollementRepository.save(receptmod);
       }
   		return null;
       }
    
   
    // Supprimer 
    public boolean delete(String  id) {
    	if(this.recollementRepository.existsById(id))
            this.recollementRepository.deleteById(id);
    	
    return this.recollementRepository.existsById(id);

    } 
    
 // Renvoie par id
    public Optional<Recollement> findById(String numRecollement) {
        return this.recollementRepository.findById(numRecollement);
    }

    // Liste 
    public List<Recollement> getAll() {
        return  this.recollementRepository.findAll();
    }
    
    //
    public List<Recollement> findByNumRecollement(String NumRecollement){
		
		return this.recollementRepository.findByNumRecollement(NumRecollement);
	}
    
    //
    public List<Recollement> findByDescriptionRecollement(String DescriptionRecollement){
		
		return this.recollementRepository.findByDescriptionRecollement(DescriptionRecollement);
	}
    
    //
    public List<Recollement> findByDateRecollement(Date DateRecollement){
		
		return this.recollementRepository.findByDateRecollement(DateRecollement);
	}
    
    //
    public List<Recollement> findByMagasinRecollement(Magasin mag){
		
		return this.recollementRepository.findByMagasin(mag);
	}
    
    //
    public List<Recollement> findByRegisseurRecollement(Regisseur reg){
		
		return this.recollementRepository.findByRegisseur(reg);
	}
    
    //
    public List<Recollement> findByExerciceRecollement(Exercice exo){
		
		return this.recollementRepository.findByExercice(exo);
	}

	
	public List<Recollement> findByCorrespondant(Correspondant Corres){
		return recollementRepository.findByCorrespondant(Corres);
	}

}
