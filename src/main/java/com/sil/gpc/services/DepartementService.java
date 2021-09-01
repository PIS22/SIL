package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Departement;
import com.sil.gpc.domains.Pays;
import com.sil.gpc.repositories.DepartementRepository;

@Service
public class DepartementService {

	private final DepartementRepository repo;

	public DepartementService(DepartementRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Departement save(Departement departement) {
		if(repo.existsById(departement.getCodeDepartement())) {
		return this.repo.save(departement);
	}
	return null;
	}
	
	public Departement edit(String id, Departement departement) {
		
		Departement entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setNomDepartement(departement.getNomDepartement());
			entiter.setPays(departement.getPays());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public Optional<Departement> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Departement> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Departement> findByCodeDepartement(String codeDepartement){
		
		return this.repo.findByCodeDepartement(codeDepartement);
	}
	
	public List<Departement> findByNomDepartement(String nomDepartement){
		
		return this.repo.findByNomDepartement(nomDepartement);
	}
	
	public List<Departement> findByPays(Pays pays){
		
		return this.repo.findByPays(pays);
	}
	
}
