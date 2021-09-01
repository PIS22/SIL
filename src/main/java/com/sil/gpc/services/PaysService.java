package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Pays;
import com.sil.gpc.repositories.PaysRepository;

@Service
public class PaysService {
	private final PaysRepository repos;

	/**
	 * @param repos
	 */
	public PaysService(PaysRepository paysr) {
		this.repos = paysr;
	}
	
	public List<Pays> findByAll(){
		return repos.findAll();
	}
	
	public Optional<Pays> findById(String cp){
		return repos.findById(cp);
	}
	
	public List<Pays> findByCode(String cp){
		return repos.findByCodePays(cp);
	}
	
	public List<Pays> findByNomComplet(String nom){
		return repos.findByNomCompletPays(nom);
	}
	
	public List<Pays> findByNom(String nom){
		return repos.findByNomPays(nom);
	}
	
	public Pays save(Pays p){
		if(!repos.existsById(p.getCodePays()))
				return repos.save(p);
		return null;
	}

	public Pays modifiePays(Pays p, String cp){
		Pays pays=repos.getOne(cp);
		pays.setCodePays(p.getCodePays());
		pays.setNomCompletPays(p.getNomCompletPays());
		pays.setNomPays(p.getNomPays());
		return repos.save(pays);
	}
	
	public boolean supprimePays(String cp){
		repos.deleteById(cp);
		return repos.existsById(cp);
	}
}
