package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.PlageNumDispo;
import com.sil.gpc.repositories.PlageNumDispoRepository;

@Service
public class PlageNumDispoService {

	private final PlageNumDispoRepository repos;

	/**
	 * @param plager
	 */
	public PlageNumDispoService(PlageNumDispoRepository plager) {
		this.repos = plager;
	}
	
	public Optional<PlageNumDispo> findById(String cp){
		return repos.findById(cp);
	}
	
	public List <PlageNumDispo> findByArticle(String codArt){
		return repos.findByArticle(codArt);
	}
	
	public List<PlageNumDispo> findByNumFinDispo(String num){
		return repos.findBynumFinDispo(num);
	}
	
	public List<PlageNumDispo> findByNumDebDispo(String num){
		return repos.findByNumDebDispo(num);
	}
	
	public List<PlageNumDispo> findByNumDeb(String num){
		return repos.findByNumDeb(num);
	}
	
	public List<PlageNumDispo> findByNumFin(String num){
		return repos.findByNumFin(num);
	}
	
	public List<PlageNumDispo> findAll(){
		return repos.findAll();
	}
	
	public PlageNumDispo save(PlageNumDispo pd){
		return repos.save(pd);
	}
	
	public PlageNumDispo edit(PlageNumDispo pd, String codeplage){
		PlageNumDispo pnd=repos.getOne(codeplage);
		if(pnd!=null) {
		pnd.setAnnee(pd.getAnnee());pnd.setArticle(pd.getArticle());
		pnd.setNumDebPlage(pd.getNumDebPlage());
		pnd.setNumDebPlageDispo(pd.getNumDebPlageDispo());
		pnd.setNumFinPlage(pd.getNumFinPlage());
		pnd.setNumFinPlageDispo(pd.getNumFinPlageDispo());
		return repos.save(pnd);
		}else
			return null;
	}
	
	public boolean delete(String cp){
		repos.deleteById(cp);
		return repos.existsById(cp);
	}
}
