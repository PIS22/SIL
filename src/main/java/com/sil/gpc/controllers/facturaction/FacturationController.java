package com.sil.gpc.controllers.facturaction;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sil.gpc.domains.*;
import com.sil.gpc.services.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  com.sil.gpc.repositories.OpCaisseRepository;
import  com.sil.gpc.repositories.LigneOpCaisseRepository;


import com.sil.gpc.dto.SearchLinesOpCaisseDTO;
import com.sil.gpc.dto.SearchOpCaisseDTO;

@RestController
@CrossOrigin
@RequestMapping(path = "/perfora-gpc/v1/facturation/")
public class FacturationController {

	private final CaisseService caisseService;
	private final AffecterService affecterService;
	private final LigneOpCaisseService ligneOpCaisseService;
	private final LigneReversementService ligneReversementService;
	private final ModePaiementService modePaiementService;
	private final OpCaisseService opCaisseService;
	private final ReversementService reversementService;
	private final TypeRecetteService typeRecetteService;
	private final ArrondissementService arrondissementService;
	private final UtilisateurService utilisateurService;
	private final ArticleService articleService;

	private  final OpCaisseRepository opCaisseRepository;
	private  final LigneOpCaisseRepository ligneOpCaisseRepository;
	private  final StockerService stockerService;
	private  final  CorrespondantService correspondantService;
	private  final  GererService gererService;

