package com.sil.gpc.services;


import com.sil.gpc.domains.Immeuble;
import com.sil.gpc.domains.PrixImmeuble;

import com.sil.gpc.repositories.PrixImmeubleRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PrixImmeubleService {

	// @Autowired
    private final PrixImmeubleRepository prixImmeubleRepository;

    public PrixImmeubleService(PrixImmeubleRepository prixImmeubleRepository) {
        this.prixImmeubleRepository = prixImmeubleRepository;
    }
    
    // Sauvegarder 
    public PrixImmeuble save(PrixImmeuble prixIm) {
        return   this.prixImmeubleRepository.save(prixIm);
    }
    
    // Editer 
    public PrixImmeuble edit(Long idPrixImmeuble, PrixImmeuble prixIm) {
       	
    	PrixImmeuble pimod = this.prixImmeubleRepository.getOne(idPrixImmeuble);
   		if(pimod != null) {
   			pimod.setIdPrixIm(prixIm.getIdPrixIm());
   			pimod.setDateDebPrixIm(prixIm.getDateDebPrixIm());
   			pimod.setDateFinPrixIm(prixIm.getDateFinPrixIm());
   			pimod.setPrixIm(prixIm.getPrixIm());
   			pimod.setImmeuble(prixIm.getImmeuble());			
   			return this.prixImmeubleRepository.save(pimod);
       }
   		return null;
       }
    
    // Supprimer 
    public boolean delete(Long  id) {
    	if(this.prixImmeubleRepository.existsById(id))
            this.prixImmeubleRepository.deleteById(id);
    	
    return this.prixImmeubleRepository.existsById(id);
    }
    
    // 
    public Optional<PrixImmeuble> findById(Long id) {
        return this.prixImmeubleRepository.findById(id);
    }
   
    // Liste 
    public List<PrixImmeuble> getAll() {
        return  this.prixImmeubleRepository.findAll();
    }
    
    //
    public List<PrixImmeuble> findByDateDebPrixIm(Date DateDebPrixIm )
    {
    	return this.prixImmeubleRepository.findByDateDebPrixIm(DateDebPrixIm);
    }
    
    //
    public List<PrixImmeuble> findByDateFinPrixIm(Date DateFinPrixIm )
    {
    	return this.prixImmeubleRepository.findByDateFinPrixIm(DateFinPrixIm);
    }
    
    //
    public List<PrixImmeuble> findByPrixIm(Long PrixIm )
    {
    	return this.prixImmeubleRepository.findByPrixIm(PrixIm);
    }
   
    //
    public List<PrixImmeuble> findByImeublem(Immeuble im )
    {
    	return this.prixImmeubleRepository.findByImmeuble(im);
    }
   
   

}
