package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.NatureJournal;
import com.sil.gpc.repositories.NatureJournalRepository;

@Service
public class NatureJournalService {

	private final NatureJournalRepository repo;

	public NatureJournalService(NatureJournalRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<NatureJournal> getAll(){
		return repo.findAll();
	}
	
	public NatureJournal getById(Long id) {
		return repo.findById(id).get();
	}
	
	public NatureJournal add(NatureJournal natureJournal) {
		return repo.save(natureJournal);
	}
	
	public NatureJournal edit(Long id, NatureJournal natureJournal) {
		
		if(repo.existsById(id)) {
			NatureJournal entiter = repo.getOne(id);
			
			entiter.setCodNat(natureJournal.getCodNat());
			entiter.setLibNat(natureJournal.getLibNat());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
	
}
