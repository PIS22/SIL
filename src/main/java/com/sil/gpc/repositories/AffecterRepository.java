package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Affecter;
import com.sil.gpc.domains.Caisse;
import com.sil.gpc.domains.Utilisateur;

@Repository
public interface AffecterRepository extends JpaRepository<Affecter, Long>{

	public List<Affecter> findByUtilisateur(Utilisateur utilisateur);
	
	public List<Affecter> findByCaisse(Caisse caisse);
	
	public List<Affecter> findByDateDebAffecter(Date dateDebAffecter);
	
	public List<Affecter> findByDateFinAffecter(Date dateFinAffecter);
	
}
