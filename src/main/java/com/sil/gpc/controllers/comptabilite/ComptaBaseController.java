package com.sil.gpc.controllers.comptabilite;

import java.util.List;

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

@RestController
@CrossOrigin
@RequestMapping(path = "/perfora-gpc/v1/compta/")
public class ComptaBaseController {
	
	private final CompteService compteService;
	private final TypeAmortService typeAmortService;
	private final AssocierService associerService;
	private final JournalService journalService;
	private final LocalisationService localisationService;
	private final EtatImmoService etatImmoService;
	private final ActiviteService activiteService;
	private final NatureJournalService natureJournalService;
	private  final TypeBudgetService typeBudgetservice;
	private final BudgetService budgetService;
	private  final  AffectComptToCaisseService affectComptToCaisseService;

	public ComptaBaseController(CompteService compteService, TypeAmortService typeAmortService, AssocierService associerService, JournalService journalService, LocalisationService localisationService, EtatImmoService etatImmoService, ActiviteService activiteService, NatureJournalService natureJournalService, TypeBudgetService typeBudgetservice, BudgetService budgetService, AffectComptToCaisseService affecteCompteToCaisseService) {
		this.compteService = compteService;
		this.typeAmortService = typeAmortService;
		this.associerService = associerService;
		this.journalService = journalService;
		this.localisationService = localisationService;
		this.etatImmoService = etatImmoService;
		this.activiteService = activiteService;
		this.natureJournalService = natureJournalService;
		this.typeBudgetservice = typeBudgetservice;
		this.budgetService = budgetService;
		this.affectComptToCaisseService = affecteCompteToCaisseService;
	}
	/*
	 * ####################### 
	 * Partie réservée pour Compte
	 * ##########################
	 */

	@GetMapping(path = "compte/list")
	public List<Compte> getAllCompte() {
		return this.compteService.getAll();
	}

	@GetMapping(path = "compte/byTyp/{t}")
	public List<Compte> getCompteByType(String t) {
		return this.compteService.comptesParType(t);
	}

	@GetMapping(path = "compte/byCodCom/{id}")
	public Compte geCompteById(@PathVariable(name = "id") Long id) {
		return this.compteService.getById(id);
	}


	@PostMapping(path = "compte/list")
	public Compte createCompte(@RequestBody Compte compte) {
		return this.compteService.add(compte);
	}

	@PutMapping(path = "compte/byCodCom/{id}")
	public Compte updateCompte(@PathVariable(name = "id") Long id, @RequestBody Compte compte) {

		return this.compteService.edit(id, compte);
	}

	@DeleteMapping(path = "compte/byCodCom/{id}")
	public Boolean deleteCompte(@PathVariable(name = "id") Long id) {

		return this.compteService.delete(id);
	}

	
	/*
	 * ####################### 
	 * Partie réservée pour TypeAmort
	 * ##########################
	 */

	
	@GetMapping(path = "typeAmort/list")
	public List<TypeAmort> getAllTypeAmort() {
		return this.typeAmortService.getAll();
	}

	@GetMapping(path = "typeAmort/byCodTypAmo/{id}")
	public TypeAmort getTypeAmortById(@PathVariable(name = "id") Long id) {
		return this.typeAmortService.getById(id);
	}


	@PostMapping(path = "typeAmort/list")
	public TypeAmort createTypeAmort(@RequestBody TypeAmort typeAmort) {
		return this.typeAmortService.add(typeAmort);
	}

	@PutMapping(path = "typeAmort/byCodTypAmo/{id}")
	public TypeAmort updateTypeAmort(@PathVariable(name = "id") Long id, @RequestBody TypeAmort typeAmort) {

		return this.typeAmortService.edit(id, typeAmort);
	}

	@DeleteMapping(path = "typeAmort/byCodTypAmo/{id}")
	public Boolean deleteTypeAmort(@PathVariable(name = "id") Long id) {

		return this.typeAmortService.delete(id);
	}
	
	
	
	
	/*
	 * ####################### 
	 * Partie réservée pour Associer
	 * ##########################
	 */
	
	@GetMapping(path = "associer/list")
	public List<Associer> getAllAssocier() {
		return this.associerService.getAll();
	}

	@GetMapping(path = "associer/byCodAsso/{id}")
	public Associer getAssocierById(@PathVariable(name = "id") Long id) {
		return this.associerService.getById(id);
	}


	@PostMapping(path = "associer/list")
	public Associer createAssocier(@RequestBody Associer associer) {
		return this.associerService.add(associer);
	}

	@PutMapping(path = "associer/byCodAsso/{id}")
	public Associer updateAssocier(@PathVariable(name = "id") Long id, @RequestBody Associer associer) {

		return this.associerService.edit(id, associer);
	}

