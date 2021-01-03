package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Pays;
import com.sil.gpc.repositories.PaysRepository;

@Service
public class PaysService {
	private final PaysRepository paysr;

	/**
	 * @param paysr
	 */
	public PaysService(PaysRepository paysr) {
		this.paysr = paysr;
	}
	
	public Pays ajoutePays(Pays p){
		return paysr.save(p);
	}
	
	public Pays recherchePays(String cp){
		return paysr.getOne(cp);
	}

	public Pays modifiePays(Pays p, String cp){
		Pays pays=paysr.getOne(cp);
		pays.setCodePays(p.getCodePays());
		pays.setNomCompletPays(p.getNomCompletPays());
		pays.setNomPays(p.getNomPays());
		return paysr.save(pays);
	}
	
	public List<Pays> supprimePays(String cp){
		paysr.deleteById(cp);
		return paysr.findAll();
	}
}
