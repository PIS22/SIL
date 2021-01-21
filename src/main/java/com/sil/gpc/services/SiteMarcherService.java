package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Arrondissement;
import com.sil.gpc.domains.Caisse;
import com.sil.gpc.domains.SiteMarcher;
import com.sil.gpc.repositories.SiteMarcherRepository;

@Service
public class SiteMarcherService {

	private final SiteMarcherRepository repo;

	public SiteMarcherService(SiteMarcherRepository repo) {
		super();
		this.repo = repo;
	}
	
public SiteMarcher save(SiteMarcher site) {
		
		return this.repo.save(site);
	}
	
	public SiteMarcher edit(String id, SiteMarcher site) {
		
		SiteMarcher entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setLibSite(site.getLibSite());
			entiter.setCodeSite(site.getCodeSite());
			entiter.setDescriSite(site.getDescriSite());
			
			return this.repo.save(entiter);
		}
		
		return null;		
	}
	
	public boolean delete(String id) {
		
		SiteMarcher entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public Optional<SiteMarcher> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<SiteMarcher> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<SiteMarcher> findByCodeSiteMarchers(String codeSite){
		
		return this.repo.findByCodeSite(codeSite);
	}
	
	public List<SiteMarcher> findByArrondissement(Arrondissement arrondi){
		
		return this.repo.findByArrondissement(arrondi);
	}
	
	public List<SiteMarcher> findByLibSite(String libeCaisse){
		
		return this.repo.findByLibSite(libeCaisse);
	}
	
	public List<SiteMarcher> findBydescriSite(String descriSite){
		
		return this.repo.findByDescriSite(descriSite);
	}
	
}
