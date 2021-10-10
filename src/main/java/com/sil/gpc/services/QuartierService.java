package com.sil.gpc.services;

import com.sil.gpc.domains.Quartier;
import com.sil.gpc.domains.Arrondissement;
import com.sil.gpc.repositories.QuartierRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class QuartierService {

	// @Autowired
    private final QuartierRepository quartierRepository;

    public QuartierService(QuartierRepository quartierRepository) {
        this.quartierRepository = quartierRepository;
    }
    
 // Sauvegarder
    public Quartier save(Quartier quartier) {
        if(!quartierRepository.existsById(quartier.getCodeQuartier()))
        	return   this.quartierRepository.save(quartier);
		return null;
    }
    
 // Editer 
    public Quartier edit(String codeQuartier, Quartier quart) {
       	
    	Quartier quartmod = this.quartierRepository.getOne(codeQuartier);
   		if(quartmod != null) {
   			quartmod.setCodeQuartier(quart.getCodeQuartier());
   			quartmod.setNomQuartier(quart.getNomQuartier());
   			quartmod.setNumTelQuartier(quart.getNumTelQuartier());
   			quartmod.setAdresseQuartier(quart.getAdresseQuartier());
   			quartmod.setArrondissement(quart.getArrondissement());	
   			return this.quartierRepository.save(quartmod);
       }
   		return null;
       }
    
    // Supprimer 
    public boolean delete(String  id) {
    	if(this.quartierRepository.existsById(id))
            this.quartierRepository.deleteById(id);
    	
            return this.quartierRepository.existsById(id);
    }
    
    // 
    public Optional<Quartier> findById(String codeQuartier) {
        return this.quartierRepository.findById(codeQuartier);
    }
    
    // Liste des Quartier
    public List<Quartier> getAll() {
        return  this.quartierRepository.findAll();
    }
    
 
    //liste par code
    public List<Quartier> findByCodeQuartier(String CodeQuartier){
		
		return this.quartierRepository.findByCodeQuartier(CodeQuartier);
	}
    
  //
    public List<Quartier> findByNomQuartier(String NomQuartier){
		
		return this.quartierRepository.findByNomQuartier(NomQuartier);
	}
    
  //
    public List<Quartier> findByNumTelQuartier(String NumTelQuartier){
		
		return this.quartierRepository.findByNumTelQuartier(NumTelQuartier);
	}
    
    //
 public List<Quartier> findByAdresseQuartier(String AdresseQuartier){
		
		return this.quartierRepository.findByAdresseQuartier(AdresseQuartier);
	}
    
    //
    public List<Quartier> findByArrondissement(Arrondissement arr){
		
		return this.quartierRepository.findByArrondissement(arr);
	}

}
