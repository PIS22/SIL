package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Magasinier;

@Repository
public interface MagasinierRepository extends JpaRepository<Magasinier, Long>{

	public List<Magasinier> findByNomMagasinier(String nomMagasinier);
	public List<Magasinier> findByNumMAgasinier(Long numMAgasinier);
	public List<Magasinier> findByPrenomMagasinier(String prenomMagasinier);
	public List<Magasinier> findByTelMagasinier(String telMagasinier);
}
