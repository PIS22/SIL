package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
	
}
