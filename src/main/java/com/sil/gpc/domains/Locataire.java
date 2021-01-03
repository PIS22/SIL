package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	@OneToMany(targetEntity = Contrat.class, mappedBy = "locataire")
	List<Contrat> contratLocataire;
	
	public Locataire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Locataire(String identiteLocataire, String adresseLocataire, String telLocataire,
			String personneAContacter) {
		super();
		this.identiteLocataire = identiteLocataire;
		this.adresseLocataire = adresseLocataire;
		this.telLocataire = telLocataire;
		this.personneAContacter = personneAContacter;
	}
	public Long getIdLocataire() {
		return idLocataire;
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

	public List<Contrat> getContratLocataire() {
		return contratLocataire;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresseLocataire, idLocataire, identiteLocataire, ifuLocataire, personneAContacter,
				telLocataire);
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
		Locataire other = (Locataire) obj;
		return Objects.equals(adresseLocataire, other.adresseLocataire)
				&& Objects.equals(idLocataire, other.idLocataire)
				&& Objects.equals(identiteLocataire, other.identiteLocataire)
				&& Objects.equals(ifuLocataire, other.ifuLocataire)
				&& Objects.equals(personneAContacter, other.personneAContacter)
				&& Objects.equals(telLocataire, other.telLocataire);
	}

	@Override
	public String toString() {
		return "Locataire [idLocataire=" + idLocataire + ", identiteLocataire=" + identiteLocataire
				+ ", adresseLocataire=" + adresseLocataire + ", telLocataire=" + telLocataire + ", ifuLocataire="
				+ ifuLocataire + ", personneAContacter=" + personneAContacter + ", contratLocataire=" + contratLocataire
				+ "]";
	}
	
	

}
