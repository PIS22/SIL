package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.DemandeApprovisionnement;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.repositories.DemandeApproRepository;

@Service
public class DemandeApproService {

	private final DemandeApproRepository repo;

	public DemandeApproService(DemandeApproRepository repo) {
		super();
		this.repo = repo;
	}
	
	public DemandeApprovisionnement save(DemandeApprovisionnement demandeApprovisionnement) {
		
		return this.repo.save(demandeApprovisionnement);
	}
	
	public DemandeApprovisionnement edit(String id, DemandeApprovisionnement demandeApprovisionnement) {
		
		DemandeApprovisionnement entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateDA(demandeApprovisionnement.getDateDA());
			entiter.setExercice(demandeApprovisionnement.getExercice());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public void delete(String id) {
		
		if(this.repo.existsById(id))
			this.repo.deleteById(id);
	}
	
	public Optional<DemandeApprovisionnement> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<DemandeApprovisionnement> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<DemandeApprovisionnement> findByNumDA(String numDA){
		
		return this.repo.findByNumDA(numDA);
	}
	
	public List<DemandeApprovisionnement> findByDateDA(Date dateDA){
		
		return this.repo.findByDateDA(dateDA);
	}
	
	public List<DemandeApprovisionnement> findByExercice(Exercice exercice){
		
		return this.repo.findByExercice(exercice);
	}
	
}
