package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays, String>{

	List<Pays> findByCodePays(String codePays);
	List<Pays> findByNomCompletPays(String nomCompletPays);
	List<Pays> findByNomPays(String nomPays);
	
}
