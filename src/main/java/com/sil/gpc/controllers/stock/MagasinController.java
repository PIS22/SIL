package com.sil.gpc.controllers.stock;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Famille;
import com.sil.gpc.domains.Gerer;
import com.sil.gpc.domains.Inventaire;
import com.sil.gpc.domains.LigneInventaire;
import com.sil.gpc.domains.Magasin;
import com.sil.gpc.domains.Magasinier;
import com.sil.gpc.domains.PlageNumArticle;
import com.sil.gpc.domains.PlageNumDispo;
import com.sil.gpc.domains.Stocker;
import com.sil.gpc.domains.Uniter;
import com.sil.gpc.services.ArticleService;
import com.sil.gpc.services.FamilleService;
import com.sil.gpc.services.GererService;
import com.sil.gpc.services.InventaireService;
import com.sil.gpc.services.LigneInventaireService;
import com.sil.gpc.services.MagasinService;
import com.sil.gpc.services.MagasinierService;
import com.sil.gpc.services.PlageNumArticleService;
import com.sil.gpc.services.PlageNumDispoService;
import com.sil.gpc.services.StockerService;
import com.sil.gpc.services.UniterService;

@CrossOrigin
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
	private final LigneInventaireService lInvServ;
	private final InventaireService invServ;

	public MagasinController(MagasinService magasinService, MagasinierService magasinierService,
			FamilleService familleService, ArticleService articleService, UniterService uniterService,
			GererService gererService, PlageNumArticleService plageNumArticleService,
			PlageNumDispoService plageNumDispoService, StockerService stockerService, LigneInventaireService lInvServ,
			InventaireService invServ) {
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
		this.lInvServ = lInvServ;
		this.invServ = invServ;
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour magasin
	 * ###########################################################
	 */

	@GetMapping(path = "magasin/list")
	public List<Magasin> getAllMagasin() {

		return this.magasinService.findAll();
	}

	@GetMapping(path = "magasin/byCodMag/{id}")
	public Optional<Magasin> getMagasinById(@PathVariable(name = "id") String id) {

		return this.magasinService.findById(id);
	}

	@PostMapping(path = "magasin/list")
	public Magasin createMagasin(@RequestBody Magasin magasin) {

		return this.magasinService.save(magasin);
	}

	@PutMapping(path = "magasin/byCodMag/{id}")
	public Magasin updateMagasin(@PathVariable(name = "id") String id, @RequestBody Magasin magasin) {

		return this.magasinService.edit(magasin, id);
	}

	@DeleteMapping(path = "magasin/byCodMag/{id}")
	public Boolean deleteMagasin(@PathVariable(name = "id") String id) {

		return this.magasinService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour magasinier
	 * ###########################################################
	 */

	@GetMapping(path = "magasinier/list")
	public List<Magasinier> getAllMagasinier() {

		return this.magasinierService.findAll();
	}

	@GetMapping(path = "magasinier/byCodMag/{id}")
	public Optional<Magasinier> getMagasinierById(@PathVariable(name = "id") Long id) {

		return this.magasinierService.findById(id);
	}

	@PostMapping(path = "magasinier/list")
	public Magasinier createMagasinier(@RequestBody Magasinier magasinier) {

		return this.magasinierService.save(magasinier);
	}

	@PutMapping(path = "magasinier/byCodMag/{id}")
	public Magasinier updateMagasinier(@PathVariable(name = "id") Long id, @RequestBody Magasinier magasinier) {

		return this.magasinierService.edit(magasinier, id);
	}

	@DeleteMapping(path = "magasinier/byCodMag/{id}")
	public Boolean deleteMagasinier(@PathVariable(name = "id") Long id) {

		return this.magasinierService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour famille
	 * ###########################################################
	 */

	@GetMapping(path = "famille/list")
	public List<Famille> getAllFamille() {

		return this.familleService.getAll();
	}

	@GetMapping(path = "famille/byCodFam/{id}")
	public Optional<Famille> getFamilleById(@PathVariable(name = "id") String id) {

		return this.familleService.getById(id);
	}

	@PostMapping(path = "famille/list")
	public Famille createFamille(@RequestBody Famille famille) {

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

	/*
	 * ########################################################### #############
	 * Partie réservée pour article
	 * ###########################################################
	 */

	@GetMapping(path = "article/list")
	public List<Article> getAllArticle() {

		return this.articleService.getAll();
	}

	@GetMapping(path = "article/byCodArt/{id}")
	public Optional<Article> getCaisseById(@PathVariable(name = "id") String id) {

		return this.articleService.getById(id);
	}

	@PostMapping(path = "article/list")
	public Article createArticle(@RequestBody Article article) {

		return this.articleService.save(article);
	}

	@PutMapping(path = "article/byCodArt/{id}")
	public Article updateArticle(@PathVariable(name = "id") String id, @RequestBody Article article) {

		return this.articleService.edit(id, article);
	}

	@DeleteMapping(path = "article/byCodArt/{id}")
	public Boolean deleteArticle(@PathVariable(name = "id") String id) {

		return this.articleService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour unité
	 * ###########################################################
	 */

	@GetMapping(path = "uniter/list")
	public List<Uniter> getAllUniter() {

		return this.uniterService.getAll();
	}

	@GetMapping(path = "uniter/byCodUni/{id}")
	public Optional<Uniter> getUniterById(@PathVariable(name = "id") String id) {

		return this.uniterService.findById(id);
	}

	@PostMapping(path = "uniter/list")
	public Uniter createUniter(@RequestBody Uniter uniter) {

		return this.uniterService.save(uniter);
	}

	@PutMapping(path = "uniter/byCodUni/{id}")
	public Uniter updateUniter(@PathVariable(name = "id") String id, @RequestBody Uniter uniter) {

		return this.uniterService.edit(id, uniter);
	}

	@DeleteMapping(path = "uniter/byCodUni/{id}")
	public Boolean deleteUniter(@PathVariable(name = "id") String id) {

		return this.uniterService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour gérer
	 * ###########################################################
	 */

	@GetMapping(path = "gerer/list")
	public List<Gerer> getAllGerer() {

		return this.gererService.getAll();
	}

	@GetMapping(path = "gerer/byCodGer/{id}")
	public Optional<Gerer> getGererById(@PathVariable(name = "id") Long id) {

		return this.gererService.getById(id);
	}

	@PostMapping(path = "gerer/list")
	public Gerer createGerer(@RequestBody Gerer gerer) {

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

	/*
	 * ########################################################### #############
	 * Partie réservée pour Plage Numéro Article
	 * ###########################################################
	 */

	@GetMapping(path = "plageNumArticle/list")
	public List<PlageNumArticle> getAllPlageNumArticle() {

		return this.plageNumArticleService.findAll();
	}

	@GetMapping(path = "plageNumArticle/byCodPlaNumArt/{id}")
	public Optional<PlageNumArticle> getPlageNumArticleById(@PathVariable(name = "id") Long id) {

		return this.plageNumArticleService.recherchePlage(id);
	}

	@PostMapping(path = "plageNumArticle/list")
	public PlageNumArticle createPlageNumArticle(@RequestBody PlageNumArticle plageNumArticle) {

		return this.plageNumArticleService.save(plageNumArticle);
	}

	@PutMapping(path = "plageNumArticle/byCodPlaNumArt/{id}")
	public PlageNumArticle updatePlageNumArticle(@PathVariable(name = "id") Long id,
			@RequestBody PlageNumArticle plageNumArticle) {

		return this.plageNumArticleService.edit(plageNumArticle, id);
	}

	@DeleteMapping(path = "plageNumArticle/byCodPlaNumArt/{id}")
	public Boolean deletePlageNumArticle(@PathVariable(name = "id") Long id) {

		return this.plageNumArticleService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour Plage Numéro Dispo
	 * ###########################################################
	 */

	@GetMapping(path = "plageNumDispo/list")
	public List<PlageNumDispo> getAllPlageNumDispo() {

		return this.plageNumDispoService.findAll();
	}

	@GetMapping(path = "plageNumDispo/byCodPlaNumDis/{id}")
	public Optional<PlageNumDispo> getPlageNumDispoById(@PathVariable(name = "id") Long id) {

		return this.plageNumDispoService.findById(id);
	}

	@PostMapping(path = "plageNumDispo/list")
	public PlageNumDispo createPlageNumDispo(@RequestBody PlageNumDispo plageNumDispo) {

		return this.plageNumDispoService.save(plageNumDispo);
	}

	@PutMapping(path = "plageNumDispo/byCodPlaNumDis/{id}")
	public PlageNumDispo updatePlageNumDispo(@PathVariable(name = "id") Long id,
			@RequestBody PlageNumDispo plageNumDispo) {

		return this.plageNumDispoService.edit(plageNumDispo, id);
	}

	@DeleteMapping(path = "plageNumDispo/byCodPlaNumDis/{id}")
	public Boolean deletePlageNumDispo(@PathVariable(name = "id") Long id) {

		return this.plageNumDispoService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour stocker
	 * ###########################################################
	 */

	@GetMapping(path = "stocker/list")
	public List<Stocker> getAllStocker() {
		return this.stockerService.getAll();
	}

	@GetMapping(path = "stocker/byCodSto/{id}")
	public Optional<Stocker> getStockerById(@PathVariable(name = "id") Long id) {
		return this.stockerService.findById(id);
	}

	@PostMapping(path = "stocker/list")
	public Stocker createStocker(@RequestBody Stocker stocker) {
		return this.stockerService.save(stocker);
	}

	@PutMapping(path = "stocker/byCodSto/{id}")
	public Stocker updateStocker(@PathVariable(name = "id") Long id, @RequestBody Stocker stocker) {

		return this.stockerService.edit(id, stocker);
	}

	@DeleteMapping(path = "stocker/byCodSto/{id}")
	public Boolean deleteStocker(@PathVariable(name = "id") Long id) {

		return this.stockerService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour Inventaire
	 * ###########################################################
	 */

	@GetMapping(path = "inventaire/list")
	public List<Inventaire> getAllInventaire() {
		return this.invServ.findAll();
	}

	@GetMapping(path = "inventaire/byCodSto/{id}")
	public Optional<Inventaire> getInventaireById(@PathVariable(name = "id") String id) {
		return this.invServ.findById(id);
	}

	@PostMapping(path = "inventaire/list")
	public Inventaire createInventaire(@RequestBody Inventaire inv) {
		return this.invServ.save(inv);
	}

	@PutMapping(path = "inventaire/byCodSto/{id}")
	public Inventaire updateInventaire(@PathVariable(name = "id") String id, @RequestBody Inventaire inv) {

		return this.invServ.edit(inv, id);
	}

	@DeleteMapping(path = "inventaire/byCodSto/{id}")
	public Boolean deleteInvent(@PathVariable(name = "id") String id) {

		return this.invServ.delete(id);
	}

	/*
	 * ########################################################### ###########
	 * Partie réservée pour LigneInventaire#############
	 * #############################################################
	 */

	@GetMapping(path = "ligneInventaire/list")
	public List<LigneInventaire> getAllLigneInventaire() {
		return this.lInvServ.findAll();
	}

	@GetMapping(path = "ligneInventaire/byCodSto/{id}")
	public Optional<LigneInventaire> getLigneInventaireById(@PathVariable(name = "id") Long id) {
		return this.lInvServ.findById(id);
	}

	@PostMapping(path = "ligneInventaire/list")
	public LigneInventaire createLigneInventaire(@RequestBody LigneInventaire livgInv) {
		return this.lInvServ.save(livgInv);
	}

	@PutMapping(path = "ligneInventaire/byCodSto/{id}")
	public LigneInventaire updateLigneInventaire(@PathVariable(name = "id") Long id,
			@RequestBody LigneInventaire ligInv) {

		return this.lInvServ.edit(ligInv, id);
	}

	@DeleteMapping(path = "ligneInventaire/byCodSto/{id}")
	public Boolean deleteLigneInventaire(@PathVariable(name = "id") Long id) {

		return this.lInvServ.delete(id);
	}

	//Léo
	@GetMapping(path = "magasinByMagasinier/{id}")
	public Magasin getMagasinByMagasinier(@PathVariable(name = "id") Long id) {
		return this.gererService.findMagasinByNumMagasinier(id);
	}

	//Léo
	@GetMapping(path = "stocker/list/{codeArticle}/{numMag}/{quant}")
	public Boolean  getAndUpdatedOrAddStokerLine(@PathVariable(name = "codeArticle") String codeArticle, @PathVariable(name = "numMag") String numMag, @PathVariable(name = "quant") Long quant) {

		return this.stockerService.updateStockByArticleAndMagasin(codeArticle, numMag, quant);
	}


}
