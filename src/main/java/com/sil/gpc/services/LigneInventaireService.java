package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LigneInventaire;
import com.sil.gpc.repositories.LigneInventaireRepository;

@Service
public class LigneInventaireService {

	private final LigneInventaireRepository repos;


	public LigneInventaireService(LigneInventaireRepository repos) {
		super();
		this.repos = repos;
	}

	public Optional<LigneInventaire> findById(Long num){
		return repos.findById(num);
	}
	
	public List<LigneInventaire> findAll(){
		return repos.findAll();
	}
	
	public LigneInventaire edit(LigneInventaire lInv, Long num){
		LigneInventaire opc=repos.findById(num).get();
		if (opc!=null) {
			opc.setArticle(lInv.getArticle());
			opc.setInventaire(lInv.getInventaire());
			opc.setObservation(lInv.getObservation());
			opc.setPu(lInv.getPu());
			opc.setStockreel(lInv.getStockreel());
			opc.setStockTheoriq(lInv.getStockTheoriq());
			return repos.save(opc);
		}else
			return null;
	}

	public LigneInventaire save(LigneInventaire inv){ 
		return repos.save(inv);
	}

	public boolean delete(Long num){
		repos.deleteById(num);
		return !repos.existsById(num);
	}
	
}
