package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Reversement;

@Repository
public interface ReversementRepository extends JpaRepository<Reversement, String> {
	
	public List<Reversement> findByNumReversement(String NumReversement);
	
	public List<Reversement> findByDateVersement(Date DateReversement);
	
	@Query(value="SELECT valeur FROM reversement WHERE code_exercice = ?1 ORDER BY valeur DESC LIMIT 1;"
			, nativeQuery = true)
	public Integer findLastNumUsed(String codeExercice);

}
