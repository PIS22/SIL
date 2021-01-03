package com.sil.gpc.services;

import com.sil.gpc.domains.TypeImmeuble;

import com.sil.gpc.repositories.TypeImmeubleRepository;
import java.util.List;

public class TypeImmeubleService {

	// @Autowired
    private final TypeImmeubleRepository typeImmeubleRepository;

    public TypeImmeubleService(TypeImmeubleRepository typeImmeubleRepository) {
        this.typeImmeubleRepository = typeImmeubleRepository;
    }

    // Liste 
    public List<TypeImmeuble> findAll() {
        return  this.typeImmeubleRepository.findAll();
    }
    
    // Renvoie 
    public TypeImmeuble findById(String codeTypIm) {
        return this.typeImmeubleRepository.getOne(codeTypIm);
    }
    
    // Sauvegarder
    public TypeImmeuble save(TypeImmeuble Im) {
        return   this.typeImmeubleRepository.save(Im);
    }
    
   // editer
    public TypeImmeuble edit(String codeTypIm, TypeImmeuble TypI) {
    	
    	TypeImmeuble typImmod = this.typeImmeubleRepository.getOne(codeTypIm);
		if(typImmod != null) {
			typImmod.setCodeTypIm(typImmod.getCodeTypIm());
			typImmod.setLibTypIm(typImmod.getLibTypIm());
			
			return this.typeImmeubleRepository.save(typImmod);
    }
		return null;
    }
    
   //supprimer
    public void delete(TypeImmeuble Im) {;
         this.typeImmeubleRepository.delete(Im);
    }   
    
    //liste par libelle
    public List<TypeImmeuble> findBylibelle(String libeTypIm){
		
		return this.typeImmeubleRepository.findByLibeTypIm(libeTypIm);
	}

}
