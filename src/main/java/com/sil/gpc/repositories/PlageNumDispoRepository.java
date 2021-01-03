package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.PlageNumDispo;

@Repository
public interface PlageNumDispoRepository extends JpaRepository<PlageNumDispo, String>{

}
