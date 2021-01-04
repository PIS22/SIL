package com.sil.gpc.controllers.stock;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Caisse;
import com.sil.gpc.domains.Famille;
import com.sil.gpc.domains.Gerer;
import com.sil.gpc.services.ArticleService;
import com.sil.gpc.services.FamilleService;
import com.sil.gpc.services.GererService;
import com.sil.gpc.services.MagasinService;
import com.sil.gpc.services.MagasinierService;
import com.sil.gpc.services.PlageNumArticleService;
import com.sil.gpc.services.PlageNumDispoService;
import com.sil.gpc.services.StockerService;
import com.sil.gpc.services.UniterService;

@RestController
@RequestMapping(path = "/perfora-gpc/v1/stock/")
public class MagasinController {

	private final MagasinService magasinService;
	private final MagasinierService magasinierService;
	private final FamilleService familleService;
	private final ArticleService articleService;
	private final UniterService uniterService;
	private final GererService gererService;
	private final PlageNumArticleService plageNumArticleService;
	private final PlageNumDispoService plageNumDispoService;
	private final StockerService stockerService;
	
	public MagasinController(MagasinService magasinService, MagasinierService magasinierService,
			FamilleService familleService, ArticleService articleService, UniterService uniterService,
			GererService gererService, PlageNumArticleService plageNumArticleService,
			PlageNumDispoService plageNumDispoService, StockerService stockerService) {
		super();
		this.magasinService = magasinService;
		this.magasinierService = magasinierService;
		this.familleService = familleService;
		this.articleService = articleService;
		this.uniterService = uniterService;
		this.gererService = gererService;
		this.plageNumArticleService = plageNumArticleService;
		this.plageNumDispoService = plageNumDispoService;
		this.stockerService = stockerService;
	}
	
	/*###########################################################
	#############	Partie réservée pour magasin
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour magasinier
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour famille
	###########################################################
	*/
	
	@GetMapping(path = "famille/list")
	public List<Famille> getAllFamille(){
		
		return this.familleService.getAll();
	}
	
	@GetMapping(path = "famille/byCodFam/{id}")
	public Optional<Famille> getFamilleById(@PathVariable(name = "id") String id){
		
		return this.familleService.getById(id);
	}
	
	@PostMapping(path = "famille/list")
	public Famille createFamille( @RequestBody Famille famille) {
		
		return this.familleService.save(famille);
	}
	
	@PutMapping(path = "famille/byCodFam/{id}")
	public Famille updateFamille(@PathVariable(name = "id") String id, @RequestBody Famille famille) {
		
		return this.familleService.edit(id, famille);
	}
	
	@DeleteMapping(path = "famille/byCodFam/{id}")
	public Boolean deleteFamille(@PathVariable(name = "id") String id) {
		
		return this.familleService.delete(id);
	}
	
	
	/*###########################################################
	#############	Partie réservée pour article
	###########################################################
	*/
	
	@GetMapping(path = "article/list")
	public List<Article> getAllArticle(){
		
		return this.articleService.getAll();
	}
	
	@GetMapping(path = "article/byCodArt/{id}")
	public Optional<Article> getCaisseById(@PathVariable(name = "id") String id){
		
		return this.articleService.getById(id);
	}
	
	@PostMapping(path = "article/list")
	public Article createArticle( @RequestBody Article article) {
		
		return this.articleService.save(article);
	}
	
	@PutMapping(path = "article/byCodArt/{id}")
	public Article updateArticle(@PathVariable(name = "id") String id, @RequestBody Article article) {
		
		return this.articleService.edit(id, article);
	}
	
	@DeleteMapping(path = "caisse/byCodArt/{id}")
	public Boolean deleteArticle(@PathVariable(name = "id") String id) {
		
		return this.articleService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour unité
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour gérer
	###########################################################
	*/
	
	@GetMapping(path = "gerer/list")
	public List<Gerer> getAllGerer(){
		
		return this.gererService.getAll();
	}
	
	@GetMapping(path = "gerer/byCodGer/{id}")
	public Optional<Gerer> getGererById(@PathVariable(name = "id") Long id){
		
		return this.gererService.getById(id);
	}
	
	@PostMapping(path = "gerer/list")
	public Gerer createGerer( @RequestBody Gerer gerer) {
		
		return this.gererService.save(gerer);
	}
	
	@PutMapping(path = "gerer/byCodGer/{id}")
	public Gerer updateGerer(@PathVariable(name = "id") Long id, @RequestBody Gerer gerer) {
		
		return this.gererService.edit(id, gerer);
	}
	
	@DeleteMapping(path = "gerer/byCodGer/{id}")
	public Boolean deleteGerer(@PathVariable(name = "id") Long id) {
		
		return this.gererService.delete(id);
	}

	
	/*###########################################################
	#############	Partie réservée pour Plage Numéro Article
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour Plage Numéro Dispo
	###########################################################
	*/
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour stocker
	###########################################################
	*/
	
	
	
	
	
	
	
	
}
