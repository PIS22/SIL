package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneIncineration;

@Repository
public interface LigneIncinerationRepository extends JpaRepository<LigneIncineration, Long>{

}
