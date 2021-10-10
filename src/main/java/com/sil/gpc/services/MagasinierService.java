package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Magasinier;
import com.sil.gpc.repositories.MagasinierRepository;

@Service
public class MagasinierService {

	private final MagasinierRepository repos;

	/**
	 * @param repos
	 */
	public MagasinierService(MagasinierRepository mgr) {
		this.repos = mgr;
	}

	public Magasinier save(Magasinier mg){
		return repos.save(mg);
	}
	public Magasinier edit(Magasinier mg, Long num){
		Magasinier mag=repos.getOne(num);
		if(mag!=null) {
		mag.setNomMagasinier(mg.getNomMagasinier());
		mag.setPrenomMagasinier(mg.getPrenomMagasinier());
		mag.setTelMagasinier(mg.getTelMagasinier());
		return repos.save(mag);
		}else
			return null;
	}
	
	public Boolean delete(Long num){
		repos.deleteById(num);
		return repos.existsById(num);
	}
	
	public List<Magasinier> findAll(){
		return repos.findAll();
	}
	
	public Optional<Magasinier> findById(Long id){
		return repos.findById(id);
	}
	
	public List<Magasinier> findByNom(String nom){
		return repos.findByNomMagasinier(nom);
	}
	
	public List<Magasinier> findByPrenom(String prenom){
		return repos.findByPrenomMagasinier(prenom);
	}
	
	public List<Magasinier> findByTelephone(String tel){
		return repos.findByTelMagasinier(tel);
	}

}
