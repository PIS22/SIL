package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LignePointVente;

@Repository
public interface LignePointVenteRepository extends JpaRepository<LignePointVente, Long>{

}
