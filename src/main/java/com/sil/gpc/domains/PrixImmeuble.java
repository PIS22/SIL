package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class PrixImmeuble implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPrixIm;
	private Date dateDebPrixIm;
	private Date dateFinPrixIm;
	private Long prixIm;

	//Liaison avec immeuble
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Immeuble.class)
	@JoinColumn(name = "codeIm",referencedColumnName = "codeIm",nullable = false)
	private Immeuble immeuble;
	
	public PrixImmeuble() {
		super();
	}

	public PrixImmeuble(Date dateDebPrixIm, Date dateFinPrixIm, Long prixIm, Immeuble immeuble) {
		super();
		this.dateDebPrixIm = dateDebPrixIm;
		this.dateFinPrixIm = dateFinPrixIm;
		this.prixIm = prixIm;
		this.immeuble = immeuble;
	}

	/**
	 * @return the idPrixIm
	 */
	public Long getIdPrixIm() {
		return idPrixIm;
	}

	/**
	 * @param idPrixIm the idPrixIm to set
	 */
	public void setIdPrixIm(Long idPrixIm) {
		this.idPrixIm = idPrixIm;
	}

	/**
	 * @return the dateDebPrixIm
	 */
	public Date getDateDebPrixIm() {
		return dateDebPrixIm;
	}

	/**
	 * @param dateDebPrixIm the dateDebPrixIm to set
	 */
	public void setDateDebPrixIm(Date dateDebPrixIm) {
		this.dateDebPrixIm = dateDebPrixIm;
	}

	/**
	 * @return the dateFinPrixIm
	 */
	public Date getDateFinPrixIm() {
		return dateFinPrixIm;
	}

	/**
	 * @param dateFinPrixIm the dateFinPrixIm to set
	 */
	public void setDateFinPrixIm(Date dateFinPrixIm) {
		this.dateFinPrixIm = dateFinPrixIm;
	}

	/**
	 * @return the prixIm
	 */
	public Long getPrixIm() {
		return prixIm;
	}

	/**
	 * @param prixIm the prixIm to set
	 */
	public void setPrixIm(Long prixIm) {
		this.prixIm = prixIm;
	}

	/**
	 * @return the immeuble
	 */
	public Immeuble getImmeuble() {
		return immeuble;
	}

	/**
	 * @param immeuble the immeuble to set
	 */
	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateDebPrixIm, dateFinPrixIm, idPrixIm, immeuble, prixIm);
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
		PrixImmeuble other = (PrixImmeuble) obj;
		return Objects.equals(dateDebPrixIm, other.dateDebPrixIm) && Objects.equals(dateFinPrixIm, other.dateFinPrixIm)
				&& Objects.equals(idPrixIm, other.idPrixIm) && Objects.equals(immeuble, other.immeuble)
				&& Objects.equals(prixIm, other.prixIm);
	}

	@Override
	public String toString() {
		return "PrixImmeuble [idPrixIm=" + idPrixIm + ", dateDebPrixIm=" + dateDebPrixIm + ", dateFinPrixIm="
				+ dateFinPrixIm + ", prixIm=" + prixIm + ", immeuble=" + immeuble + "]";
	}
	
}
