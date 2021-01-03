package com.sil.gpc.services;

import java.util.List;

import com.sil.gpc.domains.LigneRecollement;
import com.sil.gpc.repositories.LigneRecollementRepository;

public class LigneRecollementService {

	private final LigneRecollementRepository lrr;

	/**
	 * @param lr
	 */
	public LigneRecollementService(LigneRecollementRepository lrr) {
		this.lrr = lrr;
	}

	public LigneRecollement rechercheUneLigne(Long id) {
		return lrr.getOne(id);
	}

	public List<LigneRecollement> toutesLignes() {
		return lrr.findAll();
	}

	public List<LigneRecollement> ajouteLigneRecollement(LigneRecollement ligne){
		lrr.save(ligne);
		return lrr.findAll();
	}

	public LigneRecollement modifieLigneRecollement(LigneRecollement ligne, Long id) {
		LigneRecollement lr=lrr.getOne(id);
		lr.setArticle(ligne.getArticle());
		lr.setObservationLigneRecollement(ligne.getObservationLigneRecollement());
		lr.setPULigneRecollement(ligne.getPULigneRecollement());
		lr.setQuantiteLigneRecollement(ligne.getQuantiteLigneRecollement());
		return lrr.save(lr);
	}

	public List<LigneRecollement> supprimeLigneRecollement(Long id) {
		lrr.deleteById(id);
		return lrr.findAll();
	}

}
