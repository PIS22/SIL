package com.sil.gpc.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LigneOpCaisse;
import com.sil.gpc.domains.OpCaisse;

public interface LigneOpCaisseRepository extends JpaRepository<LigneOpCaisse, Long> {

	public List<LigneOpCaisse> findByArticle(Article article);

	public List<LigneOpCaisse> findByQteLigneOperCaisse(double qte);

	public List<LigneOpCaisse> findByPrixLigneOperCaisse(double prix);

	public List<LigneOpCaisse> findByOpCaisse(OpCaisse opCaisse);

	@Query(value = "SELECT SUM(LigneOpCaisse.qteLigneOperCaisse*LigneOpCaisse.PrixLigneOperCaisse) From LigneOpCaisse, "
			+ "OpCaisse WHERE(OpCaisse.numOpCaisse= LigneOpCaisse.numOpCaisse AND OpCaisse.codModePay= ?1"
			+ "AND OpCaisse.CodeTypRec='I' AND OpCaisse.codeCaisse=?2 AND OpCaisse.DateSaisie BETWEEN ?3 AND ?4)", nativeQuery = true)
	public double caisseModImput(String cMode, String cCaisse, Timestamp dDeb, Timestamp dFin);

	@Query(value = "SELECT SUM(LigneOpCaisse.qteLigneOperCaisse*LigneOpCaisse.PrixLigneOperCaisse) From LigneOpCaisse, "
			+ "OpCaisse WHERE(OpCaisse.numOpCaisse= LigneOpCaisse.numOpCaisse AND OpCaisse.codModePay= ?1"
			+ "AND OpCaisse.CodeTypRec='P' AND OpCaisse.codeCaisse=?2 AND OpCaisse.DateSaisie BETWEEN ?3 AND ?4)", nativeQuery = true)
	public double caisseModPrest(String cMode, String cCaisse, Timestamp dDeb, Timestamp dFin);

	@Query(value = "SELECT SUM(LigneOpCaisse.qteLigneOperCaisse*LigneOpCaisse.PrixLigneOperCaisse) From"
			+ " LigneOpCaisse, OpCaisse, Caisse WHERE(OpCaisse.numOpCaisse= LigneOpCaisse.numOpCaisse"
			+ " And OpCaisse.codeCaisse= Caisse.codeCaisse AND OpCaisse.codModePay= ?1 AND "
			+ "OpCaisse.CodeTypRec='I' AND Caisse.codeArrondi=?2 AND OpCaisse.DateSaisie BETWEEN ?3 AND ?4)", nativeQuery = true)
	public double arrModImput(String cMode, String cCaisse, Timestamp dDeb, Timestamp dFin);

	@Query(value = "SELECT SUM(LigneOpCaisse.qteLigneOperCaisse*LigneOpCaisse.PrixLigneOperCaisse) From"
			+ " LigneOpCaisse, OpCaisse, Caisse WHERE(OpCaisse.numOpCaisse= LigneOpCaisse.numOpCaisse"
			+ " And OpCaisse.codeCaisse= Caisse.codeCaisse AND OpCaisse.codModePay= ?1 AND "
			+ "OpCaisse.CodeTypRec='P' AND Caisse.codeArrondi=?2 AND OpCaisse.DateSaisie BETWEEN ?3 AND ?4)", nativeQuery = true)
	public double arrModPrest(String cMode, String cCaisse, Timestamp dDeb, Timestamp dFin);

}
