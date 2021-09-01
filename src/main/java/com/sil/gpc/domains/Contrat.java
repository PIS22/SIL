package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Contrat implements Serializable {

	@Id
	@Column(name = "numContrat", length = 30)
	private String numContrat;
	@Column(name = "dateSignatureContrat")
	private Date dateSignatureContrat;
	@Column(name = "dateEffetContrat")
	private Date dateEffetContrat;
	@Column(name = "dateFinContrat")
	private Date dateFinContrat;
	@Column(name = "avanceContrat")
	private double avanceContrat;
	@Column(name = "cautionContrat")
	private double cautionContrat;

	// Migration de lab clé de l'immeuble vers le contrat
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Immeuble.class)
	@JoinColumn(name = "codeImm", referencedColumnName = "codeIm", nullable = false)
	private Immeuble immeuble;

	// Migration de lab clé du locataire vers le contrat
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Locataire.class)
	@JoinColumn(name = "idLocataire", referencedColumnName = "idLocataire", nullable = false)
	private Locataire locataire;

	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numContrat
	 * @param dateSignatureContrat
	 * @param dateEffetContrat
	 * @param dateFinContrat
	 * @param avanceContrat
	 * @param cautionContrat
	 * @param immeuble
	 * @param locataire
	 */
	public Contrat(String numContrat, Date dateSignatureContrat, Date dateEffetContrat, Date dateFinContrat,
			double avanceContrat, double cautionContrat, Immeuble immeuble, Locataire locataire) {
		this.numContrat = numContrat;
		this.dateSignatureContrat = dateSignatureContrat;
		this.dateEffetContrat = dateEffetContrat;
		this.dateFinContrat = dateFinContrat;
		this.avanceContrat = avanceContrat;
		this.cautionContrat = cautionContrat;
		this.immeuble = immeuble;
		this.locataire = locataire;
	}

	/**
	 * @return the numContrat
	 */
	public String getNumContrat() {
		return numContrat;
	}

	/**
	 * @param numContrat the numContrat to set
	 */
	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;
	}

	/**
	 * @return the dateSignatureContrat
	 */
	public Date getDateSignatureContrat() {
		return dateSignatureContrat;
	}

	/**
	 * @param dateSignatureContrat the dateSignatureContrat to set
	 */
	public void setDateSignatureContrat(Date dateSignatureContrat) {
		this.dateSignatureContrat = dateSignatureContrat;
	}

	/**
	 * @return the dateEffetContrat
	 */
	public Date getDateEffetContrat() {
		return dateEffetContrat;
	}

	/**
	 * @param dateEffetContrat the dateEffetContrat to set
	 */
	public void setDateEffetContrat(Date dateEffetContrat) {
		this.dateEffetContrat = dateEffetContrat;
	}

	/**
	 * @return the dateFinContrat
	 */
	public Date getDateFinContrat() {
		return dateFinContrat;
	}

	/**
	 * @param dateFinContrat the dateFinContrat to set
	 */
	public void setDateFinContrat(Date dateFinContrat) {
		this.dateFinContrat = dateFinContrat;
	}

	/**
	 * @return the avanceContrat
	 */
	public double getAvanceContrat() {
		return avanceContrat;
	}

	/**
	 * @param avanceContrat the avanceContrat to set
	 */
	public void setAvanceContrat(double avanceContrat) {
		this.avanceContrat = avanceContrat;
	}

	/**
	 * @return the cautionContrat
	 */
	public double getCautionContrat() {
		return cautionContrat;
	}

	/**
	 * @param cautionContrat the cautionContrat to set
	 */
	public void setCautionContrat(double cautionContrat) {
		this.cautionContrat = cautionContrat;
	}

	/**
	 * @return the immeuble
	 */
	public Immeuble getImmeuble() {
		return immeuble;
	}

	/**
	 * @param immeuble the immeuble to set
	 */
	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}

	/**
	 * @return the locataire
	 */
	public Locataire getLocataire() {
		return locataire;
	}

	/**
	 * @param locataire the locataire to set
	 */
	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avanceContrat, cautionContrat, dateEffetContrat, dateFinContrat, dateSignatureContrat,
				immeuble, locataire, numContrat);
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
		Contrat other = (Contrat) obj;
		return Double.doubleToLongBits(avanceContrat) == Double.doubleToLongBits(other.avanceContrat)
				&& Double.doubleToLongBits(cautionContrat) == Double.doubleToLongBits(other.cautionContrat)
				&& Objects.equals(dateEffetContrat, other.dateEffetContrat)
				&& Objects.equals(dateFinContrat, other.dateFinContrat)
				&& Objects.equals(dateSignatureContrat, other.dateSignatureContrat)
				&& Objects.equals(immeuble, other.immeuble) && Objects.equals(locataire, other.locataire)
				&& Objects.equals(numContrat, other.numContrat);
	}

	@Override
	public String toString() {
		return "Contrat [numContrat=" + numContrat + ", dateSignatureContrat=" + dateSignatureContrat
				+ ", dateEffetContrat=" + dateEffetContrat + ", dateFinContrat=" + dateFinContrat + ", avanceContrat="
				+ avanceContrat + ", cautionContrat=" + cautionContrat + ", immeuble=" + immeuble + ", locataire="
				+ locataire + "]";
	}

}
