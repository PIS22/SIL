package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.SiteMarcher;
import com.sil.gpc.repositories.SiteMarcherRepository;

@Service
public class SiteMarcherService {

	private final SiteMarcherRepository repo;

	public SiteMarcherService(SiteMarcherRepository repo) {
		super();
		this.repo = repo;
	}

    // Sauvegarder 
    public SiteMarcher save(SiteMarcher sm) {
    	if(!repo.existsById(sm.getCodeSite()))
    		return repo.save(sm);
		return null;
    }
    
    // Editer 
    public SiteMarcher edit(String id, SiteMarcher sm) {
       	if(repo.existsById(id)) {
   			SiteMarcher por=repo.getOne(id);
   			por.setCodeSite(sm.getCodeSite());
   			por.setLibSite(sm.getLibSite());
   			por.setDescriSite(sm.getDescriSite());
   			por.setArrondissement(sm.getArrondissement());
   			return this.repo.save(por);
       }
   		return null;
       }
    
    // Supprimer 
    public boolean delete(String  id) {
    	if(this.repo.existsById(id))
            this.repo.deleteById(id);
    return !this.repo.existsById(id);
    }
    
    // 
    public Optional<SiteMarcher> findById(String id) {
        return this.repo.findById(id);
    }

    
    // 
    public List<SiteMarcher> findByLibe(String lib) {
        return this.repo.findByLibSite(lib);
    }
   
    // Liste 
    public List<SiteMarcher> getAll() {
        return  this.repo.findAll();
    }
    
}
