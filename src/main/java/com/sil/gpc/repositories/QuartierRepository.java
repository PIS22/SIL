package com.sil.gpc.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.sil.gpc.domains.Quartier;

@Repository
public interface QuartierRepository extends JpaRepository<Quartier, String> {
	
	public List<Quartier> findBylibQuartier(String libQuartier);

}