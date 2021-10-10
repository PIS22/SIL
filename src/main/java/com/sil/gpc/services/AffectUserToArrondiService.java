package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.AffectUserToArrondi;
import com.sil.gpc.repositories.AffectUserToArrondiRepository;

@Service
public class AffectUserToArrondiService {
	
	private final AffectUserToArrondiRepository repo;
	
	public AffectUserToArrondiService(AffectUserToArrondiRepository repo) {
		this.repo = repo;
	}

	public AffectUserToArrondi save(AffectUserToArrondi affect) {
		return repo.save(affect);
	}

	public AffectUserToArrondi edit(Long id, AffectUserToArrondi affect) {
		AffectUserToArrondi cib=repo.findById(id).get();
		if(cib!=null) {
			cib.setDateDebutAffectToArrondi(affect.getDateDebutAffectToArrondi());
			cib.setDateFinAffectToArrondi(affect.getDateFinAffectToArrondi());
			cib.setArrondissement(affect.getArrondissement());
			cib.setUtilisateur(affect.getUtilisateur());
			return repo.save(cib);
		}
		return null;
	}
	
	public boolean delete(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return !repo.existsById(id);
		}
		else
			return false;
	}

	public List<AffectUserToArrondi> getAll() {
		return repo.findAll();
	}

	public AffectUserToArrondi findAnAffect(Long id) {
		return repo.findById(id).get();
	}

}
