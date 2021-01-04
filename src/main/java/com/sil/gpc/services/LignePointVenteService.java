package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LignePointVente;
import com.sil.gpc.repositories.LignePointVenteRepository;

@Service
public class LignePointVenteService {

	private final LignePointVenteRepository repos;

	/**
	 * @param repos
	 */
	public LignePointVenteService(LignePointVenteRepository lpvr) {
		this.repos = lpvr;
	}


	public Optional<LignePointVente> findById(Long id) {
		return repos.findById(id);
	}

	public List<LignePointVente> findAll() {
		return repos.findAll();
	}

	public List<LignePointVente> findByArticle(Article article) {
		return repos.findByArticle(article);
	}

	public List<LignePointVente> findByQte(double qte) {
		return repos.findByQte(qte);
	}

	public List<LignePointVente> findByPrix(double prix) {
		return repos.findByPrix(prix);
	}

	public List<LignePointVente> save(LignePointVente ligne) {
		repos.save(ligne);
		return repos.findAll();
	}

	public LignePointVente edit(LignePointVente ligne, Long id) {
		LignePointVente cible=repos.getOne(id);
		if (cible!=null) {
			cible.setArticle(ligne.getArticle());
		cible.setPULignePointVente(ligne.getPULignePointVente());
		cible.setQuantiteLignePointVente(ligne.getQuantiteLignePointVente());
		return repos.save(cible);
		}else
			return null;
	}

	public boolean delete(Long id) {
		repos.deleteById(id);
		return repos.existsById(id);
	}
}
