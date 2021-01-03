package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Arrondissement implements Serializable{

	@Id
	private String codeArrondi;
	private String nomArrondi;
	private String adresseArrondi;
	private String numTelArrondi;
	
	//Migration de lab clé de la commune vers l'arrondissement
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Commune.class)
	@JoinColumn(name = "commune", nullable = false, referencedColumnName = "codeCommune")
	public Commune commune;
	
	//Migration de lab clé de l'arrondissement vers la caisse
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Caisse.class,mappedBy = "arrondissement")
	List<Caisse> caissesDunArrondissement;

	//Migration de lab clé de l'arrondissement vers le quartier
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Quartier.class,mappedBy = "arrondissement")
	List<Quartier> quartiersDunArrondissement;
	
	public Arrondissement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Arrondissement(String codeArrondi, String nomArrondi, String adresseArrondi, String numTelArrondi,
			Commune commune) {
		super();
		this.codeArrondi = codeArrondi;
		this.nomArrondi = nomArrondi;
		this.adresseArrondi = adresseArrondi;
		this.numTelArrondi = numTelArrondi;
		this.commune = commune;
	}
	public String getCodeArrondi() {
		return codeArrondi;
	}
	public void setCodeArrondi(String codeArrondi) {
		this.codeArrondi = codeArrondi;
	}
	public String getNomArrondi() {
		return nomArrondi;
	}
	public void setNomArrondi(String nomArrondi) {
		this.nomArrondi = nomArrondi;
	}
	public String getAdresseArrondi() {
		return adresseArrondi;
	}
	public void setAdresseArrondi(String adresseArrondi) {
		this.adresseArrondi = adresseArrondi;
	}
	public String getNumTelArrondi() {
		return numTelArrondi;
	}
	public void setNumTelArrondi(String numTelArrondi) {
		this.numTelArrondi = numTelArrondi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresseArrondi == null) ? 0 : adresseArrondi.hashCode());
		result = prime * result + ((codeArrondi == null) ? 0 : codeArrondi.hashCode());
		result = prime * result + ((nomArrondi == null) ? 0 : nomArrondi.hashCode());
		result = prime * result + ((numTelArrondi == null) ? 0 : numTelArrondi.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arrondissement other = (Arrondissement) obj;
		if (adresseArrondi == null) {
			if (other.adresseArrondi != null)
				return false;
		} else if (!adresseArrondi.equals(other.adresseArrondi))
			return false;
		if (codeArrondi == null) {
			if (other.codeArrondi != null)
				return false;
		} else if (!codeArrondi.equals(other.codeArrondi))
			return false;
		if (nomArrondi == null) {
			if (other.nomArrondi != null)
				return false;
		} else if (!nomArrondi.equals(other.nomArrondi))
			return false;
		if (numTelArrondi == null) {
			if (other.numTelArrondi != null)
				return false;
		} else if (!numTelArrondi.equals(other.numTelArrondi))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Arrondissement [codeArrondi=" + codeArrondi + ", nomArrondi=" + nomArrondi + ", adresseArrondi="
				+ adresseArrondi + ", numTelArrondi=" + numTelArrondi + ", codeCommune=" + commune + "]";
	}
	
}
