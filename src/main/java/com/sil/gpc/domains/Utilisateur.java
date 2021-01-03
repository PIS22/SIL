package com.sil.gpc.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {

	@Id  //*******************A générer automatiquement
	private Long idUtilisateur;
	private String login;
	private String motDePass;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String fonctionUtilisateur;
	private boolean activeUtilisateur;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = OpCaisse.class,mappedBy = "utilisateur")
	public List<OpCaisse> opCaisseParUtilisateur;
	
	private String codeService; //***************************Code Service A Etablir
	
	//**************************Les affecters de l'utilisateur
	// Liaison à la table Affecter
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Affecter.class, mappedBy = "utilisateur")
	public List<Utilisateur> affectationsDunUtilisateur;

	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String login, String motDePass, String nomUtilisateur, String prenomUtilisateur,
			String fonctionUtilisateur, boolean activeUtilisateur, String codeService) {
		super();
		this.login = login;
		this.motDePass = motDePass;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.fonctionUtilisateur = fonctionUtilisateur;
		this.activeUtilisateur = activeUtilisateur;
		this.codeService = codeService;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePass() {
		return motDePass;
	}

	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getFonctionUtilisateur() {
		return fonctionUtilisateur;
	}

	public void setFonctionUtilisateur(String fonctionUtilisateur) {
		this.fonctionUtilisateur = fonctionUtilisateur;
	}

	public boolean isActiveUtilisateur() {
		return activeUtilisateur;
	}

	public void setActiveUtilisateur(boolean activeUtilisateur) {
		this.activeUtilisateur = activeUtilisateur;
	}

	public String getCodeService() {
		return codeService;
	}

	public void setCodeService(String codeService) {
		this.codeService = codeService;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activeUtilisateur ? 1231 : 1237);
		result = prime * result + ((codeService == null) ? 0 : codeService.hashCode());
		result = prime * result + ((fonctionUtilisateur == null) ? 0 : fonctionUtilisateur.hashCode());
		result = prime * result + ((idUtilisateur == null) ? 0 : idUtilisateur.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((motDePass == null) ? 0 : motDePass.hashCode());
		result = prime * result + ((nomUtilisateur == null) ? 0 : nomUtilisateur.hashCode());
		result = prime * result + ((prenomUtilisateur == null) ? 0 : prenomUtilisateur.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (activeUtilisateur != other.activeUtilisateur)
			return false;
		if (codeService == null) {
			if (other.codeService != null)
				return false;
		} else if (!codeService.equals(other.codeService))
			return false;
		if (fonctionUtilisateur == null) {
			if (other.fonctionUtilisateur != null)
				return false;
		} else if (!fonctionUtilisateur.equals(other.fonctionUtilisateur))
			return false;
		if (idUtilisateur == null) {
			if (other.idUtilisateur != null)
				return false;
		} else if (!idUtilisateur.equals(other.idUtilisateur))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (motDePass == null) {
			if (other.motDePass != null)
				return false;
		} else if (!motDePass.equals(other.motDePass))
			return false;
		if (nomUtilisateur == null) {
			if (other.nomUtilisateur != null)
				return false;
		} else if (!nomUtilisateur.equals(other.nomUtilisateur))
			return false;
		if (prenomUtilisateur == null) {
			if (other.prenomUtilisateur != null)
				return false;
		} else if (!prenomUtilisateur.equals(other.prenomUtilisateur))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", login=" + login + ", motDePass=" + motDePass
				+ ", nomUtilisateur=" + nomUtilisateur + ", prenomUtilisateur=" + prenomUtilisateur
				+ ", fonctionUtilisateur=" + fonctionUtilisateur + ", activeUtilisateur=" + activeUtilisateur
				+ ", codeService=" + codeService + "]";
	}
	
	
}
