package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.Correspondant;
import com.sil.gpc.domains.Regisseur;
import com.sil.gpc.domains.PointVente;

@Repository
public interface PointVenteRepository extends JpaRepository<PointVente, String> {
	
	public List<PointVente> findByNumPointVente(String numPv);
	
	public List<PointVente> findBypayerPoint(boolean payerPV);
	
	public List<PointVente> findByDatePointVente(Date datePayerPV);
	
	public List<PointVente> findByExercice(Exercice exo);
	
	public List<PointVente> findByCorrespondant(Correspondant corresp);
	
	public List<PointVente> findByRegisseur(Regisseur reg);
	
	@Query(value="SELECT valeur FROM point_vente WHERE code_exercice = ?1 ORDER BY valeur DESC LIMIT 1;"
			, nativeQuery = true)
	public Integer findLastNumUsed(String codeExercice);

}
