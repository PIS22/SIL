package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LignePointVente;
import com.sil.gpc.repositories.LignePointVenteRepository;

@Service
public class LignePointVenteService {

	private final LignePointVenteRepository lpvr;

	/**
	 * @param lpr
	 */
	public LignePointVenteService(LignePointVenteRepository lpvr) {
		this.lpvr = lpvr;
	}


	public LignePointVente rechercheUneLigne(Long id) {
		return lpvr.getOne(id);
	}

	public List<LignePointVente> toutesLignes() {
		return lpvr.findAll();
	}

	public List<LignePointVente> ajoutLignePointVente(LignePointVente ligne) {
		lpvr.save(ligne);
		return lpvr.findAll();
	}

	public LignePointVente modifieLignePointVente(LignePointVente ligne, Long id) {
		LignePointVente lpv=lpvr.getOne(id);
		lpv.setArticle(ligne.getArticle());
		lpv.setPULignePointVente(ligne.getPULignePointVente());
		lpv.setQuantiteLignePointVente(ligne.getQuantiteLignePointVente());
		return lpvr.save(lpv);
	}

	public List<LignePointVente> supprimeLignePointVente(Long id) {
		lpvr.deleteById(id);
		return lpvr.findAll();
	}
}
