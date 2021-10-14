package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Associer;

@Repository
public interface AssocierRepository extends JpaRepository<Associer, Long> {

	
	
}
