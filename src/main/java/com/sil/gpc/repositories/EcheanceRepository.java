package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
	
}
