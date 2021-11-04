package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.AffectComptToCaisse;
import com.sil.gpc.repositories.AffectComptToCaisseRepository;

@Service
public class AffectComptToCaisseService {

	private final AffectComptToCaisseRepository repo;

	public AffectComptToCaisseService(AffectComptToCaisseRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<AffectComptToCaisse> getAll(){
		return repo.findAll();
	}
	
	public AffectComptToCaisse getById(Long id) {
		return repo.findById(id).get();
	}
	
	public AffectComptToCaisse add(AffectComptToCaisse compte) {
		return repo.save(compte);
	}
	
	public AffectComptToCaisse edit(Long id, AffectComptToCaisse affectComptToCaisse) {
		
		if(repo.existsById(id)) {
			AffectComptToCaisse entiter = repo.getOne(id);
			
			entiter.setCaisse(affectComptToCaisse.getCaisse());
			entiter.setCompte(affectComptToCaisse.getCompte());
			entiter.setDatDebAffComptCai(affectComptToCaisse.getDatDebAffComptCai());
			entiter.setDatFinAffComptCai(affectComptToCaisse.getDatFinAffComptCai());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
	
}
