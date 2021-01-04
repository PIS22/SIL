package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.PlageNumArticle;
import com.sil.gpc.repositories.PlageNumArticleRepository;

public class PlageNumArticleService {

	private final PlageNumArticleRepository repos;

	/**
	 * @param repos
	 */
	public PlageNumArticleService(PlageNumArticleRepository npar) {
		this.repos = npar;
	}
	
	public List<PlageNumArticle> findAll(){
		return repos.findAll();
	}
	
	public List<PlageNumArticle> findByArticle(Article article){
		return repos.findByArticle(article);
	}
	
	public List<PlageNumArticle> findByAppro(Long numAppro){
		return repos.findByLigneAppro(numAppro);
	}
	
	public List<PlageNumArticle> findByPlacement(Long numPlace){
		return repos.findByLignePlacement(numPlace);
	}
	
	public List<PlageNumArticle> findByRecollement(Long numRecol){
		return repos.findByLigneRecollement(numRecol);
	}
	
	public List<PlageNumArticle> findByNumDebut(String numDeb){
		return repos.findByNumDebPlage(numDeb);
	}
	
	public List<PlageNumArticle> findByNumFin(String numFin){
		return repos.findByNumFinPlage(numFin);
	}
	
	public Optional<PlageNumArticle> recherchePlage(Long id){
		return repos.findById(id);
	}
	
	public PlageNumArticle save(PlageNumArticle p){
		return repos.save(p);
	}
	
	public List<PlageNumArticle> edit(PlageNumArticle plage, Long id){
		PlageNumArticle pla=repos.getOne(id);
		pla.setNumDebPlage(plage.getNumDebPlage());
		pla.setNumFinPlage(plage.getNumFinPlage());
		pla.setLigneAppro(plage.getLigneAppro());
		pla.setLignePlacement(plage.getLignePlacement());
		pla.setLigneRecollement(plage.getLigneRecollement());
		return repos.findAll();
	}
	
	public boolean delete(Long id){
		repos.deleteById(id);
		return repos.existsById(id);
	}
}
