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

import com.sil.gpc.domains.Correspondant;
import com.sil.gpc.domains.LignePointVente;
import com.sil.gpc.domains.PointVente;
import com.sil.gpc.domains.TypCorres;
import com.sil.gpc.services.CorrespondantService;
import com.sil.gpc.services.LignePointVenteService;
import com.sil.gpc.services.PointVenteService;
import com.sil.gpc.services.TypCorresService;

@CrossOrigin
@RestController
@RequestMapping(path = "/perfora-gpc/v1/stock/")
public class CorrespondantController {

	private final CorrespondantService correspondantService;
	private final TypCorresService typCorresService;
	private final PointVenteService pointVenteService;
	private final LignePointVenteService lignePointVenteService;
	
	public CorrespondantController(CorrespondantService correspondantService, TypCorresService typCorresService,
			PointVenteService pointVenteService, LignePointVenteService lignePointVenteService) {
		super();
		this.correspondantService = correspondantService;
		this.typCorresService = typCorresService;
		this.pointVenteService = pointVenteService;
		this.lignePointVenteService = lignePointVenteService;
		
	}
	
	/*###########################################################
	#############	Partie réservée pour Correspondant
	###########################################################
	*/
	
	@GetMapping(path = "correspondant/list")
	public List<Correspondant> getAllCorrespondant(){
		
		return this.correspondantService.getAll();
	}
	
	@GetMapping(path = "correspondant/byCodCor/{id}")
	public Optional<Correspondant> getCorrespondantById(@PathVariable(name = "id") String id){
		
		return this.correspondantService.getById(id);
	}

	@GetMapping(path = "correspondant/imputable")
	public List<Correspondant> getCorrespondantImput(){
		
		return this.correspondantService.findByImputableCorres(true);
	}
	
	@PostMapping(path = "correspondant/list")
	public Correspondant createCorrespondant( @RequestBody Correspondant correspondant) {
		
		return this.correspondantService.save(correspondant);
	}
	
	@PutMapping(path = "correspondant/byCodCor/{id}")
	public Correspondant updateCorrespondant(@PathVariable(name = "id") String id, @RequestBody Correspondant correspondant) {
		
		return this.correspondantService.edit(id, correspondant);
	}
	
	@DeleteMapping(path = "correspondant/byCodCor/{id}")
	public Boolean deleteCorrespondant(@PathVariable(name = "id") String id) {
		
		return this.correspondantService.delete(id);
	}
	
	
	/*###########################################################
	#############	Partie réservée pour type Correspondant
	###########################################################
	*/
	
	@GetMapping(path = "typecorrespondant/list")
	public List<TypCorres> getAllTypeCorrespondant(){
		
		return this.typCorresService.getAll();
	}
	
	@GetMapping(path = "typecorrespondant/byCodTypCor/{id}")
	public Optional<TypCorres> getTypeCorrespondantById(@PathVariable(name = "id") String id){
		
		return this.typCorresService.findById(id);
	}
	
	@PostMapping(path = "typecorrespondant/list")
	public TypCorres createTypeCorrespondant( @RequestBody TypCorres correspondant) {
		
		return this.typCorresService.save(correspondant);
	}
	
	@PutMapping(path = "typecorrespondant/byCodTypCor/{id}")
	public TypCorres updateTypeCorrespondant(@PathVariable(name = "id") String id, @RequestBody TypCorres typCorres) {
		
		return this.typCorresService.edit(id, typCorres);
	}
	
	@DeleteMapping(path = "typecorrespondant/byCodCor/{id}")
	public Boolean deleteTypeCorrespondant(@PathVariable(name = "id") String id) {
		
		return this.typCorresService.delete(id);
	}
	
	/*###########################################################
	#############	Partie réservée pour point Vente
	###########################################################
	*/
	
	@GetMapping(path = "pointvente/list")
	public List<PointVente> getAllPointVente(){
		
		return this.pointVenteService.getAll();
	}
	
	@GetMapping(path = "pointvente/byCodPvt/{id}")
	public Optional<PointVente> getPointVenteById(@PathVariable(name = "id") String id){
		
		return this.pointVenteService.findById(id);
	}
	
	@PostMapping(path = "pointvente/list")
	public PointVente createPointVente( @RequestBody PointVente pv) {
		
		return this.pointVenteService.save(pv);
	}
	
	@PutMapping(path = "pointvente/byCodPvt/{id}")
	public PointVente updatePointVente(@PathVariable(name = "id") String id, @RequestBody PointVente pv) {
		return this.pointVenteService.edit(id, pv);
	}
	
	@DeleteMapping(path = "pointvente/byCodPvt/{id}")
	public Boolean delete(@PathVariable(name = "id") String id) {
		
		return this.typCorresService.delete(id);
	}


	/*###########################################################
	#############	Partie réservée pour ligne point Vente
	###########################################################
	*/

	
	@GetMapping(path = "lignepointvente/list")
	public List<LignePointVente> getAllLignePointVente(){
		
		return this.lignePointVenteService.findAll();
	}
	
	@GetMapping(path = "lignepointvente/byCodLpv/{id}")
	public Optional<LignePointVente> getLignePointVenteById(@PathVariable(name = "id") Long id){
		return this.lignePointVenteService.findById(id);
	}
	
	@PostMapping(path = "lignepointvente/list")
	public LignePointVente createLignePointVente( @RequestBody LignePointVente lpv) {
		
		return this.lignePointVenteService.save(lpv);
	}
	
	@PutMapping(path = "lignepointvente/byCodLpv/{id}")
	public LignePointVente updateLignePointVente(@PathVariable(name = "id") Long id, @RequestBody LignePointVente lpv) {
		
		return this.lignePointVenteService.edit(lpv, id);
	}
	
	@DeleteMapping(path = "lignepointvente/byCodLpv/{id}")
	public Boolean deleteLignePointVente(@PathVariable(name = "id") Long id) {
		
		return this.lignePointVenteService.delete(id);
	}
	
}
