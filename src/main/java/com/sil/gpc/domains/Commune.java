package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Commune implements Serializable{

	@Id
	private String codeCommune;
	private String nomCommune;
	private String numTelMairie;
	private String adresseMairie;
	//private String codeDepartement;
	
	//Migration de la clé du département vers la commune
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Departement.class)
	@JoinColumn(name = "codeDepartement",referencedColumnName = "codeDepartement")
	public Departement codeDepartement;
	
	//Migration de la clé de la commune vers les départements
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Arrondissement.class,fetch = FetchType.EAGER,mappedBy = "commune")
	public List<Arrondissement> arrondissementsParCommune;
	
	public Commune() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commune(String codeCommune, String nomCommune, String numTelMairie, String adresseMairie,
			Departement codedepartement) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.numTelMairie = numTelMairie;
		this.adresseMairie = adresseMairie;
		this.codeDepartement = codedepartement;
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

	@Override
	public int hashCode() {
		return Objects.hash(adresseMairie, arrondissementsParCommune, codeCommune, codeDepartement, nomCommune,
				numTelMairie);
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
		return Objects.equals(adresseMairie, other.adresseMairie)
				&& Objects.equals(arrondissementsParCommune, other.arrondissementsParCommune)
				&& Objects.equals(codeCommune, other.codeCommune)
				&& Objects.equals(codeDepartement, other.codeDepartement)
				&& Objects.equals(nomCommune, other.nomCommune) && Objects.equals(numTelMairie, other.numTelMairie);
	}
	@Override
	public String toString() {
		return "Commune [codeCommune=" + codeCommune + ", nomCommune=" + nomCommune + ", numTelMairie=" + numTelMairie
				+ ", adresseMairie=" + adresseMairie + ", codeDepartement=" + codeDepartement + "]";
	}
	
}
