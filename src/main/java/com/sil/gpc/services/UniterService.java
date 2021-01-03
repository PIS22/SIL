package com.sil.gpc.services;

import com.sil.gpc.domains.Uniter;

import com.sil.gpc.repositories.UniterRepository;
import java.util.List;

public class UniterService {

	// @Autowired
    private final UniterRepository uniterRepository;

    public UniterService(UniterRepository uniterRepository) {
        this.uniterRepository = uniterRepository;
    }

    // Liste Uniter
    public List<Uniter> findAll() {
        return  this.uniterRepository.findAll();
    }
    
    // Renvoie un Uniter par son code
    public Uniter findById(String codeUniter) {
        return this.uniterRepository.getOne(codeUniter);
    }
    
    // Sauvegarder un Uniter
    public Uniter save(Uniter uniter) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.uniterRepository.save(uniter);
    }
    
    // Editer un Uniter
    public Uniter edit(String codeUniter,Uniter uniter) {
    	
    	Uniter unitemod = this.uniterRepository.getOne(codeUniter);
		if(unitemod != null) {
			unitemod.setCodeUniter(unitemod.getCodeUniter());
			unitemod.setLibUniter(unitemod.getLibUniter());
			
			return this.uniterRepository.save(unitemod);
    }
		return null;
    }
    
    // Supprimer un Uniter
    public void delete(Uniter uniter) {
         this.uniterRepository.delete(uniter);
    }   
    
    //liste par libelle
    public List<Uniter> findBylibelle(String libUniter){
		
		return this.uniterRepository.findBylibUniter(libUniter);
	}

}
