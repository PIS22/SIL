package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneEcriture;

@Repository
public interface LigneEcritureRepository extends JpaRepository<LigneEcriture, Long> {

}
