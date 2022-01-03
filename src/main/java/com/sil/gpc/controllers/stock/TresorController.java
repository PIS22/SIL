package com.sil.gpc.controllers.stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sil.gpc.domains.*;
import com.sil.gpc.encapsuleurs.EncapCommande;
import com.sil.gpc.encapsuleurs.EncapDemandeApprovisionnement;
import com.sil.gpc.encapsuleurs.EncapReception;
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
public class TresorController {

	private final TresComService tresComService;
	private final CommandeService commandeService;
	private final LigneCommandeService ligneCommandeService;
	private final ReceptionService receptionService;
	private final LigneReceptionService ligneReceptionService;
	private final DemandeApproService demandeApproService;
	private final LigneDemandeApproService ligneDemandeApproService;
	private  final StockerService stockerService;
	private  final StockerRepository stockerRepository;
	
	public TresorController(TresComService tresComService, CommandeService commandeService,
			LigneCommandeService ligneCommandeService, ReceptionService receptionService,
			LigneReceptionService ligneReceptionService, DemandeApproService demandeApproService,
			LigneDemandeApproService ligneDemandeApproService, StockerService stockerService,
			StockerRepository stockerRepository) {
		super();
		this.tresComService = tresComService;
		this.commandeService = commandeService;
		this.ligneCommandeService = ligneCommandeService;
		this.receptionService = receptionService;
		this.ligneReceptionService = ligneReceptionService;
		this.demandeApproService = demandeApproService;
		this.ligneDemandeApproService = ligneDemandeApproService;
		this.stockerService = stockerService;
		this.stockerRepository = stockerRepository;
	}
	
	/*###########################################################
	#############	Partie réservée pour TresCom
	###########################################################
	*/
	
	@GetMapping(path = "rp/list")
	public List<TresCom> getAllRp(){
		
		return this.tresComService.getAll();
	}
	
	@GetMapping(path = "rp/byCodRp/{id}")
	public Optional<TresCom> getRpById(@PathVariable(name = "id") String id){
		
		return this.tresComService.findById(id);
	}
	
	@PostMapping(path = "rp/list")
	public TresCom createRp( @RequestBody TresCom tresCom) {
		
		return this.tresComService.save(tresCom);
	}
	
	@PutMapping(path = "rp/byCodRp/{id}")
	public TresCom updateRp(@PathVariable(name = "id") String id, @RequestBody TresCom tresCom) {
		
		return this.tresComService.edit(id, tresCom);
	}
	
	@DeleteMapping(path = "rp/byCodRp/{id}")
	public Boolean deleteRp(@PathVariable(name = "id") String id) {
		
		return this.tresComService.delete(id);
	}
	

	/*###########################################################
	#############	Partie réservée pour commande
	###########################################################
	*/
	
	@GetMapping(path = "commande/list")
	public List<Commande> getAllCommande(){
		
		return this.commandeService.getAll();
	}
	
	@GetMapping(path = "commande/byCodCom/{id}")
	public Commande getCommandeById(@PathVariable(name = "id") String id){
		
		return this.commandeService.getById(id);
	}
	
	@PostMapping(path = "commande/list")
	public Commande createCommande( @RequestBody Commande commande) {

		return this.commandeService.save(commande);
	}


	// Commande avec encapsulation
	//Léonel

	@PostMapping(path = "commande/list2")
	public EncapCommande createEncapCommande(@RequestBody EncapCommande encapCommande){

		List<LigneCommande> lignes =encapCommande.getLigneCommandes();

		Commande element = this.commandeService.save(encapCommande.getCommande());

		for (int i = 0; i < lignes.size(); i++) {
			LigneCommande lig = lignes.get(i);
			lig.setNumCommande(element);

			lignes.set(i, lig);
		}

		lignes = this.ligneCommandeService.saveAll(lignes);

		return new EncapCommande(element, lignes);

	}

	
	@PutMapping(path = "commande/byCodCom/{id}")
	public Commande updateCommande(@PathVariable(name = "id") String id, @RequestBody Commande commande) {
		
		return this.commandeService.edit(id, commande);
	}

