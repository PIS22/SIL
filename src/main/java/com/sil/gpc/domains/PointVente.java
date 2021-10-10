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
public class PointVente implements Serializable {

	@Id
	@Column(name = "numPointVente", length = 22)
	private String numPointVente;
	private Timestamp datePointVente;
	private boolean validePoint;
	private boolean payerPoint;
	private int valeur;
	private Timestamp dateSaisie;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUser", referencedColumnName = "idUtilisateur")
	public Utilisateur utlisateur;

	// Liaison avec Exercice
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;

	// Liaison avec Correspondant
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Correspondant.class)
	@JoinColumn(name = "idCorrepondant", referencedColumnName = "idCorrespondant", nullable = false)
	private Correspondant correspondant;

	// *********************************Il reste l'opération de caisse
	// Liaison avec OpCaisse
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = OpCaisse.class)
	@JoinColumn(name = "numOpCaisse", referencedColumnName = "numOpCaisse", nullable = true)
	private OpCaisse opCaisse;

	// Liaison avec Regisseur
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Regisseur.class)
	@JoinColumn(name = "idRegisseur", referencedColumnName = "idRegisseur", nullable = true)
	private Regisseur regisseur;

	public PointVente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numPointVente
	 * @param datePointVente
	 * @param validePoint
	 * @param payerPoint
	 * @param exercice
	 * @param correspondant
	 * @param opCaisse
	 * @param regisseur
	 */
	public PointVente(String numPointVente, Timestamp datePointVente, boolean validePoint, boolean payerPoint,
			Exercice exercice, Correspondant correspondant, OpCaisse opCaisse, Regisseur regisseur) {
		this.numPointVente = numPointVente;
		this.datePointVente = datePointVente;
		this.validePoint = validePoint;
		this.payerPoint = payerPoint;
		this.exercice = exercice;
		this.correspondant = correspondant;
		this.opCaisse = opCaisse;
		this.regisseur = regisseur;
		validePoint = true;
		valeur = 0;
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
	 * @return the numPointVente
	 */
	public String getNumPointVente() {
		return numPointVente;
	}

	/**
	 * @param numPointVente the numPointVente to set
	 */
	public void setNumPointVente(String numPointVente) {
		this.numPointVente = numPointVente;
	}

	/**
	 * @return the datePointVente
	 */
	public Timestamp getDatePointVente() {
		return datePointVente;
	}

	/**
	 * @param datePointVente the datePointVente to set
	 */
	public void setDatePointVente(Timestamp datePointVente) {
		this.datePointVente = datePointVente;
	}

	/**
	 * @return the validePoint
	 */
	public boolean isValidePoint() {
		return validePoint;
	}

	/**
	 * @param validePoint the validePoint to set
	 */
	public void setValidePoint(boolean validePoint) {
		this.validePoint = validePoint;
	}

	/**
	 * @return the payerPoint
	 */
	public boolean isPayerPoint() {
		return payerPoint;
	}

	/**
	 * @param payerPoint the payerPoint to set
	 */
	public void setPayerPoint(boolean payerPoint) {
		this.payerPoint = payerPoint;
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
	 * @return the opCaisse
	 */
	public OpCaisse getOpCaisse() {
		return opCaisse;
	}

	/**
	 * @param opCaisse the opCaisse to set
	 */
	public void setOpCaisse(OpCaisse opCaisse) {
		this.opCaisse = opCaisse;
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
		return "PointVente [numPointVente=" + numPointVente + ", datePointVente=" + datePointVente + ", validePoint="
				+ validePoint + ", payerPoint=" + payerPoint + ", exercice=" + exercice + ", correspondant="
				+ correspondant + ", opCaisse=" + opCaisse + ", regisseur=" + regisseur + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(correspondant, datePointVente, exercice, numPointVente, opCaisse, payerPoint, regisseur,
				validePoint);
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
		PointVente other = (PointVente) obj;
		return Objects.equals(correspondant, other.correspondant)
				&& Objects.equals(datePointVente, other.datePointVente) && Objects.equals(exercice, other.exercice)
				&& Objects.equals(numPointVente, other.numPointVente) && Objects.equals(opCaisse, other.opCaisse)
				&& payerPoint == other.payerPoint && Objects.equals(regisseur, other.regisseur)
				&& validePoint == other.validePoint;
	}

}
