package com.sil.gpc.services;

import com.sil.gpc.domains.TypeImmeuble;

import com.sil.gpc.repositories.TypeImmeubleRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TypeImmeubleService {

	// @Autowired
    private final TypeImmeubleRepository typeImmeubleRepository;

    public TypeImmeubleService(TypeImmeubleRepository typeImmeubleRepository) {
        this.typeImmeubleRepository = typeImmeubleRepository;
    }

    
 // Sauvegarder
    public TypeImmeuble save(TypeImmeuble Im) {
        if(!typeImmeubleRepository.existsById(Im.getCodeTypIm()))
        	return   this.typeImmeubleRepository.save(Im);
		return null;
    }
    
   // editer
    public TypeImmeuble edit(String codeTypIm, TypeImmeuble TypI) {
    	
    	TypeImmeuble typImmod = this.typeImmeubleRepository.getOne(codeTypIm);
		if(typImmod != null) {
			typImmod.setCodeTypIm(TypI.getCodeTypIm());
			typImmod.setLibTypIm(TypI.getLibTypIm());
			
			return this.typeImmeubleRepository.save(typImmod);
    }
		return null;
    }
    
    // Supprimer un TypeImmeuble
    public boolean delete(String id) {
    	if(this.typeImmeubleRepository.existsById(id))
			this.typeImmeubleRepository.deleteById(id);
    	
    	return this.typeImmeubleRepository.existsById(id);
    }   
    
    // Typeimmeuble par Id
    public Optional <TypeImmeuble> findById(String id) {
        return this.typeImmeubleRepository.findById(id);
    }
    
    
    // Liste de tous les TypeImmeuble
    public List<TypeImmeuble> getAll() {
        return  this.typeImmeubleRepository.findAll();
    }
    
   
    //liste par code
    public List<TypeImmeuble> findByCodeTypeImmeuble(String CodeTypeImmeuble){
		
		return this.typeImmeubleRepository.findByCodeTypIm(CodeTypeImmeuble);
	}
    
  //liste par libelle
    public List<TypeImmeuble> findByLibelleTypeImmeuble(String libelleTypImmeuble){
		
		return this.typeImmeubleRepository.findByLibTypIm(libelleTypImmeuble);
	}

}
