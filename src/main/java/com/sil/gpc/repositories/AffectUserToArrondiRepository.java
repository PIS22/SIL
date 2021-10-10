package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.AffectUserToArrondi;

@Repository
public interface AffectUserToArrondiRepository extends JpaRepository<AffectUserToArrondi, Long> {

}
