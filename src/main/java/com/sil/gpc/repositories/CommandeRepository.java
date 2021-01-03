package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.Fournisseur;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, String> {

	public List<Commande> findByNumCommande(String numCommande);
	
	public List<Commande> findByDateCommande(Date dateCommande);
	
	public List<Commande> findByDescription(String description);
	
	public List<Commande> findByDelaiLivraison(int delaiLivraison);
	
	public List<Commande> findByFrs(Fournisseur fournisseur);
	
	public List<Commande> findByExercice(Exercice exercice);
	
}
