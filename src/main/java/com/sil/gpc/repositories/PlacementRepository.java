package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Placement;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, String>{

}
