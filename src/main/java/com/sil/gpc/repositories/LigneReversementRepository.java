package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LigneReversement;
import com.sil.gpc.domains.Reversement;

@Repository
public interface LigneReversementRepository  extends JpaRepository<LigneReversement, Long>{

	List<LigneReversement> findByArticle(Article article);
	List<LigneReversement> findByBeneficiaire(String beneficiaire);
	List<LigneReversement> findByDateQuittanceReversement(Date dateQuittanceReversement);
	List<LigneReversement> findByNumReversement(Reversement numReversement);
	List<LigneReversement> findByQuittanceReversement(String quittanceReversement);
	List<LigneReversement> findByPULigneReversement(Long pULigneReversement);
	List<LigneReversement> findByQuantiteLigneReversement(Long quantiteLigneReversement);
	
}
