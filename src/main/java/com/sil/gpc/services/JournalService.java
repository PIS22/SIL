package com.sil.gpc.services;

import java.util.ArrayList;
import java.util.List;

import com.sil.gpc.domains.Compte;
import com.sil.gpc.repositories.CompteRepository;
import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Journal;
import com.sil.gpc.repositories.JournalRepository;

@Service
public class JournalService {
	private final CompteRepository repoC;

	private final JournalRepository repo;

	public JournalService(CompteRepository repoC, JournalRepository repo) {
		this.repoC = repoC;
		this.repo = repo;
	}

	public List<Compte> getEligible(Long id){

		List<Compte> eligible=new ArrayList<>();
		for (Compte c:repo.getOne(id).getCompteAutorises()){
			eligible.addAll(repo.eligible(c.getNumCpte().concat("%")));
		}
		return eligible;
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
