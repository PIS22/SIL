package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Recollement implements Serializable {

	@Id
	private String numRecollement;
	private String descriptionRecollement;
	private Timestamp dateRecollement;
	private boolean valideRecol;
	private int valeur;
	private Timestamp dateSaisie;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUser", referencedColumnName = "idUtilisateur")
	public Utilisateur utlisateur;
	

	// Liaison avec Magasin
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Magasin.class)
	@JoinColumn(name = "codeMagasin", referencedColumnName = "codeMagasin", nullable = false)
	private Magasin magasin;

	// Liaison avec Correspondant
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Correspondant.class)
	@JoinColumn(name = "idCorrespondant", referencedColumnName = "idCorrespondant", nullable = true)
	private Correspondant corres;

	// Liaison avec Regisseur
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Regisseur.class)
	@JoinColumn(name = "idRegisseur", referencedColumnName = "idRegisseur", nullable = false)
	private Regisseur regisseur;

	// Liaison avec Exercice
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;
	
	public Recollement() {
		super();
	}

	/**
	 * @param numRecollement
	 * @param descriptionRecollement
	 * @param dateRecollement
	 * @param valideRecol
	 * @param magasin
	 * @param corres
	 * @param regisseur
	 * @param exercice
	 */
	public Recollement(String numRecollement, String descriptionRecollement, Timestamp dateRecollement, boolean valideRecol,
			Magasin magasin, Correspondant corres, Regisseur regisseur, Exercice exercice) {
		this.numRecollement = numRecollement;
		this.descriptionRecollement = descriptionRecollement;
		this.dateRecollement = dateRecollement;
		this.valideRecol = valideRecol;
		this.magasin = magasin;
		this.corres = corres;
		this.regisseur = regisseur;
		this.exercice = exercice;
		this.valideRecol=true;
		this.valeur=0;
	}


	/**
	 * @return the numRecollement
	 */
	public String getNumRecollement() {
		return numRecollement;
	}

	/**
	 * @param numRecollement the numRecollement to set
	 */
	public void setNumRecollement(String numRecollement) {
		this.numRecollement = numRecollement;
	}

	/**
	 * @return the descriptionRecollement
	 */
	public String getDescriptionRecollement() {
		return descriptionRecollement;
	}

	/**
	 * @param descriptionRecollement the descriptionRecollement to set
	 */
	public void setDescriptionRecollement(String descriptionRecollement) {
		this.descriptionRecollement = descriptionRecollement;
	}

	/**
	 * @return the dateRecollement
	 */
	public Timestamp getDateRecollement() {
		return dateRecollement;
	}

	/**
	 * @param dateRecollement the dateRecollement to set
	 */
	public void setDateRecollement(Timestamp dateRecollement) {
		this.dateRecollement = dateRecollement;
	}

	/**
	 * @return the valideRecol
	 */
	public boolean isValideRecol() {
		return valideRecol;
	}

	/**
	 * @param valideRecol the valideRecol to set
	 */
	public void setValideRecol(boolean valideRecol) {
		this.valideRecol = valideRecol;
	}

	/**
	 * @return the magasin
	 */
	public Magasin getMagasin() {
		return magasin;
	}

	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * @param magasin the magasin to set
	 */
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	/**
	 * @return the corres
	 */
	public Correspondant getCorres() {
		return corres;
	}

	/**
	 * @param corres the corres to set
	 */
	public void setCorres(Correspondant corres) {
		this.corres = corres;
	}

	/**
	 * @return the regisseur
	 */
	public Regisseur getRegisseur() {
		return regisseur;
	}

	/**
	 * @param regisseur the regisseur to set
	 */
	public void setRegisseur(Regisseur regisseur) {
		this.regisseur = regisseur;
	}

	/**
	 * @return the exercice
	 */
	public Exercice getExercice() {
		return exercice;
	}

	/**
	 * @param exercice the exercice to set
	 */
	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	@Override
	public String toString() {
		return "Recollement [numRecollement=" + numRecollement + ", descriptionRecollement=" + descriptionRecollement
				+ ", dateRecollement=" + dateRecollement + ", valideRecol=" + valideRecol + ", magasin=" + magasin
				+ ", corres=" + corres + ", regisseur=" + regisseur + ", exercice=" + exercice + "]";
	}

}
