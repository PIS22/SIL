package com.sil.gpc.services;


import com.sil.gpc.domains.TypCorres;
import com.sil.gpc.repositories.TypCorresRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TypCorresService {

	// @Autowired
    private final TypCorresRepository typCorresRepository;

    public TypCorresService(TypCorresRepository typCorresRepository) {
        this.typCorresRepository = typCorresRepository;
    }

    // Sauvegarder
    public TypCorres save(TypCorres typCorres) {
    	if(!typCorresRepository.existsById(typCorres.getCodeTypCorres()))
    		return   this.typCorresRepository.save(typCorres);
		return null;
    }
    
 // editer
    public TypCorres edit(String codeTypCorres, TypCorres Typco) {
    	
    	TypCorres typCorresmmod = this.typCorresRepository.getOne(codeTypCorres);
		if(typCorresmmod != null) {
			typCorresmmod.setCodeTypCorres(Typco.getCodeTypCorres());
			typCorresmmod.setLibTypeCorres(Typco.getLibTypeCorres());
			
			return this.typCorresRepository.save(typCorresmmod);
    }
		return null;
    }
    
    
    // Supprimer  
    public boolean delete(String id) {
    	if( this.typCorresRepository.existsById(id))
         this.typCorresRepository.deleteById(id);
    	
         return this.typCorresRepository.existsById(id);
    }   
    
    // 
    public Optional<TypCorres> findById(String id) {
        return this.typCorresRepository.findById(id);
    }
    
    // Liste all
    public List<TypCorres> getAll() {
        return  this.typCorresRepository.findAll();
    }
    
  //liste par code
    public List<TypCorres> findByCodeTypCorres(String CodeTypCorres){
		
		return this.typCorresRepository.findByCodeTypCorres(CodeTypCorres);
	}
    
  //liste par libelle
    public List<TypCorres> findByLibelleTypCorres(String LibelleTypCorres){
		
		return this.typCorresRepository.findByLibTypeCorres(LibelleTypCorres);
	}
    
   
    
   

}
