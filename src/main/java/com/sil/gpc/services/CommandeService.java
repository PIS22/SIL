package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.Fournisseur;
import com.sil.gpc.repositories.CommandeRepository;

@Service
public class CommandeService {

	private final CommandeRepository repo;

	public CommandeService(CommandeRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Commande save(Commande commande) {
		commande.setValide(true);
		Integer val = 1, nbrMaxCaract = 6;
		String code = "CA-";
		if(this.repo.findLastNumUsed(commande.getExercice().getCodeExercice()) != null) {
			val = this.repo.findLastNumUsed(commande.getExercice().getCodeExercice());
			val++;
			
		}
		
		commande.setValeur(val);
		
		code = code+commande.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		commande.setNumCommande(code+val);
		System.out.println(commande.toString());
		
		if(repo.existsById(commande.getNumCommande())==false) return this.repo.save(commande) ;
		
		return null;
	}
	
	public Commande edit(String id, Commande commande) {
		
		Commande entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateCommande(commande.getDateCommande());
			entiter.setDelaiLivraison(commande.getDelaiLivraison());
			entiter.setDescription(commande.getDescription());
			entiter.setExercice(commande.getExercice());
			entiter.setFrs(commande.getFrs());
			entiter.setValide(commande.isValide());
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public Commande getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<Commande> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Commande> findByNumCommande(String numCommande){
		
		return this.repo.findByNumCommande(numCommande);
	}
	
	public List<Commande> findByDateCommande(Date dateCommande){
		
		return this.repo.findByDateCommande(dateCommande);
	}
	
	public List<Commande> findByDescription(String description){
		
		return this.repo.findByDescription(description);
	}
	
	public List<Commande> findByDelaiLivraison(int delaiLivraison){
		
		return this.repo.findByDelaiLivraison(delaiLivraison);
	}
	
	public List<Commande> findByFrs(Fournisseur fournisseur){
		
		return this.repo.findByFrs(fournisseur);
	}
	
	public List<Commande> findByExercice(Exercice exercice){
		
		return this.repo.findByExercice(exercice);
	}
	
}
