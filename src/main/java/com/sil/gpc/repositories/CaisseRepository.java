package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Arrondissement;
import com.sil.gpc.domains.Caisse;

@Repository
public interface CaisseRepository extends JpaRepository<Caisse, String>{

	public List<Caisse> findByCodeCaisse(String codeCaisse);
	
	public List<Caisse> findByArrondissement(Arrondissement arrondissement);
	
	public List<Caisse> findByLibeCaisse(String libeCaisse);

@Override
default List<Caisse> findAll(Sort arg0) {
	// TODO Auto-generated method stub
	return null;
}
	
}
