package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Magasin;
import com.sil.gpc.repositories.MagasinRepository;

@Service
public class MagasinService {
	
	private final MagasinRepository repos;

	/**
	 * @param repos
	 */
	public MagasinService(MagasinRepository mr) {
		this.repos = mr;
	}
	
	public Magasin save(Magasin mg){
		return repos.save(mg);
	}

	
	public Magasin edit(Magasin mg, String cm){
		Magasin mag=repos.getOne(cm);
		if(mag!=null) {
		mag.setCodeMagasin(mg.getCodeMagasin());
		mag.setLibMagasin(mg.getLibMagasin());
		return repos.save(mag);
		}else
			return null;
	}

	public boolean delete(String cm){
		repos.deleteById(cm);
		return repos.existsById(cm);
	}

	Optional<Magasin> findById(String cm){
		return repos.findById(cm);
	}

	List<Magasin> findByLibelle(String lib){
		return repos.findByLibMagasin(lib);
	}

	List<Magasin> findAll(){
		return repos.findAll();
	}

}
