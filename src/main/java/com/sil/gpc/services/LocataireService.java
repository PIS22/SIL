package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Locataire;
import com.sil.gpc.repositories.LocataireRepository;

@Service
public class LocataireService {
	private final LocataireRepository locr;

	/**
	 * @param lr
	 */
	public LocataireService(LocataireRepository lr) {
		this.locr = lr;
	}
	
	public Locataire ajouteLocataire(Locataire loc){
		return locr.save(loc);
	}
	
	public Locataire modifieLocataire(Locataire loc, Long id){
		Locataire lo=locr.getOne(id);
		lo.setIdentiteLocataire(loc.getIdentiteLocataire());
		lo.setAdresseLocataire(loc.getAdresseLocataire());
		lo.setIfuLocataire(loc.getIfuLocataire());
		lo.setPersonneAContacter(loc.getPersonneAContacter());
		lo.setTelLocataire(loc.getTelLocataire());
		return locr.save(lo);
	}
	
	public List<Locataire> supprimeLocataire(Long id){
		locr.deleteById(id);
		return locr.findAll();
	}
	
	public Locataire rechercheLocataire(Long id) {
		return locr.getOne(id);
	}

}
