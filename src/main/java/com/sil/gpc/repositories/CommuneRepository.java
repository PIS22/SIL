package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Commune;
import com.sil.gpc.domains.Departement;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, String>{

	public List<Commune> findByCodeCommune(String codeCommune);
	
	public List<Commune> findByNomCommune(String nomCommune);
	
	public List<Commune> findByNumTelMairie(String numTelMairie);
	
	public List<Commune> findByAdresseMairie(String adresseMairie);
	
	public List<Commune> findByCodeDepartement(Departement departement);
	
}
