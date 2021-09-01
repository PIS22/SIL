package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Gerer;
import com.sil.gpc.domains.Magasin;
import com.sil.gpc.domains.Magasinier;
import com.sil.gpc.repositories.GererRepository;

@Service
public class GererService {

	private final GererRepository repo;

	public GererService(GererRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Gerer save(Gerer gerer) {
		
		return this.repo.save(gerer);
	}
	
	public Gerer edit(Long id, Gerer gerer) {
		
		Gerer entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateDebGerer(gerer.getDateDebGerer());
			entiter.setDateFinGerer(gerer.getDateFinGerer());
			entiter.setMagasin(gerer.getMagasin());
			entiter.setMagasinier(gerer.getMagasinier());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete (Long id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public Optional<Gerer> getById(Long id){
		
		return this.repo.findById(id);
	}
	
	public List<Gerer> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Gerer> findByIdGerer(Long idGerer){
		
		return this.repo.findByIdGerer(idGerer);
	}
	
	public List<Gerer> findByDateDebGerer(Date dateDebGerer){
		
		return this.repo.findByDateDebGerer(dateDebGerer);
	}
	
	public List<Gerer> findByDateFinGerer(Date dateFinGerer){
		
		return this.repo.findByDateFinGerer(dateFinGerer);
	}
	
	public List<Gerer> findByMagasinier(Magasinier magasinier){
		
		return this.repo.findByMagasinier(magasinier);
	}
	
	public List<Gerer> findByMagasin(Magasin magasin){
		
		return this.repo.findByMagasin(magasin);
	}
	
}
