package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LigneEcriture;
import com.sil.gpc.repositories.LigneEcritureRepository;

@Service
public class LigneEcritureService {

	private final LigneEcritureRepository repo;

	public LigneEcritureService(LigneEcritureRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<LigneEcriture> getAll(){
		return repo.findAll();
	}
	
	public LigneEcriture getById(Long id) {
		return repo.findById(id).get();
	}
	
	public LigneEcriture add(LigneEcriture ligneEcriture) {
		return repo.save(ligneEcriture);
	}
	
	public LigneEcriture edit(Long id, LigneEcriture ligneEcriture) {
		
		if(repo.existsById(id)) {
			LigneEcriture entiter = repo.getOne(id);
			
			entiter.setCompte(ligneEcriture.getCompte());
			entiter.setCredit(ligneEcriture.getCredit());
			entiter.setDebit(ligneEcriture.getDebit());
			entiter.setEcriture(ligneEcriture.getEcriture());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
}
