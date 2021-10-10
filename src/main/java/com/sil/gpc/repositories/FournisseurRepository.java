package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, String> {

	public List<Fournisseur> findByCodeFrs(String codeFrs);
	
	public List<Fournisseur> findByAdresseFrs(String adresseFrs);
	
	public List<Fournisseur> findByDescription(String description);
	
	public List<Fournisseur> findByIdentiteFrs(String identiteFrs);
	
	public List<Fournisseur> findByNumIfuFrs(String numIfuFrs);
	
	public List<Fournisseur> findByRaisonSociale(String raisonSociale);
	
	public List<Fournisseur> findByTelFRS(String telFRS);
	
	
}
