package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Fonction;

@Repository
public interface FonctionRepository extends JpaRepository<Fonction, String> {

}
