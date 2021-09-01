package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class AffectUserToArrondi implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAffectUserToArrondi;
	private Date dateDebutAffectToArrondi;
	private Date dateFinAffectToArrondi;

	@ManyToOne(targetEntity = Arrondissement.class)
	@JoinColumn(name = "codeArrondi", referencedColumnName = "codeArrondi")
	private Arrondissement arrondissement;

	@ManyToOne(targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
	private Utilisateur utilisateur;

	public AffectUserToArrondi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AffectUserToArrondi(Date dateDebutAffectToArrondi, Date dateFinAffectToArrondi,
			Arrondissement arrondissement, Utilisateur utilisateur) {
		this.dateDebutAffectToArrondi = dateDebutAffectToArrondi;
		this.dateFinAffectToArrondi = dateFinAffectToArrondi;
		this.arrondissement = arrondissement;
		this.utilisateur = utilisateur;
	}

	public Long getIdAffectUserToArrondi() {
		return idAffectUserToArrondi;
	}

	public void setIdAffectUserToArrondi(Long idAffectUserToArrondi) {
		this.idAffectUserToArrondi = idAffectUserToArrondi;
	}

	public Date getDateDebutAffectToArrondi() {
		return dateDebutAffectToArrondi;
	}

	public void setDateDebutAffectToArrondi(Date dateDebutAffectToArrondi) {
		this.dateDebutAffectToArrondi = dateDebutAffectToArrondi;
	}

	public Date getDateFinAffectToArrondi() {
		return dateFinAffectToArrondi;
	}

	public void setDateFinAffectToArrondi(Date dateFinAffectToArrondi) {
		this.dateFinAffectToArrondi = dateFinAffectToArrondi;
	}

	public Arrondissement getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
