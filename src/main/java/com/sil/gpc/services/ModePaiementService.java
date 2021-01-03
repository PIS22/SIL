package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.ModePaiement;
import com.sil.gpc.repositories.ModePaiementRepository;

@Service
public class ModePaiementService {
	private final ModePaiementRepository mpr;

	/**
	 * @param mpr
	 */
	public ModePaiementService(ModePaiementRepository mpr) {
		this.mpr = mpr;
	}

	public ModePaiement ajouteModePaiment(ModePaiement mp){
		return mpr.save(mp);
	}
	
	
	public ModePaiement modifieMP(ModePaiement mp, String code){
		ModePaiement modep=mpr.getOne(code);
		modep.setCodeModPay(mp.getCodeModPay());
		modep.setLibeModPay(mp.getLibeModPay());
		return mpr.save(modep);
	}

	public List<ModePaiement> suppprimeModePaiement(String code){
		mpr.deleteById(code);
		return mpr.findAll();
	}
	
	public ModePaiement rechercheModePaiement(String code){
		return mpr.getOne(code);
	}
}
