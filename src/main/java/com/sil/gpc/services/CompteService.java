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

	public List<Compte> comptesParType(String t){
		return repo.findByTypCpte("E");
	}
	
	public Compte getById(Long id) {
		return repo.findById(id).get();
	}
	
	public Compte add(Compte compte) {
		String nc=compte.getNumCpte().concat("_");
		if (repo.enfants(nc).size()==0){
			compte.setTypCpte("E");
		}
		else{
			compte.setTypCpte("R");
		}
		Compte c= repo.save(compte);
		if (c!=null && c.getTypCpte() == "E" && c.getNumCpte().length() > 1){
			String num=c.getNumCpte().substring(0, c.getNumCpte().length()-1);
			Compte parent = repo.findByNumCpte(num);
			if(parent != null && parent.getTypCpte() != "R"){
				parent.setTypCpte("R");
				repo.save(parent);
			}
		}
		return c;
	}
	
	public Compte edit(Long id, Compte compte) {
		
		if(repo.existsById(id)) {
			Compte entiter = repo.getOne(id);
			entiter.setLibCpte(compte.getLibCpte());
			entiter.setCollectif(compte.getCollectif());
			entiter.setNumCpte(compte.getNumCpte());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
}
