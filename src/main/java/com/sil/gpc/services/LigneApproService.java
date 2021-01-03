package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LigneDemandeAppro;
import com.sil.gpc.repositories.LigneApproRepository;

@Service
public class LigneApproService {

	private final LigneApproRepository repo;

	public LigneApproService(LigneApproRepository repo) {
		super();
		this.repo = repo;
	}
	
	public LigneAppro save (LigneAppro ligneAppro) {
		
		return this.repo.save(ligneAppro);
	}
	
	public LigneAppro edit(Long id, LigneAppro ligneAppro) {
		
		LigneAppro entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setPULigneAppro(ligneAppro.getPULigneAppro());
			entiter.setQuantiteLigneAppro(ligneAppro.getQuantiteLigneAppro());
			entiter.setAppro(ligneAppro.getAppro());
			entiter.setLigneDA(ligneAppro.getLigneDA());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public void delete(Long id) {
		
		if(this.repo.existsById(id))
			this.repo.deleteById(id);
	}
	
	public Optional<LigneAppro> getById(Long id){
		
		return this.repo.findById(id);
	}
	
	public List<LigneAppro> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<LigneAppro> findByIdLigneAppro(Long idLigneAppro){
		
		return this.repo.findByIdLigneAppro(idLigneAppro);
	}
	
	public List<LigneAppro> findByPULigneAppro(Long pULigneAppro){
		
		return this.repo.findByPULigneAppro(pULigneAppro);
	}
	
	public List<LigneAppro> findByQuantiteLigneAppro(Long quantiteLigneAppro){
		
		return this.repo.findByQuantiteLigneAppro(quantiteLigneAppro);
	}
	
	public List<LigneAppro> findByAppro(Approvisionnement approvisionnement){
		
		return this.repo.findByAppro(approvisionnement);
	}
	
	public List<LigneAppro> findByLigneDA(LigneDemandeAppro ligneDemandeAppro){
		
		return this.repo.findByLigneDA(ligneDemandeAppro);
	}
	
}
