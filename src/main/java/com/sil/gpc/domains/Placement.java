package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Placement implements Serializable {

	@Id
	private String numPlacement;
	private Timestamp datePlacement;
	private int valeur;
	private boolean validepl;
	private Timestamp dateSaisie;

	public Timestamp getDateSaisie() {
		return dateSaisie;
	}

	public void setDateSaisie(Timestamp dateSaisie) {
		this.dateSaisie = dateSaisie;
	}

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUser", referencedColumnName = "idUtilisateur")
	public Utilisateur utlisateur;

	// Liaison avec Regisseur
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Regisseur.class)
	@JoinColumn(name = "idRegisseur", referencedColumnName = "IdRegisseur", nullable = false)
	private Regisseur regisseur;

	// Liaison avec correspondant
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Correspondant.class)
	@JoinColumn(name = "idCorrespondant", referencedColumnName = "idCorrespondant", nullable = false)
	private Correspondant correspondant;

	// Liaison avec Exercice
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;

	public Placement() {
		super();
	}

	/**
	 * @param numPlacement
	 * @param datePlacement
	 * @param regisseur
	 * @param correspondant
	 * @param exercice
	 */
	public Placement(String numPlacement, Timestamp datePlacement, Regisseur regisseur, Correspondant correspondant,
			Exercice exercice) {
		this.numPlacement = numPlacement;
		this.datePlacement = datePlacement;
		this.regisseur = regisseur;
		this.correspondant = correspondant;
		this.exercice = exercice;
		this.valeur = 0;
		this.validepl = true;
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
	 * @return the validepl
	 */
	public boolean isValidepl() {
		return validepl;
	}

	/**
	 * @param validepl the validepl to set
	 */
	public void setValidepl(boolean validepl) {
		this.validepl = validepl;
	}

	/**
	 * @return the numPlacement
	 */
	public String getNumPlacement() {
		return numPlacement;
	}

	/**
	 * @param numPlacement the numPlacement to set
	 */
	public void setNumPlacement(String numPlacement) {
		this.numPlacement = numPlacement;
	}

	/**
	 * @return the datePlacement
	 */
	public Timestamp getDatePlacement() {
		return datePlacement;
	}

	/**
	 * @param datePlacement the datePlacement to set
	 */
	public void setDatePlacement(Timestamp datePlacement) {
		this.datePlacement = datePlacement;
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
	 * @return the correspondant
	 */
	public Correspondant getCorrespondant() {
		return correspondant;
	}

	/**
	 * @param correspondant the correspondant to set
	 */
	public void setCorrespondant(Correspondant correspondant) {
		this.correspondant = correspondant;
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
		return "Placement [numPlacement=" + numPlacement + ", datePlacement=" + datePlacement + ", regisseur="
				+ regisseur + ", correspondant=" + correspondant + ", exercice=" + exercice + "]";
	}

}
