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
public class SiteMarcher implements Serializable{

	@Id
	private String codeSite;
	private String libSite;
	private String descriSite;
	
	@ManyToOne(targetEntity = Arrondissement.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "codeArrondi",referencedColumnName = "codeArrondi", nullable = false)
	private Arrondissement arrondissement;
	
	public SiteMarcher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codeSite
	 * @param libSite
	 * @param descriSite
	 * @param arrondissement
	 */
	public SiteMarcher(String codeSite, String libSite, String descriSite, Arrondissement arrondissement) {
		this.codeSite = codeSite;
		this.libSite = libSite;
		this.descriSite = descriSite;
		this.arrondissement = arrondissement;
	}


	public String getCodeSite() {
		return codeSite;
	}

	public void setCodeSite(String codeSite) {
		this.codeSite = codeSite;
	}

	public String getLibSite() {
		return libSite;
	}

	public void setLibSite(String libSite) {
		this.libSite = libSite;
	}

	public String getDescriSite() {
		return descriSite;
	}

	public void setDescriSite(String descriSite) {
		this.descriSite = descriSite;
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

	@Override
	public String toString() {
		return "SiteMarcher [codeSite=" + codeSite + ", LibSite=" + libSite + ", DescriSite=" + descriSite + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrondissement, codeSite, descriSite, libSite);
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
		SiteMarcher other = (SiteMarcher) obj;
		return Objects.equals(arrondissement, other.arrondissement) && Objects.equals(codeSite, other.codeSite)
				&& Objects.equals(descriSite, other.descriSite) && Objects.equals(libSite, other.libSite);
	}
	
		
}
