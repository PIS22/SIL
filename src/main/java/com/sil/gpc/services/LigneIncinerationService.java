package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LigneIncineration;
import com.sil.gpc.repositories.LigneIncinerationRepository;
@Service
public class LigneIncinerationService {
	private final LigneIncinerationRepository repos;

	public LigneIncinerationService(LigneIncinerationRepository repos) {
		super();
		this.repos = repos;
	}
	
	public LigneIncineration save(LigneIncineration lin) {
		return repos.save(lin);
	}
	
	public LigneIncineration edit(Long cod, LigneIncineration lin) {
		LigneIncineration cib = repos.findById(cod).get();
		if(cib != null) {
			cib.setArticle(lin.getArticle());
			cib.setIncineration(lin.getIncineration());
			cib.setObsLigneIncine(lin.getObsLigneIncine());
			cib.setPULigneIncine(lin.getPULigneIncine());
			cib.setQuantiteLigneIncine(lin.getQuantiteLigneIncine());
			return repos.save(cib);
		}
		return null;
	}
	
	public LigneIncineration getById(Long cod) {
		return repos.findById(cod).get();
	}
	
	public List<LigneIncineration> getAll(){
		return repos.findAll();
	}
	
	public boolean delete(Long cod) {
		if(repos.existsById(cod)) {
			repos.deleteById(cod);
			return !repos.existsById(cod);
		}
		else
			return false;
	}
}
