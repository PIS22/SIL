package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Regisseur;

@Repository
public interface RegisseurRepository extends JpaRepository<Regisseur, String> {

}