	public FacturationController(CaisseService caisseService, AffecterService affecterService,
			LigneOpCaisseService ligneOpCaisseService, LigneReversementService ligneReversementService,
			ModePaiementService modePaiementService, OpCaisseService opCaisseService,
			ReversementService reversementService, TypeRecetteService typeRecetteService,
			ArrondissementService arrondissementService, UtilisateurService utilisateurService,
			ArticleService articleService, OpCaisseRepository opCaisseRepository , LigneOpCaisseRepository ligneOpCaisseRepository,
	         StockerService stockerService, CorrespondantService correspondantService, GererService gererService) {
		super();
		this.caisseService = caisseService;
		this.affecterService = affecterService;
		this.ligneOpCaisseService = ligneOpCaisseService;
		this.ligneReversementService = ligneReversementService;
		this.modePaiementService = modePaiementService;
		this.opCaisseService = opCaisseService;
		this.reversementService = reversementService;
		this.typeRecetteService = typeRecetteService;
		this.arrondissementService = arrondissementService;
		this.utilisateurService = utilisateurService;
		this.articleService = articleService;

		this.opCaisseRepository = opCaisseRepository;
		this.ligneOpCaisseRepository = ligneOpCaisseRepository;
		this.stockerService = stockerService;
		this.correspondantService = correspondantService;
		this.gererService = gererService;

	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour Caisse
	 * ###########################################################
	 */

	@GetMapping(path = "caisse/list")
	public List<Caisse> getAllCaisse() {

		return this.caisseService.getAll();
	}

	@GetMapping(path = "caisse/list/az")
	public List<Caisse> getAllCaisseDSC() {

		return this.caisseService.listeab();
	}

	@GetMapping(path = "caisse/byCodCai/{id}")
	public Optional<Caisse> getCaisseById(@PathVariable(name = "id") String id) {

		return this.caisseService.getById(id);
	}

	@PostMapping(path = "caisse/list")
	public Caisse createCaisse(@RequestBody Caisse caisse) {

		return this.caisseService.save(caisse);
	}

	@PutMapping(path = "caisse/byCodCai/{id}")
	public Caisse updateCaisse(@PathVariable(name = "id") String id, @RequestBody Caisse caisse) {

		return this.caisseService.edit(id, caisse);
	}

	@DeleteMapping(path = "caisse/byCodCai/{id}")
	public Boolean deleteCaisse(@PathVariable(name = "id") String id) {

		return this.caisseService.delete(id);
	}

	@GetMapping(path = "caisse/byCodArrondi/{valeur}")
	public List<Caisse> getCaisseByCodeArrondissement(@PathVariable(name = "valeur") String valeur) {

		List<Caisse> res = new ArrayList<Caisse>();
		if (this.arrondissementService.findByCodeArrondi(valeur).isEmpty() == false) {
			res = this.caisseService.findByArrondissement(this.arrondissementService.findByCodeArrondi(valeur).get(0));
			return res;
		}

		return res;
	}

	@GetMapping(path = "caisse/byLibCai/{valeur}")
	public List<Caisse> getCaisseByLibeCaisse(@PathVariable(name = "valeur") String valeur) {

		return this.caisseService.findByLibeCaisse(valeur);

	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour Affecter
	 * ###########################################################
	 */

	@GetMapping(path = "affecter/list")
	public List<Affecter> getAllAffecter() {

		return this.affecterService.getAll();
	}

	@GetMapping(path = "affecter/byCodAff/{id}")
	public Optional<Affecter> getAffecterById(@PathVariable(name = "id") Long id) {

		return this.affecterService.getByid(id);
	}

	@PostMapping(path = "affecter/list")
	public Affecter createAffecter(@RequestBody Affecter affecter) {

		return this.affecterService.save(affecter);
	}

	@PutMapping(path = "affecter/byCodAff/{id}")
	public Affecter updateAffecter(@PathVariable(name = "id") Long id, @RequestBody Affecter affecter) {

		return this.affecterService.edit(id, affecter);
	}

	@DeleteMapping(path = "affecter/byCodAff/{id}")
	public Boolean deleteAffecter(@PathVariable(name = "id") Long id) {

		return this.affecterService.delete(id);
	}

	@GetMapping(path = "affecter/byCodCaiss/{valeur}")
	public List<Affecter> getAffecterByCodeCaisse(@PathVariable(name = "valeur") String valeur) {

		List<Affecter> res = new ArrayList<Affecter>();
		if (this.caisseService.findByCodeCaisse(valeur).isEmpty() == false) {
			res = this.affecterService.findByCaisse(this.caisseService.findByCodeCaisse(valeur).get(0));
			return res;
		}

		return res;
	}

	@GetMapping(path = "affecter/byCodUtilisa/{valeur}")
	public List<Affecter> getAffecterByCodeUtilisateur(@PathVariable(name = "valeur") Long valeur) {

		List<Affecter> res = new ArrayList<Affecter>();
		if (this.utilisateurService.findByIdUtilisateur(valeur).isEmpty() == false) {
			res = this.affecterService.findByUtilisateur(this.utilisateurService.findByIdUtilisateur(valeur).get(0));
			return res;
		}

		return res;
	}

	@GetMapping(path = "affecter/byDateDebAff/{valeur}")
	public List<Affecter> getAffecterByDateDebAffecter(@PathVariable(name = "valeur") Date valeur) {

		return this.affecterService.findByDateDebAffecter(valeur);
	}

	@GetMapping(path = "affecter/byDateFinAff/{valeur}")
	public List<Affecter> getAffecterByDateFinAffecter(@PathVariable(name = "valeur") Date valeur) {

		return this.affecterService.findByDateFinAffecter(valeur);
	}

	@GetMapping(path = "affecter/uc/actu/{id}")
	public List<Affecter> getCaisseActuByUser(@PathVariable(name = "id") Long id) {

		return this.affecterService.getUserCaisseActu(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour mode paiement
	 * ###########################################################
	 */

	@GetMapping(path = "modePaiement/list")
	public List<ModePaiement> getAllModePaiement() {

		return this.modePaiementService.findAll();
	}

	@GetMapping(path = "modePaiement/byCodModPai/{id}")
	public Optional<ModePaiement> getModePaiementById(@PathVariable(name = "id") String id) {

		return this.modePaiementService.findById(id);
	}

	@PostMapping(path = "modePaiement/list")
	public ModePaiement createModePaiement(@RequestBody ModePaiement modePaiement) {

		return this.modePaiementService.save(modePaiement);
	}

	@PutMapping(path = "modePaiement/byCodModPai/{id}")
	public ModePaiement updateModePaiement(@PathVariable(name = "id") String id,
			@RequestBody ModePaiement modePaiement) {

		return this.modePaiementService.edit(modePaiement, id);
	}

	@DeleteMapping(path = "modePaiement/byCodModPai/{id}")
	public Boolean deleteModePaiement(@PathVariable(name = "id") String id) {

		return this.modePaiementService.delete(id);
	}

	@GetMapping(path = "modePaiement/byLib/{valeur}")
	public List<ModePaiement> getModePaiementByLibelle(@PathVariable(name = "valeur") String valeur) {

		return this.modePaiementService.findByLibelle(valeur);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour type recette
	 * ###########################################################
	 */

	@GetMapping(path = "typeRecette/list")
	public List<TypeRecette> getAllTypeRecette() {

		return this.typeRecetteService.getAll();
	}

	@GetMapping(path = "typeRecette/byCodTypRec/{id}")
	public Optional<TypeRecette> getTypeRecetteById(@PathVariable(name = "id") String id) {

		return this.typeRecetteService.findById(id);
	}

	@PostMapping(path = "typeRecette/list")
	public TypeRecette createTypeRecette(@RequestBody TypeRecette typeRecette) {

		return this.typeRecetteService.save(typeRecette);
	}

	@PutMapping(path = "typeRecette/byCodTypRec/{id}")
	public TypeRecette updateTypeRecette(@PathVariable(name = "id") String id, @RequestBody TypeRecette typeRecette) {

		return this.typeRecetteService.edit(id, typeRecette);
	}

	@DeleteMapping(path = "typeRecette/byCodTypRec/{id}")
	public Boolean deleteTypeRecette(@PathVariable(name = "id") String id) {

		return this.typeRecetteService.delete(id);
	}

	@GetMapping(path = "typeRecette/byLibTypRec/{valeur}")
	public List<TypeRecette> getTypeRecetteByLibelleTypeRecette(@PathVariable(name = "valeur") String valeur) {

		return this.typeRecetteService.findByLibelleTypeRecette(valeur);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour Opération Caisse
	 * ###########################################################
	 */

	@GetMapping(path = "opcaisse/list")
	public List<OpCaisse> getAllOpcaisse() {
		// List<OpCaisse> opc = this.opCaisseService.findAll();
		// opc.sort(null);
		// System.out.print(opc);
		return this.opCaisseService.findAll();
	}

	@GetMapping(path = "opcaisse/byCodOpCai/{id}")
	public Optional<OpCaisse> getOpCaisseById(@PathVariable(name = "id") String id) {

		return this.opCaisseService.findById(id);
	}

	@PostMapping(path = "opcaisse/list")
	public OpCaisse createOpCaisse(@RequestBody OpCaisse opCaisse) {
		System.out.println(opCaisse);
		return opCaisseService.save(opCaisse);
	}

	@GetMapping(path = "opcaisse/list/vld")
	public List<OpCaisse> findValide() {
		return opCaisseService.findValides();
	}

	@GetMapping(path = "opcaisse/list/anl")
	public List<OpCaisse> findAnnlees() {
		return opCaisseService.findAnnulees();
	}

	@PutMapping(path = "opcaisse/byCodOpCai/{id}")
	public OpCaisse updateOpCaisse(@PathVariable(name = "id") String id, @RequestBody OpCaisse opCaisse) {

		return this.opCaisseService.edit(opCaisse, id);
	}

	@DeleteMapping(path = "opcaisse/byCodOpCai/{id}")
	public Boolean deleteOpCaisse(@PathVariable(name = "id") String id) {

		return this.opCaisseService.delete(id);
	}

	@GetMapping(path = "opcaisse/byContribu/{valeur}")
	public List<OpCaisse> getOpCaisseByContribuable(@PathVariable(name = "valeur") String valeur) {

		return this.opCaisseService.findByContribuale(valeur);
	}

	@GetMapping(path = "opcaisse/jdh/usId={id}")
	public List<OpCaisse> getDailyOpUser(@PathVariable(name = "id") Long id) {

		return this.opCaisseService.userOpDaily(id);
	}

	@GetMapping(path = "opcaisse/byDatOpCai/{valeur}")
	public List<OpCaisse> getOpCaisseByDateOpCaisse(@PathVariable(name = "valeur") Date valeur) {

		return this.opCaisseService.findByDateOpCaisse(valeur);
	}

	@GetMapping(path = "opcaisse/byModPaiem/{valeur}")
	public List<OpCaisse> getOpCaisseByModePaiement(@PathVariable(name = "valeur") String valeur) {

		return this.opCaisseService.findByModePaiement(valeur);
	}

	@GetMapping(path = "opcaisse/byTypRecet/{valeur}")
	public List<OpCaisse> getOpCaisseByTypeRecette(@PathVariable(name = "valeur") String valeur) {

		return this.opCaisseService.findByTypeRecette(valeur);
	}

	@GetMapping(path = "opcaisse/byUser/{user}/byDate/{dat}")
	public List<OpCaisse> userOpCbyDate(Long user, Date dat) {
		return this.opCaisseService.userOpOfDayAndCais(user, dat);
	}

	@GetMapping(path = "opcaisse/byUser/{user}")
	public List<OpCaisse> opByUser(@PathVariable(name = "user") Long user) {
		return this.opCaisseService.userOp(user);
	}

	/*
	 * ###########################################################################
	 * ############# Partie réservée pour ligne opération caisse #################
	 * #############################################################################
	 */

	@GetMapping(path = "ligneOpCaisse/list")
	public List<LigneOpCaisse> getAllLigneOpCaisse() {

		return this.ligneOpCaisseService.getAll();
	}

	@GetMapping(path = "ligneOpCaisse/list/anl")
	public List<LigneOpCaisse> ligneOpCaisseAnnule() {

		return this.ligneOpCaisseService.ligneOpannulees();
	}

	@GetMapping(path = "ligneOpCaisse/list/vld")
	public List<LigneOpCaisse> LigneOpCaisseValides() {

		return this.ligneOpCaisseService.ligneOpValides();
	}

	@GetMapping(path = "ligneOpCaisse/byCodLigOpCai/{id}")
	public LigneOpCaisse getLigneOpCaisseById(@PathVariable(name = "id") Long id) {

		return this.ligneOpCaisseService.getByid(id);
	}

	@PostMapping(path = "ligneOpCaisse/byNumOp/{num}")
	public LigneOpCaisse createLigneOpCaisse(@RequestBody LigneOpCaisse ligneOpCaisse) {
		/*
		 * LigneOpCaisse lo=new LigneOpCaisse();
		 * lo.setArticle(ligneOpCaisse.getArticle());
		 * lo.setCommentaireLigneOperCaisse(ligneOpCaisse.getCommentaireLigneOperCaisse(
		 * )); lo.setLivre(false); lo.setOpCaisse(ligneOpCaisse.getOpCaisse());
		 * lo.setPrixLigneOperCaisse(ligneOpCaisse.getPrixLigneOperCaisse());
		 * lo.setQteLigneOperCaisse(ligneOpCaisse.getQteLigneOperCaisse());
		 */
		return this.ligneOpCaisseService.save(ligneOpCaisse);
	}

	@PutMapping(path = "ligneOpCaisse/byCodLigOpCai/{id}")
	public LigneOpCaisse updateLigneOpCaisse(@PathVariable(name = "id") Long id, @RequestBody LigneOpCaisse ligneOpCaisse) {

		return this.ligneOpCaisseService.edit(ligneOpCaisse, id);
	}

	//Léonel
	//Validation de livraison par un livreur (Correspondant interne)
	@GetMapping(path = "ligneOpCaisse/livraison/{id}/{idUser}")
	public LigneOpCaisse updateLigneOpCaisseAndLivre(@PathVariable(name = "id") Long id, @PathVariable(name = "idUser") Long idUser) {

		Optional<LigneOpCaisse> ligneOpCaisseALivre = Optional.of(ligneOpCaisseRepository.findById(id).get());
		Optional<Correspondant> CorrespondantLivreur = correspondantService.finCorrespondantByUserId(idUser);
		//Magsin du correspondant
		Optional <Magasin> magasinCorrespondant = Optional.ofNullable(gererService.findMagasinByNumMagasinier(CorrespondantLivreur.get().getMagasinier().getNumMAgasinier()));
		LigneOpCaisse ligneOpCaisse = ligneOpCaisseALivre.get();
		//Optional<Magasin> magasinLivreur

		if (ligneOpCaisseALivre.isPresent() && magasinCorrespondant.isPresent()){

			stockerService.updateStockByArticleAndMagasin(ligneOpCaisse.getArticle().getCodeArticle(), magasinCorrespondant.get().getCodeMagasin(), (long) ligneOpCaisseALivre.get().getQteLigneOperCaisse());
		}

		ligneOpCaisse.setLivre(true);
		ligneOpCaisse.setMagasin(magasinCorrespondant.get());



		return this.ligneOpCaisseService.edit(ligneOpCaisse, id);



	}

	//Léonel
	//Magasin by userId
	@GetMapping(path = "magasin/{idUser}")
	public  Magasin findMagasinByUserId(@PathVariable(name = "idUser") Long idUser){

		Optional<Correspondant> CorrespondantLivreur = correspondantService.finCorrespondantByUserId(idUser);
		//Magsin du correspondant
		Optional <Magasin> magasinCorrespondant = Optional.ofNullable(gererService.findMagasinByNumMagasinier(CorrespondantLivreur.get().getMagasinier().getNumMAgasinier()));

		if (magasinCorrespondant.isPresent()){

			return  magasinCorrespondant.get();
		}
		else {
			return  null;
		}


	}


	@DeleteMapping(path = "ligneOpCaisse/byCodLigOpCai/{id}")
	public Boolean deleteLigneOpCaisse(@PathVariable(name = "id") Long id) {

		return this.ligneOpCaisseService.delete(id);
	}

	@GetMapping(path = "ligneOpCaisse/byCodArti/{valeur}")
	public List<LigneOpCaisse> getLigneOpCaisseByArticle(@PathVariable(name = "valeur") String valeur) {

		List<LigneOpCaisse> res = new ArrayList<LigneOpCaisse>();
		if (this.articleService.findByCodeArticle(valeur).isEmpty() == false) {
			res = this.ligneOpCaisseService.getByArticle(this.articleService.findByCodeArticle(valeur).get(0));
			return res;
		}
		return res;
	}

	@GetMapping(path = "ligneOpCaisse/numOp/{numoc}")
	public List<LigneOpCaisse> getLigneOpCaisseByOC(@PathVariable(name = "numoc") String numoc) {
		return this.ligneOpCaisseService.findLigneByOP(numoc);
	}

	@GetMapping(path = "ligneOpCaisse/byPriLig/{valeur}")
	public List<LigneOpCaisse> getLigneOpCaisseByPrixLigne(@PathVariable(name = "valeur") Long valeur) {

		return this.ligneOpCaisseService.getByPrixLigne(valeur);
	}

	@GetMapping(path = "ligneOpCaisse/byQteLig/{valeur}")
	public List<LigneOpCaisse> getLigneOpCaisseByQteLigne(@PathVariable(name = "valeur") Long valeur) {

		return this.ligneOpCaisseService.getByQteLigne(valeur);
	}

	@PostMapping(path = "/op/listV")
	public OpCaisse savingVente(@RequestBody OpPrestBlock block) {
		return opCaisseService.saveVente(block);
	}

	@PostMapping(path = "/op/listL")
	public OpCaisse savingLoyer(@RequestBody OpLocBlock block) {
		return opCaisseService.saveLoyer(block);
	}
	/*
	 * @PostMapping(path = "/op/listI") public OpCaisse savingImput(@RequestBody
	 * OpPointBlock block) { return opCaisseService.saveImput(block); }
	 * 
	 * 
	 * ########################################################### #############
	 * Partie réservée pour reversement
	 * ###########################################################
	 */

	@GetMapping(path = "reversement/list")
	public List<Reversement> getAllReversement() {

		return this.reversementService.getAll();
	}

	@GetMapping(path = "reversement/byCodRev/{id}")
	public Optional<Reversement> getReversementById(@PathVariable(name = "id") String id) {

		return this.reversementService.findById(id);
	}

	@PostMapping(path = "reversement/list")
	public Reversement createReversement(@RequestBody Reversement reversement) {

		return this.reversementService.save(reversement);
	}

	@PutMapping(path = "reversement/byCodRev/{id}")
	public Reversement updateReversement(@PathVariable(name = "id") String id, @RequestBody Reversement reversement) {

		return this.reversementService.edit(id, reversement);
	}

	@DeleteMapping(path = "reversement/byCodRev/{id}")
	public Boolean deleteReversement(@PathVariable(name = "id") String id) {

		return this.reversementService.delete(id);
	}

	@GetMapping(path = "reversement/byDatRev/{valeur}")
	public List<Reversement> getReversementByDateReversement(@PathVariable(name = "valeur") Date valeur) {

		return this.reversementService.findByDateReversement(valeur);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour ligne reversement
	 * ###########################################################
	 */

	@GetMapping(path = "ligneReversement/list")
	public List<LigneReversement> getAllLigneReversement() {

		return this.ligneReversementService.findAll();
	}

	@GetMapping(path = "ligneReversement/byCodLigRev/{id}")
	public Optional<LigneReversement> getLigneReversementById(@PathVariable(name = "id") Long id) {

		return this.ligneReversementService.findById(id);
	}

	@PostMapping(path = "ligneReversement/list")
	public LigneReversement createLigneReversement(@RequestBody LigneReversement ligneReversement) {

		return this.ligneReversementService.save(ligneReversement);
	}

	@PutMapping(path = "ligneReversement/byCodLigRev/{id}")
	public LigneReversement updateLigneReversement(@PathVariable(name = "id") Long id,
			@RequestBody LigneReversement ligneReversement) {

		return this.ligneReversementService.edit(ligneReversement, id);
	}

	@DeleteMapping(path = "ligneReversement/byCodLigRev/{id}")
	public Boolean deleteLigneReversement(@PathVariable(name = "id") Long id) {

		return this.ligneReversementService.delete(id);
	}

	@GetMapping(path = "ligneReversement/byBeneficiai/{valeur}")
	public List<LigneReversement> getLigneReversementByBeneficiaire(@PathVariable(name = "valeur") String valeur) {

		return this.ligneReversementService.findBybeneficiairex(valeur);
	}

	@GetMapping(path = "ligneReversement/byPriLig/{valeur}")
	public List<LigneReversement> getLigneReversementByPrixLigne(@PathVariable(name = "valeur") Long valeur) {

		return this.ligneReversementService.findByPrix(valeur);
	}

	@GetMapping(path = "ligneReversement/byQuittance/{valeur}")
	public List<LigneReversement> getLigneReversementByQuittance(@PathVariable(name = "valeur") String valeur) {

		return this.ligneReversementService.findByQuittance(valeur);
	}

	@GetMapping(path = "ligneReversement/byQteLigRev/{valeur}")
	public List<LigneReversement> getLigneReversementByQteLigne(@PathVariable(name = "valeur") Long valeur) {

		return this.ligneReversementService.findByQte(valeur);
	}

	@GetMapping(path = "ligneReversement/byDatQuittanc/{valeur}")
	public List<LigneReversement> getLigneReversementByDateQuittance(@PathVariable(name = "valeur") Date valeur) {

		return this.ligneReversementService.findByDate(valeur);
	}

	//Léonel essaie
	@PostMapping("/find/date-between")
	public List<OpCaisse> findOpcaisseOfDay(@RequestBody SearchOpCaisseDTO searchOpCaisseDTO) {

		LocalDateTime start = LocalDateTime.of(LocalDate.from(searchOpCaisseDTO.getStartDate()), LocalTime.of(0, 0, 0));
		LocalDateTime end = LocalDateTime.of(LocalDate.from(searchOpCaisseDTO.getEndDate()), LocalTime.of(23, 59, 59));

		List<OpCaisse> opCaisseOfDayList = opCaisseRepository.getAllOpCaisseOfDay(start, end,  searchOpCaisseDTO.getCodeCaisse());

		return opCaisseOfDayList;


	}

	//Léonel essaie 2
	@PostMapping("/find/lines-opcaisse-by-periode-caisse")
	public List<LigneOpCaisse> findLinesOpcaisseByPeriode(@RequestBody SearchLinesOpCaisseDTO searchLinesOpCaisseDTO) {

		//LocalDateTime start = LocalDateTime.of(LocalDate.from(searchOpCaisseDTO.getStartDate()), LocalTime.of(0, 0, 0));
		//LocalDateTime end = LocalDateTime.of(LocalDate.from(searchOpCaisseDTO.getEndDate()), LocalTime.of(23, 59, 59));


		List<LigneOpCaisse> LinesOpCaisseByPeriodeList = ligneOpCaisseRepository.getAllLinesOpCaisseBetweenTwoPeriodeAndCaisse(searchLinesOpCaisseDTO.getStartDateTime(),searchLinesOpCaisseDTO.getEndDateTime(),searchLinesOpCaisseDTO.getCodeCaisse());

		return LinesOpCaisseByPeriodeList;
	}

}
