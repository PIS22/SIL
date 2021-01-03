package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Placement;
import com.sil.gpc.repositories.PlacementRepository;

@Service
public class PlacementService {
	private final PlacementRepository placr;

	/**
	 * @param placr
	 */
	public PlacementService(PlacementRepository placr) {
		this.placr = placr;
	}
	
	public Placement ajoutePlacement(Placement placem){
		return placr.save(placem);
	}

	public Placement modifiePlacement(Placement p, String np){
		Placement placem=placr.getOne(np);
		placem.setDatePlacement(p.getDatePlacement());
		return placr.save(placem);
	}
	
	public Placement recherchePlacement(String np){
		return placr.getOne(np);
	}
	
	public List<Placement> supprimePlacement(String np){
		placr.deleteById(np);
		return placr.findAll();
	}
}
