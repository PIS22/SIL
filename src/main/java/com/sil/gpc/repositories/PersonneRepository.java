package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
