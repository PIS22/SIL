package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.OpCaisse;

@Repository
public interface OpCaisseRepository extends JpaRepository<OpCaisse, String>{

	List<OpCaisse> findByCaisse(String codCai);
	List<OpCaisse> findByContribuable(String contribuable);
	List<OpCaisse> findByDateOpCaisse(Date dateOpCaisse);
	List<OpCaisse> findByModePaiement(String CodMP);
	List<OpCaisse> findByTypeRecette(String codTR);
	
}
