package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LigneReversement;
import com.sil.gpc.repositories.LigneReversementRepository;

@Service
public class LigneReversementService {

	private final LigneReversementRepository lrr;

	/**
	 * @param lrr
	 */
	public LigneReversementService(LigneReversementRepository lrr) {
		this.lrr = lrr;
	}

	public LigneReversement rechercheUneLigne(Long id) {
		return lrr.getOne(id);
	}

	public List<LigneReversement> toutesLignes() {
		return lrr.findAll();
	}


	public LigneReversement ajouteLigneReversement(LigneReversement ligne){
		return lrr.save(ligne);
	}

	public LigneReversement modifieLigneReversement(LigneReversement ligne, Long id) {
		LigneReversement lr=lrr.getOne(id);
		lr.setArticle(ligne.getArticle());
		lr.setBeneficiaire(ligne.getBeneficiaire());
		lr.setDateQuittanceReversement(ligne.getDateQuittanceReversement());
		lr.setObservation(ligne.getObservation());
		lr.setPULigneReversement(ligne.getPULigneReversement());
		lr.setQuantiteLigneReversement(ligne.getQuantiteLigneReversement());
		lr.setQuittanceReversement(ligne.getQuittanceReversement());
		return lrr.save(lr);
	}
	
	public List<LigneReversement> supprimeLigneReversement(Long id){
		lrr.deleteById(id);
		return lrr.findAll();
	}
}
