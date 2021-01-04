package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Locataire;
import com.sil.gpc.repositories.LocataireRepository;

@Service
public class LocataireService {
	private final LocataireRepository repos;

	/**
	 * @param repos
	 */
	public LocataireService(LocataireRepository lr) {
		this.repos = lr;
	}
	
	public Locataire save(Locataire loc){
		return repos.save(loc);
	}
	
	public Locataire edit(Locataire loc, Long id){
		Locataire cible=repos.getOne(id);
		if(cible!=null) {
		cible.setIdentiteLocataire(loc.getIdentiteLocataire());
		cible.setAdresseLocataire(loc.getAdresseLocataire());
		cible.setIfuLocataire(loc.getIfuLocataire());
		cible.setPersonneAContacter(loc.getPersonneAContacter());
		cible.setTelLocataire(loc.getTelLocataire());
		return repos.save(cible);
		}else
			return null;
	}
	
	public boolean delete(Long id){
		repos.deleteById(id);
		return repos.existsById(id);
	}
	
	public Optional<Locataire> findById(Long id) {
		return repos.findById(id);
	}
	
	public List<Locataire> findByAdresse(String adresse) {
		return repos.findByAdresseLocataire(adresse);
	}
	
	public List<Locataire> findByidentite(String identite) {
		return repos.findByIdentiteLocataire(identite);
	}
	
	public List<Locataire> findByIfu(String ifu) {
		return repos.findByIfuLocataire(ifu);
	}
	
	public List<Locataire> findByPersonne(String personne) {
		return repos.findByPersonneAContacter(personne);
	}
	
	public List<Locataire> findByTelephone(String tel) {
		return repos.findByTelLocataire(tel);
	}

}
