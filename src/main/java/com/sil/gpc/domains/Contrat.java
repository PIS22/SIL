package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@Column(name = "avanceContrat")
	private double avanceContrat;
	@Column(name = "cautionContrat")
	private double cautionContrat;

	// Migration de lab clé de l'immeuble vers le contrat
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Immeuble.class)
	@JoinColumn(name = "codeImm", referencedColumnName = "codeIm", nullable = false)
	private Immeuble immeuble;

	// Migration de lab clé du locataire vers le contrat
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Locataire.class)
	@JoinColumn(name = "idLocataire", referencedColumnName = "idLocataire", nullable = false)
	private Locataire locataire;

	// Migration de la clé de l'échéance vers le contrat
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Echeance.class, mappedBy = "contrat")
	List<Echeance> echeancesDunContrat = new ArrayList<>();

	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numContrat
	 * @param dateSignatureContrat
	 * @param dateEffetContrat
	 * @param avanceContrat
	 * @param cautionContrat
	 * @param immeuble
	 * @param locataire
	 */
	public Contrat(String numContrat, Date dateSignatureContrat, Date dateEffetContrat, double avanceContrat,
			double cautionContrat, Immeuble immeuble, Locataire locataire) {
		this.numContrat = numContrat;
		this.dateSignatureContrat = dateSignatureContrat;
		this.dateEffetContrat = dateEffetContrat;
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

	/**
	 * @return the echeancesDunContrat
	 */
	public List<Echeance> getEcheancesDunContrat() {
		return echeancesDunContrat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avanceContrat, cautionContrat, dateEffetContrat, dateSignatureContrat, immeuble, locataire,
				numContrat);
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
				&& Objects.equals(dateSignatureContrat, other.dateSignatureContrat)
				&& Objects.equals(immeuble, other.immeuble) && Objects.equals(locataire, other.locataire)
				&& Objects.equals(numContrat, other.numContrat);
	}

	@Override
	public String toString() {
		return "Contrat [numContrat=" + numContrat + ", dateSignatureContrat=" + dateSignatureContrat
				+ ", dateEffetContrat=" + dateEffetContrat + ", avanceContrat=" + avanceContrat + ", cautionContrat="
				+ cautionContrat + ", immeuble=" + immeuble + ", echeancesDunContrat=" + echeancesDunContrat
				+ ", locataire=" + locataire + "]";
	}

}
