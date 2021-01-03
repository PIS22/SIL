package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Recollement;

@Repository
public interface RecollementRepository extends JpaRepository<Recollement, String> {

}
