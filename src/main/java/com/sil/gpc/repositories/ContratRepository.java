package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Contrat;
import com.sil.gpc.domains.Immeuble;
import com.sil.gpc.domains.Locataire;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, String> {

	public List<Contrat> findByNumContrat(String numContrat);
	
	public List<Contrat> findByDateSignatureContrat(Date dateSignatureContrat);
	
	public List<Contrat> findByDateEffetContrat(Date dateEffetContrat);
	
	public List<Contrat> findByAvanceContrat(double avanceContrat);
	
	public List<Contrat> findByCautionContrat(double cautionContrat);
	
	public List<Contrat> findByImmeuble(Immeuble immeuble);

	//public List<Contrat> getByLocataire(Long idloc);

	public List<Contrat> findByLocataire(Locataire loc);
	
}
