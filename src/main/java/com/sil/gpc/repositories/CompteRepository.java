package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

}
