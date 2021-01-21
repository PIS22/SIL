package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true, targetEntity = Arrondissement.class)
	@JoinColumn(name = "codeArrondis", referencedColumnName = "codeArrondi", nullable = false)
	Arrondissement arrondis;
	
	public SiteMarcher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SiteMarcher(String codeSite, String libSite, String descriSite) {
		super();
		this.codeSite = codeSite;
		this.libSite = libSite;
		this.descriSite = descriSite;
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

	@Override
	public String toString() {
		return "SiteMarcher [codeSite=" + codeSite + ", LibSite=" + libSite + ", DescriSite=" + descriSite + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrondis, codeSite, descriSite, libSite);
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
		return Objects.equals(arrondis, other.arrondis) && Objects.equals(codeSite, other.codeSite)
				&& Objects.equals(descriSite, other.descriSite) && Objects.equals(libSite, other.libSite);
	}
	
	
	
	
}
