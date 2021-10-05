package com.sil.gpc.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LigneOpCaisse;
import com.sil.gpc.domains.OpCaisse;
import com.sil.gpc.repositories.LigneOpCaisseRepository;

@Service
public class LigneOpCaisseService {

	private final LigneOpCaisseRepository repos;

	public LigneOpCaisseService(LigneOpCaisseRepository repos) {
		this.repos = repos;
	}

	public LigneOpCaisse getByid(Long id) {
		return repos.getOne(id);
	}

	public List<LigneOpCaisse> getByArticle(Article article) {
		return repos.findByArticle(article);
	}

	public List<LigneOpCaisse> getByQteLigne(double qte) {
		return repos.findByQteLigneOperCaisse(qte);
	}

	public List<LigneOpCaisse> ligneOpValides() {
		return repos.ligneOpValides();
	}

	public List<LigneOpCaisse> ligneOpannulees() {
		return repos.ligneOpAnnules();
	}

	public List<LigneOpCaisse> getByPrixLigne(double prix) {
		return repos.findByPrixLigneOperCaisse(prix);
	}

	public List<LigneOpCaisse> getAll() {
		return repos.findAll();
	}

	public LigneOpCaisse save(LigneOpCaisse ligne) {
		return repos.save(ligne);
	}

	public List<LigneOpCaisse> saving(List<LigneOpCaisse> lines) {
		return repos.saveAll(lines);
	}

	public LigneOpCaisse edit(LigneOpCaisse ligne, Long id) {
		System.out.printf("igne: ", ligne.getMagasin());
		LigneOpCaisse cible = repos.getOne(id);
		if (cible != null) {
			cible.setCommentaireLigneOperCaisse(ligne.getCommentaireLigneOperCaisse());
			cible.setArticle(ligne.getArticle());
			cible.setPrixLigneOperCaisse(ligne.getPrixLigneOperCaisse());
			cible.setQteLigneOperCaisse(ligne.getQteLigneOperCaisse());
			cible.setLivre(ligne.isLivre());
			cible.setMagasin(ligne.getMagasin());
			return repos.save(cible);
		} else
			return null;
	}

	public boolean delete(Long id) {
		repos.deleteById(id);
		return repos.existsById(id);
	}

	public List<LigneOpCaisse> getByOperation(OpCaisse oc) {
		return repos.findByOpCaisse(oc);
	}

	public List<LigneOpCaisse> findLigneByOP(String numopc) {
		return repos.lignesOP(numopc);
	}

	public double caisseImputMode(String caisse, String mode, Timestamp deb, Timestamp fin) {
		return repos.caisseModImput(mode, caisse, deb, fin);
	}

	public double caissePrestMode(String caisse, String mode, Timestamp deb, Timestamp fin) {
		return repos.caisseModPrest(mode, caisse, deb, fin);
	}

	public double arrImputMode(String caisse, String mode, Timestamp deb, Timestamp fin) {
		return repos.arrModImput(mode, caisse, deb, fin);
	}

	public double arrPrestMode(String caisse, String mode, Timestamp deb, Timestamp fin) {
		return repos.caisseModImput(mode, caisse, deb, fin);
	}

}
