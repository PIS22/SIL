package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Activite;
import com.sil.gpc.repositories.ActiviteRepository;

@Service
public class ActiviteService {

	private final ActiviteRepository repo;

	public ActiviteService(ActiviteRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<Activite> getAll(){
		return repo.findAll();
	}
	
	public Activite getById(Long id) {
		return repo.findById(id).get();
	}
	
	public Activite add(Activite activite) {
		return repo.save(activite);
	}
	
	public Activite edit(Long id, Activite activite) {
		
		if(repo.existsById(id)) {
			Activite entiter = repo.getOne(id);
			
			entiter.setCodeAct(activite.getCodeAct());
			entiter.setLibAct(activite.getLibAct());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
	
}
