package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Correspondant;
import com.sil.gpc.domains.Placement;
import com.sil.gpc.domains.Regisseur;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, String>{

	List<Placement> findByDatePlacement(Date datePlacement);
	List<Placement> findByExercice(int exercice);
	List<Placement> findByCorrespondant(Correspondant corres);
	List<Placement> findByRegisseur(Regisseur regi);
	
}
