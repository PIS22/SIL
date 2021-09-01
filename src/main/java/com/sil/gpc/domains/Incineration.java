package com.sil.gpc.domains;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Incineration {

	@Id
	private String numIncine;
	private Timestamp dateIncine;
	private boolean valideIncine;
	private String ObservationIncine;
	private int valeur;
	private Timestamp dateSaisie;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUser", referencedColumnName = "idUtilisateur")
	public Utilisateur utlisateur;

	// Liaison avec Exercice
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;
	
	/**
	 * 
	 */
	public Incineration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numIncine
	 * @param dateIncine
	 * @param valideIncine
	 * @param observationIncine
	 * @param exercice
	 */
	public Incineration(String numIncine, Timestamp dateIncine, boolean valideIncine, String observationIncine,
			Exercice exercice) {
		this.numIncine = numIncine;
		this.dateIncine = dateIncine;
		this.valideIncine = valideIncine;
		ObservationIncine = observationIncine;
		this.exercice = exercice;
		this.valeur=0;
		this.valideIncine=true;
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
	 * @return the numIncine
	 */
	public String getNumIncine() {
		return numIncine;
	}

	/**
	 * @param numIncine the numIncine to set
	 */
	public void setNumIncine(String numIncine) {
		this.numIncine = numIncine;
	}

	/**
	 * @return the dateIncine
	 */
	public Timestamp getDateIncine() {
		return dateIncine;
	}

	/**
	 * @param dateIncine the dateIncine to set
	 */
	public void setDateIncine(Timestamp dateIncine) {
		this.dateIncine = dateIncine;
	}

	/**
	 * @return the valideIncine
	 */
	public boolean isValideIncine() {
		return valideIncine;
	}

	public void setValideIncine(boolean valideIncine) {
		this.valideIncine = valideIncine;
	}

	public String getObservationIncine() {
		return ObservationIncine;
	}

	public void setObservationIncine(String observationIncine) {
		ObservationIncine = observationIncine;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public Timestamp getDateSaisie() {
		return dateSaisie;
	}

	public void setDateSaisie(Timestamp dateSaisie) {
		this.dateSaisie = dateSaisie;
	}

	public Utilisateur getUtlisateur() {
		return utlisateur;
	}

	public void setUtlisateur(Utilisateur utlisateur) {
		this.utlisateur = utlisateur;
	}

	@Override
	public String toString() {
		return "Incineration [numIncine=" + numIncine + ", dateIncine=" + dateIncine + ", valideIncine=" + valideIncine
				+ ", ObservationIncine=" + ObservationIncine + ", exercice=" + exercice + "]";
	}

}
