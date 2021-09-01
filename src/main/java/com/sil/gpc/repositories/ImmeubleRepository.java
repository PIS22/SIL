package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Immeuble;
import com.sil.gpc.domains.TypeImmeuble;
import com.sil.gpc.domains.Quartier;

@Repository
public interface ImmeubleRepository extends JpaRepository<Immeuble, String> {

	public List<Immeuble> findByCodeIm(String codeIm);
	
	public List<Immeuble> findByLocalisationIm(String localisationIm);
	
	public List<Immeuble> findByQuartier(Quartier quartier);
	
	public List<Immeuble> findByTypeImmeuble(TypeImmeuble typeImmeuble);
	
	public List<Immeuble> findByEtatIm(boolean etatIm);
	
}
