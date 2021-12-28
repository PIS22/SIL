package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Immeuble implements Serializable{

	@Id
	private String codeIm;
	private String libIm;
	private String localisationIm;
	private String ilot;
	private String parcelle;
	private boolean etatIm;
	private boolean batie;
	private double superficie;
	private double nbrFace;
	private double nbrPlace;
	private String stuctResp;
	private String activiter;
	private String forme;
	private String autre;
	private String dimensions;
	
	//Liaison avec Quartier
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Arrondissement.class)
	@JoinColumn(name="codeArrondi", referencedColumnName = "codeArrondi", nullable = true)
	private Arrondissement arrondissement;

	//Liaison avec Arrondissement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Quartier.class)
	@JoinColumn(name="codeQuartier", referencedColumnName = "codeQuartier", nullable = true)
	private Quartier quartier;
	
	//Liaison  avec TypeImmeuble
		@ManyToOne(fetch = FetchType.EAGER,targetEntity = TypeImmeuble.class)
		@JoinColumn(name="codeTypImm", referencedColumnName = "codeTypIm", nullable = false)
		private TypeImmeuble typeImmeuble;
		
	//Liaison  avec Site
			@ManyToOne(fetch = FetchType.EAGER,targetEntity = SiteMarcher.class)
			@JoinColumn(name="codeSite", referencedColumnName = "codeSite", nullable = true)
			private SiteMarcher siteMarcher;
			
	
	
			public Immeuble() {
				super();
				// TODO Auto-generated constructor stub
			}

	

	public Immeuble(String codeIm, String libIm, String localisationIm, String ilot, String parcelle, boolean etatIm,
			boolean batie, double superficie, double nbrFace, double nbrPlace, String stuctResp, String activiter,
			String forme, String autre, String dimensions, Arrondissement arrondissement, Quartier quartier,
			TypeImmeuble typeImmeuble, SiteMarcher siteMarcher) {
		super();
		this.codeIm = codeIm;
		this.libIm = libIm;
		this.localisationIm = localisationIm;
		this.ilot = ilot;
		this.parcelle = parcelle;
		this.etatIm = etatIm;
		this.batie = batie;
		this.superficie = superficie;
		this.nbrFace = nbrFace;
		this.nbrPlace = nbrPlace;
		this.stuctResp = stuctResp;
		this.activiter = activiter;
		this.forme = forme;
		this.autre = autre;
		this.dimensions = dimensions;
		this.arrondissement = arrondissement;
		this.quartier = quartier;
		this.typeImmeuble = typeImmeuble;
		this.siteMarcher = siteMarcher;
	}



	/**
	 * @return the codeIm
	 */
	public String getCodeIm() {
		return codeIm;
	}

	/**
	 * @param codeIm the codeIm to set
	 */
	public void setCodeIm(String codeIm) {
		this.codeIm = codeIm;
	}

	/**
	 * @return the libIm
	 */
	public String getLibIm() {
		return libIm;
	}

	/**
	 * @param libIm the libIm to set
	 */
	public void setLibIm(String libIm) {
		this.libIm = libIm;
	}

	/**
	 * @return the localisationIm
	 */
	public String getLocalisationIm() {
		return localisationIm;
	}

	/**
	 * @param localisationIm the localisationIm to set
	 */
	public void setLocalisationIm(String localisationIm) {
		this.localisationIm = localisationIm;
	}

	/**
	 * @return the etatIm
	 */
	public boolean isEtatIm() {
		return etatIm;
	}

	/**
	 * @param etatIm the etatIm to set
	 */
	public void setEtatIm(boolean etatIm) {
		this.etatIm = etatIm;
	}

	/**
	 * @return the superficie
	 */
	public double getSuperficie() {
		return superficie;
	}

	/**
	 * @param superficie the superficie to set
	 */
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}


	/**
	 * @return the stuctResp
	 */
	public String getStuctResp() {
		return stuctResp;
	}

	/**
	 * @param stuctResp the stuctResp to set
	 */
	public void setStuctResp(String stuctResp) {
		this.stuctResp = stuctResp;
	}

	/**
	 * @return the autre
	 */
	public String getAutre() {
		return autre;
	}

	/**
	 * @param autre the autre to set
	 */
	public void setAutre(String autre) {
		this.autre = autre;
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

	/**
	 * @return the siteMarcher
	 */
	public SiteMarcher getSiteMarcher() {
		return siteMarcher;
	}

	/**
	 * @param siteMarcher the siteMarcher to set
	 */
	public void setSiteMarcher(SiteMarcher siteMarcher) {
		this.siteMarcher = siteMarcher;
	}



	public String getIlot() {
		return ilot;
	}



	public void setIlot(String ilot) {
		this.ilot = ilot;
	}



	public String getParcelle() {
		return parcelle;
	}



	public void setParcelle(String parcelle) {
		this.parcelle = parcelle;
	}



	public boolean isBatie() {
		return batie;
	}



	public void setBatie(boolean batie) {
		this.batie = batie;
	}



	public double getNbrFace() {
		return nbrFace;
	}



	public void setNbrFace(double nbrFace) {
		this.nbrFace = nbrFace;
	}



	public double getNbrPlace() {
		return nbrPlace;
	}



	public void setNbrPlace(double nbrPlace) {
		this.nbrPlace = nbrPlace;
	}



	public String getActiviter() {
		return activiter;
	}



	public void setActiviter(String activiter) {
		this.activiter = activiter;
	}



	public String getForme() {
		return forme;
	}



	public void setForme(String forme) {
		this.forme = forme;
	}



	public String getDimensions() {
		return dimensions;
	}



	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}



	@Override
	public String toString() {
		return "Immeuble [codeIm=" + codeIm + ", libIm=" + libIm + ", localisationIm=" + localisationIm + ", ilot="
				+ ilot + ", parcelle=" + parcelle + ", etatIm=" + etatIm + ", batie=" + batie + ", superficie="
				+ superficie + ", nbrFace=" + nbrFace + ", nbrPlace=" + nbrPlace + ", stuctResp=" + stuctResp
				+ ", activiter=" + activiter + ", forme=" + forme + ", autre=" + autre + ", dimensions=" + dimensions
				+ ", arrondissement=" + arrondissement + ", quartier=" + quartier + ", typeImmeuble=" + typeImmeuble
				+ ", siteMarcher=" + siteMarcher + "]";
	}

	


}
