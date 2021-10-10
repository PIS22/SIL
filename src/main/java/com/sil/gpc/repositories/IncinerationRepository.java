package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Incineration;
@Repository
public interface IncinerationRepository extends JpaRepository<Incineration, String>{

	@Query(value = "SELECT TOP 1 Valeur FROM Incineration WHERE (code_exercice =?1) "
			+ "ORDER BY DESC ", nativeQuery = true)
	public int dernièreValeur(String codExo);
}
