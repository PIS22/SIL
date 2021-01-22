package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Regisseur implements Serializable{

	@Id
	private String idRegisseur;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity =Magasinier.class)
	@JoinColumn(name ="numMagasinier", referencedColumnName = "numMagasinier",nullable = false )
	private Magasinier magasinier;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity =Utilisateur.class)
	@JoinColumn(name ="idUtilisateur", referencedColumnName = "idUtilisateur",nullable = false )
	private Utilisateur utilisateur;

	// Liaison à la table Recollement
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Recollement.class, mappedBy = "regisseur")
	public List<Recollement> recollementsParRegisseur;
	
	// Liaison à la table Recollement
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Reversement.class, mappedBy = "regisseur")
	public List<Reversement> reversementsParRegisseur;

	// Liaison à la table PointVente
	@OneToMany(cascade = CascadeType.ALL, targetEntity = PointVente.class, mappedBy = "regisseur")
	public List<PointVente> pointsParRegisseur;

	// Liaison à la table Placement
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Placement.class, mappedBy = "regisseur")
	public List<PointVente> placementsParRegisseur;
	
	
	public Regisseur() {
		super();
	}

	public Regisseur(String idRegisseur, Magasinier magasinier, Utilisateur utilisateur) {
		super();
		this.idRegisseur = idRegisseur;
		this.magasinier = magasinier;
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the idRegisseur
	 */
	public String getIdRegisseur() {
		return idRegisseur;
	}

	/**
	 * @param idRegisseur the idRegisseur to set
	 */
	public void setIdRegisseur(String idRegisseur) {
		this.idRegisseur = idRegisseur;
	}

	/**
	 * @return the magasinier
	 */
	public Magasinier getMagasinier() {
		return magasinier;
	}

	/**
	 * @param magasinier the magasinier to set
	 */
	public void setMagasinier(Magasinier magasinier) {
		this.magasinier = magasinier;
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRegisseur, magasinier, utilisateur);
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
		Regisseur other = (Regisseur) obj;
		return Objects.equals(idRegisseur, other.idRegisseur) && Objects.equals(magasinier, other.magasinier)
				&& Objects.equals(utilisateur, other.utilisateur);
	}

	@Override
	public String toString() {
		return "Regisseur [idRegisseur=" + idRegisseur + ", magasinier=" + magasinier + ", utilisateur=" + utilisateur
				+ "]";
	}
	

}
