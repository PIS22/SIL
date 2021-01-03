package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Famille;
import com.sil.gpc.repositories.FamilleRepository;

@Service
public class FamilleService {

	private final FamilleRepository repo;

	public FamilleService(FamilleRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Famille save(Famille famille) {
		
		return this.repo.save(famille);
	}
	
	public Famille edit(String id, Famille famille) {
		
		Famille entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setLibFamille(famille.getLibFamille());
		}
		
		return null;
	}
	
	public void delete (String id) {
		
		if(this.repo.existsById(id))
			this.repo.deleteById(id);
	}
	
	public Optional<Famille> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Famille> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Famille> findByCodeFamille(String codeFamille){
		
		return this.repo.findByCodeFamille(codeFamille);
	}
	
	public List<Famille> findByLibFamille(String libFamille){
		
		return this.repo.findByLibFamille(libFamille);
	}
	
}
