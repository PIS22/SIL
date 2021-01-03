package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.PointVente;

@Repository
public interface PointVenteRepository extends JpaRepository<PointVente, String> {

}
