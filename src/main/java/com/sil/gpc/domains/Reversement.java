package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Reversement implements Serializable{

	@Id
	private String numReversement;
	private Timestamp dateVersement;
	private boolean valideReve;
	private int valeur;
	private Timestamp dateSaisie;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUser", referencedColumnName = "idUtilisateur")
	public Utilisateur utlisateur;
	
	//Liaison avec Exercice
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice",referencedColumnName = "codeExercice",nullable = false)
	private Exercice exercice;
	
	//Liaison avec Reversement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Regisseur.class)
	@JoinColumn(name = "idRegisseur",referencedColumnName = "idRegisseur",nullable = false)
	private Regisseur regisseur;
	
	public Reversement() {
		super();
	}
	
	/**
	 * @return the numReversement
	 */
	public String getNumReversement() {
		return numReversement;
	}
	
	/**
	 * @param numReversement
	 * @param dateVersement
	 * @param valideReve
	 * @param exercice
	 * @param regisseur
	 */
	public Reversement(String numReversement, Timestamp dateVersement, boolean valideReve, Exercice exercice,
			Regisseur regisseur) {
		this.numReversement = numReversement;
		this.dateVersement = dateVersement;
		this.valideReve = valideReve;
		this.exercice = exercice;
		this.regisseur = regisseur;
		valideReve=true;
		valeur =  0;
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
	 * @return the dateVersement
	 */
	public Timestamp getDateVersement() {
		return dateVersement;
	}

	/**
	 * @param dateVersement the dateVersement to set
	 */
	public void setDateVersement(Timestamp dateVersement) {
		this.dateVersement = dateVersement;
	}

	/**
	 * @return the valideReve
	 */
	public boolean isValideReve() {
		return valideReve;
	}

	/**
	 * @param valideReve the valideReve to set
	 */
	public void setValideReve(boolean valideReve) {
		this.valideReve = valideReve;
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
	 * @param numReversement the numReversement to set
	 */
	public void setNumReversement(String numReversement) {
		this.numReversement = numReversement;
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
		return "Reversement [numReversement=" + numReversement + ", dateVersement=" + dateVersement + ", valideReve="
				+ valideReve + ", exercice=" + exercice + ", regisseur=" + regisseur + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateVersement, exercice, numReversement, regisseur, valideReve);
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
		Reversement other = (Reversement) obj;
		return Objects.equals(dateVersement, other.dateVersement) && Objects.equals(exercice, other.exercice)
				&& Objects.equals(numReversement, other.numReversement) && Objects.equals(regisseur, other.regisseur)
				&& valideReve == other.valideReve;
	}
	
}
