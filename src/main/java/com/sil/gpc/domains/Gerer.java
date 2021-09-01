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
public class Gerer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idGerer;
	private Date dateDebGerer;
	private Date dateFinGerer;

	//Liaison avec MagasinierService
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Magasinier.class)
	@JoinColumn(name = "numMagasinier", referencedColumnName ="numMagasinier",nullable = false)
	private Magasinier magasinier;
	
	//Liaison avec Magasin
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Magasin.class)
	@JoinColumn(name = "codeMagasin", referencedColumnName ="codeMagasin",nullable = false)
	private Magasin magasin;
	
	public Gerer() {
		super();
	}
	
	public Gerer(Date dateDebGerer, Date dateFinGerer, Magasinier magasinier, Magasin magasin) {
		super();
		this.dateDebGerer = dateDebGerer;
		this.dateFinGerer = dateFinGerer;
		this.magasinier = magasinier;
		this.magasin = magasin;
	}

	/**
	 * @return the idGerer
	 */
	public Long getIdGerer() {
		return idGerer;
	}

	/**
	 * @param idGerer the idGerer to set
	 */
	public void setIdGerer(Long idGerer) {
		this.idGerer = idGerer;
	}

	/**
	 * @return the magasinier
	 */
	public Magasinier getMagasinier() {
		return magasinier;
	}

	/**
	 * @param magasinier the magasinier to set
	 */
	public void setMagasinier(Magasinier magasinier) {
		this.magasinier = magasinier;
	}

	/**
	 * @return the magasin
	 */
	public Magasin getMagasin() {
		return magasin;
	}

	/**
	 * @param magasin the magasin to set
	 */
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public Date getDateDebGerer() {
		return dateDebGerer;
	}

	public void setDateDebGerer(Date dateDebGerer) {
		this.dateDebGerer = dateDebGerer;
	}

	public Date getDateFinGerer() {
		return dateFinGerer;
	}

	public void setDateFinGerer(Date dateFinGerer) {
		this.dateFinGerer = dateFinGerer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateDebGerer, dateFinGerer, idGerer, magasin, magasinier);
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
		Gerer other = (Gerer) obj;
		return Objects.equals(dateDebGerer, other.dateDebGerer) && Objects.equals(dateFinGerer, other.dateFinGerer)
				&& idGerer == other.idGerer && Objects.equals(magasin, other.magasin)
				&& Objects.equals(magasinier, other.magasinier);
	}

	@Override
	public String toString() {
		return "Gerer [idGerer=" + idGerer + ", dateDebGerer=" + dateDebGerer + ", dateFinGerer=" + dateFinGerer
				+ ", magasinier=" + magasinier + ", magasin=" + magasin + "]";
	}	
	
	
}
