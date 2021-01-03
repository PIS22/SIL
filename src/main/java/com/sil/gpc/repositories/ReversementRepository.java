package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Reversement;

@Repository
public interface ReversementRepository extends JpaRepository<Reversement, String> {

}
