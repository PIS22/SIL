package com.sil.gpc.services;

import java.util.List;

import com.sil.gpc.domains.PlageNumArticle;
import com.sil.gpc.repositories.PlageNumArticleRepository;

public class PlageNumArticleService {

	private final PlageNumArticleRepository par;

	/**
	 * @param npar
	 */
	public PlageNumArticleService(PlageNumArticleRepository npar) {
		this.par = npar;
	}
	
	public PlageNumArticle ajoutePlage(PlageNumArticle p){
		return par.save(p);
	}
	
	public List<PlageNumArticle> modifiePlage(PlageNumArticle plage, Long id){
		PlageNumArticle pla=par.getOne(id);
		pla.setNumDebPlage(plage.getNumDebPlage());
		pla.setNumFinPlage(plage.getNumFinPlage());
		pla.setLigneAppro(plage.getLigneAppro());
		pla.setLignePlacement(plage.getLignePlacement());
		pla.setLigneRecollement(plage.getLigneRecollement());
		return par.findAll();
	}
	
	public PlageNumArticle recherchePlage(Long id){
		return par.getOne(id);
	}
	
	public List<PlageNumArticle> supprimePlage(Long id){
		return par.findAll();
	}
}
