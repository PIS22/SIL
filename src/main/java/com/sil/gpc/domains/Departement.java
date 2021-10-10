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
public class Departement implements Serializable{

	@Id
	private String codeDepartement;
	private String nomDepartement;
	
	@ManyToOne(targetEntity = Pays.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codePays", referencedColumnName = "codePays", nullable = false)
	public Pays pays;
	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codeDepartement
	 * @param nomDepartement
	 * @param pays
	 */
	public Departement(String codeDepartement, String nomDepartement, Pays pays) {
		this.codeDepartement = codeDepartement;
		this.nomDepartement = nomDepartement;
		this.pays = pays;
	}

	/**
	 * @return the codeDepartement
	 */
	public String getCodeDepartement() {
		return codeDepartement;
	}

	/**
	 * @param codeDepartement the codeDepartement to set
	 */
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	/**
	 * @return the nomDepartement
	 */
	public String getNomDepartement() {
		return nomDepartement;
	}

	/**
	 * @param nomDepartement the nomDepartement to set
	 */
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	/**
	 * @return the pays
	 */
	public Pays getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(Pays pays) {
		this.pays = pays;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeDepartement, nomDepartement, pays);
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
		Departement other = (Departement) obj;
		return Objects.equals(codeDepartement, other.codeDepartement)
				&& Objects.equals(nomDepartement, other.nomDepartement) && Objects.equals(pays, other.pays);
	}

	@Override
	public String toString() {
		return "Departement [codeDepartement=" + codeDepartement + ", nomDepartement=" + nomDepartement + ", pays="
				+ pays + "]";
	}
	
	
}
