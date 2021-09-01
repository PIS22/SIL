package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Exercice;
import com.sil.gpc.repositories.ExerciceRepository;

@Service
public class ExerciceService {

	private final ExerciceRepository repo;

	public ExerciceService(ExerciceRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Exercice save (Exercice exercice) {
		if(!repo.existsById(exercice.getCodeExercice())) {
		return this.repo.save(exercice);
		}
		return null;
	}
	
	public Exercice edit (String id, Exercice exercice) {
		
		Exercice entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateDebut(exercice.getDateDebut());
			entiter.setDateFin(exercice.getDateFin());
			entiter.setEtatExo(exercice.getEtatExo());
			entiter.setExoSelectionner(exercice.isExoSelectionner());
			entiter.setLibExercice(exercice.getLibExercice());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public Optional<Exercice> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Exercice> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Exercice> findByCodeExercice(String codeExercice){
		
		return this.findByCodeExercice(codeExercice);
	}
	
	public List<Exercice> findByDateDebut(Date dateDebut){
		
		return this.findByDateDebut(dateDebut);
	}
	
	public List<Exercice> findByDateFin(Date dateFin){
		
		return this.findByDateFin(dateFin);
	}
	
	public List<Exercice> findByEtatExo(String etatExo){
		
		return this.findByEtatExo(etatExo);
	}
	
	public List<Exercice> findByLibExercice(String libExercice){
		
		return this.findByLibExercice(libExercice);
	}
	
	public List<Exercice> findByExoSelectionner(boolean exoSelectionner){
		
		return this.findByExoSelectionner(exoSelectionner);
	}
	
}
