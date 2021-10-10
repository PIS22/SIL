package com.sil.gpc.repositories;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Contrat;
import com.sil.gpc.domains.Echeance;
import com.sil.gpc.domains.OpCaisse;

@Repository
public interface EcheanceRepository extends JpaRepository<Echeance, Long> {

	public List<Echeance> findByIdEcheance(Long idEcheance);

	public List<Echeance> findByDateEcheance(Date dateEcheance);

	public List<Echeance> findByMoisEcheance(String moisEcheance);

	public List<Echeance> findByContrat(Contrat contrat);

	public List<Echeance> findByOpCaisse(OpCaisse opCaisse);

	public List<Echeance> findByPayeEcheance(boolean payeEcheance);

	@Query(value = "SELECT echeance.* FROM echeance, op_caisse\r\n"
			+ "where op_caisse.num_op_caisse=echeance.num_op_caisse  and\r\n"
			+ "op_caisse.valide_op_caisse=false", nativeQuery = true)
	public List<Echeance> echeancesAnnules();

	@Query(value = "SELECT echeance.* FROM echeance, op_caisse\r\n"
			+ "where op_caisse.num_op_caisse=echeance.num_op_caisse  and\r\n"
			+ "op_caisse.valide_op_caisse=true", nativeQuery = true)
	public List<Echeance> echeancesValides();

	@Query(value = "SELECT SUM(E.prix) From Echeance AS E, OpCaisse AS OP WHERE("
			+ "			OP.numOpCaisse= E.numOpCaisse AND OP.codeModPay= ?1 AND OP.codeCaisse=?2"
			+ "			AND OP.dateSaisie BETWEEN ?3 AND ?4)", nativeQuery = true)
	public double caisseModLoca(String cMode, String cCaisse, Timestamp dDeb, Timestamp dFin);

	@Query(value = "SELECT SUM(Echeance.prix) From Echeance, OpCaisse, Caisse WHERE(OpCaisse.numOpCaisse= Echeance.numOpCaisse"
			+ " And OpCaisse.codeCaisse= Caisse.codeCaisse AND OpCaisse.codeModPay= ?1 AND "
			+ "Caisse.codeArrondi=?2 AND OpCaisse.DateSaisie BETWEEN ?3 AND ?4)", nativeQuery = true)
	public double arrModLoca(String cMode, String cCaisse, Timestamp dDeb, Timestamp dFin);

	@Query(value = "Select E.* From echeance E Where E.num_op_caisse=?", nativeQuery = true)
	public List<Echeance> lignesOP(String numop);

}
