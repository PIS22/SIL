package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Ecriture;
import com.sil.gpc.repositories.EcritureRepository;

@Service
public class EcritureService {

	private final EcritureRepository repo;

	public EcritureService(EcritureRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Ecriture> getAll(){
		return repo.findAll();
	}
	
	public Ecriture getById(String id) {
		return repo.findById(id).get();
	}
	
	public Ecriture add(Ecriture ecriture) {
		return repo.save(ecriture);
	}
	
	public Ecriture edit(String id, Ecriture ecriture) {
		
		if(repo.existsById(id)) {
			Ecriture entiter = repo.getOne(id);
			
			entiter.setDatEcri(ecriture.getDatEcri());
			entiter.setDescipt(ecriture.getDescipt());
			entiter.setExo(ecriture.getExo());
			entiter.setJournal(ecriture.getJournal());
			entiter.setRefExtern(ecriture.getRefExtern());
			entiter.setRefIntern(ecriture.getRefIntern());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (String id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
	
}
