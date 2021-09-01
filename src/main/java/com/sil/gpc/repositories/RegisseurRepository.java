package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Regisseur;

@Repository
public interface RegisseurRepository extends JpaRepository<Regisseur, String> {
	
	public List<Regisseur> findByIdRegisseur(String IdRegisseur);
	

}
