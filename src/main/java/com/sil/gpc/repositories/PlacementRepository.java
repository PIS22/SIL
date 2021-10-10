package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Placement;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, String>{

	List<Placement> findByDatePlacement(Date datePlacement);
	List<Placement> findByExercice(int exercice);
	
	@Query(value="SELECT valeur FROM placement WHERE code_exercice = ?1 ORDER BY valeur DESC LIMIT 1;"
			, nativeQuery = true)
	public Integer findLastNumUsed(String codeExercice);
}
