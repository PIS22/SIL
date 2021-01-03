package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneReversement;

@Repository
public interface LigneReversementRepository  extends JpaRepository<LigneReversement, Long>{

}
