package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Placement;
import com.sil.gpc.repositories.PlacementRepository;

@Service
public class PlacementService {
	private final PlacementRepository repos;

	/**
	 * @param placr
	 */
	public PlacementService(PlacementRepository placr) {
		this.repos = placr;
	}
	
	public Placement save(Placement placem){
placem.setValidepl(true);
		
		Integer val = 1, nbrMaxCaract = 6;
		String code = "PL-";
		if(this.repos.findLastNumUsed(placem.getExercice().getCodeExercice()) != null) {
			val = this.repos.findLastNumUsed(placem.getExercice().getCodeExercice());
			val++;
			
		}
		
		placem.setValeur(val);
		
		code = code+placem.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		placem.setNumPlacement(code+val);
		
		if(repos.existsById(placem.getNumPlacement())==false) return repos.save(placem);
		
		return null;
		
	}

	public Placement edit(Placement p, String np){
		Placement placem=repos.getOne(np);
		if (placem!=null) {
			placem.setDatePlacement(p.getDatePlacement());
			placem.setCorrespondant(p.getCorrespondant());
			placem.setExercice(p.getExercice());
			placem.setValidepl(p.isValidepl());
			placem.setRegisseur(p.getRegisseur());
			return repos.save(placem);
		}else
			return null;
	}
	
	public List<Placement> findAll(){
		return repos.findAll();
	}
	
	public Optional<Placement> findById(String np){
		return repos.findById(np);
	}
	
	public List<Placement> findByExercice(int exo) {
		return repos.findByExercice(exo);
	}
	
	public List<Placement> findByDatePlacement(Date dateP){
		return repos.findByDatePlacement(dateP);
	}
	
	public Boolean delete(String np){
		repos.deleteById(np);
		return repos.existsById(np);
	}
}