	//Modification de la commande
	//Léonel
	@PutMapping(path = "commande/update/{id}")
	public Boolean updateEncapCommande(@PathVariable(name = "id") String id, @RequestBody EncapCommande encapCommande) {

		List<LigneCommande> oldLignesCommande  = new ArrayList<>();

		List<LigneCommande> newLignesCommande  = new ArrayList<>();

		LigneCommande  deletedLignesCommande  = new LigneCommande();

		LigneCommande	savedLignesCommande  = new LigneCommande();


		for(int i = 0; i < this.ligneCommandeService.getAll().size(); i++) {
			if(this.ligneCommandeService.getAll().get(i).getNumCommande().getNumCommande().equalsIgnoreCase(id)) {
				oldLignesCommande.add(this.ligneCommandeService.getAll().get(i));
			}
		}

		newLignesCommande.addAll(encapCommande.getLigneCommandes());

		for (int a = 0 ; a < newLignesCommande.size(); a++){

			//System.out.println("new "+newLignesReceptions.get(a).getLigneCommande().getArticle().getCodeArticle());

			boolean existInReceptionOrNotExist = false;

			for ( int b = 0 ; b < oldLignesCommande.size(); b++){

				//System.out.println("old "+oldLignesReceptions.get(b).getLigneCommande().getArticle().getCodeArticle());

				if (oldLignesCommande.get(b).getArticle().getCodeArticle().equals(newLignesCommande.get(a).getArticle().getCodeArticle())){



					// Cas ou la quantité receptionnée pour la ligne est supérieur à la quantité à receptionnée
					if (oldLignesCommande.get(b).getQteLigneCommande()> newLignesCommande.get(a).getQteLigneCommande()){

						ligneCommandeService.edit(newLignesCommande.get(a).getIdLigneCommande(), newLignesCommande.get(a));
						existInReceptionOrNotExist = true;
					}
					// Cas ou la quantité receptionnée pour la ligne est inférieur à la quantité à receptionnée
					else if (oldLignesCommande.get(b).getQteLigneCommande() < newLignesCommande.get(a).getQteLigneCommande()){


						ligneCommandeService.edit(newLignesCommande.get(a).getIdLigneCommande(), newLignesCommande.get(a));
						existInReceptionOrNotExist = true;
					}
					//Cas ou la quantité receptionnée ets égale à la quantité à receptionner lors de la modification
					else  if(oldLignesCommande.get(b).getQteLigneCommande() == newLignesCommande.get(a).getQteLigneCommande()){

						existInReceptionOrNotExist = true;
					}



				}


			}
			// Après avoir faire le parcours de tous la liste des anciennes lignes receptions il ne retrouve le nouveau element
			//alors il faut une insertion  du ce nouveau ligne reception et un réajustement du stock en augmentation au caveau Trésor
			if (existInReceptionOrNotExist == false){
				savedLignesCommande = newLignesCommande.get(a);
				savedLignesCommande.setNumCommande(commandeService.getById(id));
				ligneCommandeService.save(savedLignesCommande);
			}
		}


		// Cas ou une ligne reception était receptionnée et n'est plus à réceptionner lors de la modification
		// Rechercher une ancienne ligne receptionnée dans la liste des nouvelles lignes à receptionner dans la liste
		if (oldLignesCommande.size() > newLignesCommande.size()){

			for (int l = 0 ; l < oldLignesCommande.size(); l++){

				boolean oldOneLinesReceptionNotExistOnNewLinesReceptionList = false;

				for (int m = 0 ; m < newLignesCommande.size(); m++){

					if (oldLignesCommande.get(l).getArticle().getCodeArticle().equals(newLignesCommande.get(m).getArticle().getCodeArticle()) ){

						oldOneLinesReceptionNotExistOnNewLinesReceptionList = true;

					}

				}

				if (oldOneLinesReceptionNotExistOnNewLinesReceptionList == false){

					deletedLignesCommande = oldLignesCommande.get(l);
					ligneCommandeService.delete(deletedLignesCommande.getIdLigneCommande());
				}

			}

		}

		commandeService.edit(id, encapCommande.getCommande());


		return true;
	}

	@DeleteMapping(path = "commande/byCodCom/{id}")
	public Boolean deleteCommande(@PathVariable(name = "id") String id) {
		
		return this.commandeService.delete(id);
	}

