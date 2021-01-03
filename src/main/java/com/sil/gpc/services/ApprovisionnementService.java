package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.repositories.ApprovisionementRepository;

@Service
public class ApprovisionnementService {

	private final ApprovisionementRepository repo;

	public ApprovisionnementService(ApprovisionementRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Approvisionnement save(Approvisionnement approvisionnement) {
		
		return this.repo.save(approvisionnement);
	}
	
	public Approvisionnement edit(String id, Approvisionnement approvisionnement) {
		
		Approvisionnement entiter = this.repo.getOne(id); 
		if(entiter != null) {
			entiter.setDateAppro(approvisionnement.getDateAppro());
			entiter.setDescriptionAppro(approvisionnement.getDescriptionAppro());
			entiter.setExercice(approvisionnement.getExercice());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public void delete(String id) {
		
		Approvisionnement entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
	}
	
	public Optional<Approvisionnement> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Approvisionnement> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Approvisionnement> findByNumAppro(String numAppro){
		
		return this.repo.findByNumAppro(numAppro);
	}
	
	public List<Approvisionnement> findByDateAppro(Date dateAppro){
		
		return this.repo.findByDateAppro(dateAppro);
	}
	
	public List<Approvisionnement> findByDescriptionAppro(String descriptionAppro){
		
		return this.repo.findByDescriptionAppro(descriptionAppro);
	}
	
	public List<Approvisionnement> findByExercice(Exercice exercice){
		
		return this.repo.findByExercice(exercice);
	}
	
}
