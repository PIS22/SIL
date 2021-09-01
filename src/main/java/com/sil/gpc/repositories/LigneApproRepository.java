package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LigneDemandeAppro;

@Repository
public interface LigneApproRepository extends JpaRepository<LigneAppro, Long> {

	public List<LigneAppro> findByIdLigneAppro(Long idLigneAppro);
	
	public List<LigneAppro> findByPULigneAppro(Long pULigneAppro);
	
	public List<LigneAppro> findByQuantiteLigneAppro(Long quantiteLigneAppro);
	
	public List<LigneAppro> findByAppro(Approvisionnement approvisionnement);
	
	public List<LigneAppro> findByLigneDA(LigneDemandeAppro ligneDemandeAppro);
	
}
