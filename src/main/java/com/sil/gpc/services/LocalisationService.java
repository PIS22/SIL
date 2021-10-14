package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Localisation;
import com.sil.gpc.domains.TypeAmort;
import com.sil.gpc.repositories.LocalisationRepository;
import com.sil.gpc.repositories.TypeAmortRepository;

@Service
public class LocalisationService {
	
	private final LocalisationRepository repo;

	public LocalisationService(LocalisationRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Localisation> getAll(){
		return repo.findAll();
	}
	
	public Localisation getById(Long id) {
		return repo.findById(id).get();
	}
	
	public Localisation add(Localisation localisation) {
		return repo.save(localisation);
	}
	
	public Localisation edit(Long id, Localisation localisation) {
		
		if(repo.existsById(id)) {
			Localisation entiter = repo.getOne(id);
			
			entiter.setCodLoc(localisation.getCodLoc());
			entiter.setLibLoc(localisation.getLibLoc());
			entiter.setSiteMarcher(localisation.getSiteMarcher());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
}
