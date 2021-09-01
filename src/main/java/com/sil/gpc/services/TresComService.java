package com.sil.gpc.services;

import com.sil.gpc.domains.TresCom;

import com.sil.gpc.repositories.TresComRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TresComService {

	private final TresComRepository tresComRepository;

    public TresComService(TresComRepository tresComRepository) {
        this.tresComRepository = tresComRepository;
    }

    
    // Sauvegarder
    public TresCom save(TresCom receptPercep) {
        if(!tresComRepository.existsById(receptPercep.getIdRp()))
        	return   this.tresComRepository.save(receptPercep);
		return null;
    }
    
  //Editer
    public TresCom edit(String idRp, TresCom recepPercept) {
       	
    	TresCom rpmod = this.tresComRepository.getOne(idRp);
   		if(rpmod != null) {
   			rpmod.setIdRp(recepPercept.getIdRp());
   			rpmod.setMagasinier(recepPercept.getMagasinier());
   			rpmod.setUtilisateur(recepPercept.getUtilisateur());
   			return this.tresComRepository.save(rpmod);
       }
   		return null;
       }
    
    // Supprimer 
    public boolean delete(String  id) {
    	if(this.tresComRepository.existsById(id))
            this.tresComRepository.deleteById(id);
    	
            return this.tresComRepository.existsById(id);
    }   
    
    // 
    public Optional<TresCom> findById(String idRp) {
        return this.tresComRepository.findById(idRp);
    }
    
    // Liste 
    public List<TresCom> getAll() {
        return  this.tresComRepository.findAll();
    }
    
    
    //
    public List<TresCom> findByIdrp(String idRp){
		
		return this.tresComRepository.findByIdRp(idRp);
	}

    
   

}
