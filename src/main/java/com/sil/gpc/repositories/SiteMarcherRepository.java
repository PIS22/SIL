package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.SiteMarcher;

@Repository
public interface SiteMarcherRepository extends JpaRepository<SiteMarcher, String>{

	List<SiteMarcher> findByLibSite(String libSite);
}
