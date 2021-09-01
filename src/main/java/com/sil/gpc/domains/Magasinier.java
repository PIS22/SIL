package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Magasinier implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numMAgasinier;
	private String nomMagasinier;
	private String prenomMagasinier;
	private String telMagasinier;
	
	public Magasinier() {
		super();
	}

	public Magasinier(String nomMagasinier, String prenomMagasinier, String telMagasinier) {
		super();
		this.nomMagasinier = nomMagasinier;
		this.prenomMagasinier = prenomMagasinier;
		this.telMagasinier = telMagasinier;
	}

	public Long getNumMAgasinier() {
		return numMAgasinier;
	}

	public void setNumMAgasinier(Long numMAgasinier) {
		this.numMAgasinier = numMAgasinier;
	}

	public String getNomMagasinier() {
		return nomMagasinier;
	}

	public void setNomMagasinier(String nomMagasinier) {
		this.nomMagasinier = nomMagasinier;
	}

	public String getPrenomMagasinier() {
		return prenomMagasinier;
	}

	public void setPrenomMagasinier(String prenomMagasinier) {
		this.prenomMagasinier = prenomMagasinier;
	}

	public String getTelMagasinier() {
		return telMagasinier;
	}

	public void setTelMagasinier(String telMagasinier) {
		this.telMagasinier = telMagasinier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomMagasinier == null) ? 0 : nomMagasinier.hashCode());
		result = prime * result + ((numMAgasinier == null) ? 0 : numMAgasinier.hashCode());
		result = prime * result + ((prenomMagasinier == null) ? 0 : prenomMagasinier.hashCode());
		result = prime * result + ((telMagasinier == null) ? 0 : telMagasinier.hashCode());
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
		Magasinier other = (Magasinier) obj;
		if (nomMagasinier == null) {
			if (other.nomMagasinier != null)
				return false;
		} else if (!nomMagasinier.equals(other.nomMagasinier))
			return false;
		if (numMAgasinier == null) {
			if (other.numMAgasinier != null)
				return false;
		} else if (!numMAgasinier.equals(other.numMAgasinier))
			return false;
		if (prenomMagasinier == null) {
			if (other.prenomMagasinier != null)
				return false;
		} else if (!prenomMagasinier.equals(other.prenomMagasinier))
			return false;
		if (telMagasinier == null) {
			if (other.telMagasinier != null)
				return false;
		} else if (!telMagasinier.equals(other.telMagasinier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MagasinierService [numMAgasinier=" + numMAgasinier + ", nomMagasinier=" + nomMagasinier + ", prenomMagasinier="
				+ prenomMagasinier + ", telMagasinier=" + telMagasinier + "]";
	}
	
	
	
}
