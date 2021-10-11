package com.sil.gpc.repositories;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LigneOpCaisse;
import com.sil.gpc.domains.OpCaisse;
import org.springframework.data.repository.query.Param;

public interface LigneOpCaisseRepository extends JpaRepository<LigneOpCaisse, Long> {

	public List<LigneOpCaisse> findByArticle(Article article);

	public List<LigneOpCaisse> findByQteLigneOperCaisse(double qte);

	public List<LigneOpCaisse> findByPrixLigneOperCaisse(double prix);

	public List<LigneOpCaisse> findByOpCaisse(OpCaisse opCaisse);

	@Query(value = "SELECT ligne_op_caisse.* FROM ligne_op_caisse, op_caisse \r\n"
			+ "where op_caisse.num_op_caisse=ligne_op_caisse.num_op_caisse  and \r\n"
			+ "	op_caisse.valide_op_caisse=false", nativeQuery = true)
	List<LigneOpCaisse> ligneOpAnnules();

	@Query(value = "SELECT ligne_op_caisse.* FROM ligne_op_caisse, op_caisse \r\n"
			+ "where op_caisse.num_op_caisse=ligne_op_caisse.num_op_caisse  and \r\n"
			+ "	op_caisse.valide_op_caisse=true", nativeQuery = true)
	List<LigneOpCaisse> ligneOpValides();

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

	@Query(value = "Select LOP.* From ligne_op_caisse LOP Where LOP.num_op_caisse=?", nativeQuery = true)
	public List<LigneOpCaisse> lignesOP(String numop);

	// Léonel
	@Query(value = "SELECT id_ligne_oper_caisse, commentaire_ligne_oper_caisse, livre, prix_ligne_oper_caisse, qte_ligne_oper_caisse, \n" +
			"ligne_op_caisse.code_article, code_magasin, ligne_op_caisse.num_op_caisse\n" +
			"\tFROM ligne_op_caisse, article, op_caisse WHERE livre= false AND article.code_article = ligne_op_caisse.code_article \n" +
			"\tAND article.livrable_article = true AND op_caisse.num_op_caisse = ligne_op_caisse.num_op_caisse AND op_caisse.code_typ_rec = 'P' \n" +
			"\tAND op_caisse.code_caisse = :codeCaisse AND op_caisse.valide_op_caisse = true AND op_caisse.date_op_caisse >= :startDate " +
			"AND op_caisse.date_op_caisse <= :endDate", nativeQuery = true)
	List<LigneOpCaisse> getAllLinesOpCaisseBetweenTwoPeriodeAndCaisse(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("codeCaisse") String codeCaisse);

}
