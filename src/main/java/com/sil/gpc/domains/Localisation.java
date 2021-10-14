package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Localisation implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLoc;
	@Column(unique = true)
	private String codLoc;
	private String libLoc;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = SiteMarcher.class)
	@JoinColumn(name = "siteMarcher", nullable = false, referencedColumnName = "codeSite")
	private SiteMarcher siteMarcher;
	
	public Localisation() {
		// TODO Auto-generated constructor stub
	}

	public Localisation(Long idLoc, String codLoc, String libLoc, SiteMarcher siteMarcher) {
		super();
		this.idLoc = idLoc;
		this.codLoc = codLoc;
		this.libLoc = libLoc;
		this.siteMarcher = siteMarcher;
	}

	public Long getIdLoc() {
		return idLoc;
	}

	public void setIdLoc(Long idLoc) {
		this.idLoc = idLoc;
	}

	public String getCodLoc() {
		return codLoc;
	}

	public void setCodLoc(String codLoc) {
		this.codLoc = codLoc;
	}

	public String getLibLoc() {
		return libLoc;
	}

	public void setLibLoc(String libLoc) {
		this.libLoc = libLoc;
	}

	public SiteMarcher getSiteMarcher() {
		return siteMarcher;
	}

	public void setSiteMarcher(SiteMarcher siteMarcher) {
		this.siteMarcher = siteMarcher;
	}

	@Override
	public String toString() {
		return "Localisation [idLoc=" + idLoc + ", codLoc=" + codLoc + ", libLoc=" + libLoc + ", siteMarcher="
				+ siteMarcher + "]";
	}
	
	

}
