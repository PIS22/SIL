package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Ecriture;

@Repository
public interface EcritureRepository extends JpaRepository<Ecriture, String> {

}
