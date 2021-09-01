package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Arrondissement;
import com.sil.gpc.domains.Commune;

@Repository
public interface ArrondissementRepository extends JpaRepository<Arrondissement, String>{

	public List<Arrondissement> findByCodeArrondi(String codeArrondi);
	
	public List<Arrondissement> findByNomArrondi(String nomArrondi);
	
	public List<Arrondissement> findByNumTelArrondi(String numTelArrondi);
	
	public List<Arrondissement> findByAdresseArrondi(String adresseArrondi);
	
	public List<Arrondissement> findByCommune(Commune commune);
	
}
