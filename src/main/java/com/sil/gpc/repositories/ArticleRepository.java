package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Famille;
import com.sil.gpc.domains.Uniter;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {

	public List<Article> findByCodeArticle(String codeArticle);
	
	public List<Article> findByLibArticle(String libArticle);
	
	public List<Article> findByPrixVenteArticle(Long prixVenteArticle);
	
	public List<Article> findByCouleurArticle(String couleurArticle);
	
	public List<Article> findByFamille(Famille famille);
	
	public List<Article> findByUnite(Uniter uniter);
	
	public List<Article> findByStockerArticle(boolean stockerArticle);
	
	public List<Article> findByNumSerieArticle(boolean numSerieArticle);
	
	public List<Article> findByLivrableArticle(boolean livrableArticle);
	
	public List<Article> findByConsommableArticle(boolean consommableArticle);
	
}
