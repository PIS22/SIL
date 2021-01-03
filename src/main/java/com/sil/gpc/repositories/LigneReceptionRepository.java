package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneReception;

@Repository
public interface LigneReceptionRepository extends JpaRepository<LigneReception, Long>{

}
