package com.sil.gpc.controllers.comptabilite;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sil.gpc.domains.Ecriture;
import com.sil.gpc.domains.Immo;
import com.sil.gpc.domains.LigneEcriture;
import com.sil.gpc.services.EcritureService;
import com.sil.gpc.services.ImmoService;
import com.sil.gpc.services.LigneEcritureService;

@RestController
@CrossOrigin
@RequestMapping(path = "/perfora-gpc/v1/compta/")
public class ComptaTraitementController {
	
	private final ImmoService immoService;
	private final EcritureService ecritureService;
	private final LigneEcritureService ligneEcritureService;
	
	public ComptaTraitementController(ImmoService immoService, EcritureService ecritureService,
			LigneEcritureService ligneEcritureService) {
		super();
		this.immoService = immoService;
		this.ecritureService = ecritureService;
		this.ligneEcritureService = ligneEcritureService;
	}
	
	/*
	 * ####################### 
	 * Partie réservée pour Immo
	 * ##########################
	 */

	@GetMapping(path = "immo/list")
	public List<Immo> getAllImmo() {
		return this.immoService.getAll();
	}

	@GetMapping(path = "immo/byCodImmo/{id}")
	public Immo getImmoById(@PathVariable(name = "id") Long id) {
		return this.immoService.getById(id);
	}


	@PostMapping(path = "immo/list")
	public Immo createImmo(@RequestBody Immo immo) {
		return this.immoService.add(immo);
	}

	@PutMapping(path = "immo/byCodImmo/{id}")
	public Immo updateImmo(@PathVariable(name = "id") Long id, @RequestBody Immo immo) {

		return this.immoService.edit(id, immo);
	}

	@DeleteMapping(path = "immo/byCodImmo/{id}")
	public Boolean deleteImmo(@PathVariable(name = "id") Long id) {

		return this.immoService.delete(id);
	}

	
	/*
	 * ####################### 
	 * Partie réservée pour Ecriture
	 * ##########################
	 */
	
	
	@GetMapping(path = "ecriture/list")
	public List<Ecriture> getAllEcriture() {
		return this.ecritureService.getAll();
	}

	@GetMapping(path = "ecriture/byCodEcri/{id}")
	public Ecriture getEcritureById(@PathVariable(name = "id") String id) {
		return this.ecritureService.getById(id);
	}


	@PostMapping(path = "ecriture/list")
	public Ecriture createEcriture(@RequestBody Ecriture ecriture) {
		return this.ecritureService.add(ecriture);
	}

	@PutMapping(path = "ecriture/byCodEcri/{id}")
	public Ecriture updateEcriture(@PathVariable(name = "id") String id, @RequestBody Ecriture ecriture) {

		return this.ecritureService.edit(id, ecriture);
	}

	@DeleteMapping(path = "ecriture/byCodEcri/{id}")
	public Boolean deleteEcriture(@PathVariable(name = "id") String id) {

		return this.ecritureService.delete(id);
	}
	
	
	
	
	/*
	 * ####################### 
	 * Partie réservée pour LigneEcriture
	 * ##########################
	 */
	
	
	@GetMapping(path = "ligneEcriture/list")
	public List<LigneEcriture> getAllLigneEcriture() {
		return this.ligneEcritureService.getAll();
	}

	@GetMapping(path = "ligneEcriture/byCodLigEcr/{id}")
	public LigneEcriture getLigneEcritureById(@PathVariable(name = "id") Long id) {
		return this.ligneEcritureService.getById(id);
	}


	@PostMapping(path = "ligneEcriture/list")
	public LigneEcriture createLigneEcriture(@RequestBody LigneEcriture ligneEcriture) {
		return this.ligneEcritureService.add(ligneEcriture);
	}

	@PutMapping(path = "ligneEcriture/byCodLigEcr/{id}")
	public LigneEcriture updateLigneEcriture(@PathVariable(name = "id") Long id, @RequestBody LigneEcriture ligneEcriture) {
		return this.ligneEcritureService.edit(id, ligneEcriture);
	}

	@DeleteMapping(path = "ligneEcriture/byCodLigEcr/{id}")
	public Boolean deleteLigneEcriture(@PathVariable(name = "id") Long id) {
		return this.ligneEcritureService.delete(id);
	}
	
}
