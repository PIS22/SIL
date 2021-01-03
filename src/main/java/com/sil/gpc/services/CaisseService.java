package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Arrondissement;
import com.sil.gpc.domains.Caisse;
import com.sil.gpc.repositories.CaisseRepository;

@Service
public class CaisseService {

	private final CaisseRepository repo;

	public CaisseService(CaisseRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Caisse save(Caisse caisse) {
		
		return this.repo.save(caisse);
	}
	
	public Caisse edit(String id, Caisse caisse) {
		
		Caisse entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setLibeCaisse(caisse.getLibeCaisse());
			entiter.setArrondissement(caisse.getArrondissement());
			
			return this.repo.save(entiter);
		}
		
		return null;		
	}
	
	public void delete(String id) {
		
		Caisse entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
	}
	
	public Optional<Caisse> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Caisse> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Caisse> findByCodeCaisse(String codeCaisse){
		
		return this.repo.findByCodeCaisse(codeCaisse);
	}
	
	public List<Caisse> findByArrondissement(Arrondissement arrondissement){
		
		return this.repo.findByArrondissement(arrondissement);
	}
	
	public List<Caisse> findByLibeCaisse(String libeCaisse){
		
		return this.repo.findByLibeCaisse(libeCaisse);
	}
	
}
