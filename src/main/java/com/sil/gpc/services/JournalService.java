package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Journal;
import com.sil.gpc.repositories.JournalRepository;

@Service
public class JournalService {

	private final JournalRepository repo;

	public JournalService(JournalRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Journal> getAll(){
		return repo.findAll();
	}
	
	public Journal getById(Long id) {
		return repo.findById(id).get();
	}
	
	public Journal add(Journal journal) {
		return repo.save(journal);
	}
	
	public Journal edit(Long id, Journal journal) {
		
		if(repo.existsById(id)) {
			Journal entiter = repo.getOne(id);
			
			entiter.setCodJrn(journal.getCodJrn());
			entiter.setLibJrn(journal.getLibJrn());
			entiter.setNatJrn(journal.getNatJrn());
			entiter.setAutoContrepart(journal.getAutoContrepart());
			entiter.setCompteAutorises(journal.getCompteAutorises());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
}
