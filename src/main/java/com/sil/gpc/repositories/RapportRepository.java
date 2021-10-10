package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Rapport;

@Repository
public interface RapportRepository extends JpaRepository<Rapport, Long> {
	public List<Rapport> findByLibRap(String libRap);

}
