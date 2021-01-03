package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class PointVente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="numPointVente", length = 15)
	private String numPointVente; 
	private Date datePointVente;
	private boolean payerPoint;

	//Liaison avec Exercice
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice",referencedColumnName = "codeExercice",nullable = false)
	private Exercice exercice;

	//Liaison avec Correspondant
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Correspondant.class)
	@JoinColumn(name = "idCorrepondant",referencedColumnName = "idCorrespondant",nullable = false)
	private Correspondant correspondant;

	//*********************************Il reste l'opération de caisse
	//Liaison avec OpCaisse
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = OpCaisse.class)
	@JoinColumn(name = "numOpCaisse",referencedColumnName = "numOpCaisse",nullable = false)
	private OpCaisse opCaisse;

	// Liaison avec la table Echeance
	@OneToMany( cascade = CascadeType.ALL,targetEntity = Echeance.class, mappedBy = "opCaisse")
	private List<Echeance> echeancesOpCaisse;
	
	
	//Liaison avec Regisseur
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Regisseur.class)
	@JoinColumn(name = "idRegisseur",referencedColumnName = "idRegisseur",nullable = false)
	private Regisseur regisseur;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = LignePointVente.class,mappedBy = "pointVente")
	public List<LignePointVente> lignesParPoint;
	
	public PointVente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PointVente(String numPointVente, Date datePointVente, boolean payerPoint, Exercice exercice,
			Correspondant correspondant, Regisseur regisseur, List<LignePointVente> lignesParPoint) {
		super();
		this.numPointVente = numPointVente;
		this.datePointVente = datePointVente;
		this.payerPoint = payerPoint;
		this.exercice = exercice;
		this.correspondant = correspondant;
		this.regisseur = regisseur;
		this.lignesParPoint = lignesParPoint;
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
	public Date getDatePointVente() {
		return datePointVente;
	}

	/**
	 * @param datePointVente the datePointVente to set
	 */
	public void setDatePointVente(Date datePointVente) {
		this.datePointVente = datePointVente;
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
	 * @return the lignesParPoint
	 */
	public List<LignePointVente> getLignesParPoint() {
		return lignesParPoint;
	}

	/**
	 * @param lignesParPoint the lignesParPoint to set
	 */
	public void setLignesParPoint(List<LignePointVente> lignesParPoint) {
		this.lignesParPoint = lignesParPoint;
	}

	@Override
	public int hashCode() {
		return Objects.hash(correspondant, datePointVente, exercice, lignesParPoint, numPointVente, payerPoint,
				regisseur);
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
				&& Objects.equals(lignesParPoint, other.lignesParPoint)
				&& Objects.equals(numPointVente, other.numPointVente) && payerPoint == other.payerPoint
				&& Objects.equals(regisseur, other.regisseur);
	}

	@Override
	public String toString() {
		return "PointVente [numPointVente=" + numPointVente + ", datePointVente=" + datePointVente + ", payerPoint="
				+ payerPoint + ", exercice=" + exercice + ", correspondant=" + correspondant + ", regisseur="
				+ regisseur + ", lignesParPoint=" + lignesParPoint + "]";
	}


}
