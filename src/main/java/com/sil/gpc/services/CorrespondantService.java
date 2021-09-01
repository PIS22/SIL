 package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Correspondant;
import com.sil.gpc.domains.Magasinier;
import com.sil.gpc.domains.TypCorres;
import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.repositories.CorrespondantRepository;

@Service
public class CorrespondantService {

	private final CorrespondantRepository repo;

	public CorrespondantService(CorrespondantRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Correspondant save(Correspondant correspondant) {
		if(!repo.existsById(correspondant.getIdCorrespondant())) {
			return this.repo.save(correspondant);
		}
		return null;
	}
	
	public Correspondant edit(String id, Correspondant correspondant) {
		
		Correspondant entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setImputableCorres(correspondant.isImputableCorres());
			entiter.setMagasinier(correspondant.getMagasinier());
			//entiter.setTypecorres(correspondant.getTypecorres());
			entiter.setUtilisateur(correspondant.getUtilisateur());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public Optional<Correspondant> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Correspondant> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Correspondant> findByIdCorrespondant(String idCorrespondant){
		
		return this.findByIdCorrespondant(idCorrespondant);
	}
	
	public List<Correspondant> findByMagasinier(Magasinier magasinier){
		
		return this.findByMagasinier(magasinier);
	}
	
	public List<Correspondant> findByTypecorres(TypCorres typecorres){
		
		return this.findByTypecorres(typecorres);
	}
	
	public List<Correspondant> findByUtilisateur(Utilisateur utilisateur){
		
		return this.findByUtilisateur(utilisateur);
	}
	
	public List<Correspondant> findByImputableCorres(boolean imputableCorres){
		
		return this.findByImputableCorres(imputableCorres);
	}
	
}
