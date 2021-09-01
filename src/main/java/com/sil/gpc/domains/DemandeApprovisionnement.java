package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class DemandeApprovisionnement implements Serializable {
	@Id
	@Column(length = 20)
	private String numDA;
	private Timestamp dateDA;
	private int valeur;
	private boolean valideDA;

	// Liaison avec Exercice
	@ManyToOne(targetEntity = Exercice.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	public Exercice exercice;

	public DemandeApprovisionnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandeApprovisionnement(String numDA, Timestamp dateDA, Exercice exercice) {
		super();
		this.numDA = numDA;
		this.dateDA = dateDA;
		this.exercice = exercice;
		valeur = 0;
	}

	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	public boolean isValideDA() {
		return valideDA;
	}

	public void setValideDA(boolean valideDA) {
		this.valideDA = valideDA;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the numDA
	 */
	public String getNumDA() {
		return numDA;
	}

	/**
	 * @param numDA the numDA to set
	 */
	public void setNumDA(String numDA) {
		this.numDA = numDA;
	}

	/**
	 * @return the dateDA
	 */
	public Timestamp getDateDA() {
		return dateDA;
	}

	/**
	 * @param dateDA the dateDA to set
	 */
	public void setDateDA(Timestamp dateDA) {
		this.dateDA = dateDA;
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
	public int hashCode() {
		return Objects.hash(dateDA, exercice, numDA);
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
		DemandeApprovisionnement other = (DemandeApprovisionnement) obj;
		return Objects.equals(dateDA, other.dateDA) && Objects.equals(exercice, other.exercice)
				&& Objects.equals(numDA, other.numDA);
	}

}