	@DeleteMapping(path = "associer/byCodAsso/{id}")
	public Boolean deleteAssocier(@PathVariable(name = "id") Long id) {

		return this.associerService.delete(id);
	}
	
	
	
	/*
	 * ####################### 
	 * Partie réservée pour Journal
	 * ##########################
	 */

	@GetMapping(path = "compte/jn/{id}")
	public List<Compte> getEligible(@PathVariable (name = "id") Long id){
		return journalService.getEligible(id);
	}

	@GetMapping(path = "journal/!cod/{cjrn}")
	public List<Journal> getAutresJournaux(@PathVariable(name = "cjrn") String cjrn) {
		return this.journalService.getAutre(cjrn);
	}

	@GetMapping(path = "journal/list")
	public List<Journal> getAllJournal() {
		return this.journalService.getAll();
	}

	@GetMapping(path = "journal/byCodJour/{id}")
	public Journal getJournalById(@PathVariable(name = "id") Long id) {
		return this.journalService.getById(id);
	}


	@PostMapping(path = "journal/list")
	public Journal createJournal(@RequestBody Journal journal) {
		return this.journalService.add(journal);
	}

	@PutMapping(path = "journal/byCodJour/{id}")
	public Journal updateJournal(@PathVariable(name = "id") Long id, @RequestBody Journal journal) {

		return this.journalService.edit(id, journal);
	}

	@DeleteMapping(path = "journal/byCodJour/{id}")
	public Boolean deleteJournal(@PathVariable(name = "id") Long id) {

		return this.journalService.delete(id);
	}
	
	
	/*
	 * ####################### 
	 * Partie réservée pour Localisation
	 * ##########################
	 */
	

		@GetMapping(path = "localisation/list")
		public List<Localisation> getAllLocalisation() {
			return this.localisationService.getAll();
		}
	
		@GetMapping(path = "localisation/byCodLocali/{id}")
		public Localisation getLocalisationById(@PathVariable(name = "id") Long id) {
			return this.localisationService.getById(id);
		}
	
	
		@PostMapping(path = "localisation/list")
		public Localisation createLocalisation(@RequestBody Localisation localisation) {
			return this.localisationService.add(localisation);
		}
	
		@PutMapping(path = "localisation/byCodLocali/{id}")
		public Localisation updateLocalisation(@PathVariable(name = "id") Long id, @RequestBody Localisation localisation) {
	
			return this.localisationService.edit(id, localisation);
		}
	
		@DeleteMapping(path = "localisation/byCodLocali/{id}")
		public Boolean deleteLocalisation(@PathVariable(name = "id") Long id) {
	
			return this.localisationService.delete(id);
		}
		
		
		/*
		 * ####################### 
		 * Partie réservée pour EtatImmo
		 * ##########################
		 */
		

			@GetMapping(path = "etatImmo/list")
			public List<EtatImmo> getAllEtatImmo() {
				return this.etatImmoService.getAll();
			}
		
			@GetMapping(path = "etatImmo/byCodEtaImm/{id}")
			public EtatImmo getEtatImmoById(@PathVariable(name = "id") Long id) {
				return this.etatImmoService.getById(id);
			}
		
		
			@PostMapping(path = "etatImmo/list")
			public EtatImmo createEtatImmo(@RequestBody EtatImmo etatImmo) {
				return this.etatImmoService.add(etatImmo);
			}
		
			@PutMapping(path = "etatImmo/byCodEtaImm/{id}")
			public EtatImmo updateEtatImmo(@PathVariable(name = "id") Long id, @RequestBody EtatImmo etatImmo) {
		
				return this.etatImmoService.edit(id, etatImmo);
			}
		
			@DeleteMapping(path = "etatImmo/byCodEtaImm/{id}")
			public Boolean deleteEtatImmo(@PathVariable(name = "id") Long id) {
		
				return this.etatImmoService.delete(id);
			}
			
			
			/*
			 * ####################### 
			 * Partie réservée pour Activite
			 * ##########################
			 */
			

				@GetMapping(path = "activite/list")
				public List<Activite> getAllActivite() {
					return this.activiteService.getAll();
				}
			
				@GetMapping(path = "activite/byCodAct/{id}")
				public Activite getActiviteById(@PathVariable(name = "id") Long id) {
					return this.activiteService.getById(id);
				}
			
			
				@PostMapping(path = "activite/list")
				public Activite createActivite(@RequestBody Activite activite) {
					return this.activiteService.add(activite);
				}
			
				@PutMapping(path = "activite/byCodAct/{id}")
				public Activite updateActivite(@PathVariable(name = "id") Long id, @RequestBody Activite activite) {
			
					return this.activiteService.edit(id, activite);
				}
			
				@DeleteMapping(path = "activite/byCodAct/{id}")
				public Boolean deleteActivite(@PathVariable(name = "id") Long id) {
			
					return this.activiteService.delete(id);
				}


