package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Magasin;

@Repository
public interface MagasinRepository extends JpaRepository<Magasin, String>{

}
