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
		demandeApprovisionnement.setValideDA(true);
		Integer val = 1, nbrMaxCaract = 6;
		String code = "DA-";
		if(this.repo.findLastNumUsed(demandeApprovisionnement.getExercice().getCodeExercice()) != null) {
			val = this.repo.findLastNumUsed(demandeApprovisionnement.getExercice().getCodeExercice());
			val++;
			
		}
		
		demandeApprovisionnement.setValeur(val);
		
		code = code+demandeApprovisionnement.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		demandeApprovisionnement.setNumDA(code+val);
		
		if(repo.existsById(demandeApprovisionnement.getNumDA())==false) return this.repo.save(demandeApprovisionnement);
		
		return null;
		
	}
	
	public DemandeApprovisionnement edit(String id, DemandeApprovisionnement demandeApprovisionnement) {
		
		DemandeApprovisionnement entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateDA(demandeApprovisionnement.getDateDA());
			entiter.setExercice(demandeApprovisionnement.getExercice());
			entiter.setValideDA(demandeApprovisionnement.isValideDA());
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
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
