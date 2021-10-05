package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.OpCaisse;

@Repository
public interface OpCaisseRepository extends JpaRepository<OpCaisse, String> {

	List<OpCaisse> findByCaisse(String codCai);

	List<OpCaisse> findByContribuable(String contribuable);

	List<OpCaisse> findByDateOpCaisse(Date dateOpCaisse);

	List<OpCaisse> findByModePaiement(String CodMP);

	List<OpCaisse> findByTypeRecette(String codTR);

	@Query(value = "SELECT * FROM op_caisse WHERE op_caisse.valide_op_caisse=false", nativeQuery = true)
	public List<OpCaisse> opcannule();

	@Query(value = "SELECT * FROM op_caisse WHERE op_caisse.valide_op_caisse=true", nativeQuery = true)
	public List<OpCaisse> opcValides();

	@Query(value = "SELECT * FROM op_caisse op WHERE op.valide_op_caisse=true\r\n"
			+ "AND id_utilisateur= ? AND date_op_caisse>=current_Date", nativeQuery = true)
	public List<OpCaisse> dailyOp(Long idUser);

	@Query(value = "SELECT * FROM op_caisse WHERE idUtilisateur = ?1 AND date_op_caisse=?2;", nativeQuery = true)
	public List<OpCaisse> userOpcOfDay(Long idUser, Date dateOpCaisse);

	@Query(value = "SELECT * FROM op_caisse WHERE idUtilisateur = ?1;", nativeQuery = true)
	public List<OpCaisse> userOpc(Long idUser);

	@Query(value = "SELECT valeur FROM op_caisse WHERE code_caisse = ?1 AND code_exercice = ?2 ORDER BY valeur DESC LIMIT 1;", nativeQuery = true)
	public Integer findLastNumUsed(String codeCai, String codeExo);

}
