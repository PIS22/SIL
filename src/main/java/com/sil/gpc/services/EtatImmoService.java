package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.EtatImmo;
import com.sil.gpc.repositories.EtatImmoRepository;

@Service
public class EtatImmoService {
	
	private final EtatImmoRepository repo;

	public EtatImmoService(EtatImmoRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<EtatImmo> getAll(){
		return repo.findAll();
	}
	
	public EtatImmo getById(Long id) {
		return repo.findById(id).get();
	}
	
	public EtatImmo add(EtatImmo etatImmo) {
		return repo.save(etatImmo);
	}
	
	public EtatImmo edit(Long id, EtatImmo etatImmo) {
		
		if(repo.existsById(id)) {
			EtatImmo entiter = repo.getOne(id);

			entiter.setCodeEtatImo(etatImmo.getCodeEtatImo());
			entiter.setLibEtatImo(etatImmo.getLibEtatImo());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
}
