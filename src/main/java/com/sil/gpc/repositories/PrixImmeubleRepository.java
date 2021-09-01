package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Immeuble;
import com.sil.gpc.domains.PrixImmeuble;

@Repository
public interface PrixImmeubleRepository extends JpaRepository<PrixImmeuble, Long> {
	
	public List<PrixImmeuble> findByIdPrixIm(Long idPrixIm);
	
	public List<PrixImmeuble> findByPrixIm(Long PrixIm);
	
	public List<PrixImmeuble> findByDateDebPrixIm(Date DateDebPrixIm);
	
	public List<PrixImmeuble> findByDateFinPrixIm(Date DateFinPrixIm);
	
	public List<PrixImmeuble> findByImmeuble(Immeuble im);

}
