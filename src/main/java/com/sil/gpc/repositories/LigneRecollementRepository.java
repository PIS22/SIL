package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LigneRecollement;

@Repository
public interface LigneRecollementRepository extends JpaRepository<LigneRecollement, Long>{

	List<LigneRecollement> findByArticle(Article article);
	List<LigneRecollement> findByQte(double qte);
	List<LigneRecollement> findByPrix(double prix);
}
