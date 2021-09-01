package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Affecter;
import com.sil.gpc.domains.Caisse;
import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.repositories.AffecterRepository;

@Service
public class AffecterService {

	private final AffecterRepository repos;

	public AffecterService(AffecterRepository repos) {
		super();
		this.repos = repos;
	}
	
	public Affecter save(Affecter affecter) {

		return this.repos.save(affecter);
	}
	
	public Affecter edit(Long id, Affecter affecter) {
		Affecter entiter = this.repos.getOne(id);
		
		if(entiter != null) {
			entiter.setUtilisateur(affecter.getUtilisateur());
			entiter.setCaisse(affecter.getCaisse());
			entiter.setDateDebAffecter(affecter.getDateDebAffecter());
			entiter.setDateFinAffecter(affecter.getDateFinAffecter());
			
			return this.repos.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		Affecter entiter = this.repos.getOne(id);
		if(entiter != null) {
			this.repos.deleteById(id);
		}
		return !this.repos.existsById(id);
	}
	
	public Optional<Affecter> getByid(Long id){
		
		return this.repos.findById(id);
	}
	
	public List<Affecter> getAll(){
		return this.repos.findAll();
	}
	
	public List<Affecter> findByUtilisateur(Utilisateur utilisateur){
		return this.repos.findByUtilisateur(utilisateur);
	}
	
	public List<Affecter> findByCaisse(Caisse caisse){
		return this.repos.findByCaisse(caisse);
	}
	
	public List<Affecter> findByDateDebAffecter(Date date){
		return this.repos.findByDateDebAffecter(date);
	}
	
	public List<Affecter> findByDateFinAffecter(Date date){
		return this.repos.findByDateFinAffecter(date);
	}
}
