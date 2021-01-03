package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneRecollement;

@Repository
public interface LigneRecollementRepository extends JpaRepository<LigneRecollement, Long>{

}
