package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Immo;

@Repository
public interface ImmoRepository extends JpaRepository<Immo, Long>{

}
