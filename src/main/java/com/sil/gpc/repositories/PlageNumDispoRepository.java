package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.PlageNumDispo;

@Repository
public interface PlageNumDispoRepository extends JpaRepository<PlageNumDispo, Long> {

	List<PlageNumDispo> findByArticle(String codArt);

	List<PlageNumDispo> findByNumDebPlage(String num);

	List<PlageNumDispo> findByNumFinPlage(String num);

	List<PlageNumDispo> findByNumDebPlageDispo(String num);

	List<PlageNumDispo> findByNumFinPlageDispo(String num);

	// List<PlageNumDispo> findByMagasinArticle(Magasin magasin, Article article);

	@Query(value = "Select * from plage_num_dispo where article.code_article=?1 and codeMagasin=?2"
			+ "order by codeExercice ASC, numDebPlageDispo ASC", nativeQuery = true)
	List<PlageNumDispo> premiersNumerosParArticle(String arti, String mag);
}
