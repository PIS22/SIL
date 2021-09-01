package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import com.sil.gpc.domains.Service;
import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.repositories.UtilisateurRepository;

@org.springframework.stereotype.Service
public class UtilisateurService {

	private final UtilisateurRepository userRepository;

	public UtilisateurService(UtilisateurRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Sauvegarder
	public Utilisateur save(Utilisateur user) {
		return this.userRepository.save(user);
	}

	// Editer
	public Utilisateur edit(Long idUser, Utilisateur user) {
		Utilisateur usermod = this.userRepository.getOne(idUser);
		if (usermod != null) {
			usermod.setNomUtilisateur(user.getNomUtilisateur());
			usermod.setPrenomUtilisateur(user.getPrenomUtilisateur());
			usermod.setLogin(user.getLogin());
			if (usermod.isAskMdp1erLance() && user.getMotDePass() != null && user.getMotDePass() != "") {
				usermod.setMotDePass(user.getMotDePass());
			}
			usermod.setAskMdp1erLance(user.isAskMdp1erLance());
			usermod.setActiveUtilisateur(user.isActiveUtilisateur());
			usermod.setFonctionUtilisateur(user.getFonctionUtilisateur());
			usermod.setService(user.getService());
			usermod.setService(user.getService());
			return this.userRepository.save(usermod);
		}
		return null;
	}

	// Supprimer
	public boolean delete(Long id) {
		if (this.userRepository.existsById(id))
			this.userRepository.deleteById(id);

		return this.userRepository.existsById(id);
	}

	//
	public Optional<Utilisateur> findById(Long id) {
		return this.userRepository.findById(id);
	}

	//
	public Utilisateur trouveUn(Long id) {
		return this.userRepository.getOne(id);
	}

	// Liste
	public List<Utilisateur> getAll() {
		if (this.userRepository.findAll().size() == 0) {
			userRepository.save(new Utilisateur("Admin", "admin", "Administrateur", "", "Administrateur", true, null));
		}
		return this.userRepository.findAll();
	}

	//
	public List<Utilisateur> findByIdUtilisateur(Long IdUser) {

		return this.userRepository.findByIdUtilisateur(IdUser);
	}

	//
	public List<Utilisateur> findByActiveUtilisateur(boolean ActiveUser) {

		return this.userRepository.findByActiveUtilisateur(ActiveUser);
	}

	//
	public List<Utilisateur> findByLoginUtilisateur(Long Login) {

		return this.userRepository.findByLogin(Login);
	}

	//
	public List<Utilisateur> findByNomUtilisateur(Long NomUser) {

		return this.userRepository.findByNomUtilisateur(NomUser);
	}

	//
	public List<Utilisateur> findByPrenomUtilisateur(Long PrenomUser) {

		return this.userRepository.findByPrenomUtilisateur(PrenomUser);
	}

	//
	public List<Utilisateur> findByFonctionUtilisateur(Long FonctionUser) {

		return this.userRepository.findByFonctionUtilisateur(FonctionUser);
	}

	//
	public List<Utilisateur> findByServiceUtilisateur(Service ServiceUser) {

		return this.userRepository.findByService(ServiceUser);
	}

}
