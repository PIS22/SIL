package com.sil.gpc.controllers.commune;

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

import com.sil.gpc.domains.AffectDroitGroupUser;
import com.sil.gpc.domains.AffectUserGroup;
import com.sil.gpc.domains.AffectUserToArrondi;
import com.sil.gpc.domains.Arrondissement;
import com.sil.gpc.domains.Commune;
import com.sil.gpc.domains.Departement;
import com.sil.gpc.domains.DroitUser;
import com.sil.gpc.domains.EtreAffecte;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.Fournisseur;
import com.sil.gpc.domains.GroupUser;
import com.sil.gpc.domains.InstituReverse;
import com.sil.gpc.domains.Service;
import com.sil.gpc.domains.SiteMarcher;
import com.sil.gpc.domains.Pays;
import com.sil.gpc.domains.PourcenReverse;
import com.sil.gpc.domains.Quartier;
import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.services.AffectDroitGroupUserService;
import com.sil.gpc.services.AffectUserGroupService;
import com.sil.gpc.services.AffectUserToArrondiService;
import com.sil.gpc.services.ArrondissementService;
import com.sil.gpc.services.CommuneService;
import com.sil.gpc.services.DepartementService;
import com.sil.gpc.services.DroitUserService;
import com.sil.gpc.services.EtreAffeccteService;
import com.sil.gpc.services.ExerciceService;
import com.sil.gpc.services.FournisseurService;
import com.sil.gpc.services.GroupUserService;
import com.sil.gpc.services.InstituReverseService;
import com.sil.gpc.services.PaysService;
import com.sil.gpc.services.PourcenReverseService;
import com.sil.gpc.services.QuartierService;
import com.sil.gpc.services.ServiceService;
import com.sil.gpc.services.SiteMarcherService;
import com.sil.gpc.services.UtilisateurService;

@RestController
@CrossOrigin
@RequestMapping(path = "/perfora-gpc/v1/commune/")
public class CommuneController {

	private final ExerciceService exerciceService;
	private final FournisseurService fournisseurService;
	private final ServiceService serviceService;
	private final UtilisateurService utilisateurService;
	private final PaysService paysService;
	private final DepartementService departementService;
	private final CommuneService communeService;
	private final ArrondissementService arrondissementService;
	private final QuartierService quartierService;
	private final EtreAffeccteService etreAffecterService;
	private final SiteMarcherService siMaS;
	private final GroupUserService ug;
	private final AffectDroitGroupUserService dgus;
	private final AffectUserGroupService aug;
	private final DroitUserService du;
	private final InstituReverseService ir;
	private final PourcenReverseService perce;
	private final AffectUserToArrondiService auta;

	public CommuneController(ExerciceService exerciceService, FournisseurService fournisseurService,
			ServiceService serviceService, UtilisateurService utilisateurService, PaysService paysService,
			DepartementService departementService, CommuneService communeService,
			ArrondissementService arrondissementService, QuartierService quartierService,
			EtreAffeccteService etreAffecterService, SiteMarcherService siMaS, GroupUserService ug,
			AffectDroitGroupUserService dgus, AffectUserGroupService aug, DroitUserService du, InstituReverseService ir,
			PourcenReverseService perce, AffectUserToArrondiService auta) {
		this.exerciceService = exerciceService;
		this.fournisseurService = fournisseurService;
		this.serviceService = serviceService;
		this.utilisateurService = utilisateurService;
		this.paysService = paysService;
		this.departementService = departementService;
		this.communeService = communeService;
		this.arrondissementService = arrondissementService;
		this.quartierService = quartierService;
		this.etreAffecterService = etreAffecterService;
		this.siMaS = siMaS;
		this.ug = ug;
		this.dgus = dgus;
		this.aug = aug;
		this.du = du;
		this.ir = ir;
		this.perce = perce;
		this.auta = auta;
	}

	/*###########################################################
	#############	Partie réservée pour exercice
	###########################################################
	*/
	
