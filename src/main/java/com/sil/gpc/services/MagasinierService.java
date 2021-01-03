package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Magasinier;
import com.sil.gpc.repositories.MagasinierRepository;

@Service
public class MagasinierService {

	private final MagasinierRepository mgr;

	/**
	 * @param mgr
	 */
	public MagasinierService(MagasinierRepository mgr) {
		this.mgr = mgr;
	}

	public Magasinier ajouteMagasinier(Magasinier mg){
		return mgr.save(mg);
	}
	public Magasinier modifieMagassinier(Magasinier mg, Long num){
		Magasinier mag=mgr.getOne(num);
		mag.setNomMagasinier(mg.getNomMagasinier());
		mag.setPrenomMagasinier(mg.getPrenomMagasinier());
		mag.setTelMagasinier(mg.getTelMagasinier());
		return mgr.save(mag);
	}
	
	public List<Magasinier> supprimeMagasinier(Long num){
		mgr.deleteById(num);
		return mgr.findAll();
	}
}
