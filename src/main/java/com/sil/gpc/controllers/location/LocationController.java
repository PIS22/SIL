package com.sil.gpc.controllers.location;

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
import com.sil.gpc.domains.Contrat;
import com.sil.gpc.domains.Echeance;
import com.sil.gpc.domains.Immeuble;
import com.sil.gpc.domains.Locataire;
import com.sil.gpc.domains.PrixImmeuble;
import com.sil.gpc.domains.Quartier;
import com.sil.gpc.domains.TypeImmeuble;
import com.sil.gpc.services.ContratService;
import com.sil.gpc.services.EcheanceService;
import com.sil.gpc.services.ImmeubleService;
import com.sil.gpc.services.LocataireService;
import com.sil.gpc.services.PrixImmeubleService;
import com.sil.gpc.services.TypeImmeubleService;

@CrossOrigin
@RestController
@RequestMapping(path = "/perfora-gpc/v1/location/")
public class LocationController {

	private final ContratService contratService;
	private final EcheanceService echeanceService;
	private final TypeImmeubleService typeImmeubleService;
	private final ImmeubleService immeubleService;
	private final PrixImmeubleService prixImmeubleService;
	private final LocataireService locataireService;
	
	
	public LocationController(ContratService contratService, EcheanceService echeanceService,
			TypeImmeubleService typeImmeubleService, ImmeubleService immeubleService,
			PrixImmeubleService prixImmeubleService, LocataireService locataireService) {
		super();
		this.contratService = contratService;
		this.echeanceService = echeanceService;
		this.typeImmeubleService = typeImmeubleService;	
		this.immeubleService = immeubleService;
		this.prixImmeubleService = prixImmeubleService;
		this.locataireService = locataireService;
		
	}
	
	/*###########################################################
	#############	Partie réservée pour contrat
	###########################################################
	*/

	@GetMapping(path = "contrat/list")
	public List<Contrat> getAllContrat(){
		return this.contratService.getAll();
	}
	
	@GetMapping(path = "contrat/byCodCon/{id}")
	public Optional<Contrat> getContratById(@PathVariable(name = "id") String id){
		return this.contratService.getById(id);
	}
	
	@GetMapping(path = "contrat/byImm/{imm}")
	public List<Contrat> getContratByImmeuble(@PathVariable(name = "imm") Immeuble imm){
		return this.contratService.findByImmeuble(imm);
	}
	
	@GetMapping(path = "contrat/byLoc/{loc}")
	public List<Contrat> getContratByLocataire(@PathVariable(name = "loc") Locataire loc){
		return this.contratService.findByLocataire(loc);
	}
	
	@GetMapping(path = "contrat/byDatEff/{dateEffet}")///21602470
	public List<Contrat> getContratByDate(@PathVariable(name = "effet") Date dateEffet){
		return this.contratService.findByDateEffetContrat(dateEffet);
	}
	
	@PostMapping(path = "contrat/list")
	public Contrat createContrat( @RequestBody Contrat contrat) {
		return this.contratService.save(contrat);
	}
	
	@PutMapping(path = "contrat/byCodCon/{id}")
	public Contrat updateContrat(@PathVariable(name = "id") String id, @RequestBody Contrat contrat) {
		
		return this.contratService.edit(id, contrat);
	}
	
	@DeleteMapping(path = "contrat/byCodCon/{id}")
	public Boolean deleteContrat(@PathVariable(name = "id") String id) {
		return this.contratService.delete(id);
	}
	
	
	/*###########################################################
	#############	Partie réservée pour echeance
	###########################################################
	*/
	
	@GetMapping(path = "echeance/list")
	public List<Echeance> getAllEcheance(){
		
		return this.echeanceService.getAll();
	}
	
	@GetMapping(path = "echeance/byCodEch/{id}")
	public Optional<Echeance> getEcheanceById(@PathVariable(name = "id") Long id){
		
		return this.echeanceService.getById(id);
	}
	
	@GetMapping(path = "echeance/byCon/{contrat}")
	public List<Echeance> findByContrat(@PathVariable(name = "contrat") Contrat contrat){
		
		return this.echeanceService.findByContrat(contrat);
	}
	
	@GetMapping(path = "echeancesPayeesParContrat")
	public List<Echeance> findByEcheancesPayees(){
		
		return this.echeanceService.findByPayeEcheance(true);
	}
	
	@GetMapping(path = "echeancesNonPayeesParContrat")
	public List<Echeance> findByEcheancesNonPayees(){
		
		return this.echeanceService.findByPayeEcheance(false);
	}
	
	@PostMapping(path = "echeance/list")
	public Echeance createEcheance( @RequestBody Echeance echeance) {
		//Echeance e=new Echeance();
		return this.echeanceService.save(echeance);
	}
	
	@PutMapping(path = "echeance/byCodEch/{id}")
	public Echeance updateEcheance(@PathVariable(name = "id") Long id, @RequestBody Echeance echeance) {
		System.out.println("Mise à jour de l\'échéance N°: " +id+" en "+ echeance.toString());
		return this.echeanceService.edit(id, echeance);
	}
	
	@DeleteMapping(path = "echeance/byCodEch/{id}")
	public Boolean deleteEcheance(@PathVariable(name = "id") Long id) {
		
		return this.echeanceService.delete(id);
	}
	
	
	/*###########################################################
	#############	Partie réservée pour type immeuble
	###########################################################
	*/
	
	@GetMapping(path = "typeimmeuble/list")
	public List<TypeImmeuble> getAllTypeImmeubles(){
		
		return this.typeImmeubleService.getAll();
	}
	
