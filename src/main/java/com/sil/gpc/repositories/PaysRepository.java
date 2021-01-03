package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays, String>{

}