	@GetMapping(path = "exercice/list")
	public List<Exercice> getAllExercice(){
		
		return this.exerciceService.getAll();
	}
	
	@GetMapping(path = "exercice/byCodExe/{id}")
	public Optional<Exercice> getExerciceById(@PathVariable(name = "id") String id){
		
		return this.exerciceService.getById(id);
	}
	
	@GetMapping(path = "exercice/byExoSel/{exoSel}")
	public List<Exercice> getExerciceById(@PathVariable(name = "exoSel") boolean exoSel){
		
		return this.exerciceService.findByExoSelectionner(exoSel);
	}
	
	@PostMapping(path = "exercice/list")
	public Exercice createExercice( @RequestBody Exercice exercice) {
		
		return this.exerciceService.save(exercice);
	}
	
	@PutMapping(path = "exercice/byCodExe/{id}")
	public Exercice updateExercice(@PathVariable(name = "id") String id, @RequestBody Exercice exercice) {
		
		return this.exerciceService.edit(id, exercice);
	}
	
	@DeleteMapping(path = "exercice/byCodExe/{id}")
	public Boolean deleteExercice(@PathVariable(name = "id") String id) {
		
		return this.exerciceService.delete(id);
	}
	
	

	/*###########################################################
	#############	Partie réservée pour EtreAffecte
	###########################################################
	*/
	
	@GetMapping(path = "Affect/list")
	public List<EtreAffecte> getAllAffectation(){
		
		return this.etreAffecterService.getAllAffect();
	}
	
	@GetMapping(path = "Affect/byId/{id}")
	public Optional<EtreAffecte> getAffectationById(@PathVariable(name = "id") Long id){
		
		return this.etreAffecterService.findById(id);
	}
	
@GetMapping(path = "Affect/bydatArr/{exoSel}")
	public List<EtreAffecte> findAffectationByDA(@PathVariable(name = "exoSel") Date da){
		
		return this.etreAffecterService.findByDateArrivee(da);
	}
	
	@PostMapping(path = "Affect/list")
	public EtreAffecte createAffectation( @RequestBody EtreAffecte affect) {
		
		return this.etreAffecterService.save(affect);
	}
	
	@PutMapping(path = "Affect/byId/{id}")
	public EtreAffecte updateAffectation(@PathVariable(name = "id") Long id, @RequestBody EtreAffecte affect) {
		
		return this.etreAffecterService.edit(id, affect);
	}
	