	@GetMapping(path = "typeimmeuble/byCodImm/{id}")
	public Optional<TypeImmeuble> getTypeImmeubleById(@PathVariable(name = "id") String id){
		
		return this.typeImmeubleService.findById(id);
	}
	
	@PostMapping(path = "typeimmeuble/list")
	public TypeImmeuble createTypeImmeuble( @RequestBody TypeImmeuble tym) {
		
		return this.typeImmeubleService.save(tym);
	}
	
	@PutMapping(path = "typeimmeuble/byCodImm/{id}")
	public TypeImmeuble updateTypeImmeuble(@PathVariable(name = "id") String codeTym, @RequestBody TypeImmeuble tym) {
		
		return this.typeImmeubleService.edit(codeTym, tym);
	}
	
	@DeleteMapping(path = "typeimmeuble/byCodImm/{id}")
	public Boolean deleteTypeImmeuble(@PathVariable(name = "id") String id) {
		
		return this.typeImmeubleService.delete(id);
	}

	
	/*###########################################################
	#############	Partie réservée pour immeuble
	###########################################################
	*/
	
	@GetMapping(path = "immeuble/list")
	public List<Immeuble> getAllImmeuble(){
		
		return this.immeubleService.getAll();
	}
	
	@GetMapping(path = "immeuble/byCodImm/{id}")
	public Optional<Immeuble> getImmeubleById(@PathVariable(name = "id") String id){
		
		return this.immeubleService.getById(id);
	}
	
	@GetMapping(path = "immeuble/byQua/{quartier}")
	public List<Immeuble> getImmeubleByQuartier(@PathVariable(name = "quartier") Quartier quartier){
		
		return this.immeubleService.findByQuartier(quartier);
	}
	
	@GetMapping(path = "immeuble/byEta/{etat}")
	public List<Immeuble> getImmeubleByEtat(@PathVariable(name = "etat") Boolean etat){
		
		return this.immeubleService.findByEtatIm(etat);
	}
	
	@GetMapping(path = "immeuble/byTypImm/{typImm}")
	public List<Immeuble> getImmeubleByQuartier(@PathVariable(name = "quartier") TypeImmeuble typImm){
		
		return this.immeubleService.findByTypeImmeuble(typImm);
	}
	
	@PostMapping(path = "immeuble/list")
	public Immeuble createImmeuble( @RequestBody Immeuble immeuble) {
		
		return this.immeubleService.save(immeuble);
	}
	
	@PutMapping(path = "immeuble/byCodImm/{id}")
	public Immeuble updateImmeuble(@PathVariable(name = "id") String id, @RequestBody Immeuble immeuble) {
		
		return this.immeubleService.edit(id, immeuble);
	}
	
	@DeleteMapping(path = "immeuble/byCodImm/{id}")
	public Boolean deleteImmeuble(@PathVariable(name = "id") String id) {
		
		return this.immeubleService.delete(id);
	}

	/*###########################################################
	#############	Partie réservée pour prix immeuble
	###########################################################
	*/
	
	@GetMapping(path = "priximmeuble/list")
	public List<PrixImmeuble> getAllPrixImmeuble(){
		
		return this.prixImmeubleService.getAll();
	}
	
	@GetMapping(path = "priximmeuble/byCodImm/{id}")
	public Optional<PrixImmeuble> getPrixImmeubleById(@PathVariable(name = "id") Long id){
		
		return this.prixImmeubleService.findById(id);
	}

	@GetMapping(path = "priximmeuble/byImm/{imm}")
	public List<PrixImmeuble> getPrixImmeubleById(@PathVariable(name = "imm") Immeuble imm){
		
		return this.prixImmeubleService.findByImeublem(imm);
	}
	
	@PostMapping(path = "priximmeuble/list")
	public PrixImmeuble createPrixImmeuble( @RequestBody PrixImmeuble priImm) {
		
		return this.prixImmeubleService.save(priImm);
	}
	
	@PutMapping(path = "priximmeuble/byCodImm/{id}")
	public PrixImmeuble updatePrixImmeuble(@PathVariable(name = "id") Long id, @RequestBody PrixImmeuble priImm) {
		
		return this.prixImmeubleService.edit(id, priImm);
	}
	
	@DeleteMapping(path = "priximmeuble/byCodImm/{id}")
	public Boolean deletePrixImmeuble(@PathVariable(name = "id") Long id) {
		
		return this.prixImmeubleService.delete(id);
	}
	 
	/*###########################################################
	#############	Partie réservée pour locataire
	###########################################################
	*/
	
	@GetMapping(path = "locataire/list")
	public List<Locataire> getAllLocataire(){
		
		return this.locataireService.findAll();
	}
	
	@GetMapping(path = "locataire/byCodLoc/{id}")
	public Optional<Locataire> getLocataireById(@PathVariable(name = "id") Long id){
		
		return this.locataireService.findById(id);
	}
	
	@GetMapping(path = "locataire/byide/{identite}")
	public List<Locataire> getLocataireByIdentite(@PathVariable(name = "identite") String identite){
		
		return this.locataireService.findByidentite(identite);
	}
	
	@PostMapping(path = "locataire/list")
	public Locataire createLocataire( @RequestBody Locataire loc) {
		
		return this.locataireService.save(loc);
	}
	
	@PutMapping(path = "locataire/byCodLoc/{id}")
	public Locataire updateLocataire(@PathVariable(name = "id") Long id, @RequestBody Locataire loc) {
		
		return this.locataireService.edit(loc, id);
	}
	
	@DeleteMapping(path = "locataire/byCodLoc/{id}")
	public Boolean deleteLocataire(@PathVariable(name = "id") Long id) {
		
		return this.locataireService.delete(id);
	}
	 
}
