package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Arrondissement;
import com.sil.gpc.domains.SiteMarcher;

@Repository
public interface SiteMarcherRepository extends JpaRepository<SiteMarcher, String>{
	public List<SiteMarcher> findByArrondissement(Arrondissement arrond);
	public List<SiteMarcher> findByCodeSite(String codeSite);
	public List<SiteMarcher> findByDescriSite(String descriSite);
	public List<SiteMarcher> findByLibSite(String libSite);

}
