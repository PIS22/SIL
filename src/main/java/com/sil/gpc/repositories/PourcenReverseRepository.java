package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.PourcenReverse;

@Repository
public interface PourcenReverseRepository extends JpaRepository<PourcenReverse, Long> {
 

}
