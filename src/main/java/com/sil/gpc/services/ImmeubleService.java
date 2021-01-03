package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Immeuble;
import com.sil.gpc.domains.TypeImmeuble;
import com.sil.gpc.domains.Quartier;
import com.sil.gpc.repositories.ImmeubleRepository;

@Service
public class ImmeubleService {

	private final ImmeubleRepository repo;

	public ImmeubleService(ImmeubleRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Immeuble save(Immeuble immeuble) {
		
		return this.repo.save(immeuble);
	}
	
	public Immeuble edit(String id, Immeuble immeuble) {
		
		Immeuble entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setEtatIm(immeuble.isEtatIm());
			entiter.setLocalisationIm(immeuble.getLocalisationIm());
			entiter.setQuartier(immeuble.getQuartier());
			entiter.setTypeImmeuble(immeuble.getTypeImmeuble());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public void delete (String id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
	}
	
	public Optional<Immeuble> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Immeuble> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Immeuble> findByCodeIm(String codeIm){
		
		return this.repo.findByCodeIm(codeIm);
	}
	
	public List<Immeuble> findByLocalisationIm(String localisationIm){
		
		return this.repo.findByLocalisationIm(localisationIm);
	}
	
	public List<Immeuble> findByQuartier(Quartier quartier){
		
		return this.repo.findByQuartier(quartier);
	}
	
	public List<Immeuble> findByTypeImmeuble(TypeImmeuble typeImmeuble){
		
		return this.repo.findByTypeImmeuble(typeImmeuble);
	}
	
	public List<Immeuble> findByEtatIm(boolean etatIm){
		
		return this.repo.findByEtatIm(etatIm);
	}
	
}
