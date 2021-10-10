package com.sil.gpc.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Quartier;
import com.sil.gpc.domains.Arrondissement;

@Repository
public interface QuartierRepository extends JpaRepository<Quartier, String> {
	
	public List<Quartier> findByCodeQuartier(String CodeQuartier);
	
	public List<Quartier> findByNomQuartier(String NomQuartier);
	
	public List<Quartier> findByNumTelQuartier(String NumTelQuartier);
	
	public List<Quartier> findByAdresseQuartier(String AdresseQuartier);
	
	public List<Quartier> findByArrondissement(Arrondissement arr);

}