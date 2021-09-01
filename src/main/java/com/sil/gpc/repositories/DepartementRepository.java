package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sil.gpc.domains.Departement;
import com.sil.gpc.domains.Pays;

public interface DepartementRepository extends JpaRepository<Departement, String> {

	public List<Departement> findByCodeDepartement(String codeDepartement);
	
	public List<Departement> findByNomDepartement(String nomDepartement);
	
	public List<Departement> findByPays(Pays pays);
	
}
