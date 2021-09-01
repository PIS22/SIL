package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sil.gpc.domains.LigneInventaire;

@Repository
public interface LigneInventaireRepository extends JpaRepository<LigneInventaire, Long>{
	

}
