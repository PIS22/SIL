package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

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
		
		return this.repo.save(commande);
	}
	
	public Commande edit(String id, Commande commande) {
		
		Commande entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateCommande(commande.getDateCommande());
			entiter.setDelaiLivraison(commande.getDelaiLivraison());
			entiter.setDescription(commande.getDescription());
			entiter.setExercice(commande.getExercice());
			entiter.setFrs(commande.getFrs());
			
			return this.repo.save(commande);
		}
		
		return null;
	}
	
	public void delete(String id) {
		
		if(this.repo.existsById(id))
			this.repo.deleteById(id);
	}
	
	public Optional<Commande> getById(String id){
		
		return this.repo.findById(id);
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
