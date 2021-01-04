package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Locataire;

@Repository
public interface LocataireRepository extends JpaRepository<Locataire, Long>{

	public List<Locataire> findByIdentiteLocataire(String identiteLocataire);
	public List<Locataire> findByAdresseLocataire(String adresseLocataire);
	public List<Locataire> findByIfuLocataire(String ifuLocataire);
	public List<Locataire> findByTelLocataire(String telLocataire);
	public List<Locataire> findByPersonneAContacter(String personneAContacter);
}
