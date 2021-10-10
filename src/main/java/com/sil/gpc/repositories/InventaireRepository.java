package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Inventaire;

@Repository
public interface InventaireRepository extends JpaRepository<Inventaire, String>{

	@Query(value="SELECT valeur FROM Inventaire WHERE code_exercice = ?1 ORDER BY valeur DESC LIMIT 1;"
			, nativeQuery = true)
	Integer findLastNumUsed(String codeExo);
	
}
