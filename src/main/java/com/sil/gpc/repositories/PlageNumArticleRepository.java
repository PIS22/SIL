package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.PlageNumArticle;

@Repository
public interface PlageNumArticleRepository extends JpaRepository<PlageNumArticle, Long>{

	List<PlageNumArticle> findByLigneAppro(Long la);
	List<PlageNumArticle> findByLignePlacement(Long lp);
	List<PlageNumArticle> findByLigneRecollement(Long lr);
	List<PlageNumArticle> findByNumDebPlage(String numDebPlage);
	List<PlageNumArticle> findByNumFinPlage(String numFinPlage);
}
