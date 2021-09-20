package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Occuper;

@Repository
public interface OccuperRepository extends JpaRepository<Occuper, Long> {

	@Query(value = "SELECT * FROM occuper WHERE dat_fin=null", nativeQuery = true)
	public List<Occuper> occupantsActuels();

}
