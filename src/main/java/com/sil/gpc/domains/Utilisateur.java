package com.sil.gpc.domains;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Utilisateur {

	@Id  //*******************A générer automatiquement
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUtilisateur;
	@Column(unique = true)
	private String login;
	private String motDePass;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String fonctionUtilisateur;
	private boolean activeUtilisateur;
	private String dateLastConnex;
	private boolean askMdp1erLance;
	
	@ManyToOne(targetEntity = Service.class)
	@JoinColumn(name = "codeService", referencedColumnName = "codeService", nullable = true)
	public Service service;
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String login, String motDePass, String nomUtilisateur, String prenomUtilisateur,
			String fonctionUtilisateur, boolean activeUtilisateur, Service service) {
		super();
		this.login = login;
		this.motDePass = motDePass;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.fonctionUtilisateur = fonctionUtilisateur;
		this.activeUtilisateur = activeUtilisateur;
		this.service = service;
		this.askMdp1erLance = true;
	}

	public Utilisateur(String login, String motDePass, String nomUtilisateur, String prenomUtilisateur,
			String fonctionUtilisateur, boolean activeUtilisateur, String dateLastConnex, boolean askMdp1erLance,
			Service service) {
		super();
		this.login = login;
		this.motDePass = motDePass;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.fonctionUtilisateur = fonctionUtilisateur;
		this.activeUtilisateur = activeUtilisateur;
		this.dateLastConnex = dateLastConnex;
		this.askMdp1erLance = askMdp1erLance;
		this.service = service;
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

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getDateLastConnex() {
		return dateLastConnex;
	}

	public void setDateLastConnex(String dateLastConnex) {
		this.dateLastConnex = dateLastConnex;
	}

	public boolean isAskMdp1erLance() {
		return askMdp1erLance;
	}

	public void setAskMdp1erLance(boolean askMdp1erLance) {
		this.askMdp1erLance = askMdp1erLance;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", login=" + login + ", motDePass=" + motDePass
				+ ", nomUtilisateur=" + nomUtilisateur + ", prenomUtilisateur=" + prenomUtilisateur
				+ ", fonctionUtilisateur=" + fonctionUtilisateur + ", activeUtilisateur=" + activeUtilisateur
				+ ", dateLastConnex=" + dateLastConnex + ", askMdp1erLance=" + askMdp1erLance + ", service=" + service
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(activeUtilisateur, askMdp1erLance, dateLastConnex, fonctionUtilisateur, idUtilisateur,
				login, motDePass, nomUtilisateur, prenomUtilisateur, service);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Utilisateur other = (Utilisateur) obj;
		return activeUtilisateur == other.activeUtilisateur && askMdp1erLance == other.askMdp1erLance
				&& Objects.equals(dateLastConnex, other.dateLastConnex)
				&& Objects.equals(fonctionUtilisateur, other.fonctionUtilisateur)
				&& Objects.equals(idUtilisateur, other.idUtilisateur) && Objects.equals(login, other.login)
				&& Objects.equals(motDePass, other.motDePass) && Objects.equals(nomUtilisateur, other.nomUtilisateur)
				&& Objects.equals(prenomUtilisateur, other.prenomUtilisateur) && Objects.equals(service, other.service);
	}
	
}
