package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LigneRecollement;
import com.sil.gpc.repositories.LigneRecollementRepository;

@Service
public class LigneRecollementService {

	private final LigneRecollementRepository repos;

	/**
	 * @param repos
	 */
	public LigneRecollementService(LigneRecollementRepository lrr) {
		this.repos = lrr;
	}

	public Optional<LigneRecollement> FindById(Long id) {
		return repos.findById(id);
	}

	public List<LigneRecollement> findAll() {
		return repos.findAll();
	}

	public List<LigneRecollement> findByArtice(Article article) {
		return repos.findByArticle(article);
	}

	public List<LigneRecollement> findByQte(double qte) {
		return repos.findByQuantiteLigneRecollement(qte);
	}

	public List<LigneRecollement> findByPrix(double prix) {
		return repos.findByPULigneRecollement(prix);
	}

	public LigneRecollement save(LigneRecollement ligne){
		return repos.save(ligne);
	}

	public LigneRecollement edit(LigneRecollement ligne, Long id) {
		LigneRecollement cible=repos.getOne(id);
		if(cible!=null) {
		cible.setArticle(ligne.getArticle());
		cible.setObservationLigneRecollement(ligne.getObservationLigneRecollement());
		cible.setPULigneRecollement(ligne.getPULigneRecollement());
		cible.setQuantiteLigneRecollement(ligne.getQuantiteLigneRecollement());
		return repos.save(cible);
		}else
			return null;
	}

	public boolean delete(Long id) {
		repos.deleteById(id);
		return repos.existsById(id);
	}

}
