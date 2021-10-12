package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Gerer;
import com.sil.gpc.domains.Magasin;
import com.sil.gpc.domains.Magasinier;

@Repository
public interface GererRepository extends JpaRepository<Gerer, Long> {

	public List<Gerer> findByIdGerer(Long idGerer);

	public List<Gerer> findByDateDebGerer(Date dateDebGerer);

	public List<Gerer> findByDateFinGerer(Date dateFinGerer);

	public List<Gerer> findByMagasinier(Magasinier magasinier);

	public List<Gerer> findByMagasin(Magasin magasin);

	@Query(value = "SELECT codeMagasin FROM Gerer WHERE numMagasinier=?1 AND dateFinGerer=null", nativeQuery = true)
	Magasin mag(Long idMag);

	Optional<Gerer> findByMagasinier_NumMAgasinier(Long numMagasinier);

}
