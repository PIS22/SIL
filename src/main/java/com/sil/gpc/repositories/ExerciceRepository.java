package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Exercice;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, String> {

	public List<Exercice> findByCodeExercice(String codeExercice);
	
	public List<Exercice> findByDateDebut(Date dateDebut);
	
	public List<Exercice> findByDateFin(Date dateFin);
	
	public List<Exercice> findByEtatExo(String etatExo);
	
	public List<Exercice> findByLibExercice(String libExercice);
	
	public List<Exercice> findByExoSelectionner(boolean exoSelectionner);
	
}
