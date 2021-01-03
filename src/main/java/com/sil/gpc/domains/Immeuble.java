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
public class Immeuble implements Serializable{

	@Id
	private String codeIm;
	private String localisationIm;
	private boolean etatIm;
	//Liaison avec QuartierRepository
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Quartier.class)
	@JoinColumn(name="codeQuartier", referencedColumnName = "codeQuartier", nullable = false)
	private Quartier quartier;
	
	//Liaison  avec TypeImmeuble
		@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = TypeImmeuble.class)
		@JoinColumn(name="codeTypImm", referencedColumnName = "codeTypIm", nullable = false)
		private TypeImmeuble typeImmeuble;
		
		//Liaison  avec PrixImmeuble
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = PrixImmeuble.class,mappedBy = "immeuble")
		public List<PrixImmeuble> prixImmeuble;//*****************************Erreur, c'est prix Immeuble
	
	public Immeuble() {
		super();
	}


	public String getCodeIm() {
		return codeIm;
	}

	public void setCodeIm(String codeIm) {
		this.codeIm = codeIm;
	}

	public String getLocalisationIm() {
		return localisationIm;
	}

	public void setLocalisationIm(String localisationIm) {
		this.localisationIm = localisationIm;
	}

	public boolean isEtatIm() {
		return etatIm;
	}

	public void setEtatIm(boolean etatIm) {
		this.etatIm = etatIm;
	}


	/**
	 * @return the quartier
	 */
	public Quartier getQuartier() {
		return quartier;
	}


	/**
	 * @param quartier the quartier to set
	 */
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}


	/**
	 * @return the typeImmeuble
	 */
	public TypeImmeuble getTypeImmeuble() {
		return typeImmeuble;
	}


	/**
	 * @param typeImmeuble the typeImmeuble to set
	 */
	public void setTypeImmeuble(TypeImmeuble typeImmeuble) {
		this.typeImmeuble = typeImmeuble;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codeIm, etatIm, localisationIm, quartier, typeImmeuble);
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
		Immeuble other = (Immeuble) obj;
		return Objects.equals(codeIm, other.codeIm) && etatIm == other.etatIm
				&& Objects.equals(localisationIm, other.localisationIm) && Objects.equals(quartier, other.quartier)
				&& Objects.equals(typeImmeuble, other.typeImmeuble);
	}	
}
