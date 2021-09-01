package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.Exercice;

@Repository
public interface ApprovisionementRepository extends JpaRepository<Approvisionnement, String>{

	public List<Approvisionnement> findByNumAppro(String numAppro);
	
	public List<Approvisionnement> findByExercice(Exercice exercice);
	
	public List<Approvisionnement> findByDateAppro(Date dateAppro);
	
	public List<Approvisionnement> findByDescriptionAppro(String descriptionAppro);
	
	@Query(value="SELECT valeur FROM approvisionnement WHERE code_exercice = ?1 ORDER BY valeur DESC LIMIT 1;"
			, nativeQuery = true)
	public Integer findLastNumUsed(String codeExercice);
	
}
