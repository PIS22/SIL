package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Commune;
import com.sil.gpc.domains.Departement;
import com.sil.gpc.repositories.CommuneRepository;

@Service
public class CommuneService {

	private final CommuneRepository repo;

	public CommuneService(CommuneRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Commune save(Commune commune) {
		
		return this.repo.save(commune);
	}
	
	public Commune edit(String id, Commune commune) {
		
		Commune entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setAdresseMairie(commune.getAdresseMairie());
			entiter.setNomCommune(commune.getNomCommune());
			entiter.setNumTelMairie(commune.getNumTelMairie());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public void delete (String id) {
		
		if(this.repo.existsById(id))
			this.repo.deleteById(id);
	}
	
	public Optional<Commune> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Commune> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Commune> findByCodeCommune(String codeCommune){
		
		return this.repo.findByCodeCommune(codeCommune);
	}
	
	public List<Commune> findByNomCommune(String nomCommune){
		
		return this.repo.findByNomCommune(nomCommune);
	}
	
	public List<Commune> findByNumTelMairie(String numTelMairie){
		
		return this.repo.findByNumTelMairie(numTelMairie);
	}
	
	public List<Commune> findByAdresseMairie(String adresseMairie){
		
		return this.repo.findByAdresseMairie(adresseMairie);
	}
	
	public List<Commune> findByCodeDepartement(Departement departement){
		
		return this.repo.findByCodeDepartement(departement);
	}
	
}
