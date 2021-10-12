package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Correspondant;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.LignePointVente;
import com.sil.gpc.domains.PointVente;
import com.sil.gpc.domains.Regisseur;

@Repository
public interface PointVenteRepository extends JpaRepository<PointVente, String> {

	public Optional<PointVente> findByNumPointVente(String numPv);


	public List<PointVente> findBypayerPoint(boolean payerPV);

	public List<PointVente> findByDatePointVente(Date datePayerPV);

	public List<PointVente> findByExercice(Exercice exo);

	public List<PointVente> findByCorrespondant(Correspondant corresp);

	public List<PointVente> findByRegisseur(Regisseur reg);

	@Query(value = "SELECT valeur FROM point_vente WHERE code_exercice = ?1 ORDER BY valeur DESC LIMIT 1;", nativeQuery = true)
	public Integer findLastNumUsed(String codeExercice);

	@Query(value = "Select l.* From ligne_point_vente l Where l.num_point_vente =?", nativeQuery = true)
	public List<LignePointVente> ligneByPv(String numop);

	@Query(value = "Select p.num_point_vente From point_vente p Where p.num_op_caisse =?", nativeQuery = true)
	public List<String> pointByOp(String numop);

	List<PointVente> findAllByCorrespondant_IdCorrespondantAndPayerPointIsFalse(String codeCorres);

}
