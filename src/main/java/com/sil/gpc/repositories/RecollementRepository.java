package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.Recollement;
import com.sil.gpc.domains.Regisseur;

@Repository
public interface RecollementRepository extends JpaRepository<Recollement, String> {

	public List<Recollement> findByNumRecollement(String NumRecollement);

	public List<Recollement> findByDescriptionRecollement(String DescriptionRecollement);

	public List<Recollement> findByDateRecollement(Date DateRecollement);

	public List<Recollement> findByRegisseur(Regisseur reg);

	public List<Recollement> findByExercice(Exercice exo);

	@Query(value = "SELECT valeur FROM recollement WHERE code_exercice = ?1 ORDER BY valeur DESC LIMIT 1;", nativeQuery = true)
	public Integer findLastNumUsed(String codeExercice);

}
