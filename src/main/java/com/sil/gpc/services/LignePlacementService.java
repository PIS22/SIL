package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LignePlacement;
import com.sil.gpc.repositories.LignePlacementRepository;

@Service
public class LignePlacementService {

	private final LignePlacementRepository repos;

	/**
	 * @param repos
	 */
	public LignePlacementService(LignePlacementRepository lpr) {
		this.repos = lpr;
	}


	public Optional<LignePlacement> findById(Long id) {
		return repos.findById(id);
	}

	public List<LignePlacement> findAll() {
		return repos.findAll();
	}

	public List<LignePlacement> findByArticle(Article art) {
		return repos.findByArticle(art);
	}

	public List<LignePlacement> findByPrix(double prix) {
		return repos.findByPrix(prix);
	}

	public LignePlacement save(LignePlacement ligne) {
		return repos.save(ligne);
	}

	public LignePlacement edit(LignePlacement ligne, Long id) {
		LignePlacement lp=repos.getOne(id);
		lp.setArticle(ligne.getArticle());
		lp.setPULignePlacement(ligne.getPULignePlacement());
		lp.setQuantiteLignePlacement(ligne.getQuantiteLignePlacement());
		return repos.save(lp);
	}

	public boolean delete(Long id) {
		repos.deleteById(id);
		return repos.existsById(id);
	}
	
}