	@DeleteMapping(path = "Affect/byId/{id}")
	public Boolean deleteAffectation(@PathVariable(name = "id") Long id) {
		
		return this.etreAffecterService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour fournisseur
	###########################################################
	*/
	
	@GetMapping(path = "fournisseur/list")
	public List<Fournisseur> getAllFournisseur(){
		
		return this.fournisseurService.getAll();
	}
	
	@GetMapping(path = "fournisseur/byCodFou/{raiSocial}")
	public List<Fournisseur> getFournisseurByRaisonSocial(@PathVariable(name = "raiSocial") String raiSocial){
		
		return this.fournisseurService.findByRaisonSociale(raiSocial);
	}
	
	@GetMapping(path = "fournisseur/byIdenFou/{identite}")
	public List<Fournisseur> getFournisseurByIdentite(@PathVariable(name = "identite") String identite){
		
		return this.fournisseurService.findByIdentiteFrs(identite);
	}
	
	@GetMapping(path = "fournisseur/byAdrFou/{adresse}")
	public List<Fournisseur> getFournisseurByAdresse(@PathVariable(name = "adresse") String adresse){
		
		return this.fournisseurService.findByAdresseFrs(adresse);
	}
	
	@GetMapping(path = "fournisseur/byRaiSocFou/{id}")
	public Optional<Fournisseur> getFournisseurById(@PathVariable(name = "id") String id){
		
		return this.fournisseurService.getById(id);
	}
	
	@PostMapping(path = "fournisseur/list")
	public Fournisseur createFournisseur( @RequestBody Fournisseur fournisseur) {
		
		return this.fournisseurService.save(fournisseur);
	}
	
	@PutMapping(path = "fournisseur/byCodFou/{id}")
	public Fournisseur updateFournisseur(@PathVariable(name = "id") String id, @RequestBody Fournisseur fournisseur) {
		
		return this.fournisseurService.edit(id, fournisseur);
	}
	
	@DeleteMapping(path = "fournisseur/byCodFou/{id}")
	public Boolean deleteFournisseur(@PathVariable(name = "id") String id) {
		
		return this.fournisseurService.delete(id);
	}	
	
	
	/*###########################################################
	#############	Partie réservée pour service
	###########################################################
	*/
	@GetMapping(path = "service/list")
	public List<Service> getAllService(){
		
		return this.serviceService.getAll();
	}
	
	@GetMapping(path = "service/byCodSev/{id}")
	public Optional<Service> getServiceById(@PathVariable(name = "id") String id){
		
		return this.serviceService.findById(id);
	}
	
	@GetMapping(path = "service/byLibSev/{libelle}")
	public List<Service> getServiceByLibelleService(@PathVariable(name = "libelle") String libelle){
		
		return this.serviceService.findByLibelleServicer(libelle);
	}
	
	@PostMapping(path = "service/list")
	public Service createService( @RequestBody Service service) {
		
		return this.serviceService.save(service);
	}
	
	@PutMapping(path = "service/byCodSev/{id}")
	public Service updateService(@PathVariable(name = "id") String id, @RequestBody Service service) {
		
		return this.serviceService.edit(id, service);
	}
	
	@DeleteMapping(path = "service/byCodSev/{id}")
	public Boolean deleteService(@PathVariable(name = "id") String id) {
		
		return this.serviceService.delete(id);
	}	
	
	
	/*###########################################################
	#############	Partie réservée pour utilisateur
	###########################################################
	*/
	@GetMapping(path = "user/list")
	public List<Utilisateur> getAllUser(){
		
		return this.utilisateurService.getAll();
	}
	
	@GetMapping(path = "user/byCodUser/{id}")
	public Optional<Utilisateur> getUserById(@PathVariable(name = "id") Long id){
		
		return this.utilisateurService.findById(id);
	}
	
	@GetMapping(path = "user/byService/{sev}")
	public List<Utilisateur> getUserByService(@PathVariable(name = "sev") Service sev){
		
		return this.utilisateurService.findByServiceUtilisateur(sev);
	}
	
	@GetMapping(path = "user/byActiveUser/{actUser}")
	public List<Utilisateur> getUserByActiveUser(@PathVariable(name = "actUser") boolean actUser){
		
		return this.utilisateurService.findByActiveUtilisateur(actUser);
	}
	
	@GetMapping(path = "user/byFonUser/{fonc}")
	public List<Utilisateur> getUserByFonctionUser(@PathVariable(name = "fonc") Long fonc){
		
		return this.utilisateurService.findByFonctionUtilisateur(fonc);
	}
	
	@GetMapping(path = "user/byNomUser/{nom}")
	public List<Utilisateur> getUserByNomUser(@PathVariable(name = "nom") Long nom){
		
		return this.utilisateurService.findByNomUtilisateur(nom);
	}
	
	@PostMapping(path = "user/list")
	public Utilisateur createUser( @RequestBody Utilisateur user) {
		
		return this.utilisateurService.save(user);
	}
	
	@PutMapping(path = "user/byCodUser/{id}")
	public Utilisateur updateUser(@PathVariable(name = "id") Long id, @RequestBody Utilisateur user) {
		
		return this.utilisateurService.edit(id, user);
	}
	
	@DeleteMapping(path = "user/byCodUser/{id}")
	public Boolean deleteUser(@PathVariable(name = "id") Long id) {
		
		return this.utilisateurService.delete(id);
	}	

	
	
	/*###########################################################
	#############	Partie réservée pour AffectDroitGroupeUser
	###########################################################
	*/
	@GetMapping(path = "adgu/list")
	public List<AffectDroitGroupUser> getAllDroitsGroup(){
		
		return this.dgus.getAll();
	}
	
	@GetMapping(path = "adgu/byId/{id}")
	public Optional<AffectDroitGroupUser> getDroitGroupeUser(@PathVariable(name = "id") Long id){
		
		return this.dgus.findById(id);
	}
	
	@GetMapping(path = "adgu/bygro/{gu}")
	public List<AffectDroitGroupUser> getDroitGroupByGroup(@PathVariable(name = "gu") GroupUser gu){
		
		return this.dgus.findByGroup(gu);
	}
	
	@GetMapping(path = "adgu/bydro/{du}")
	public List<AffectDroitGroupUser> getDroitGroupByDroit(@PathVariable(name = "du") DroitUser du){
		
		return this.dgus.findByDroit(du);
	}
	
	@PostMapping(path = "adgu/list")
	public AffectDroitGroupUser createaffectDroitGroup( @RequestBody AffectDroitGroupUser adgu) {
		
		return this.dgus.save(adgu);
	}
	
	@PutMapping(path = "adgu/byid/{id}")
	public AffectDroitGroupUser updatedroitGroup(@PathVariable(name = "id") Long id, @RequestBody AffectDroitGroupUser adgu) {
		
		return this.dgus.edit(id, adgu);
	}
	
	@DeleteMapping(path = "user/byidr/{id}")
	public Boolean deleteDroitGroup(@PathVariable(name = "id") Long id) {
		
		return this.dgus.delete(id);	
	}
	
	
	/*###########################################################
	#############	Partie réservée pour AffectUserGroup
	###########################################################
	*/

	@GetMapping(path = "ug/list")
	public List<AffectUserGroup> getAllgroups(){
		
		return this.aug.getAll();
	}
	
	@GetMapping(path = "aug/byId/{id}")
	public Optional<AffectUserGroup> getGroupeUser(@PathVariable(name = "id") Long id){
		
		return this.aug.findById(id);
	}
	
	@GetMapping(path = "aug/bygro/{gro}")
	public List<AffectUserGroup> getUserGroupBygroup(@PathVariable(name = "gu") GroupUser gu){
		
		return this.aug.findByGroups(gu);
	}
	
	@GetMapping(path = "aug/byUse/{du}")
	public List<AffectUserGroup> getUserByDroit(@PathVariable(name = "du") Utilisateur u){
		
		return this.aug.findByUser(u);
	}
	
	@PostMapping(path = "aug/list")
	public AffectUserGroup createAffectUserGroup( @RequestBody AffectUserGroup agu) {
		
		return this.aug.save(agu);
	}
	
	@PutMapping(path = "aug/byid/{id}")
	public AffectUserGroup updateAffectUserGroup(@PathVariable(name = "id") Long id, @RequestBody AffectUserGroup agu) {
		
		return this.aug.edit(id, agu);
	}
	
	@DeleteMapping(path = "aug/byidAGU/{id}")
	public Boolean deleteUserToGroup(@PathVariable(name = "id") Long id) {
		
		return this.aug.delete(id);
}	
	
	
	/*###########################################################
	#############	Partie réservée pour DroitUser
	###########################################################
	*/

	@GetMapping(path = "du/list")
	public List<DroitUser> getAllDroits(){
		
		return this.du.getAll();
	}
	
	@GetMapping(path = "du/byId/{id}")
	public Optional<DroitUser> getDroitUser(@PathVariable(name = "id") Long id){
		
		return this.du.findById(id);
	}
	
	@GetMapping(path = "du/byCodDro/{cdu}")
	public List<DroitUser> droitUserBycode(@PathVariable(name = "cdu") String cdu){
		
		return this.du.findByCodedroit(cdu);
	}
	
	@GetMapping(path = "du/byLib/{lib}")
	public List<DroitUser> getDroitByLib(@PathVariable(name = "lib") String lib){
		
		return this.du.findByLibDroitId(lib);
	}
	
	@PostMapping(path = "du/list")
	public DroitUser createDroitUser( @RequestBody DroitUser dus) {
		
		return this.du.save(dus);
	}
	
	@PutMapping(path = "du/byid/{id}")
	public DroitUser updateDroit(@PathVariable(name = "id") Long id, @RequestBody DroitUser du) {
		
		return this.du.edit(id, du);
	}
	
	@DeleteMapping(path = "du/byid/{id}")
	public Boolean deleteDroitUser(@PathVariable(name = "id") Long id) {
		
		return this.du.delete(id);
}	
	
	
	/*###########################################################
	#############	Partie réservée pour GoupUser
	###########################################################
	*/

	@GetMapping(path = "gro/list")
	public List<GroupUser> getAllGroups(){
		
		return this.ug.getAll();
	}
	
	@GetMapping(path = "gro/byId/{id}")
	public Optional<GroupUser> getGroupe(@PathVariable(name = "id") String id){
		
		return this.ug.findById(id);
	}
	
	@GetMapping(path = "gro/byLib/{lib}")
	public List<GroupUser> getGroupByLib(@PathVariable(name = "lib") String lib){
		
		return this.ug.findByLib(lib);
	}
	
	@PostMapping(path = "gro/list")
	public GroupUser createGroupUser( @RequestBody GroupUser group) {
		
		return this.ug.save(group);
	}
	
	@PutMapping(path = "gro/byid/{id}")
	public GroupUser updateGroup(@PathVariable(name = "id") String id, @RequestBody GroupUser g) {
		
		return this.ug.edit(id, g);
	}
	
	@DeleteMapping(path = "gro/byid/{id}")
	public Boolean deleteGroup(@PathVariable(name = "id") String id) {
		
		return this.ug.delete(id);
}	
	
	
	/*###########################################################
	#############	Partie réservée pour pays
	###########################################################
	*/
	@GetMapping(path = "pays/list")
	public List<Pays> getAllPays(){
		
		return this.paysService.findByAll();
	}
	
	@GetMapping(path = "pays/byCodPay/{id}")
	public Optional<Pays> getPaysById(@PathVariable(name = "id") String id){
		
		return this.paysService.findById(id);
	}
	
	@GetMapping(path = "pays/byNomPay/{nom}")
	public List<Pays> getPaysByLibelle(@PathVariable(name = "nom") String nom){
		
		return this.paysService.findByNom(nom);
	}
	
	@PostMapping(path = "pays/list")
	public Pays createPays( @RequestBody Pays pays) {
		
		return this.paysService.save(pays);
	}
	
	@PutMapping(path = "pays/byCodPay/{id}")
	public Pays updatePays(@PathVariable(name = "id") String id, @RequestBody Pays pays) {
		
		return this.paysService.modifiePays(pays, id);
	}
	
	@DeleteMapping(path = "pays/byCodPay/{id}")
	public Boolean deletePays(@PathVariable(name = "id") String id) {
		
		return this.paysService.supprimePays(id);
	}	
	
	/*###########################################################
	#############	Partie réservée pour departement
	###########################################################
	*/
	
	@GetMapping(path = "departement/list")
	public List<Departement> getAllDepartement(){
		
		return this.departementService.getAll();
	}
	
	@GetMapping(path = "departement/byCodDep/{id}")
	public Optional<Departement> getDepartementById(@PathVariable(name = "id") String id){
		
		return this.departementService.getById(id);
	}
	
	@GetMapping(path = "departement/byNomDep/{nom}")
	public List<Departement> getDepartementByNom(@PathVariable(name = "nom") String nom){
		
		return this.departementService.findByNomDepartement(nom);
	}
	
	@GetMapping(path = "departement/byPays/{pay}")
	public List<Departement> getDepartementByNom(@PathVariable(name = "pay") Pays pay){
		
		return this.departementService.findByPays(pay);
	}
	
	@PostMapping(path = "departement/list")
	public Departement createDepartement( @RequestBody Departement departement) {
		
		return this.departementService.save(departement);
	}
	
	@PutMapping(path = "departement/byCodDep/{id}")
	public Departement updateDepartement(@PathVariable(name = "id") String id, @RequestBody Departement departement) {
		
		return this.departementService.edit(id, departement);
	}
	
	@DeleteMapping(path = "departement/byCodDep/{id}")
	public Boolean deleteDepartement(@PathVariable(name = "id") String id) {
		
		return this.departementService.delete(id);
	}	
	
	
	/*###########################################################
	#############	Partie réservée pour commune
	###########################################################
	*/
	
	@GetMapping(path = "commune/list")
	public List<Commune> getAllCommune(){
		
		return this.communeService.getAll();
	}
	
	@GetMapping(path = "commune/byCodCom/{id}")
	public Optional<Commune> getCommuneById(@PathVariable(name = "id") String id){
		
		return this.communeService.getById(id);
	}
	
	@GetMapping(path = "commune/byCodDep/{codeDep}")
	public List<Commune> getCommuneByCodeDepartement(@PathVariable(name = "codeDep") Departement codeDep){
		
		return this.communeService.findByCodeDepartement(codeDep);
	}
	
	@GetMapping(path = "commune/byAdrMai/{adrMai}")
	public List<Commune> getCommuneByAdresseMairie(@PathVariable(name = "adrMai") String adrMai){
		
		return this.communeService.findByAdresseMairie(adrMai);
	}
	
	@GetMapping(path = "commune/byNomCom/{nom}")
	public List<Commune> getCommuneByNomCommune(@PathVariable(name = "nom") String nom){
		
		return this.communeService.findByNomCommune(nom);
	}
	
	@GetMapping(path = "commune/byCodCom/{codeCom}")
	public List<Commune> getCommuneByCodeCom(@PathVariable(name = "codeCom") String codeCom){
		
		return this.communeService.findByCodeCommune(codeCom);
	}
	
	
	@PostMapping(path = "commune/list")
	public Commune createCommune( @RequestBody Commune commune) {
		
		return this.communeService.save(commune);
	}
	
	@PutMapping(path = "commune/byCodCom/{id}")
	public Commune updateCommune(@PathVariable(name = "id") String id, @RequestBody Commune commune) {
		
		return this.communeService.edit(id, commune);
	}
	
	@DeleteMapping(path = "commune/byCodCom/{id}")
	public Boolean deleteCommune(@PathVariable(name = "id") String id) {
		
		return this.communeService.delete(id);
	}	
	
	
	
	/*###########################################################
	#############	Partie réservée pour arrondissement
	###########################################################
	*/
	
	@GetMapping(path = "arrondissement/list")
	public List<Arrondissement> getAllArrondissement(){
		
		return this.arrondissementService.getAll();
	}
	
	@GetMapping(path = "arrondissement/byCodArr/{id}")
	public Optional<Arrondissement> getArrondissementById(@PathVariable(name = "id") String id){
		
		return this.arrondissementService.getById(id);
	}
	
	@GetMapping(path = "arrondissement/byCom/{com}")
	public List<Arrondissement> getArrondissementByCommune(@PathVariable(name = "com") Commune com){
		
		return this.arrondissementService.findByCommune(com);
	}
	
	@GetMapping(path = "arrondissement/byNomArr/{nom}")
	public List<Arrondissement> getArrondissementByNomArrondissement(@PathVariable(name = "nom") String nom){
		
		return this.arrondissementService.findByNomArrondi(nom);
	}
	
	@GetMapping(path = "arrondissement/byCodArr/{code}")
	public List<Arrondissement> getArrondissementByCodeArrondissement(@PathVariable(name = "code") String code){
		
		return this.arrondissementService.findByCodeArrondi(code);
	}
	
	@GetMapping(path = "arrondissement/byAdrArr/{adresse}")
	public List<Arrondissement> getArrondissementByCommune(@PathVariable(name = "adresse") String adresse){
		
		return this.arrondissementService.findByAdresseArrondi(adresse);
	}
	
	@PostMapping(path = "arrondissement/list")
	public Arrondissement createArrondissement( @RequestBody Arrondissement arrondissement) {
		
		return this.arrondissementService.save(arrondissement);
	}
	
	@PutMapping(path = "arrondissement/byCodArr/{id}")
	public Arrondissement updateArrondissement(@PathVariable(name = "id") String id, @RequestBody Arrondissement arrondissement) {
		
		return this.arrondissementService.edit(id, arrondissement);
	}
	
	@DeleteMapping(path = "arrondissement/byCodArr/{id}")
	public Boolean deleteArrondissement(@PathVariable(name = "id") String id) {
		
		return this.arrondissementService.delete(id);
	}
	
	/*###########################################################
	#############	Partie réservée pour quartier
	###########################################################
	*/
	@GetMapping(path = "quartier/list")
	public List<Quartier> getAllQuartier(){
		
		return this.quartierService.getAll();
	}
	
	@GetMapping(path = "quartier/byCodQua/{id}")
	public Optional<Quartier> getQuartierById(@PathVariable(name = "id") String id){
		
		return this.quartierService.findById(id);
	}
	
	@GetMapping(path = "quartier/byNomQua/{nom}")
	public List<Quartier> getQuartierByNom(@PathVariable(name = "nom") String nom){
		
		return this.quartierService.findByNomQuartier(nom);
	}
	
	@GetMapping(path = "quartier/byArrQua/{arrondissement}")
	public List<Quartier> getQuartierbByArrondissement(@PathVariable(name = "arrondissement") String arrondissement){
		
		return this.quartierService.findByNomQuartier(arrondissement);
	}
	
	@GetMapping(path = "quartier/byAdrQua/{adresse}")
	public List<Quartier> getQuartierbByAdresse(@PathVariable(name = "adresse") String adresse){
		
		return this.quartierService.findByAdresseQuartier(adresse);
	}
	
	@PostMapping(path = "quartier/list")
	public Quartier createQuartier( @RequestBody Quartier quartier) {
		
		return this.quartierService.save(quartier);
	}
	
	@PutMapping(path = "quartier/byCodQua/{id}")
	public Quartier updateQuartier(@PathVariable(name = "id") String id, @RequestBody Quartier quartier) {
		
		return this.quartierService.edit(id, quartier);
	}
	
	@DeleteMapping(path = "quartier/byCodQua/{id}")
	public Boolean deleteQuartier(@PathVariable(name = "id") String id) {
		
		return this.quartierService.delete(id);
	}	

	
	/*###########################################################
	#############	Partie réservée pour siteMarcher
	###########################################################
	*/
	@GetMapping(path = "site/list")
	public List<SiteMarcher> getAllSite(){
		
		return this.siMaS.getAll();
	}
	
	@GetMapping(path = "site/byCodSit/{id}")
	public Optional<SiteMarcher> getSiteById(@PathVariable(name = "id") String id){
		
		return this.siMaS.findById(id);
	}
	
	@GetMapping(path = "site/byLibSit/{lib}")
	public List<SiteMarcher> getSiteByLibelle(@PathVariable(name = "nom") String lib){
		
		return this.siMaS.findByLibe(lib);
	}
	
	@PostMapping(path = "site/list")
	public SiteMarcher createSite( @RequestBody SiteMarcher site) {
		
		return this.siMaS.save(site);
	}
	
	@PutMapping(path = "site/byCodSit/{id}")
	public SiteMarcher updateSite(@PathVariable(name = "id") String id, @RequestBody SiteMarcher sit) {
		
		return this.siMaS.edit(id, sit);
	}
	
	@DeleteMapping(path = "site/byCodSit/{id}")
	public Boolean deleteSite(@PathVariable(name = "id") String id) {
		
		return this.siMaS.delete(id);
	}		

	
	/*###########################################################
	#############	Partie réservée pour InstituReverse
	###########################################################
	*/
	
	@GetMapping(path = "ins/list")
	public List<InstituReverse> getAllInstitut(){
		
		return this.ir.findAll();
	}
	
	@GetMapping(path = "ins/byCodIns/{id}")
	public InstituReverse getInstById(@PathVariable(name = "id") String id){
		
		return this.ir.getByCod(id);
	}
	
	@GetMapping(path = "ins/byLibIns/{lib}")
	public List<InstituReverse> getInstByLibelle(@PathVariable(name = "nom") String lib){
		
		return this.ir.getByLib(lib);
	}
	
	@PostMapping(path = "ins/list")
	public InstituReverse createIns( @RequestBody InstituReverse ins) {
		
		return this.ir.saveInst(ins);
	}
	
	@PutMapping(path = "ins/byCodIns/{id}")
	public InstituReverse updateInst(@PathVariable(name = "id") String id, @RequestBody InstituReverse ins) {
		
		return this.ir.editInst(id, ins);
	}
	
	@DeleteMapping(path = "ins/byCodIns/{id}")
	public Boolean deleteInst(@PathVariable(name = "id") String id) {
		
		return this.ir.delIntByCod(id);
	}		

	
	/*###########################################################
	#############	Partie réservée pour siteMarcher
	###########################################################
	*/
	@GetMapping(path = "pourcentage/list")
	public List<PourcenReverse> getAllPourcentages(){
		
		return this.perce.getAll();
	}
	
	@GetMapping(path = "pourcentage/byId/{id}")
	public Optional<PourcenReverse> getPourcentageById(@PathVariable(name = "id") Long id){
		
		return this.perce.findById(id);
	}
	
	@PostMapping(path = "pourcentage/list")
	public PourcenReverse createSite( @RequestBody PourcenReverse pource) {
		
		return this.perce.save(pource);
	}
	
	@PutMapping(path = "pourcentage/byId/{id}")
	public PourcenReverse updatePourcentage(@PathVariable(name = "id") Long id, @RequestBody PourcenReverse por) {
		PourcenReverse p= perce.findById(id).get();
		p.setArticle(por.getArticle());
		p.setValPourcenRevers(por.getValPourcenRevers());
		p.setInstituReverse(por.getInstituReverse());
		return this.perce.save(por);
	}
	
	@DeleteMapping(path = "pourcentage/byId/{id}")
	public Boolean deleteSite(@PathVariable(name = "id") Long id) {
		
		return this.perce.delete(id);
	}	

	
	/*###########################################################
	#############	Partie réservée pour AffectUserToArrondi
	###########################################################
	*/
	@GetMapping(path = "affectUserToArrondi/list")
	public List<AffectUserToArrondi> getAllAffectUserArrondi(){
		
		return this.auta.getAll();
	}
	
	@GetMapping(path = "affectAnUserToArrondi/byCodAffUseToArr/{id}")
	public AffectUserToArrondi getUserArrondiId(@PathVariable(name = "id") Long id){
		
		return this.auta.findAnAffect(id);
	}
	
	@PostMapping(path = "affectUserToArrondi/list")
	public AffectUserToArrondi createUserArrondi( @RequestBody AffectUserToArrondi userArrondi) {
		
		return this.auta.save(userArrondi);
	}
	
	@PutMapping(path = "affectUserToArrondi/byCodAffUseToArr/{id}")
public AffectUserToArrondi updateUserArrondi(@PathVariable(name = "id") Long id, @RequestBody AffectUserToArrondi userArrondi) {
		return this.auta.edit(id, userArrondi);
	}
	
	@DeleteMapping(path = "affectUserToArrondi/byCodAffUseToArr/{id}")
	public Boolean deleteUserArrondi(@PathVariable(name = "id") Long id) {
		
		return this.auta.delete(id);
	}	
	
	
}
