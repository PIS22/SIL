package com.sil.gpc.services;


import com.sil.gpc.domains.TypeRecette;

import com.sil.gpc.repositories.TypeRecetteRepository;
import java.util.List;

public class TypeRecetteService {

	// @Autowired
    private final TypeRecetteRepository typeRecetteRepository;

    public TypeRecetteService(TypeRecetteRepository typeRecetteRepository) {
        this.typeRecetteRepository = typeRecetteRepository;
    }

    // Liste des TypeRecette
    public List<TypeRecette> findAllTypeRecette() {
        return  this.typeRecetteRepository.findAll();
    }
    
    // Renvoie un TypeRecette par son code
    public TypeRecette findById(String codeTypRec) {
        return this.typeRecetteRepository.getOne(codeTypRec);
    }
    
    // Sauvegarder un TypeRecette
    public TypeRecette save(TypeRecette typeRecette) {
        return   this.typeRecetteRepository.save(typeRecette);
    }
    
    
    // Editer un TypeRecette
    public TypeRecette edit(String codeTypeRecette,TypeRecette typeRecette) {
    	
    	TypeRecette typeRecettemod = this.typeRecetteRepository.getOne(codeTypeRecette);
		if(typeRecettemod != null) {
			typeRecettemod.setCodeTypRec(typeRecettemod.getCodeTypRec());
			typeRecettemod.setCodeTypRec(typeRecettemod.getLibeTypRec());
			
			return this.typeRecetteRepository.save(typeRecettemod);
    }
		return null;
    }
    
    // Supprimer un TypeRecette
    public void delete(TypeRecette typeRecette) {
         this.typeRecetteRepository.delete(typeRecette);
    }   
    
  
    //liste par libelle
	public List<TypeRecette> findBylibelle(String libeTypRec){
		
		return this.typeRecetteRepository.findBylibeTypRec(libeTypRec);
	}

}
