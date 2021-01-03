package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Magasin;
import com.sil.gpc.repositories.MagasinRepository;

@Service
public class MagasinService {
	
	private final MagasinRepository mgr;

	/**
	 * @param mr
	 */
	public MagasinService(MagasinRepository mr) {
		this.mgr = mr;
	}
	
	public Magasin ajouteMagasin(Magasin mg){
		return mgr.save(mg);
	}

	
	public Magasin modifieMagasin(Magasin mg, String cm){
		Magasin mag=mgr.getOne(cm);
		mag.setCodeMagasin(mg.getCodeMagasin());
		mag.setLibMagasin(mg.getLibMagasin());
		return mgr.save(mag);
	}

	
	List<Magasin> supprimeMagasin(String cm){
		mgr.deleteById(cm);
		return mgr.findAll();
	}

}
