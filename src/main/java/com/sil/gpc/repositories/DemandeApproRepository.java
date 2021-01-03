package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.DemandeApprovisionnement;
import com.sil.gpc.domains.Exercice;

@Repository
public interface DemandeApproRepository extends JpaRepository<DemandeApprovisionnement, String> {

	public List<DemandeApprovisionnement> findByNumDA(String numDA);
	
	public List<DemandeApprovisionnement> findByDateDA(Date dateDA);
	
	public List<DemandeApprovisionnement> findByExercice(Exercice exercice);
	
	
}
