package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Compte;
import com.sil.gpc.repositories.CompteRepository;

@Service
public class CompteService {

	private final CompteRepository repo;

	public CompteService(CompteRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Compte> getAll(){
		return repo.findAll();
	}
	
	public Compte getById(Long id) {
		return repo.findById(id).get();
	}
	
	public Compte add(Compte compte) {
		return repo.save(compte);
	}
	
	public Compte edit(Long id, Compte compte) {
		
		if(repo.existsById(id)) {
			Compte entiter = repo.getOne(id);
			
			entiter.setLibCpte(compte.getLibCpte());
			entiter.setCollectif(compte.getCollectif());
			entiter.setNumCpte(compte.getNumCpte());
			
			return repo.save(compte);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
}
