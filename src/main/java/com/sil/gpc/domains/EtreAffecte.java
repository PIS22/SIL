package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class EtreAffecte implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAffecte;
	private Date dateArrivee;
	private Date dateDepart;
	
	//Liaison avec Correspondant
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Correspondant.class)
	@JoinColumn(name = "idCorrespondant",referencedColumnName = "idCorrespondant",nullable = false)
	private Correspondant corres;
	
	//Liaison avec Site
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Arrondissement.class)
	@JoinColumn(name = "codeArrondi",referencedColumnName = "codeArrondi",nullable = false)
	private Arrondissement arrondissement;

	//Liaison avec Site
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = SiteMarcher.class)
	@JoinColumn(name = "codeSite",referencedColumnName = "codeSite",nullable = true)
	private SiteMarcher site;

	/**
	 * 
	 */
	public EtreAffecte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EtreAffecte(Date dateArrivee, Date dateDepart, Correspondant corres, Arrondissement arrondissement,
			SiteMarcher site) {
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.corres = corres;
		this.arrondissement = arrondissement;
		this.site = site;
	}

	public Arrondissement getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
	}

	/**
	 * @return the idAffecte
	 */
	public Long getIdAffecte() {
		return idAffecte;
	}

	/**
	 * @param idAffecte the idAffecte to set
	 */
	public void setIdAffecte(Long idAffecte) {
		this.idAffecte = idAffecte;
	}

	/**
	 * @return the dateArrivee
	 */
	public Date getDateArrivee() {
		return dateArrivee;
	}

	/**
	 * @param dateArrivee the dateArrivee to set
	 */
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	/**
	 * @return the dateDepart
	 */
	public Date getDateDepart() {
		return dateDepart;
	}

	/**
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**
	 * @return the corres
	 */
	public Correspondant getCorres() {
		return corres;
	}

	/**
	 * @param corres the corres to set
	 */
	public void setCorres(Correspondant corres) {
		this.corres = corres;
	}

	/**
	 * @return the site
	 */
	public SiteMarcher getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(SiteMarcher site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "EtreAffecte [idAffecte=" + idAffecte + ", dateArrivee=" + dateArrivee + ", dateDepart=" + dateDepart
				+ ", corres=" + corres + ", site=" + site + "]";
	}

	
}
