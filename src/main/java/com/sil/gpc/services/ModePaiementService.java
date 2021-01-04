package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.ModePaiement;
import com.sil.gpc.repositories.ModePaiementRepository;

@Service
public class ModePaiementService {
	private final ModePaiementRepository repos;

	/**
	 * @param repos
	 */
	public ModePaiementService(ModePaiementRepository mpr) {
		this.repos = mpr;
	}

	public ModePaiement save(ModePaiement mp){
		return repos.save(mp);
	}
	
	
	public ModePaiement edit(ModePaiement mp, String code){
		ModePaiement modep=repos.getOne(code);
		if(modep!=null) {
		modep.setCodeModPay(mp.getCodeModPay());
		modep.setLibeModPay(mp.getLibeModPay());
		return repos.save(modep);
		}else
			return null;
	}

	public boolean delete(String code){
		repos.deleteById(code);
		return repos.existsById(code);
	}
	
	public Optional<ModePaiement> findById(String code){
		return repos.findById(code);
	}
	
	public List<ModePaiement> findByCode(String code){
		return repos.findByCodeModPay(code);
	}
	
	public List<ModePaiement> findByLibelle(String lib){
		return repos.findByLibeModPay(lib);
	}
	
	public List<ModePaiement> findAll(){
		return repos.findAll();
	}
}
