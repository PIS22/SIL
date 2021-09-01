package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Correspondant;
import com.sil.gpc.domains.EtreAffecte;
import com.sil.gpc.domains.SiteMarcher;

@Repository
public interface EtreAffecteRepository extends JpaRepository<EtreAffecte, Long> {
	
	public List<EtreAffecte> findByDateArrivee(Date dateArrivee);
	
	public List<EtreAffecte> findBySite(SiteMarcher site);
	
	public List<EtreAffecte> findByCorres(Correspondant corres);

}
