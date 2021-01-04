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
		return repos.save(placem);
	}

	public Placement edit(Placement p, String np){
		Placement placem=repos.getOne(np);
		if (placem!=null) {
		placem.setDatePlacement(p.getDatePlacement());
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
	
	public List<Placement> findById(Date dateP){
		return repos.findByDatePlacement(dateP);
	}
	
	public Boolean delete(String np){
		repos.deleteById(np);
		return repos.existsById(np);
	}
}
