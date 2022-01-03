package com.sil.gpc.controllers.stock;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sil.gpc.domains.*;
import com.sil.gpc.encapsuleurs.EncapApprovisionnement;
import com.sil.gpc.encapsuleurs.EncapPlacement;
import com.sil.gpc.repositories.StockerRepository;
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
	private  final StockerRepository stockerRepository;
	private  final GererService gererService;

	public MairieController(ApprovisionnementService approvisionnementService, LigneApproService ligneApproService,
			PlacementService placementService, LignePlacementService lignePlacementService,
			RecollementService recollementService, LigneRecollementService ligneRecollementService,
			RegisseurService regisseurService, PlageNumDispoService pds, StockerService s, StockerRepository stockerRepository,
	         GererService gererService) {
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
		this.stockerRepository = stockerRepository;
		this.gererService = gererService;
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

	//Léonel

	@PostMapping(path = "approvisionnement/list2")
	public EncapApprovisionnement createEncapApprovisionnement(@RequestBody EncapApprovisionnement encapApprovisionnement){

		List<LigneAppro> lignes = encapApprovisionnement.getLigneAppros();


		Approvisionnement element = this.approvisionnementService.save(encapApprovisionnement.getApprovisionnement());

		for (int i = 0; i < lignes.size(); i++) {
			System.out.println("data"+lignes.get(i));
			LigneAppro lig = lignes.get(i);
			lig.setAppro(element);

			lignes.set(i, lig);
		}

		//parcourir afin d'ajuster le stock

		for (int j = 0 ; j < lignes.size(); j++){
			ligneApproService.save(lignes.get(j));

			//update stock pour le caveau Mairie
			stk.updateOrAddStockByArticleAndMagasin(lignes.get(j).getLigneDA().getArticle().getCodeArticle(),"CM", (long) lignes.get(j).getQuantiteLigneAppro());

			//update stock pour le caveau Trésor
			stk.updateStockByArticleAndMagasin(lignes.get(j).getLigneDA().getArticle().getCodeArticle(),"CT", (long) lignes.get(j).getQuantiteLigneAppro());

		}

		return new EncapApprovisionnement(element, lignes);

	}

	@PutMapping(path = "approvisionnement/byCodApp/{id}")
	public Approvisionnement updateApprovisionnement(@PathVariable(name = "id") String id,
			@RequestBody Approvisionnement approvisionnement) {

		return this.approvisionnementService.edit(id, approvisionnement);
	}

	@PutMapping(path = "approvisionnement/byCodAppro2/{id}")
	public Boolean updateEncapApprovisionnement(@PathVariable(name = "id") String id, @RequestBody EncapApprovisionnement encapApprovisionnement) {

		List<LigneAppro> oldLignesAppros = new ArrayList<>();

		List<LigneAppro> newLignesAppros = new ArrayList<>();

		LigneAppro deletedLignesAppros = new LigneAppro();

		LigneAppro	savedLignesAppros = new LigneAppro();


		for(int i = 0; i < this.ligneApproService.findAll().size(); i++) {
			if(this.ligneApproService.findAll().get(i).getAppro().getNumAppro().equalsIgnoreCase(id)) {
				oldLignesAppros.add(this.ligneApproService.findAll().get(i));
			}
		}

		newLignesAppros.addAll(encapApprovisionnement.getLigneAppros());

		for (int a = 0 ; a < newLignesAppros.size(); a++){

			//System.out.println("new "+newLignesReceptions.get(a).getLigneCommande().getArticle().getCodeArticle());

			boolean existInReceptionOrNotExist = false;

			for ( int b = 0 ; b < oldLignesAppros.size(); b++){

				//System.out.println("old "+oldLignesReceptions.get(b).getLigneCommande().getArticle().getCodeArticle());

				if (oldLignesAppros.get(b).getLigneDA().getArticle().getCodeArticle().equals(newLignesAppros.get(a).getLigneDA().getArticle().getCodeArticle())){

					//Recuperer le stock pour savoir si c'est une modification ou un ajout
					Optional<Stocker> stockerLine = stockerRepository.findByArticle_CodeArticleAndMagasin_CodeMagasin(newLignesAppros.get(a).getLigneDA().getArticle().getCodeArticle(), "CT");
					Optional<Stocker> stockerLineCM = stockerRepository.findByArticle_CodeArticleAndMagasin_CodeMagasin(newLignesAppros.get(a).getLigneDA().getArticle().getCodeArticle(), "CM");

					// Cas ou la quantité receptionnée pour la ligne est supérieur à la quantité à receptionnée
					if (oldLignesAppros.get(b).getQuantiteLigneAppro() > newLignesAppros.get(a).getQuantiteLigneAppro()){

						//stocker Caveau Trésor
						if (stockerLine.isPresent()){

							stk.updateOrAddStockByArticleAndMagasin(newLignesAppros.get(a).getLigneDA().getArticle().getCodeArticle(), "CT", (long) (oldLignesAppros.get(b).getQuantiteLigneAppro() -  newLignesAppros.get(a).getQuantiteLigneAppro()));

						}
						//stocker Caveau Mairie
						if (stockerLineCM.isPresent()){

							stk.updateStockByArticleAndMagasin(newLignesAppros.get(a).getLigneDA().getArticle().getCodeArticle(), "CM", (long) (oldLignesAppros.get(b).getQuantiteLigneAppro() -  newLignesAppros.get(a).getQuantiteLigneAppro()));

						}
						//stocker Caveau Trésor
						if (!stockerLine.isPresent()){

							stk.updateOrAddStockByArticleAndMagasin(newLignesAppros.get(a).getLigneDA().getArticle().getCodeArticle(), "CT", (long) (newLignesAppros.get(a).getQuantiteLigneAppro()));

						}

						//stocker Caveau Mairie
						if (!stockerLineCM.isPresent()){

							stk.updateStockByArticleAndMagasin(newLignesAppros.get(a).getLigneDA().getArticle().getCodeArticle(), "CM", (long) (newLignesAppros.get(a).getQuantiteLigneAppro()));

						}

						ligneApproService.edit(newLignesAppros.get(a).getIdLigneAppro(), newLignesAppros.get(a));
						existInReceptionOrNotExist = true;
					}
					// Cas ou la quantité receptionnée pour la ligne est inférieur à la quantité à receptionnée
					else if (oldLignesAppros.get(b).getQuantiteLigneAppro() < newLignesAppros.get(a).getQuantiteLigneAppro()){
						//System.out.println("true 2");
						if (stockerLine.isPresent()){

							stk.updateStockByArticleAndMagasin(newLignesAppros.get(a).getLigneDA().getArticle().getCodeArticle(), "CT", (long) (newLignesAppros.get(a).getQuantiteLigneAppro() - oldLignesAppros.get(b).getQuantiteLigneAppro() ));

						}

						if (stockerLineCM.isPresent()){

							stk.updateOrAddStockByArticleAndMagasin(newLignesAppros.get(a).getLigneDA().getArticle().getCodeArticle(), "CM", (long) (newLignesAppros.get(a).getQuantiteLigneAppro() - oldLignesAppros.get(b).getQuantiteLigneAppro() ));

						}

						if (!stockerLine.isPresent()){

							stk.updateStockByArticleAndMagasin(newLignesAppros.get(a).getLigneDA().getArticle().getCodeArticle(), "CT", (long) (newLignesAppros.get(a).getQuantiteLigneAppro()));
						}

						//Caveau Mairie
						if (!stockerLineCM.isPresent()){

							stk.updateOrAddStockByArticleAndMagasin(newLignesAppros.get(a).getLigneDA().getArticle().getCodeArticle(), "CM", (long) (newLignesAppros.get(a).getQuantiteLigneAppro()));
						}

						ligneApproService.edit(newLignesAppros.get(a).getIdLigneAppro(), newLignesAppros.get(a));
						existInReceptionOrNotExist = true;
					}
					//Cas ou la quantité receptionnée est égale à la quantité à receptionner lors de la modification
					else  if(oldLignesAppros.get(b).getQuantiteLigneAppro() == newLignesAppros.get(a).getQuantiteLigneAppro()){

						existInReceptionOrNotExist = true;
					}



				}


			}
			// Après avoir faire le parcours de tous la liste des anciennes lignes receptions il ne retrouve le nouveau element
			//alors il faut une insertion  du ce nouveau ligne reception et un réajustement du stock en augmentation au caveau Trésor
			if (existInReceptionOrNotExist == false){

				savedLignesAppros = newLignesAppros.get(a);
				savedLignesAppros.setAppro(approvisionnementService.findById(id).get());
				ligneApproService.save(savedLignesAppros);

				//Caveau Trésor
				stk.updateStockByArticleAndMagasin(savedLignesAppros.getLigneDA().getArticle().getCodeArticle(), "CT", (long) savedLignesAppros.getQuantiteLigneAppro());

				//Caveau Mairie
				stk.updateOrAddStockByArticleAndMagasin(savedLignesAppros.getLigneDA().getArticle().getCodeArticle(), "CM", (long) savedLignesAppros.getQuantiteLigneAppro());

			}
		}


		// Cas ou une ligne reception était receptionnée et n'est plus à réceptionner lors de la modification
		// Rechercher une ancienne ligne receptionnée dans la liste des nouvelles lignes à receptionner dans la liste
		if (oldLignesAppros.size() > newLignesAppros.size()){

			for (int l = 0 ; l < oldLignesAppros.size(); l++){

				boolean oldOneLinesReceptionNotExistOnNewLinesReceptionList = false;

				for (int m = 0 ; m < newLignesAppros.size(); m++){

					if (oldLignesAppros.get(l).getLigneDA().getArticle().getCodeArticle().equals(newLignesAppros.get(m).getLigneDA().getArticle().getCodeArticle()) ){

						oldOneLinesReceptionNotExistOnNewLinesReceptionList = true;

					}

				}

				if (oldOneLinesReceptionNotExistOnNewLinesReceptionList == false){

					deletedLignesAppros = oldLignesAppros.get(l);

					//Caveau Trésor
					stk.updateOrAddStockByArticleAndMagasin(deletedLignesAppros.getLigneDA().getArticle().getCodeArticle(), "CT", (long) deletedLignesAppros.getQuantiteLigneAppro());

					//Caveau Mairie
					stk.updateStockByArticleAndMagasin(deletedLignesAppros.getLigneDA().getArticle().getCodeArticle(), "CM", (long) deletedLignesAppros.getQuantiteLigneAppro());
					ligneApproService.delete(deletedLignesAppros.getIdLigneAppro());
				}

			}

		}

		approvisionnementService.edit(id, encapApprovisionnement.getApprovisionnement());


		// vérification de la satisfaction de la Demande d'Approvisionnement



		return true;
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

	//Léonel

	@PostMapping(path = "placement/list2")
	public EncapPlacement createEncapEncapPlacement(@RequestBody EncapPlacement encapPlacement){

		List<LignePlacement> lignes = encapPlacement.getLignePlacements();

		Optional <Magasin> magasinCorrespondant = Optional.ofNullable(gererService.findMagasinByNumMagasinier(encapPlacement.getPlacement().getCorrespondant().getMagasinier().getNumMAgasinier()));


		Placement element = this.placementService.save(encapPlacement.getPlacement());

		for (int i = 0; i < lignes.size(); i++) {
			System.out.println("data"+lignes.get(i));
			LignePlacement lig = lignes.get(i);
			lig.setPlacement(element);

			lignes.set(i, lig);
		}

		//parcourir afin d'ajuster le stock

		for (int j = 0 ; j < lignes.size(); j++){
			lignePlacementService.save(lignes.get(j));

			//update stock pour le Correspondant
			//Vérifier si le magasin est présent ou existe
			if (magasinCorrespondant.isPresent()){

				stk.updateOrAddStockByArticleAndMagasin(lignes.get(j).getArticle().getCodeArticle(), magasinCorrespondant.get().getCodeMagasin(), (long) lignes.get(j).getQuantiteLignePlacement());

			}

			//update stock pour le caveau Mairie
			stk.updateStockByArticleAndMagasin(lignes.get(j).getArticle().getCodeArticle(),"CM", (long) lignes.get(j).getQuantiteLignePlacement());

		}

		return new EncapPlacement(element, lignes);

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

	//Léonel updated placement
	@PutMapping(path = "placement/update/{id}")
	public Boolean updateEncapPlacement(@PathVariable(name = "id") String id, @RequestBody EncapPlacement encapPlacement) {

		List<LignePlacement> oldLignesPlacements = new ArrayList<>();

		List<LignePlacement> newLignesPlacements = new ArrayList<>();

		LignePlacement deletedLignesPlacements  = new LignePlacement();

		LignePlacement	savedLignesPlacements  = new LignePlacement();

		//Magsin du correspondant
		Optional <Magasin> magasinCorrespondant = Optional.ofNullable(gererService.findMagasinByNumMagasinier(encapPlacement.getPlacement().getCorrespondant().getMagasinier().getNumMAgasinier()));


		for(int i = 0; i < this.lignePlacementService.findAll().size(); i++) {
			if(this.lignePlacementService.findAll().get(i).getPlacement().getNumPlacement().equalsIgnoreCase(id)) {
				oldLignesPlacements.add(this.lignePlacementService.findAll().get(i));
			}
		}

		newLignesPlacements.addAll(encapPlacement.getLignePlacements());

		for (int a = 0 ; a < newLignesPlacements.size(); a++){

			//System.out.println("new "+newLignesReceptions.get(a).getLigneCommande().getArticle().getCodeArticle());

			boolean existInReceptionOrNotExist = false;

			for ( int b = 0 ; b < oldLignesPlacements.size(); b++){

				//System.out.println("old "+oldLignesReceptions.get(b).getLigneCommande().getArticle().getCodeArticle());

				if (oldLignesPlacements.get(b).getArticle().getCodeArticle().equals(newLignesPlacements.get(a).getArticle().getCodeArticle())){

					//Recuperer le stock pour savoir si c'est une modification ou un ajout

					Optional<Stocker> stockerLineCM = stockerRepository.findByArticle_CodeArticleAndMagasin_CodeMagasin(newLignesPlacements.get(a).getArticle().getCodeArticle(), "CM");
					Optional<Stocker> stockerLineCorrespondant= stockerRepository.findByArticle_CodeArticleAndMagasin_CodeMagasin(newLignesPlacements.get(a).getArticle().getCodeArticle(), magasinCorrespondant.get().getCodeMagasin());

					// Cas ou la quantité receptionnée pour la ligne est supérieur à la quantité à receptionnée
					if (oldLignesPlacements.get(b).getQuantiteLignePlacement() > newLignesPlacements.get(a).getQuantiteLignePlacement()){

						//stocker Caveau Mairie
						if (stockerLineCM.isPresent()){

							stk.updateOrAddStockByArticleAndMagasin(newLignesPlacements.get(a).getArticle().getCodeArticle(), "CM", (long) (oldLignesPlacements.get(b).getQuantiteLignePlacement() -  newLignesPlacements.get(a).getQuantiteLignePlacement()));

						}
						//stocker du  Correspondant
						if (stockerLineCorrespondant.isPresent()){

							stk.updateStockByArticleAndMagasin(newLignesPlacements.get(a).getArticle().getCodeArticle(), magasinCorrespondant.get().getCodeMagasin(), (long) (oldLignesPlacements.get(b).getQuantiteLignePlacement()-  newLignesPlacements.get(a).getQuantiteLignePlacement()));

						}
						//stocker Caveau Mairie
						if (!stockerLineCM.isPresent()){

							stk.updateOrAddStockByArticleAndMagasin(newLignesPlacements.get(a).getArticle().getCodeArticle(), "CM", (long) (newLignesPlacements.get(a).getQuantiteLignePlacement()));

						}

						//stocker  Correspondant
						if (!stockerLineCorrespondant.isPresent()){

							stk.updateStockByArticleAndMagasin(newLignesPlacements.get(a).getArticle().getCodeArticle(), magasinCorrespondant.get().getCodeMagasin(), (long) (newLignesPlacements.get(a).getQuantiteLignePlacement()));

						}

						lignePlacementService.edit(newLignesPlacements.get(a), newLignesPlacements.get(a).getIdLignePlacement());
						existInReceptionOrNotExist = true;
					}
					// Cas ou la quantité receptionnée pour la ligne est inférieur à la quantité à receptionnée
					else if (oldLignesPlacements.get(b).getQuantiteLignePlacement() < newLignesPlacements.get(a).getQuantiteLignePlacement()){

						if (stockerLineCM.isPresent()){

							stk.updateStockByArticleAndMagasin(newLignesPlacements.get(a).getArticle().getCodeArticle(), "CM", (long) (newLignesPlacements.get(a).getQuantiteLignePlacement() - oldLignesPlacements.get(b).getQuantiteLignePlacement() ));

						}

						if (stockerLineCorrespondant.isPresent()){

							stk.updateOrAddStockByArticleAndMagasin(newLignesPlacements.get(a).getArticle().getCodeArticle(), magasinCorrespondant.get().getCodeMagasin(), (long) (newLignesPlacements.get(a).getQuantiteLignePlacement() - oldLignesPlacements.get(b).getQuantiteLignePlacement() ));

						}

						if (!stockerLineCM.isPresent()){

							stk.updateStockByArticleAndMagasin(newLignesPlacements.get(a).getArticle().getCodeArticle(), "CM", (long) (newLignesPlacements.get(a).getQuantiteLignePlacement()));
						}

						//Stock Correspondant
						if (!stockerLineCM.isPresent()){

							stk.updateOrAddStockByArticleAndMagasin(newLignesPlacements.get(a).getArticle().getCodeArticle(), magasinCorrespondant.get().getCodeMagasin(), (long) (newLignesPlacements.get(a).getQuantiteLignePlacement()));
						}

						lignePlacementService.edit(newLignesPlacements.get(a), newLignesPlacements.get(a).getIdLignePlacement());
						existInReceptionOrNotExist = true;
					}
					//Cas ou la quantité receptionnée est égale à la quantité à receptionner lors de la modification
					else  if(oldLignesPlacements.get(b).getQuantiteLignePlacement() == newLignesPlacements.get(a).getQuantiteLignePlacement()){

						existInReceptionOrNotExist = true;
					}



				}


			}
			// Après avoir faire le parcours de tous la liste des anciennes lignes receptions il ne retrouve le nouveau element
			//alors il faut une insertion  du ce nouveau ligne reception et un réajustement du stock en augmentation au caveau Trésor
			if (existInReceptionOrNotExist == false){

				savedLignesPlacements = newLignesPlacements.get(a);
				savedLignesPlacements.setPlacement(placementService.findById(id).get());
				lignePlacementService.save(savedLignesPlacements);

				//Caveau Mairie
				stk.updateStockByArticleAndMagasin(savedLignesPlacements.getArticle().getCodeArticle(), "CM", (long) savedLignesPlacements.getQuantiteLignePlacement());

				//Stock du Correspondant
				stk.updateOrAddStockByArticleAndMagasin(savedLignesPlacements.getArticle().getCodeArticle(), magasinCorrespondant.get().getCodeMagasin(), (long) savedLignesPlacements.getQuantiteLignePlacement());

			}
		}


		// Cas ou une ligne reception était receptionnée et n'est plus à réceptionner lors de la modification
		// Rechercher une ancienne ligne receptionnée dans la liste des nouvelles lignes à receptionner dans la liste
		if (oldLignesPlacements.size() > newLignesPlacements.size()){

			for (int l = 0 ; l < oldLignesPlacements.size(); l++){

				boolean oldOneLinesReceptionNotExistOnNewLinesReceptionList = false;

				for (int m = 0 ; m < newLignesPlacements.size(); m++){

					if (oldLignesPlacements.get(l).getArticle().getCodeArticle().equals(newLignesPlacements.get(m).getArticle().getCodeArticle()) ){

						oldOneLinesReceptionNotExistOnNewLinesReceptionList = true;

					}

				}

				if (oldOneLinesReceptionNotExistOnNewLinesReceptionList == false){

					deletedLignesPlacements = oldLignesPlacements.get(l);

					//Caveau Mairie
					stk.updateOrAddStockByArticleAndMagasin(deletedLignesPlacements.getArticle().getCodeArticle(), "CM", (long) deletedLignesPlacements.getQuantiteLignePlacement());

					//Stock du Correspondant
					stk.updateStockByArticleAndMagasin(deletedLignesPlacements.getArticle().getCodeArticle(), magasinCorrespondant.get().getCodeMagasin(), (long) deletedLignesPlacements.getQuantiteLignePlacement());
					lignePlacementService.delete(deletedLignesPlacements.getIdLignePlacement());
				}

			}

		}

		placementService.edit(encapPlacement.getPlacement(), id);


		// vérification de la satisfaction de la Demande d'Approvisionnement



		return true;
	}

	//Annulation de Placement
	@PutMapping(path = "placement/annulation/{id}")
	public Placement annulerPlacement(@PathVariable(name = "id") String id, @RequestBody Placement placement) {

		List<LignePlacement> oldLignesPlacements = new ArrayList<>();


		//Magsin du correspondant
		Optional <Magasin> magasinCorrespondant = Optional.ofNullable(gererService.findMagasinByNumMagasinier(placement.getCorrespondant().getMagasinier().getNumMAgasinier()));


		for(int i = 0; i < this.lignePlacementService.findAll().size(); i++) {
			if(this.lignePlacementService.findAll().get(i).getPlacement().getNumPlacement().equalsIgnoreCase(id)) {
				oldLignesPlacements.add(this.lignePlacementService.findAll().get(i));
			}
		}

		//Annulation se passera au niveau du Caveau Mairie et le Stocker du Correspondant
		for (int i = 0; i < oldLignesPlacements.size(); i++){

			//Caveau Mairie
			stk.updateOrAddStockByArticleAndMagasin(oldLignesPlacements.get(i).getArticle().getCodeArticle(), "CM", (long) oldLignesPlacements.get(i).getQuantiteLignePlacement());

			//Stock du Correspondant
			stk.updateStockByArticleAndMagasin(oldLignesPlacements.get(i).getArticle().getCodeArticle(), magasinCorrespondant.get().getCodeMagasin(), (long) oldLignesPlacements.get(i).getQuantiteLignePlacement());
		}


		return this.placementService.annulEdit(placement, id);
	}



	@DeleteMapping(path = "placement/byCodPla/{id}")
	public Boolean deletePlacement(@PathVariable(name = "id") String id) {

		return this.placementService.delete(id);
	}

	//Léo Delete Placement
	@DeleteMapping(path = "placement/delete/{id}")
	public Boolean deletedPlacement(@PathVariable(name = "id") String id) {

		List<LignePlacement> oldLignesPlacements = new ArrayList<>();

		for(int i = 0; i < this.lignePlacementService.findAll().size(); i++) {
			if(this.lignePlacementService.findAll().get(i).getPlacement().getNumPlacement().equalsIgnoreCase(id)) {
				oldLignesPlacements.add(this.lignePlacementService.findAll().get(i));
			}
		}

		for (int i = 0; i < oldLignesPlacements.size(); i++){
			lignePlacementService.delete(oldLignesPlacements.get(i).getIdLignePlacement());
		}


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