	//Léo Delete Commande
	@DeleteMapping(path = "commande/delete/{id}")
	public Boolean deletedCommande(@PathVariable(name = "id") String id) {

		List<LigneCommande> oldLignesLigneLigneCommandes = new ArrayList<>();

		for(int i = 0; i < this.ligneCommandeService.getAll().size(); i++) {
			if(this.ligneCommandeService.getAll().get(i).getNumCommande().getNumCommande().equalsIgnoreCase(id)) {
				oldLignesLigneLigneCommandes.add(this.ligneCommandeService.getAll().get(i));
			}
		}

		for (int i = 0; i < oldLignesLigneLigneCommandes.size(); i++){
			ligneCommandeService.delete(oldLignesLigneLigneCommandes.get(i).getIdLigneCommande());
		}


		return this.commandeService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour lignes commande
	###########################################################
	*/
	
	@GetMapping(path = "ligneCommande/list")
	public List<LigneCommande> getAllLigneCommande(){
		
		return this.ligneCommandeService.getAll();
	}
	
	@GetMapping(path = "ligneCommande/byCodLigCom/{id}")
	public Optional<LigneCommande> getLigneCommandeById(@PathVariable(name = "id") Long id){
		
		return this.ligneCommandeService.getById(id);
	}
	
	@PostMapping(path = "ligneCommande/list")
	public LigneCommande createLigneCommande( @RequestBody LigneCommande ligneCommande) {
		
		return this.ligneCommandeService.save(ligneCommande);
	}
	
	@PutMapping(path = "ligneCommande/byCodLigCom/{id}")
	public LigneCommande updateLigneCommande(@PathVariable(name = "id") Long id, @RequestBody LigneCommande ligneCommande) {
		
		return this.ligneCommandeService.edit(id, ligneCommande);
	}
	
	@DeleteMapping(path = "ligneCommande/byCodLigCom/{id}")
	public Boolean deleteLigneCommande(@PathVariable(name = "id") Long id) {
		
		return this.ligneCommandeService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour reception
	###########################################################
	*/
	
	@GetMapping(path = "reception/list")
	public List<Reception> getAllReception(){
		
		return this.receptionService.getAll();
	}
	
	@GetMapping(path = "reception/byCodRec/{id}")
	public Optional<Reception> getReceptionById(@PathVariable(name = "id") String id){
		
		return this.receptionService.findById(id);
	}
	
	@PostMapping(path = "reception/list")
	public Reception createReception( @RequestBody Reception reception) {
		
		return this.receptionService.save(reception);
	}

	//Léonel

	@PostMapping(path = "reception/list2")
	public EncapReception createEncapReception(@RequestBody EncapReception encapReception){

		List<LigneReception> lignes =encapReception.getLigneReceptions();

		Reception element = this.receptionService.save(encapReception.getReception());

		for (int i = 0; i < lignes.size(); i++) {
			LigneReception lig = lignes.get(i);
			lig.setReception(element);

			lignes.set(i, lig);
		}

		//lignes = this.ligneReceptionService.saveAll(lignes);
		//parcourir afin d'ajuster le stock

		for (int j = 0 ; j < lignes.size(); j++){
			ligneReceptionService.save(lignes.get(j));
			stockerService.updateOrAddStockByArticleAndMagasin(lignes.get(j).getLigneCommande().getArticle().getCodeArticle(),"CT", (long) lignes.get(j).getQuantiteLigneReception());

		}

		return new EncapReception(element, lignes);

	}
	
	@PutMapping(path = "reception/byCodRec/{id}")
	public Reception updateReception(@PathVariable(name = "id") String id, @RequestBody Reception reception) {
		
		return this.receptionService.edit(id, reception);
	}

	@PutMapping(path = "reception/byCodRec2/{id}")
	public Boolean updateEncapRecaption(@PathVariable(name = "id") String id, @RequestBody EncapReception encapReception) {

		List<LigneReception> oldLignesReceptions = new ArrayList<>();

		List<LigneReception> newLignesReceptions = new ArrayList<>();

		LigneReception  deletedLignesReceptions = new LigneReception();

	    LigneReception	savedLignesReceptions = new  LigneReception();


		for(int i = 0; i < this.ligneReceptionService.findAll().size(); i++) {
			if(this.ligneReceptionService.findAll().get(i).getReception().getNumReception().equalsIgnoreCase(id)) {
				oldLignesReceptions.add(this.ligneReceptionService.findAll().get(i));
			}
		}

		newLignesReceptions.addAll(encapReception.getLigneReceptions());

		for (int a = 0 ; a < newLignesReceptions.size(); a++){

			//System.out.println("new "+newLignesReceptions.get(a).getLigneCommande().getArticle().getCodeArticle());

			boolean existInReceptionOrNotExist = false;

			for ( int b = 0 ; b < oldLignesReceptions.size(); b++){

				//System.out.println("old "+oldLignesReceptions.get(b).getLigneCommande().getArticle().getCodeArticle());

				if (oldLignesReceptions.get(b).getLigneCommande().getArticle().getCodeArticle().equals(newLignesReceptions.get(a).getLigneCommande().getArticle().getCodeArticle())){

					//Recuperer le stock pour savoir si c'est une modification ou un ajout
					Optional<Stocker> stockerLine = stockerRepository.findByArticle_CodeArticleAndMagasin_CodeMagasin(newLignesReceptions.get(a).getLigneCommande().getArticle().getCodeArticle(), "CT");
					//System.out.println("true oui");
					// Cas ou la quantité receptionnée pour la ligne est supérieur à la quantité à receptionnée
					if (oldLignesReceptions.get(b).getQuantiteLigneReception() > newLignesReceptions.get(a).getQuantiteLigneReception()){
						//System.out.println("true 1");
						if (stockerLine.isPresent()){

							stockerService.updateStockByArticleAndMagasin(newLignesReceptions.get(a).getLigneCommande().getArticle().getCodeArticle(), "CT", (long) (oldLignesReceptions.get(b).getQuantiteLigneReception() -  newLignesReceptions.get(a).getQuantiteLigneReception()));

						}
						if (!stockerLine.isPresent()){

							stockerService.updateStockByArticleAndMagasin(newLignesReceptions.get(a).getLigneCommande().getArticle().getCodeArticle(), "CT", (long) (newLignesReceptions.get(a).getQuantiteLigneReception()));

						}

						ligneReceptionService.edit(newLignesReceptions.get(a), newLignesReceptions.get(a).getIdLigneReception());
						existInReceptionOrNotExist = true;
					}
 						// Cas ou la quantité receptionnée pour la ligne est inférieur à la quantité à receptionnée
					else if (oldLignesReceptions.get(b).getQuantiteLigneReception() < newLignesReceptions.get(a).getQuantiteLigneReception()){
						//System.out.println("true 2");
						if (stockerLine.isPresent()){

							stockerService.updateOrAddStockByArticleAndMagasin(newLignesReceptions.get(a).getLigneCommande().getArticle().getCodeArticle(), "CT", (long) (newLignesReceptions.get(a).getQuantiteLigneReception() - oldLignesReceptions.get(b).getQuantiteLigneReception() ));

						}

						if (!stockerLine.isPresent()){

							stockerService.updateOrAddStockByArticleAndMagasin(newLignesReceptions.get(a).getLigneCommande().getArticle().getCodeArticle(), "CT", (long) (newLignesReceptions.get(a).getQuantiteLigneReception()));
						}

						ligneReceptionService.edit(newLignesReceptions.get(a), newLignesReceptions.get(a).getIdLigneReception());
						existInReceptionOrNotExist = true;
					}
					//Cas ou la quantité receptionnée ets égale à la quantité à receptionner lors de la modification
					else  if(oldLignesReceptions.get(b).getQuantiteLigneReception() == newLignesReceptions.get(a).getQuantiteLigneReception()){

						existInReceptionOrNotExist = true;
					}



				}


			}
			// Après avoir faire le parcours de tous la liste des anciennes lignes receptions il ne retrouve le nouveau element
			//alors il faut une insertion  du ce nouveau ligne reception et un réajustement du stock en augmentation au caveau Trésor
			if (existInReceptionOrNotExist == false){
				//savedLignesReceptions.add(newLignesReceptions.get(a));
			    savedLignesReceptions = newLignesReceptions.get(a);
				savedLignesReceptions.setReception(receptionService.findById(id).get());
				ligneReceptionService.save(savedLignesReceptions);
				stockerService.updateOrAddStockByArticleAndMagasin(savedLignesReceptions.getLigneCommande().getArticle().getCodeArticle(), "CT", (long) savedLignesReceptions.getQuantiteLigneReception());

			}
		}


		// Cas ou une ligne reception était receptionnée et n'est plus à réceptionner lors de la modification
		// Rechercher une ancienne ligne receptionnée dans la liste des nouvelles lignes à receptionner dans la liste
		if (oldLignesReceptions.size() > newLignesReceptions.size()){

			for (int l = 0 ; l < oldLignesReceptions.size(); l++){

				boolean oldOneLinesReceptionNotExistOnNewLinesReceptionList = false;

				for (int m = 0 ; m < newLignesReceptions.size(); m++){

					if (oldLignesReceptions.get(l).getLigneCommande().getArticle().getCodeArticle().equals(newLignesReceptions.get(m).getLigneCommande().getArticle().getCodeArticle()) ){

						oldOneLinesReceptionNotExistOnNewLinesReceptionList = true;

					}

				}

				if (oldOneLinesReceptionNotExistOnNewLinesReceptionList == false){

					deletedLignesReceptions = oldLignesReceptions.get(l);
					stockerService.updateStockByArticleAndMagasin(deletedLignesReceptions.getLigneCommande().getArticle().getCodeArticle(), "CT", (long) deletedLignesReceptions.getQuantiteLigneReception());
					ligneReceptionService.delete(deletedLignesReceptions.getIdLigneReception());
				}

			}

		}

		receptionService.edit(id, encapReception.getReception());


		return true;
	}

	//Annulation de reception
	@PutMapping(path = "reception/annulation/{id}")
	public Reception annulerReception(@PathVariable(name = "id") String id, @RequestBody Reception reception) {

		List<LigneReception> oldLignesReceptions = new ArrayList<>();

		for(int i = 0; i < this.ligneReceptionService.findAll().size(); i++) {
			if(this.ligneReceptionService.findAll().get(i).getReception().getNumReception().equalsIgnoreCase(id)) {
				oldLignesReceptions.add(this.ligneReceptionService.findAll().get(i));
			}
		}
		for (int i = 0; i < oldLignesReceptions.size(); i++){
			stockerService.updateStockByArticleAndMagasin(oldLignesReceptions.get(i).getLigneCommande().getArticle().getCodeArticle(), "CT", (long) oldLignesReceptions.get(i).getQuantiteLigneReception());
		}

		return this.receptionService.edit(id, reception);
	}


	
	@DeleteMapping(path = "reception/byCodRec/{id}")
	public Boolean deleteReception(@PathVariable(name = "id") String id) {
		
		return this.receptionService.delete(id);
	}

	//Léo Delete Reception
	@DeleteMapping(path = "reception/delete/{id}")
	public Boolean deletedReception(@PathVariable(name = "id") String id) {

		List<LigneReception> oldLignesReceptions = new ArrayList<>();

		for(int i = 0; i < this.ligneReceptionService.findAll().size(); i++) {
			if(this.ligneReceptionService.findAll().get(i).getReception().getNumReception().equalsIgnoreCase(id)) {
				oldLignesReceptions.add(this.ligneReceptionService.findAll().get(i));
			}
		}

		for (int i = 0; i < oldLignesReceptions.size(); i++){
			ligneReceptionService.delete(oldLignesReceptions.get(i).getIdLigneReception());
		}


		return this.receptionService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour ligne reception
	###########################################################
	*/
	
	@GetMapping(path = "ligneReception/list")
	public List<LigneReception> getAllLigneReception(){
		
		return this.ligneReceptionService.findAll();
	}
	
	@GetMapping(path = "ligneReception/byCodLigRec/{id}")
	public Optional<LigneReception> getLigneReceptionById(@PathVariable(name = "id") Long id){
		
		return this.ligneReceptionService.findById(id);
	}
	
	@PostMapping(path = "ligneReception/list")
	public LigneReception createLigneReception( @RequestBody LigneReception ligneReception) {
		
		return this.ligneReceptionService.save(ligneReception);
	}
	
	@PutMapping(path = "ligneReception/byCodLigRec/{id}")
	public LigneReception updateLigneReception(@PathVariable(name = "id") Long id, @RequestBody LigneReception ligneReception) {
		
		return this.ligneReceptionService.edit(ligneReception, id);
	}
	
	@DeleteMapping(path = "ligneReception/byCodLigRec/{id}")
	public Boolean deleteLigneReception(@PathVariable(name = "id") Long id) {
		
		return this.ligneReceptionService.delete(id);
	}		
	
	
	
	/*###########################################################
	#############	Partie réservée pour demande appro
	###########################################################
	*/
	
	@GetMapping(path = "demandeAppro/list")
	public List<DemandeApprovisionnement> getAllDemandeAppro(){
		
		return this.demandeApproService.getAll();
	}
	
	@GetMapping(path = "demandeAppro/byCodDemApp/{id}")
	public Optional<DemandeApprovisionnement> getDemandeApproById(@PathVariable(name = "id") String id){
		
		return this.demandeApproService.getById(id);
	}
	
	@PostMapping(path = "demandeAppro/list")
	public DemandeApprovisionnement createDemandeAppro( @RequestBody DemandeApprovisionnement demandeApprovisionnement) {
		
		return this.demandeApproService.save(demandeApprovisionnement);
	}


	//Léonel

	@PostMapping(path = "demandeAppro/list2")
	public EncapDemandeApprovisionnement createEncapDemandeApprovisionnement(@RequestBody EncapDemandeApprovisionnement encapDemandeApprovisionnement){

		List<LigneDemandeAppro> lignes = encapDemandeApprovisionnement.getLigneDemandeAppros();


		DemandeApprovisionnement element = this.demandeApproService.save(encapDemandeApprovisionnement.getDemandeApprovisionnement());

		for (int i = 0; i < lignes.size(); i++) {
			LigneDemandeAppro lig = lignes.get(i);
			lig.setAppro(element);

			lignes.set(i, lig);
		}

		lignes = this.ligneDemandeApproService.saveAll(lignes);

		return new EncapDemandeApprovisionnement(element, lignes);

	}


	@PutMapping(path = "demandeAppro/byCodDemApp/{id}")
	public DemandeApprovisionnement updateDemandeAppro(@PathVariable(name = "id") String id, @RequestBody DemandeApprovisionnement demandeApprovisionnement) {
		
		return this.demandeApproService.edit(id, demandeApprovisionnement);
	}

	//Léonel
	@PutMapping(path = "demandeAppro/update/{id}")
	public Boolean updateEncapDemandeApprovisionnement(@PathVariable(name = "id") String id, @RequestBody EncapDemandeApprovisionnement encapDemandeApprovisionnement) {

		List<LigneDemandeAppro> oldLignesDemandeAppro = new ArrayList<>();

		List<LigneDemandeAppro> newLignesDemandeAppro = new ArrayList<>();

		LigneDemandeAppro  deletedLignesDemandeAppro = new LigneDemandeAppro();

		LigneDemandeAppro	savedLignesDemandeAppro = new LigneDemandeAppro();


		for(int i = 0; i < this.ligneDemandeApproService.getAll().size(); i++) {
			if(this.ligneDemandeApproService.getAll().get(i).getAppro().getNumDA().equalsIgnoreCase(id)) {
				oldLignesDemandeAppro.add(this.ligneDemandeApproService.getAll().get(i));
			}
		}

		newLignesDemandeAppro.addAll(encapDemandeApprovisionnement.getLigneDemandeAppros());

		for (int a = 0 ; a < newLignesDemandeAppro.size(); a++){

			//System.out.println("new "+newLignesReceptions.get(a).getLigneCommande().getArticle().getCodeArticle());

			boolean existInReceptionOrNotExist = false;

			for ( int b = 0 ; b < oldLignesDemandeAppro.size(); b++){

				//System.out.println("old "+oldLignesReceptions.get(b).getLigneCommande().getArticle().getCodeArticle());

				if (oldLignesDemandeAppro.get(b).getArticle().getCodeArticle().equals(newLignesDemandeAppro.get(a).getArticle().getCodeArticle())){



					// Cas ou la quantité receptionnée pour la ligne est supérieur à la quantité à receptionnée
					if (oldLignesDemandeAppro.get(b).getQuantiteDemandee()> newLignesDemandeAppro.get(a).getQuantiteDemandee()){

						ligneDemandeApproService.edit(newLignesDemandeAppro.get(a).getIdLigneDA(), newLignesDemandeAppro.get(a));
						existInReceptionOrNotExist = true;
					}
					// Cas ou la quantité receptionnée pour la ligne est inférieur à la quantité à receptionnée
					else if (oldLignesDemandeAppro.get(b).getQuantiteDemandee() < newLignesDemandeAppro.get(a).getQuantiteDemandee()){


						ligneDemandeApproService.edit(newLignesDemandeAppro.get(a).getIdLigneDA(), newLignesDemandeAppro.get(a));
						existInReceptionOrNotExist = true;
					}
					//Cas ou la quantité receptionnée ets égale à la quantité à receptionner lors de la modification
					else  if(oldLignesDemandeAppro.get(b).getQuantiteDemandee() == newLignesDemandeAppro.get(a).getQuantiteDemandee()){

						existInReceptionOrNotExist = true;
					}



				}


			}
			// Après avoir faire le parcours de tous la liste des anciennes lignes receptions il ne retrouve le nouveau element
			//alors il faut une insertion  du ce nouveau ligne reception et un réajustement du stock en augmentation au caveau Trésor
			if (existInReceptionOrNotExist == false){
				savedLignesDemandeAppro = newLignesDemandeAppro.get(a);
				savedLignesDemandeAppro.setAppro(demandeApproService.findById(id).get());
				ligneDemandeApproService.save(savedLignesDemandeAppro);
			}
		}


		// Cas ou une ligne reception était receptionnée et n'est plus à réceptionner lors de la modification
		// Rechercher une ancienne ligne receptionnée dans la liste des nouvelles lignes à receptionner dans la liste
		if (oldLignesDemandeAppro.size() > newLignesDemandeAppro.size()){

			for (int l = 0 ; l < oldLignesDemandeAppro.size(); l++){

				boolean oldOneLinesReceptionNotExistOnNewLinesReceptionList = false;

				for (int m = 0 ; m < newLignesDemandeAppro.size(); m++){

					if (oldLignesDemandeAppro.get(l).getArticle().getCodeArticle().equals(newLignesDemandeAppro.get(m).getArticle().getCodeArticle()) ){

						oldOneLinesReceptionNotExistOnNewLinesReceptionList = true;

					}

				}

				if (oldOneLinesReceptionNotExistOnNewLinesReceptionList == false){

					deletedLignesDemandeAppro = oldLignesDemandeAppro.get(l);
					ligneDemandeApproService.delete(deletedLignesDemandeAppro.getIdLigneDA());
				}

			}

		}

		demandeApproService.edit(id, encapDemandeApprovisionnement.getDemandeApprovisionnement());


		return true;
	}


	@DeleteMapping(path = "demandeAppro/byCodDemApp/{id}")
	public Boolean deleteDemandeAppro(@PathVariable(name = "id") String id) {
		
		return this.demandeApproService.delete(id);
	}

	//Léo Delete Demande Approvisionnement
	@DeleteMapping(path = "demandeAppro/delete/{id}")
	public Boolean deletedDemandeApprovisionnement(@PathVariable(name = "id") String id) {

		List<LigneDemandeAppro> oldLignesLigneDemandeAppros = new ArrayList<>();

		for(int i = 0; i < this.ligneDemandeApproService.getAll().size(); i++) {
			if(this.ligneDemandeApproService.getAll().get(i).getAppro().getNumDA().equalsIgnoreCase(id)) {
				oldLignesLigneDemandeAppros.add(this.ligneDemandeApproService.getAll().get(i));
			}
		}

		for (int i = 0; i < oldLignesLigneDemandeAppros.size(); i++){
			ligneDemandeApproService.delete(oldLignesLigneDemandeAppros.get(i).getIdLigneDA());
		}


		return this.demandeApproService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour ligne demande appro
	###########################################################
	*/
	
	@GetMapping(path = "ligneDemandeAppro/list")
	public List<LigneDemandeAppro> getAllLigneDemandeAppro(){
		
		return this.ligneDemandeApproService.getAll();
	}
	
	@GetMapping(path = "ligneDemandeAppro/byCodLigDemApp/{id}")
	public Optional<LigneDemandeAppro> getLigneDemandeApproById(@PathVariable(name = "id") Long id){
		
		return this.ligneDemandeApproService.getById(id);
	}
	
	@PostMapping(path = "ligneDemandeAppro/list")
	public LigneDemandeAppro createLigneDemandeAppro( @RequestBody LigneDemandeAppro ligneDemandeAppro) {
		
		return this.ligneDemandeApproService.save(ligneDemandeAppro);
	}
	
	@PutMapping(path = "ligneDemandeAppro/byCodLigDemApp/{id}")
	public LigneDemandeAppro updateLigneDemandeAppro(@PathVariable(name = "id") Long id, @RequestBody LigneDemandeAppro ligneDemandeAppro) {
		
		return this.ligneDemandeApproService.edit(id, ligneDemandeAppro);
	}
	
	@DeleteMapping(path = "ligneDemandeAppro/byCodLigDemApp/{id}")
	public Boolean deleteLigneDemandeAppro(@PathVariable(name = "id") Long id) {
		
		return this.ligneDemandeApproService.delete(id);
	}


	
	
	
}
