package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Correspondant;
import com.sil.gpc.domains.EtreAffecte;
import com.sil.gpc.domains.SiteMarcher;
import com.sil.gpc.repositories.EtreAffecteRepository;

@Service
public class EtreAffeccteService {

	private final EtreAffecteRepository repos;

	/**
	 * @param repos
	 */
	public EtreAffeccteService(EtreAffecteRepository repos) {
		this.repos = repos;
	}


    // Sauvegarder 
    public EtreAffecte save(EtreAffecte rep) {
        return   this.repos.save(rep);
    }
    
    // Editer 
    public EtreAffecte edit(Long id, EtreAffecte recept) {
       	
    	EtreAffecte receptmod = this.repos.getOne(id);
   		if(receptmod != null) {
   			receptmod.setDateArrivee(recept.getDateArrivee());;
   			receptmod.setDateDepart(recept.getDateDepart());
   			receptmod.setSite(recept.getSite());
   			receptmod.setCorres(recept.getCorres());
   			return this.repos.save(receptmod);
       }
   		return null;
       }
    
    // Supprimer 
    public boolean delete(Long  id) {
    	if(this.repos.existsById(id))
            this.repos.deleteById(id);
    	return this.repos.existsById(id);
    }   
    
    // 
    public Optional<EtreAffecte> findById(Long id) {
        return this.repos.findById(id);
    }
    
    
    // Liste 
    public List<EtreAffecte> getAllAffect() {
        return  this.repos.findAll();
    }
    
 //
    public List<EtreAffecte> findByDateArrivee(Date datearr){
		
		return this.repos.findByDateArrivee(datearr);
	}
    
    //
    public List<EtreAffecte> findByCorresp(Correspondant corres){
		
		return this.repos.findByCorres(corres);
	}
    
    //
    public List<EtreAffecte> findBySite(SiteMarcher site){
		
		return this.repos.findBySite(site);
	}

}
