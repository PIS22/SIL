package com.sil.gpc.repositories;

import java.time.LocalDateTime;
import java.util.List;

import com.sil.gpc.dto.ImputByArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LignePointVente;
import com.sil.gpc.domains.Stocker;

@Repository
public interface LignePointVenteRepository extends JpaRepository<LignePointVente, Long> {

	public List<LignePointVente> findByArticle(Article article);

	public List<LignePointVente> findByQuantiteLignePointVente(double qte);

	public List<LignePointVente> findByPULignePointVente(double prix);

	@Query(value = "SELECT l.* FROM ligne_point_vente l where l.num_point_vente in\r\n"
			+ "	(SELECT p.num_point_vente from point_vente p Where p.num_op_caisse = ?)", nativeQuery = true)
	public List<LignePointVente> ligneByOp(String numop);

	@Query(value = "UPDATE stocker set quantiter_stocker = quantiter_stocker- ? where code_magasin=? and code_article=?", nativeQuery = true)
	public Stocker ajusterQuantite(double qtv, String cMag, String cArt);

	@Query(value = "INSERT INTO stocker (code_article, cump, code_magasin, quantiter_stocker) VALUSE(?,?,?,?)", nativeQuery = true)
	public Stocker ajouteLigne(String cArt, double pu, String cMag, double qte);

	//Léo
	List<LignePointVente> findAllByPointVente_NumPointVente(String numPointVente);

	@Query(value = "SELECT *\n" +
			"\tFROM public.point_vente, op_caisse, ligne_point_vente where ligne_point_vente.num_point_vente = point_vente.num_point_vente\n" +
			"\tAND point_vente.num_op_caisse = op_caisse.num_op_caisse AND op_caisse.code_caisse = :codeCaisse \n" +
			"\tAnd point_vente.payer_point = true and point_vente.valide_point = true AND  point_vente.date_point_vente >= :startDate AND point_vente.date_point_vente <= :endDate ;", nativeQuery = true)
	List<LignePointVente> getAllLignePvImput(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("codeCaisse") String codeCaisse);

	@Query(value = "SELECT  ligne_point_vente.code_article, article.lib_article, sum(quantite_ligne_point_vente) as quantite, sum(quantite_ligne_point_vente*puligne_point_vente) as montant\n" +
			"\tFROM ligne_point_vente, point_vente, op_caisse, article\n" +
			"\twhere ligne_point_vente.num_point_vente = point_vente.num_point_vente \n" +
			"\tAND point_vente.num_op_caisse = op_caisse.num_op_caisse AND op_caisse.code_caisse = :codeCaisse \n" +
			"\tAND point_vente.payer_point = true AND point_vente.valide_point = true\n" +
			"\tAND point_vente.date_point_vente >= :startDate AND point_vente.date_point_vente <= :endDate\n" +
			"\tAND article.code_article = ligne_point_vente.code_article\n" +
			"\tGROUP BY ligne_point_vente.code_article, article.lib_article ;", nativeQuery = true)
	List<ImputByArticle> getAllLignePvImputGroupByArticle(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("codeCaisse") String codeCaisse);

}
