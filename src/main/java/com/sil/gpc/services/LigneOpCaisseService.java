package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LigneOpCaisse;
import com.sil.gpc.repositories.LigneOpCaisseRepository;

@Service
public class LigneOpCaisseService {

	private final LigneOpCaisseRepository lopr;
	
	/**
	 * @param lopr
	 */
	public LigneOpCaisseService(LigneOpCaisseRepository lopr) {
		this.lopr = lopr;
	}

	public LigneOpCaisse rechercheUneLigne(Long id) {
		return lopr.getOne(id);
	}

	public List<LigneOpCaisse> toutesLignes() {
		return lopr.findAll();
	}

	public LigneOpCaisse ajoutLigneOpCaisse(LigneOpCaisse ligne) {
		return lopr.save(ligne);
	}

	public LigneOpCaisse modifieLigneOpCaisse(LigneOpCaisse ligne, Long id) {
		LigneOpCaisse loc=lopr.getOne(id);
		loc.setCommentaireLigneOperCaisse(ligne.getCommentaireLigneOperCaisse());
		loc.setArticle(ligne.getArticle());
		loc.setPrixLigneOperCaisse(ligne.getPrixLigneOperCaisse());
		loc.setQteLigneOperCaisse(ligne.getQteLigneOperCaisse());
		return lopr.save(loc);
	}

	public List<LigneOpCaisse> supprimeLigneOpCaisse(Long id) {
		lopr.deleteById(id);
		return lopr.findAll();
	}
	
}
