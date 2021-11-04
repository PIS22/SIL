package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.AffectComptToCaisse;

@Repository
public interface AffectComptToCaisseRepository extends JpaRepository<AffectComptToCaisse, Long> {

}
