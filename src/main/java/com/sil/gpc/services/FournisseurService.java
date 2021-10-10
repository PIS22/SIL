package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Fournisseur;
import com.sil.gpc.repositories.FournisseurRepository;

@Service
public class FournisseurService {

	private final FournisseurRepository repo;

	public FournisseurService(FournisseurRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Fournisseur save(Fournisseur fournisseur) {
		if(!repo.existsById(fournisseur.getCodeFrs())) {
			return this.repo.save(fournisseur);
		}
		return null;
	}
	
	public Fournisseur edit(String id, Fournisseur fournisseur) {
		
		Fournisseur entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setAdresseFrs(fournisseur.getAdresseFrs());
			entiter.setDescription(fournisseur.getDescription());
			entiter.setIdentiteFrs(fournisseur.getIdentiteFrs());
			entiter.setNumIfuFrs(fournisseur.getNumIfuFrs());
			entiter.setRaisonSociale(fournisseur.getRaisonSociale());
			entiter.setTelFRS(fournisseur.getTelFRS());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete (String id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public Optional<Fournisseur> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Fournisseur> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Fournisseur> findByCodeFrs(String codeFrs){
		
		return this.repo.findByCodeFrs(codeFrs);
	}
	
	public List<Fournisseur> findByAdresseFrs(String adresseFrs){
		
		return this.repo.findByAdresseFrs(adresseFrs);
	}
	
	public List<Fournisseur> findByDescription(String description){
		
		return this.repo.findByDescription(description);
	}
	
	public List<Fournisseur> findByIdentiteFrs(String identiteFrs){
		
		return this.repo.findByIdentiteFrs(identiteFrs);
	}
	
	public List<Fournisseur> findByNumIfuFrs(String numIfuFrs){
		
		return this.repo.findByNumIfuFrs(numIfuFrs);
	}
	
	public List<Fournisseur> findByRaisonSociale(String raisonSociale){
		
		return this.repo.findByRaisonSociale(raisonSociale);
	}
	
	public List<Fournisseur> findByTelFRS(String telFRS){
		
		return this.repo.findByTelFRS(telFRS);
	}
	
}
