package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Associer;
import com.sil.gpc.repositories.AssocierRepository;

@Service
public class AssocierService {

	private final AssocierRepository repo;

	public AssocierService(AssocierRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Associer> getAll(){
		return repo.findAll();
	}
	
	public Associer getById(Long id) {
		return repo.findById(id).get();
	}
	
	public Associer add(Associer associer) {
		return repo.save(associer);
	}
	
	public Associer edit(Long id, Associer associer) {
		
		if(repo.existsById(id)) {
			Associer entiter = repo.getOne(id);
			
			entiter.setDebComArt(associer.getDebComArt());
			entiter.setFinComArt(associer.getFinComArt());
			entiter.setArticle(associer.getArticle());
			entiter.setCompte(associer.getCompte());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
}
