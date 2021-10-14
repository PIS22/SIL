package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Immo;
import com.sil.gpc.repositories.ImmoRepository;

@Service
public class ImmoService {

	private final ImmoRepository repo;

	public ImmoService(ImmoRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Immo> getAll(){
		return repo.findAll();
	}
	
	public Immo getById(Long id) {
		return repo.findById(id).get();
	}
	
	public Immo add(Immo immo) {
		return repo.save(immo);
	}
	
	public Immo edit(Long id, Immo immo) {
		
		if(repo.existsById(id)) {
			Immo entiter = repo.getOne(id);
			
			entiter.setActivite(immo.getActivite());
			entiter.setDatEntree(immo.getDatEntree());
			entiter.setElement(immo.getElement());
			entiter.setEtatImmo(immo.getEtatImmo());
			entiter.setIntitule(immo.getIntitule());
			entiter.setLocalisation(immo.getLocalisation());
			entiter.setNbAnne(immo.getNbAnne());
			entiter.setNbMois(immo.getNbMois());
			entiter.setNbJrs(immo.getNbJrs());
			entiter.setService(immo.getService());
			entiter.setTypeAmort(immo.getTypeAmort());
			entiter.setValAmortissable(immo.getValAmortissable());
			entiter.setValBrute(immo.getValBrute());
			entiter.setValResid(immo.getValResid());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
	
}
