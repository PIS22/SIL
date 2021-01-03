package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.PrixImmeuble;

@Repository
public interface PrixImmeubleRepository extends JpaRepository<PrixImmeuble, Long> {

}
