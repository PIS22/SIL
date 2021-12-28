package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Locataire implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLocataire;
	@Column(nullable = false)
	private String identiteLocataire;
	private String adresseLocataire;
	private String telLocataire;
	private String ifuLocataire;
	private String personneAContacter;
	private String numContibuable;
	
	public Locataire() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idLocataire
	 * @param identiteLocataire
	 * @param adresseLocataire
	 * @param telLocataire
	 * @param ifuLocataire
	 * @param personneAContacter
	 */
	

	public Long getIdLocataire() {
		return idLocataire;
	}
	public Locataire(Long idLocataire, String identiteLocataire, String adresseLocataire, String telLocataire,
			String ifuLocataire, String personneAContacter, String numContibuable) {
		super();
		this.idLocataire = idLocataire;
		this.identiteLocataire = identiteLocataire;
		this.adresseLocataire = adresseLocataire;
		this.telLocataire = telLocataire;
		this.ifuLocataire = ifuLocataire;
		this.personneAContacter = personneAContacter;
		this.numContibuable = numContibuable;
	}

	public void setIdLocataire(Long idLocataire) {
		this.idLocataire = idLocataire;
	}
	public String getIdentiteLocataire() {
		return identiteLocataire;
	}
	public void setIdentiteLocataire(String identiteLocataire) {
		this.identiteLocataire = identiteLocataire;
	}
	public String getAdresseLocataire() {
		return adresseLocataire;
	}
	public void setAdresseLocataire(String adresseLocataire) {
		this.adresseLocataire = adresseLocataire;
	}
	public String getTelLocataire() {
		return telLocataire;
	}
	public void setTelLocataire(String telLocataire) {
		this.telLocataire = telLocataire;
	}
	public String getPersonneAContacter() {
		return personneAContacter;
	}
	public void setPersonneAContacter(String personneAContacter) {
		this.personneAContacter = personneAContacter;
	}

	public String getIfuLocataire() {
		return ifuLocataire;
	}

	public void setIfuLocataire(String ifuLocataire) {
		this.ifuLocataire = ifuLocataire;
	}

	public String getNumContibuable() {
		return numContibuable;
	}

	public void setNumContibuable(String numContibuable) {
		this.numContibuable = numContibuable;
	}

	@Override
	public String toString() {
		return "Locataire [idLocataire=" + idLocataire + ", identiteLocataire=" + identiteLocataire
				+ ", adresseLocataire=" + adresseLocataire + ", telLocataire=" + telLocataire + ", ifuLocataire="
				+ ifuLocataire + ", personneAContacter=" + personneAContacter + ", numContibuable=" + numContibuable
				+ "]";
	}

	

}
