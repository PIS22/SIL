package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.DemandeApprovisionnement;
import com.sil.gpc.domains.LigneDemandeAppro;
import com.sil.gpc.repositories.LigneDemandeApproRepository;

@Service
public class LigneDemandeApproService {

	private final LigneDemandeApproRepository repo;

	public LigneDemandeApproService(LigneDemandeApproRepository repo) {
		super();
		this.repo = repo;
	}
	
	public LigneDemandeAppro save (LigneDemandeAppro ligneDemandeAppro) {
		
		return this.repo.save(ligneDemandeAppro);
	}
	
	public LigneDemandeAppro edit (Long id, LigneDemandeAppro ligneDemandeAppro) {
		
		LigneDemandeAppro entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setAppro(ligneDemandeAppro.getAppro());
			entiter.setArticle(ligneDemandeAppro.getArticle());
			entiter.setQuantiteDemandee(ligneDemandeAppro.getQuantiteDemandee());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete (Long id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public Optional<LigneDemandeAppro> getById(Long id){
		
		return this.repo.findById(id);
	}
	
	public List<LigneDemandeAppro> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<LigneDemandeAppro> findByIdLigneDA(Long idLigneDA){
		
		return this.repo.findByIdLigneDA(idLigneDA);
	}
	
	public List<LigneDemandeAppro> findByQuantiteDemandee(Long quantiteDemandee){
		
		return this.repo.findByQuantiteDemandee(quantiteDemandee);
	}
	
	public List<LigneDemandeAppro> findByArticle(Article article){
		
		return this.repo.findByArticle(article);
	}
	
	public List<LigneDemandeAppro> findByAppro(DemandeApprovisionnement appro){
		
		return this.repo.findByAppro(appro);
	}
	
}
