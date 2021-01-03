package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LignePlacement;
import com.sil.gpc.repositories.LignePlacementRepository;

@Service
public class LignePlacementService {

	private final LignePlacementRepository lpr;

	/**
	 * @param lpr
	 */
	public LignePlacementService(LignePlacementRepository lpr) {
		this.lpr = lpr;
	}


	public LignePlacement rechercheUneLigne(Long id) {
		return lpr.getOne(id);
	}

	public List<LignePlacement> toutesLignes() {
		return lpr.findAll();
	}

	public LignePlacement ajoutLignePlacement(LignePlacement ligne) {
		return lpr.save(ligne);
	}

	public LignePlacement modifieLignePlacement(LignePlacement ligne, Long id) {
		LignePlacement lp=lpr.getOne(id);
		lp.setArticle(ligne.getArticle());
		lp.setPULignePlacement(ligne.getPULignePlacement());
		lp.setQuantiteLignePlacement(ligne.getQuantiteLignePlacement());
		return lpr.save(lp);
	}

	public List<LignePlacement> supprimeLignePlacements(Long id) {
		lpr.deleteById(id);
		return lpr.findAll();
	}
	
}
