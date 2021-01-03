package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.OpCaisse;

@Repository
public interface OpCaisseRepository extends JpaRepository<OpCaisse, String>{

}
