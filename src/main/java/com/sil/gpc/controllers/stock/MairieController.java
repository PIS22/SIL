package com.sil.gpc.controllers.stock;

import java.sql.Date;
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

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LignePlacement;
import com.sil.gpc.domains.LigneRecollement;
import com.sil.gpc.domains.Magasin;
import com.sil.gpc.domains.Placement;
import com.sil.gpc.domains.PlageNumDispo;
import com.sil.gpc.domains.Recollement;
import com.sil.gpc.domains.Regisseur;
import com.sil.gpc.domains.Stocker;
import com.sil.gpc.services.ApprovisionnementService;
import com.sil.gpc.services.LigneApproService;
import com.sil.gpc.services.LignePlacementService;
import com.sil.gpc.services.LigneRecollementService;
import com.sil.gpc.services.PlacementService;
import com.sil.gpc.services.PlageNumDispoService;
import com.sil.gpc.services.RecollementService;
import com.sil.gpc.services.RegisseurService;
import com.sil.gpc.services.StockerService;

@CrossOrigin
@RestController
@RequestMapping(path = "/perfora-gpc/v1/stock/")
public class MairieController {

	private final ApprovisionnementService approvisionnementService;
	private final LigneApproService ligneApproService;
	private final PlacementService placementService;
	private final LignePlacementService lignePlacementService;
	private final RecollementService recollementService;
	private final LigneRecollementService ligneRecollementService;
	private final RegisseurService regisseurService;
	private final PlageNumDispoService pds;
	private final StockerService stk;

