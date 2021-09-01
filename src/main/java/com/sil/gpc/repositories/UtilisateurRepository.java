package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.domains.Service;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	public List<Utilisateur> findByIdUtilisateur(Long IdUser);
	
	public List<Utilisateur> findByLogin(Long Login);
	
	public List<Utilisateur> findByNomUtilisateur(Long NomUser);
	
	public List<Utilisateur> findByPrenomUtilisateur(Long PrenomUser);
	
	public List<Utilisateur> findByFonctionUtilisateur(Long FonctionUser);
	
	public List<Utilisateur> findByActiveUtilisateur(boolean ActiveUser);
	
	public List<Utilisateur> findByService(Service ServiceUser);
	
	

}
