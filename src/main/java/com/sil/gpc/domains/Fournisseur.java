package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity(name = "Fournisseur")
public class Fournisseur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(length = 4)
	private String codeFrs;
	@Column(length = 150)
	private String identiteFrs;
	@Column(length = 100)
	private String adresseFrs;
	@Column(length = 150)
	private String raisonSociale;
	@Column(length = 13)
	private String numIfuFrs;
	@Column(length = 45)
	private String telFRS;
	@Column(length = 150)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Commande.class,mappedBy = "frs")
	List<Commande> cmdesParFrs;
	
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fournisseur(String codeFrs, String identiteFrs, String adresseFrs, String raisonSociale, String numIfuFrs,
			String telFRS, String description) {
		super();
		this.codeFrs = codeFrs;
		this.identiteFrs = identiteFrs;
		this.adresseFrs = adresseFrs;
		this.raisonSociale = raisonSociale;
		this.numIfuFrs = numIfuFrs;
		this.telFRS = telFRS;
		this.description = description;
	}

	public String getCodeFrs() {
		return codeFrs;
	}

	public void setCodeFrs(String codeFrs) {
		this.codeFrs = codeFrs;
	}

	public String getIdentiteFrs() {
		return identiteFrs;
	}

	public void setIdentiteFrs(String identiteFrs) {
		this.identiteFrs = identiteFrs;
	}

	public String getAdresseFrs() {
		return adresseFrs;
	}

	public void setAdresseFrs(String adresseFrs) {
		this.adresseFrs = adresseFrs;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getNumIfuFrs() {
		return numIfuFrs;
	}

	public void setNumIfuFrs(String numIfuFrs) {
		this.numIfuFrs = numIfuFrs;
	}

	public String getTelFRS() {
		return telFRS;
	}

	public void setTelFRS(String telFRS) {
		this.telFRS = telFRS;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresseFrs, codeFrs, description, identiteFrs, numIfuFrs, raisonSociale, telFRS);
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
		Fournisseur other = (Fournisseur) obj;
		return Objects.equals(adresseFrs, other.adresseFrs) && Objects.equals(codeFrs, other.codeFrs)
				&& Objects.equals(description, other.description) && Objects.equals(identiteFrs, other.identiteFrs)
				&& Objects.equals(numIfuFrs, other.numIfuFrs) && Objects.equals(raisonSociale, other.raisonSociale)
				&& Objects.equals(telFRS, other.telFRS);
	}

	@Override
	public String toString() {
		return "Fournisseur [codeFrs=" + codeFrs + ", identiteFrs=" + identiteFrs + ", adresseFrs=" + adresseFrs
				+ ", raisonSociale=" + raisonSociale + ", numIfuFrs=" + numIfuFrs + ", telFRS=" + telFRS
				+ ", description=" + description + ", cmdesParFrs=" + cmdesParFrs + "]";
	}
	
	

}