	/*
	 * #######################
	 * Partie réservée pour NatureJournal
	 * ##########################
	 */


	@GetMapping(path = "natureJournal/list")
	public List<NatureJournal> getAllNatureJournal() {
		return this.natureJournalService.getAll();
	}

	@GetMapping(path = "natureJournal/byCodNatJour/{id}")
	public NatureJournal getNatureJournalById(@PathVariable(name = "id") Long id) {
		return this.natureJournalService.getById(id);
	}


	@PostMapping(path = "natureJournal/list")
	public NatureJournal createNatureJournal(@RequestBody NatureJournal natureJournal) {
		return this.natureJournalService.add(natureJournal);
	}

	@PutMapping(path = "natureJournal/byCodNatJour/{id}")
	public NatureJournal updateNatureJournal(@PathVariable(name = "id") Long id, @RequestBody NatureJournal natureJournal) {

		return this.natureJournalService.edit(id, natureJournal);
	}

	@DeleteMapping(path = "natureJournal/byCodNatJour/{id}")
	public Boolean deleteNatureJournal(@PathVariable(name = "id") Long id) {

		return this.natureJournalService.delete(id);
	}
	/*
	 * #######################
	 * Partie réservée pour typeBudget
	 * ##########################
	 */


	@GetMapping(path = "natBud/list")
	public List<TypeBudget> getAllTypeBudget() {
		return this.typeBudgetservice.getAll();
	}

	@GetMapping(path = "natBud/byCodNat/{id}")
	public TypeBudget getTypeBudgetById(@PathVariable(name = "id") Long id) {
		return this.typeBudgetservice.getById(id);
	}


	@PostMapping(path = "natBud/list")
	public TypeBudget createTypeBudget(@RequestBody TypeBudget tBudg) {
		return this.typeBudgetservice.add(tBudg);
	}

	@PutMapping(path = "natBug/byCodNat/{id}")
	public TypeBudget updateTypeBudget(@PathVariable(name = "id") Long id, @RequestBody TypeBudget tBdg) {

		return this.typeBudgetservice.edit(id, tBdg);
	}

	@DeleteMapping(path = "natBug/byCodNat/{id}")
	public Boolean deleteTypeBudget(@PathVariable(name = "id") Long id) {

		return this.typeBudgetservice.delete(id);
	}
	/*
	 * #######################
	 * Partie réservée pour Budget
	 * ##########################
	 */


	@GetMapping(path = "bdg/list")
	public List<Budget> getAllBudget() {
		return this.budgetService.getAll();
	}

	@GetMapping(path = "bdg/byIdBdg/{id}")
	public Budget getBudgetById(@PathVariable(name = "id") Long id) {
		return this.budgetService.getById(id);
	}


	@PostMapping(path = "bdg/list")
	public Budget createBudget(@RequestBody Budget bdg) {
		return this.budgetService.add(bdg);
	}

	@PutMapping(path = "bdg/byIdBdg/{id}")
	public Budget updateBudget(@PathVariable(name = "id") Long id, @RequestBody Budget bdg) {

		return this.budgetService.edit(id, bdg);
	}

	@DeleteMapping(path = "bdg/byIdBdg/{id}")
	public Boolean deleteBudget(@PathVariable(name = "id") Long id) {

		return this.budgetService.delete(id);
	}


	/*
	 * #######################
	 * Partie réservée pour AffectComptToCaisse
	 * ##########################
	 */


	@GetMapping(path = "affectComptToCaisse/list")
	public List<AffectComptToCaisse> getAllAffectComptToCaisse() {
		return this.affectComptToCaisseService.getAll();
	}

	@GetMapping(path = "affectComptToCaisse/byCodAffComToCai/{id}")
	public AffectComptToCaisse getAffectComptToCaisseById(@PathVariable(name = "id") Long id) {
		return this.affectComptToCaisseService.getById(id);
	}


	@PostMapping(path = "affectComptToCaisse/list")
	public AffectComptToCaisse createAffectComptToCaisse(@RequestBody AffectComptToCaisse affectComptToCaisse) {
		return this.affectComptToCaisseService.add(affectComptToCaisse);
	}

	@PutMapping(path = "affectComptToCaisse/byCodAffComToCai/{id}")
	public AffectComptToCaisse updateAffectComptToCaisse(@PathVariable(name = "id") Long id, @RequestBody AffectComptToCaisse affectComptToCaisse) {

		return this.affectComptToCaisseService.edit(id, affectComptToCaisse);
	}

	@DeleteMapping(path = "affectComptToCaisse/byCodAffComToCai/{id}")
	public Boolean deleteAffectComptToCaisse(@PathVariable(name = "id") Long id) {

		return this.affectComptToCaisseService.delete(id);
	}

}
