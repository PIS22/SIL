package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LigneReception;

@Repository
public interface LigneReceptionRepository extends JpaRepository<LigneReception, Long>{

	List<LigneReception> findByArticle(Article article);
	List<LigneReception> findByQte(double qte);
	List<LigneReception> findByPrix(double prix);
}
