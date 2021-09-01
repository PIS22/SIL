package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Echeance implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEcheance;
	private String moisEcheance;
	private int annee;
	private Date dateEcheance;
	private boolean payeEcheance;
	private double prix;
	@ManyToOne(targetEntity = Contrat.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "numContrat",referencedColumnName = "numContrat", nullable = false)
	private Contrat contrat;

	//Liaison avec la table OpCaisse
	@ManyToOne(targetEntity = OpCaisse.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "numOpCaisse", referencedColumnName = "numOpCaisse",nullable = true)
	private OpCaisse opCaisse ;

	public Echeance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Echeance(String moisEcheance, int annee, Date dateEcheance, boolean payeEcheance, double prix,
			Contrat contrat, OpCaisse opCaisse) {
		this.moisEcheance = moisEcheance;
		this.annee = annee;
		this.dateEcheance = dateEcheance;
		this.payeEcheance = payeEcheance;
		this.prix = prix;
		this.contrat = contrat;
		this.opCaisse = opCaisse;
	}

	public String getMoisEcheance() {
		return moisEcheance;
	}

	public void setMoisEcheance(String moisEcheance) {
		this.moisEcheance = moisEcheance;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	/**
	 * @param dateEcheance the dateEcheance to set
	 */
	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	/**
	 * @return the payeEcheance
	 */
	public boolean isPayeEcheance() {
		return payeEcheance;
	}

	/**
	 * @param payeEcheance the payeEcheance to set
	 */
	public void setPayeEcheance(boolean payeEcheance) {
		this.payeEcheance = payeEcheance;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the contrat
	 */
	public Contrat getContrat() {
		return contrat;
	}

	/**
	 * @param contrat the contrat to set
	 */
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
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
	 * @return the idEcheance
	 */
	public Long getIdEcheance() {
		return idEcheance;
	}

	@Override
	public String toString() {
		return "Echeance [idEcheance=" + idEcheance + ", moisEcheance=" + moisEcheance + ", annee=" + annee
				+ ", dateEcheance=" + dateEcheance + ", payeEcheance=" + payeEcheance + ", prix=" + prix + ", contrat="
				+ contrat + ", opCaisse=" + opCaisse + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(annee, contrat, dateEcheance, idEcheance, moisEcheance, opCaisse, payeEcheance, prix);
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
		Echeance other = (Echeance) obj;
		return annee == other.annee && Objects.equals(contrat, other.contrat)
				&& Objects.equals(dateEcheance, other.dateEcheance) && Objects.equals(idEcheance, other.idEcheance)
				&& Objects.equals(moisEcheance, other.moisEcheance) && Objects.equals(opCaisse, other.opCaisse)
				&& payeEcheance == other.payeEcheance
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix);
	}

}