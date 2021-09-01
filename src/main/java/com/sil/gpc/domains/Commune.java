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
public class Commune implements Serializable{

	@Id
	private String codeCommune;
	private String nomCommune;
	private String numTelMairie;
	private String adresseMairie;
	private String entetePage;
	private String piedPage;
	
	//Migration de la clé du département vers la commune
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Departement.class)
	@JoinColumn(name = "codeDepartement",referencedColumnName = "codeDepartement")
	public Departement codeDepartement;
	
	//Migration de la clé de la commune vers les départements
	//@OneToMany(cascade = CascadeType.ALL,targetEntity = Arrondissement.class,fetch = FetchType.EAGER,mappedBy = "commune")
	//public List<Arrondissement> arrondissementsParCommune;
	
	public Commune() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param codeCommune
	 * @param nomCommune
	 * @param numTelMairie
	 * @param adresseMairie
	 * @param entetePage
	 * @param piedPage
	 * @param codeDepartement
	 */
	public Commune(String codeCommune, String nomCommune, String numTelMairie, String adresseMairie, String entetePage,
			String piedPage, Departement codeDepartement) {
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.numTelMairie = numTelMairie;
		this.adresseMairie = adresseMairie;
		this.entetePage = entetePage;
		this.piedPage = piedPage;
		this.codeDepartement = codeDepartement;
	}


	public String getCodeCommune() {
		return codeCommune;
	}
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}
	public String getNomCommune() {
		return nomCommune;
	}
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	public String getNumTelMairie() {
		return numTelMairie;
	}
	public void setNumTelMairie(String numTelMairie) {
		this.numTelMairie = numTelMairie;
	}
	public String getAdresseMairie() {
		return adresseMairie;
	}
	public void setAdresseMairie(String adresseMairie) {
		this.adresseMairie = adresseMairie;
	}
	
	public String getEntetePage() {
		return entetePage;
	}
	public void setEntetePage(String entetePage) {
		this.entetePage = entetePage;
	}
	public String getPiedPage() {
		return piedPage;
	}
	public void setPiedPage(String piedPage) {
		this.piedPage = piedPage;
	}


	@Override
	public int hashCode() {
		return Objects.hash(adresseMairie, codeCommune, codeDepartement, entetePage, nomCommune, numTelMairie,
				piedPage);
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
		Commune other = (Commune) obj;
		return Objects.equals(adresseMairie, other.adresseMairie) && Objects.equals(codeCommune, other.codeCommune)
				&& Objects.equals(codeDepartement, other.codeDepartement)
				&& Objects.equals(entetePage, other.entetePage) && Objects.equals(nomCommune, other.nomCommune)
				&& Objects.equals(numTelMairie, other.numTelMairie) && Objects.equals(piedPage, other.piedPage);
	}

	@Override
	public String toString() {
		return "Commune [codeCommune=" + codeCommune + ", nomCommune=" + nomCommune + ", numTelMairie=" + numTelMairie
				+ ", adresseMairie=" + adresseMairie + ", entetePage=" + entetePage + ", piedPage=" + piedPage
				+ ", codeDepartement=" + codeDepartement + "]";
	}
	
	
}
