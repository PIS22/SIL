package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Quartier implements Serializable {

	@Id
	private String codeQuartier;
	private String nomQuartier;
	private String numTelQuartier;
	private String adresseQuartier;

	//Liaison  avec Arrondissement
		@ManyToOne(fetch = FetchType.EAGER,targetEntity = Arrondissement.class)
		@JoinColumn(name="codeArrondi", referencedColumnName = "codeArrondi", nullable = false)
		private Arrondissement arrondissement;
	
	public Quartier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quartier(String codeQuartier, String nomQuartier, String numTelQuartier, String adresseQuartier,
			 Arrondissement arrondissement) {
		super();
		this.codeQuartier = codeQuartier;
		this.nomQuartier = nomQuartier;
		this.numTelQuartier = numTelQuartier;
		this.adresseQuartier = adresseQuartier;
		this.arrondissement = arrondissement;
	}

	/**
	 * @return the codeQuartier
	 */
	public String getCodeQuartier() {
		return codeQuartier;
	}

	/**
	 * @param codeQuartier the codeQuartier to set
	 */
	public void setCodeQuartier(String codeQuartier) {
		this.codeQuartier = codeQuartier;
	}

	/**
	 * @return the nomQuartier
	 */
	public String getNomQuartier() {
		return nomQuartier;
	}

	/**
	 * @param nomQuartier the nomQuartier to set
	 */
	public void setNomQuartier(String nomQuartier) {
		this.nomQuartier = nomQuartier;
	}

	/**
	 * @return the numTelQuartier
	 */
	public String getNumTelQuartier() {
		return numTelQuartier;
	}

	/**
	 * @param numTelQuartier the numTelQuartier to set
	 */
	public void setNumTelQuartier(String numTelQuartier) {
		this.numTelQuartier = numTelQuartier;
	}

	/**
	 * @return the adresseQuartier
	 */
	public String getAdresseQuartier() {
		return adresseQuartier;
	}

	/**
	 * @param adresseQuartier the adresseQuartier to set
	 */
	public void setAdresseQuartier(String adresseQuartier) {
		this.adresseQuartier = adresseQuartier;
	}


	/**
	 * @return the arrondissement
	 */
	public Arrondissement getArrondissement() {
		return arrondissement;
	}

	/**
	 * @param arrondissement the arrondissement to set
	 */
	public void setArrondissement(Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresseQuartier, arrondissement, codeQuartier, nomQuartier, numTelQuartier);
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
		Quartier other = (Quartier) obj;
		return Objects.equals(adresseQuartier, other.adresseQuartier)
				&& Objects.equals(arrondissement, other.arrondissement)
				&& Objects.equals(codeQuartier, other.codeQuartier) && Objects.equals(nomQuartier, other.nomQuartier)
				&& Objects.equals(numTelQuartier, other.numTelQuartier);
	}

	@Override
	public String toString() {
		return "Quartier [codeQuartier=" + codeQuartier + ", nomQuartier=" + nomQuartier + ", numTelQuartier="
				+ numTelQuartier + ", adresseQuartier=" + adresseQuartier + ", arrondissement=" + arrondissement + "]";
	}
}
