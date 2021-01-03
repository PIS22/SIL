package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.PlageNumDispo;
import com.sil.gpc.repositories.PlageNumDispoRepository;

@Service
public class PlageNumDispoService {

	private final PlageNumDispoRepository pdr;

	/**
	 * @param plager
	 */
	public PlageNumDispoService(PlageNumDispoRepository plager) {
		this.pdr = plager;
	}
	
	public PlageNumDispo ajoutePlageDispo(PlageNumDispo pd){
		return pdr.save(pd);
	}
	
	public PlageNumDispo modifiePlageDispo(PlageNumDispo pd, String codeplage){
		PlageNumDispo pnd=pdr.getOne(codeplage);
		pnd.setAnnee(pd.getAnnee());pnd.setArticle(pd.getArticle());
		pnd.setNumDebPlage(pd.getNumDebPlage());
		pnd.setNumDebPlageDispo(pd.getNumDebPlageDispo());
		pnd.setNumFinPlage(pd.getNumFinPlage());
		pnd.setNumFinPlageDispo(pd.getNumFinPlageDispo());
		return pdr.save(pnd);
	}
	
	public PlageNumDispo recherchePlageDispo(String cp){
		return pdr.getOne(cp);
	}
	
	public List<PlageNumDispo> supprimePlageDispo(String cp){
		pdr.deleteById(cp);
		return pdr.findAll();
	}
}
