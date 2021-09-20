package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Reception implements Serializable {

	@Id
	@Column(length = 20)
	private String numReception;
	@Column(length = 150)
	private String observation;
	private Timestamp dateReception;
	private boolean valideRecep;
	private int valeur;
	private Timestamp dateSaisie;

	@ManyToOne(targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUser", referencedColumnName = "idUtilisateur")
	public Utilisateur utlisateur;

	@ManyToOne(targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice")
	public Exercice exercice;

	public Reception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reception(String numReception, String observation, Timestamp dateReception, boolean valideRecep, int valeur,
			Exercice exercice) {
		this.numReception = numReception;
		this.observation = observation;
		this.dateReception = dateReception;
		this.valideRecep = valideRecep;
		this.valeur = valeur;
		this.exercice = exercice;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getNumReception() {
		return numReception;
	}

	/**
	 * @param numReception the numReception to set
	 */
	public void setNumReception(String numReception) {
		this.numReception = numReception;
	}

	public int getValeur() {
		return valeur;
	}

	public String getObservation() {
		return observation;
	}

	/**
	 * @param observation the observation to set
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}

	/**
	 * @return the dateReception
	 */
	public Timestamp getDateReception() {
		return dateReception;
	}

	/**
	 * @param dateReception the dateReception to set
	 */
	public void setDateReception(Timestamp dateReception) {
		this.dateReception = dateReception;
	}

	public boolean isValideRecep() {
		return valideRecep;
	}

	/**
	 * @param valideRecep the valideRecep to set
	 */
	public void setValideRecep(boolean valideRecep) {
		this.valideRecep = valideRecep;
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
		return "Reception [numReception=" + numReception + ", observation=" + observation + ", dateReception="
				+ dateReception + ", valideRecep=" + valideRecep + "]";
	}

}
