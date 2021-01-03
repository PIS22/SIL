package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Famille;
import com.sil.gpc.domains.Uniter;
import com.sil.gpc.repositories.ArticleRepository;

@Service
public class ArticleService {

	private final ArticleRepository repo;

	public ArticleService(ArticleRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Article save(Article article) {
		
		return this.repo.save(article);
	}
	
	public Article edit(String id, Article article) {
		
		Article entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setConsommableArticle(article.isConsommableArticle());
			entiter.setCouleurArticle(article.getCouleurArticle());
			entiter.setLibArticle(article.getLibArticle());
			entiter.setLivrableArticle(article.isLivrableArticle());
			entiter.setNumSerieArticle(article.isNumSerieArticle());
			entiter.setPrixVenteArticle(article.getPrixVenteArticle());
			entiter.setStockerArticle(article.isStockerArticle());
			entiter.setFamille(article.getFamille());
			entiter.setUnite(article.getUnite());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public void delete(String id) {
		
		Article entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
	}
	
	public Optional<Article> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Article> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Article> findByCodeArticle(String codeArticle){
		
		return this.repo.findByCodeArticle(codeArticle);
	}
	
	public List<Article> findByLibArticle(String libArticle){
		
		return this.repo.findByLibArticle(libArticle);
	}
	
	public List<Article> findByPrixVenteArticle(Long prixVenteArticle){
		
		return this.repo.findByPrixVenteArticle(prixVenteArticle);
	}
	
	public List<Article> findByCouleurArticle(String couleurArticle){
		
		return this.repo.findByCouleurArticle(couleurArticle);
	}
	
	public List<Article> findByFamille(Famille famille){
		
		return this.repo.findByFamille(famille);
	}
	
	public List<Article> findByUnite(Uniter uniter){
		
		return this.repo.findByUnite(uniter);
	}
	
	public List<Article> findByStockerArticle(boolean stockerArticle){
		
		return this.repo.findByStockerArticle(stockerArticle);
	}
	
	public List<Article> findByNumSerieArticle(boolean numSerieArticle){
		
		return this.repo.findByNumSerieArticle(numSerieArticle);
	}
	
	public List<Article> findByLivrableArticle(boolean livrableArticle){
		
		return this.repo.findByLivrableArticle(livrableArticle);
	}
	
	public List<Article> findByConsommableArticle(boolean consommableArticle){
		
		return this.repo.findByConsommableArticle(consommableArticle);
	}
	
	
	
}
