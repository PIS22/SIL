package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.InstituReverse;

@Repository
public interface InstituReverseRepository extends JpaRepository<InstituReverse, String> {

	List<InstituReverse> findByLibInstRevers(String libInstRevers);
}
