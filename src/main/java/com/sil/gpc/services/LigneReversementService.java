package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LigneReversement;
import com.sil.gpc.domains.Reversement;
import com.sil.gpc.repositories.LigneReversementRepository;

@Service
public class LigneReversementService {

	private final LigneReversementRepository repos;

	/**
	 * @param repos
	 */
	public LigneReversementService(LigneReversementRepository lrr) {
		this.repos = lrr;
	}

	public Optional<LigneReversement> findById(Long id) {
		return repos.findById(id);
	}

	public List<LigneReversement> findByArticle(Article article){
		return repos.findByArticle(article);
	}

	public List<LigneReversement> findByQte(Long qte) {
		return repos.findByQuantiteLigneReversement(qte);
	}

	public List<LigneReversement> findBybeneficiairex(String beneficiaire) {
		return repos.findByBeneficiaire(beneficiaire);
	}

	public List<LigneReversement> findByDate(Date dateQuittance) {
		return repos.findByDateQuittanceReversement(dateQuittance);
	}

	public List<LigneReversement> findByNumReversement(Reversement reversement){
		return repos.findByNumReversement(reversement);
	}

	public List<LigneReversement> findByQuittance(String quittance){
		return repos.findByQuittanceReversement(quittance);
	}

	public List<LigneReversement> findByPrix(Long pu){
		return repos.findByPULigneReversement(pu);
	}

	public List<LigneReversement> findAll() {
		return repos.findAll();
	}


	public LigneReversement save(LigneReversement ligne){
		return repos.save(ligne);
	}

	public LigneReversement edit(LigneReversement ligne, Long id) {
		LigneReversement cible=repos.getOne(id);
		if (cible!=null) {
		cible.setArticle(ligne.getArticle());
		cible.setBeneficiaire(ligne.getBeneficiaire());
		cible.setDateQuittanceReversement(ligne.getDateQuittanceReversement());
		cible.setObservation(ligne.getObservation());
		cible.setPULigneReversement(ligne.getPULigneReversement());
		cible.setQuantiteLigneReversement(ligne.getQuantiteLigneReversement());
		cible.setQuittanceReversement(ligne.getQuittanceReversement());
		return repos.save(cible);
		}else
			return null;
	}
	
	public boolean delete(Long id){
		repos.deleteById(id);
		return repos.existsById(id);
	}
}
