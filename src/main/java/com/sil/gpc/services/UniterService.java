package com.sil.gpc.services;


import com.sil.gpc.domains.Uniter;
import com.sil.gpc.repositories.UniterRepository;
import java.util.List;
import java.util.Optional;

public class UniterService {

	// @Autowired
    private final UniterRepository uniterRepository;

    public UniterService(UniterRepository uniterRepository) {
        this.uniterRepository = uniterRepository;
    }

 // Sauvegarder un Uniter
    public Uniter save(Uniter uniter) {
        return   this.uniterRepository.save(uniter);
    }
    
    // Editer un Uniter
    public Uniter edit(String codeUniter,Uniter uniter) {
    	
    	Uniter unitemod = this.uniterRepository.getOne(codeUniter);
		if(unitemod != null) {
			unitemod.setCodeUniter(uniter.getCodeUniter());
			unitemod.setLibUniter(uniter.getLibUniter());
			
			return this.uniterRepository.save(unitemod);
    }
		return null;
    }
    
 // Supprimer  
    public boolean delete(String id) {
         this.uniterRepository.deleteById(id);
    	
    	if(this.uniterRepository.existsById(id)) return false; else return true;
    }   
    
 // Renvoie un Uniter par son code
    public Optional <Uniter> findById(String id) {
        return this.uniterRepository.findById(id);
    }
    
    
    // Liste Uniter
    public List<Uniter> getAll() {
        return  this.uniterRepository.findAll();
    }
    
    
  //liste par code
    public List<Uniter> findByCodeUniter(String CodeUniter){
		
		return this.uniterRepository.findByCodeUniter(CodeUniter);
	}
    
  //liste par libelle
    public List<Uniter> findByLibelleUniter(String LibelleUniter){
		
		return this.uniterRepository.findByLibelleUniter(LibelleUniter);
	}
    

}
