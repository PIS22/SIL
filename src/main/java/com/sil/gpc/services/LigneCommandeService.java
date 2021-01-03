package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.repositories.LigneCommandeRepository;

@Service
public class LigneCommandeService {

	private final LigneCommandeRepository repo;

	public LigneCommandeService(LigneCommandeRepository repo) {
		super();
		this.repo = repo;
	}
	
	public LigneCommande save(LigneCommande ligneCommande) {
		
		return this.repo.save(ligneCommande);
	}
	
	public LigneCommande edit(Long id, LigneCommande ligneCommande) {
		
		LigneCommande entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setPULigneCommande(ligneCommande.getPULigneCommande());
			entiter.setQteLigneCommande(ligneCommande.getQteLigneCommande());
			entiter.setRemise(ligneCommande.getRemise());
			entiter.setTVA(ligneCommande.getTVA());
			entiter.setArticle(ligneCommande.getArticle());
			entiter.setNumCommande(ligneCommande.getNumCommande());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public void delete(Long id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
	}
	
	public Optional<LigneCommande> getById(Long id){
		
		return this.repo.findById(id);
	}
	
	public List<LigneCommande> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<LigneCommande> findByIdLigneCommande (Long idLigneCommande){
		
		return this.repo.findByIdLigneCommande(idLigneCommande);
	}
	
	public List<LigneCommande> findByQteLigneCommande(Long qteLigneCommande){
		
		return this.repo.findByQteLigneCommande(qteLigneCommande);
	}
	
	public List<LigneCommande> findByPULigneCommande(Long PULigneCommande){
		
		return this.repo.findByPULigneCommande(PULigneCommande);
	}
	
	public List<LigneCommande> findByREmise(Long remise){
		
		return this.repo.findByREmise(remise);
	}
	
	public List<LigneCommande> findByTVA(Long tva){
		
		return this.repo.findByTVA(tva);
	}
	
	public List<LigneCommande> findByNumCommande(Commande commande){
		
		return this.repo.findByNumCommande(commande);
	}
	
	public List<LigneCommande> findByArticle(Article article){
		
		return this.repo.findByArticle(article);
	}
	
}
