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
import javax.persistence.PrimaryKeyJoinColumn;

@SuppressWarnings("serial")
@Entity
public class Caisse implements Serializable {
	
	@Id
	@PrimaryKeyJoinColumn
	private String codeCaisse;
	private String libeCaisse;

	
	//Liaison à venir
	@ManyToOne(cascade = CascadeType.DETACH,targetEntity = Arrondissement.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "codeArrondi",referencedColumnName = "codeArrondi", nullable = false)
	private Arrondissement arrondissement;
	
	@OneToMany(targetEntity = Affecter.class, mappedBy = "caisse")
	public List<Affecter> utilisateursDuneCaisse;
	
	@OneToMany(targetEntity = OpCaisse.class, mappedBy = "caisse")
	public List<OpCaisse> opérationsDuneCaisse;
		
	public Caisse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Caisse(String codeCaisse, String libeCaisse, Arrondissement arrondissement) {
		super();
		this.codeCaisse = codeCaisse;
		this.libeCaisse = libeCaisse;
		this.arrondissement = arrondissement;
	}
	
	public String getCodeCaisse() {
		return codeCaisse;
	}

	public void setCodeCaisse(String codeCaisse) {
		this.codeCaisse = codeCaisse;
	}
	
	public String getLibeCaisse() {
		return libeCaisse;
	}
	
	public void setLibeCaisse(String libeCaisse) {
		this.libeCaisse = libeCaisse;
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

	/**
	 * @return the affectationsDuneCaisse
	 */
	public List<Affecter> getAffectationsDuneCaisse() {
		return utilisateursDuneCaisse;
	}

	/**
	 * @return the opérationsDuneCaisse
	 */
	public List<OpCaisse> getOpérationsDuneCaisse() {
		return opérationsDuneCaisse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrondissement, codeCaisse, libeCaisse);
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
		Caisse other = (Caisse) obj;
		return Objects.equals(arrondissement, other.arrondissement) && Objects.equals(codeCaisse, other.codeCaisse)
				&& Objects.equals(libeCaisse, other.libeCaisse);
	}

	@Override
	public String toString() {
		return "Caisse [codeCaisse=" + codeCaisse + ", libeCaisse=" + libeCaisse + ", arrondissement=" + arrondissement
				+ ", affectationsDuneCaisse=" + utilisateursDuneCaisse + ", opérationsDuneCaisse="
				+ opérationsDuneCaisse + "]";
	}


}
