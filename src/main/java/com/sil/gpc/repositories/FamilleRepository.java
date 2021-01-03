package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sil.gpc.domains.Famille;

public interface FamilleRepository extends JpaRepository<Famille, String>{

	public List<Famille> findByCodeFamille(String codeFamille);
	
	public List<Famille> findByLibFamille(String libFamille);
	
}
