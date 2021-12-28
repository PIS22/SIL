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
		if(!repo.existsById(immeuble.getCodeIm())) {
			return this.repo.save(immeuble);
		}
		return null;
	}
	
	public List<Immeuble> saveAll(List<Immeuble> immeubles) {
		
			return this.repo.saveAll(immeubles);
		
	}
	
	public Immeuble edit(String id, Immeuble immeuble) {
		
		Immeuble entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setArrondissement(immeuble.getArrondissement());
			entiter.setAutre(immeuble.getAutre());
			entiter.setEtatIm(immeuble.isEtatIm());
			entiter.setLocalisationIm(immeuble.getLocalisationIm());
			entiter.setQuartier(immeuble.getQuartier());
			entiter.setTypeImmeuble(immeuble.getTypeImmeuble());
			entiter.setLibIm(immeuble.getLibIm());
			entiter.setSiteMarcher(immeuble.getSiteMarcher());
			entiter.setStuctResp(immeuble.getStuctResp());
			entiter.setSuperficie(immeuble.getSuperficie());
			entiter.setActiviter(immeuble.getActiviter());
			entiter.setBatie(immeuble.isBatie());
			entiter.setDimensions(immeuble.getDimensions());
			entiter.setForme(immeuble.getForme());
			entiter.setIlot(immeuble.getIlot());
			entiter.setNbrFace(immeuble.getNbrFace());
			entiter.setNbrPlace(immeuble.getNbrPlace());
			entiter.setParcelle(immeuble.getParcelle());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete (String id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
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