	public MairieController(ApprovisionnementService approvisionnementService, LigneApproService ligneApproService,
			PlacementService placementService, LignePlacementService lignePlacementService,
			RecollementService recollementService, LigneRecollementService ligneRecollementService,
			RegisseurService regisseurService, PlageNumDispoService pds, StockerService s) {
		super();
		this.approvisionnementService = approvisionnementService;
		this.ligneApproService = ligneApproService;
		this.placementService = placementService;
		this.lignePlacementService = lignePlacementService;
		this.recollementService = recollementService;
		this.ligneRecollementService = ligneRecollementService;
		this.regisseurService = regisseurService;
		this.pds = pds;
		this.stk = s;
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour Approvisionnement
	 * ###########################################################
	 */

	@GetMapping(path = "approvisionnement/list")
	public List<Approvisionnement> getAllApprovisionnement() {

		return this.approvisionnementService.getAll();
	}

	@GetMapping(path = "approvisionnement/byCodApp/{id}")
	public Optional<Approvisionnement> getApprovisionnementById(@PathVariable(name = "id") String id) {

		return this.approvisionnementService.getById(id);
	}

	@PostMapping(path = "approvisionnement/list")
	public Approvisionnement createApprovisionnement(@RequestBody Approvisionnement approvisionnement) {

		return this.approvisionnementService.save(approvisionnement);
	}

	@PutMapping(path = "approvisionnement/byCodApp/{id}")
	public Approvisionnement updateApprovisionnement(@PathVariable(name = "id") String id,
			@RequestBody Approvisionnement approvisionnement) {

		return this.approvisionnementService.edit(id, approvisionnement);
	}

	@DeleteMapping(path = "approvisionnement/byCodApp/{id}")
	public Boolean deleteApprovisionnement(@PathVariable(name = "id") String id) {

		return this.approvisionnementService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour ligne approvisionnement
	 * ###########################################################
	 */

	@GetMapping(path = "ligneAppro/list")
	public List<LigneAppro> getAllLigneAppro() {

		return this.ligneApproService.getAll();
	}

	@GetMapping(path = "ligneAppro/byCodLigApp/{id}")
	public Optional<LigneAppro> getLigneApproById(@PathVariable(name = "id") Long id) {

		return this.ligneApproService.getById(id);
	}

	@PostMapping(path = "ligneAppro/list")
	public LigneAppro createLigneAppro(@RequestBody LigneAppro ligneAppro) {

		LigneAppro la = this.ligneApproService.save(ligneAppro);
		if (la != null && la.getLigneDA().getArticle().isNumSerieArticle()) {
			Long qte = (long) la.getQuantiteLigneAppro();
			List<PlageNumDispo> plageD = pds.premieresPlageDispoMag(la.getLigneDA().getArticle().getCodeArticle(),
					"CT");
			PlageNumDispo plagecourante = plageD.get(0);
			Long qt = plagecourante.getNumFinPlageDispo() - plagecourante.getNumDebPlageDispo() + 1;
			if (qte < qt) {
				PlageNumDispo np = new PlageNumDispo(plagecourante.getNumDebPlageDispo(),
						plagecourante.getNumDebPlageDispo(), plagecourante.getNumDebPlageDispo() + qte - 1,
						plagecourante.getNumDebPlageDispo() + qte - 1, plagecourante.getExercice(),
						plagecourante.getArticle(), new Magasin("CM", "Caveau Mairie"), null, la.getAppro(), null,
						null);
				System.out.println("Nouvelle plage" + np);
				if (pds.save(np) != null) {
					plagecourante.setNumDebPlageDispo(plagecourante.getNumDebPlageDispo() + qte);
					System.out.println("plage reaménagée: " + plagecourante);
					pds.edit(plagecourante, plagecourante.getCodePlageDispo());
				}
			} else {
				int i = 0;
				while (qte > 0) {
					plagecourante = plageD.get(i);
					qt = plagecourante.getNumFinPlageDispo() - plagecourante.getNumDebPlageDispo() + 1;
					if (qte >= qt) {
						plagecourante.setMagasin(new Magasin("CM", "Caveau mairie"));
						System.out.println("plage reaménagée: " + plagecourante);
						pds.edit(plagecourante, plagecourante.getCodePlageDispo());
					} else {
						PlageNumDispo np = new PlageNumDispo(plagecourante.getNumDebPlageDispo(),
								plagecourante.getNumDebPlageDispo(), plagecourante.getNumDebPlageDispo() + qte - 1,
								plagecourante.getNumDebPlageDispo() + qte - 1, plagecourante.getExercice(),
								plagecourante.getArticle(), new Magasin("CM", "Caveau Mairie"), null, la.getAppro(),
								null, null);
						System.out.println("Nouvelle plage" + np);
						if (pds.save(np) != null) {
							plagecourante.setNumDebPlageDispo(plagecourante.getNumDebPlageDispo() + qte);
							System.out.println("plage reaménagée: " + plagecourante);
							pds.edit(plagecourante, plagecourante.getCodePlageDispo());
						}
					}
					i++;
					qte -= qt;
				}
			}
		}
		Stocker stkMairie = stk.ligneStocker(ligneAppro.getLigneDA().getArticle(), "CM");
		stkMairie.setQuantiterStocker(stkMairie.getQuantiterStocker() + la.getQuantiteLigneAppro());
		stk.edit(stkMairie.getIdStocker(), stkMairie);
		Stocker stkTresor = stk.ligneStocker(ligneAppro.getLigneDA().getArticle(), "CT");
		stkTresor.setQuantiterStocker(stkTresor.getQuantiterStocker() + la.getQuantiteLigneAppro());
		stk.edit(stkTresor.getIdStocker(), stkTresor);
		return la;
	}

	@PutMapping(path = "ligneAppro/byCodLigApp/{id}")
	public LigneAppro updateLigneAppro(@PathVariable(name = "id") Long id, @RequestBody LigneAppro ligneAppro) {

		return this.ligneApproService.edit(id, ligneAppro);
	}

	@DeleteMapping(path = "ligneAppro/byCodLigApp/{id}")
	public Boolean deleteLigneAppro(@PathVariable(name = "id") Long id) {

		return this.ligneApproService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour Placement
	 * ###########################################################
	 */
	@GetMapping(path = "placement/list")
	public List<Placement> getAllPlacement() {

		return this.placementService.findAll();
	}

	@GetMapping(path = "placement/byCodPla/{id}")
	public Optional<Placement> getPlacementById(@PathVariable(name = "id") String id) {

		return this.placementService.findById(id);
	}

	@GetMapping(path = "placement/byExo/{exo}")
	public List<Placement> getPlacementByExercice(@PathVariable(name = "exo") Exercice exo) {

		return null;// this.placementService.findByExercice(exo); // utiliser l'objet Exercice et
					// non int
	}

	@GetMapping(path = "placement/byDatePla/{datePla}")
	public List<Placement> getPlacementByDate(@PathVariable(name = "datePla") Date datePla) {

		return this.placementService.findByDatePlacement(datePla); // nom de methode mal defini
	}

	@PostMapping(path = "placement/list")
	public Placement createPlacement(@RequestBody Placement placement) {

		return this.placementService.save(placement);
	}

	@PutMapping(path = "placement/byCodPla/{id}")
	public Placement updatePlacement(@PathVariable(name = "id") String id, @RequestBody Placement placement) {

		return this.placementService.edit(placement, id);
	}

	@DeleteMapping(path = "placement/byCodPla/{id}")
	public Boolean deletePlacement(@PathVariable(name = "id") String id) {

		return this.placementService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour Ligne placement
	 * ###########################################################
	 */
	@GetMapping(path = "lignePla/list")
	public List<LignePlacement> getAllLignePla() {

		return this.lignePlacementService.findAll();
	}

	@GetMapping(path = "lignePla/byCodLigPla/{id}")
	public Optional<LignePlacement> getLignePlaById(@PathVariable(name = "id") Long id) {

		return this.lignePlacementService.findById(id);
	}

	@GetMapping(path = "lignePla/Prix/{prix}")
	public List<LignePlacement> getLignePlaByPrix(@PathVariable(name = "prix") double prix) {

		return this.lignePlacementService.findByPrix(prix);
	}

	@GetMapping(path = "lignePla/Article/{art}")
	public List<LignePlacement> getLignePlaByArticle(@PathVariable(name = "art") Article art) {

		return this.lignePlacementService.findByArticle(art);
	}

	@PostMapping(path = "lignePla/list")
	public LignePlacement createLignePla(@RequestBody LignePlacement lignePla) {

		return this.lignePlacementService.save(lignePla);
	}

	@PutMapping(path = "lignePla/byCodLigPla/{id}")
	public LignePlacement updateLignePla(@PathVariable(name = "id") Long id, @RequestBody LignePlacement lignePla) {

		return this.lignePlacementService.edit(lignePla, id);
	}

	@DeleteMapping(path = "lignePla/byCodLiPla/{id}")
	public Boolean deleteLignePla(@PathVariable(name = "id") Long id) {

		return this.lignePlacementService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour Recollement
	 * ###########################################################
	 */
	@GetMapping(path = "recollement/list")
	public List<Recollement> getAllRecollement() {

		return this.recollementService.getAll();
	}

	@GetMapping(path = "recollement/byCodReco/{id}")
	public Optional<Recollement> getRecollementById(@PathVariable(name = "id") String id) {

		return this.recollementService.findById(id);
	}

	@GetMapping(path = "recollement/byDateReco/{dateReco}")
	public List<Recollement> getRecollementByDateRecollement(@PathVariable(name = "dateReco") Date dateReco) {

		return this.recollementService.findByDateRecollement(dateReco);
	}

	// @GetMapping(path = "recollement/byMag/{mag}")
	// public List<Recollement> getRecollementByMagasin(@PathVariable(name = "mag")
	// Magasin mag) {
//
	// return this.recollementService.findByMagasinRecollement(mag);
	// }

	@GetMapping(path = "recollement/byReg/{reg}")
	public List<Recollement> getRecollementByRegisseur(@PathVariable(name = "reg") Regisseur reg) {

		return this.recollementService.findByRegisseurRecollement(reg);
	}

	@GetMapping(path = "recollement/byExo/{exo}")
	public List<Recollement> getRecollementByExercice(@PathVariable(name = "exo") Exercice exo) {

		return this.recollementService.findByExerciceRecollement(exo);
	}

	@PostMapping(path = "recollement/list")
	public Recollement createRecollement(@RequestBody Recollement recollement) {

		return this.recollementService.save(recollement);
	}

	@PutMapping(path = "recollement/byCodReco/{id}")
	public Recollement updateRecollement(@PathVariable(name = "id") String id, @RequestBody Recollement recollement) {

		return this.recollementService.edit(id, recollement);
	}

	@DeleteMapping(path = "recollement/byCodReco/{id}")
	public Boolean deleteRecollement(@PathVariable(name = "id") String id) {

		return this.recollementService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour Ligne Recollement
	 * ###########################################################
	 */
	@GetMapping(path = "ligneRecoll/list")
	public List<LigneRecollement> getAllLigneRecoll() {

		return this.ligneRecollementService.findAll();
	}

	@GetMapping(path = "ligneRecoll/byCodLigRecoll/{id}")
	public Optional<LigneRecollement> getLigneRecollById(@PathVariable(name = "id") Long id) {

		return this.ligneRecollementService.FindById(id);
	}

	@GetMapping(path = "ligneRecoll/byPrixLigRecoll/{prix}")
	public List<LigneRecollement> getLigneRecollByPrix(@PathVariable(name = "prix") double prix) {

		return this.ligneRecollementService.findByPrix(prix);
	}

	@GetMapping(path = "ligneRecoll/byQteLigRecoll/{qte}")
	public List<LigneRecollement> getLigneRecollByQuantite(@PathVariable(name = "qte") double qte) {

		return this.ligneRecollementService.findByQte(qte);
	}

	@GetMapping(path = "ligneRecoll/byArticle/{art}")
	public List<LigneRecollement> getLigneRecollByQuantite(@PathVariable(name = "art") Article art) {

		return this.ligneRecollementService.findByArtice(art);
	}

	@PostMapping(path = "ligneRecoll/list")
	public LigneRecollement createLigneRecollement(@RequestBody LigneRecollement ligneRecoll) {

		return this.ligneRecollementService.save(ligneRecoll);
	}

	@PutMapping(path = "ligneRecoll/byCodLigRecoll/{id}")
	public LigneRecollement updateLigneRecollement(@PathVariable(name = "id") Long id,
			@RequestBody LigneRecollement ligneRecoll) {

		return this.ligneRecollementService.edit(ligneRecoll, id);
	}

	@DeleteMapping(path = "ligneRecoll/byCodLigRecoll/{id}")
	public Boolean deleteLigneRecollement(@PathVariable(name = "id") Long id) {

		return this.ligneRecollementService.delete(id);
	}

	/*
	 * ########################################################### #############
	 * Partie réservée pour Régisseur
	 * ###########################################################
	 */
	@GetMapping(path = "regisseur/list")
	public List<Regisseur> getAllRegisseur() {

		return this.regisseurService.getAll();
	}

	@GetMapping(path = "regisseur/byCodReg/{id}")
	public Optional<Regisseur> getRegisseurById(@PathVariable(name = "id") String id) {

		return this.regisseurService.findById(id);
	}

	@PostMapping(path = "regisseur/list")
	public Regisseur createRegisseur(@RequestBody Regisseur regisseur) {

		return this.regisseurService.save(regisseur);
	}

	@PutMapping(path = "regisseur/byCodReg/{id}")
	public Regisseur updateApprovisionnement(@PathVariable(name = "id") String id, @RequestBody Regisseur regisseur) {

		return this.regisseurService.edit(id, regisseur);
	}

	@DeleteMapping(path = "regisseur/byCodReg/{id}")
	public Boolean deleteRegisseur(@PathVariable(name = "id") String id) {

		return this.regisseurService.delete(id);
	}


}
