package com.sil.gpc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Correspondant;
import com.sil.gpc.domains.Magasinier;
import com.sil.gpc.domains.TypCorres;
import com.sil.gpc.domains.Utilisateur;

@Repository
public interface CorrespondantRepository extends JpaRepository<Correspondant, String>{

	public List<Correspondant> findByIdCorrespondant(String idCorrespondant);
	
	public List<Correspondant> findByMagasinier(Magasinier magasinier);
	
	public List<Correspondant> findByTypecorres(TypCorres typecorres);
	
	public List<Correspondant> findByUtilisateur(Utilisateur utilisateur);
	
	public List<Correspondant> findByImputableCorres(boolean imputableCorres);

	//Léo
	List<Correspondant> findAllByImputableCorresIsTrue();

	//Léo
	Optional<Correspondant> findByUtilisateur_IdUtilisateur(Long IdUser);
	
}
