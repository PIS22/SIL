package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Arrondissement;
import com.sil.gpc.domains.Commune;
import com.sil.gpc.repositories.ArrondissementRepository;

@Service
public class ArrondissementService {

	private final ArrondissementRepository repo;

	public ArrondissementService(ArrondissementRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Arrondissement save(Arrondissement arrondissement) {
		if(!repo.existsById(arrondissement.getCodeArrondi())) {
			return this.repo.save(arrondissement);
		}
		return null;
	}
	
	public Arrondissement edit(String id, Arrondissement arrondissement) {
		
		Arrondissement entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setNomArrondi(arrondissement.getNomArrondi());
			entiter.setAdresseArrondi(arrondissement.getAdresseArrondi());
			entiter.setNumTelArrondi(arrondissement.getNumTelArrondi());
			
			return this.repo.save(entiter);
		}
		
		return null;
		
	}
	
	public boolean delete(String id) {
		
		Arrondissement entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
		
	}
	
	public Optional<Arrondissement> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Arrondissement> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Arrondissement> findByCodeArrondi(String codeArrondi){
		
		return this.repo.findByCodeArrondi(codeArrondi);
	}
	
	public List<Arrondissement> findByNomArrondi(String nomArrondi){
		
		return this.repo.findByNomArrondi(nomArrondi);
	}
	
	public List<Arrondissement> findByNumTelArrondi(String numTelArrondi){
		
		return this.repo.findByNumTelArrondi(numTelArrondi);
	}
	
	public List<Arrondissement> findByAdresseArrondi(String adresseArrondi){
		
		return this.repo.findByAdresseArrondi(adresseArrondi);
	}
	
	public List<Arrondissement> findByCommune(Commune commune){
		
		return this.repo.findByCommune(commune);
	}
	
}
