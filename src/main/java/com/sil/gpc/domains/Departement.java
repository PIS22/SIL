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
public class Departement implements Serializable{

	@Id
	private String codeDepartement;
	private String nomDepartement;
	
	//Migration de la clé du département vers les communes
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Commune.class,mappedBy = "codeDepartement", fetch = FetchType.EAGER)
	public List<Commune> communesParDepartement;
	
	@ManyToOne(cascade = CascadeType.ALL,targetEntity = Pays.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codePays", referencedColumnName = "codePays", nullable = false)
	public Pays pays;
	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departement(String codeDepartement, String nomDepartement, List<Commune> communesParDepartement, Pays pays) {
		super();
		this.codeDepartement = codeDepartement;
		this.nomDepartement = nomDepartement;
		this.communesParDepartement = communesParDepartement;
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
	 * @return the communesParDepartement
	 */
	public List<Commune> getCommunesParDepartement() {
		return communesParDepartement;
	}

	/**
	 * @param communesParDepartement the communesParDepartement to set
	 */
	public void setCommunesParDepartement(List<Commune> communesParDepartement) {
		this.communesParDepartement = communesParDepartement;
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
		return Objects.hash(codeDepartement, communesParDepartement, nomDepartement, pays);
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
				&& Objects.equals(communesParDepartement, other.communesParDepartement)
				&& Objects.equals(nomDepartement, other.nomDepartement) && Objects.equals(pays, other.pays);
	}

	@Override
	public String toString() {
		return "Departement [codeDepartement=" + codeDepartement + ", nomDepartement=" + nomDepartement
				+ ", communesParDepartement=" + communesParDepartement + ", pays=" + pays + "]";
	}
}
