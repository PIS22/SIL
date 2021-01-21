package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@SuppressWarnings("serial")
@Entity

public class EtreAffecte implements Serializable{
	@Id
	private Long idAff;
	private Date dateArrivee;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true, targetEntity = SiteMarcher.class)
	@JoinColumn(name = "codesite", referencedColumnName = "codeSite", nullable = false)
	private SiteMarcher site;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true, targetEntity = Correspondant.class)
	private Correspondant correspondant;

	/**
	 * @param dateArrivee
	 * @param site
	 * @param correspondant
	 */
	public EtreAffecte(Date dateArrivee, SiteMarcher site, Correspondant correspondant) {
		this.dateArrivee = dateArrivee;
		this.site = site;
		this.correspondant = correspondant;
	}

	/**
	 * @return the idAff
	 */
	public Long getIdAff() {
		return idAff;
	}

	/**
	 * @param idAff the idAff to set
	 */
	public void setIdAff(Long idAff) {
		this.idAff = idAff;
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

	/**
	 * @return the correspondant
	 */
	public Correspondant getCorrespondant() {
		return correspondant;
	}

	/**
	 * @param correspondant the correspondant to set
	 */
	public void setCorrespondant(Correspondant correspondant) {
		this.correspondant = correspondant;
	}

	@Override
	public String toString() {
		return "EtreAffecte [idAff=" + idAff + ", dateArrivee=" + dateArrivee + ", site=" + site + ", correspondant="
				+ correspondant + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(correspondant, dateArrivee, idAff, site);
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
		EtreAffecte other = (EtreAffecte) obj;
		return Objects.equals(correspondant, other.correspondant) && Objects.equals(dateArrivee, other.dateArrivee)
				&& Objects.equals(idAff, other.idAff) && Objects.equals(site, other.site);
	}	
	
}
