package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Magasinier;

@Repository
public interface MagasinierRepository extends JpaRepository<Magasinier, Long>{

}
