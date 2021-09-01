package com.sil.gpc.domains;

import java.io.Serializable;
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
public class LigneRecollement implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneRecollement;
	private Long quantiteLigneRecollement;
	private Long PULigneRecollement;
	private String observationLigneRecollement;
	
	//Liaison à la table Recollement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Recollement.class)
	@JoinColumn(name = "numRecollement", nullable = false, referencedColumnName = "numRecollement")
	public Recollement recollement;

	//Liaison à la table Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", nullable = false, referencedColumnName = "codeArticle")
	public Article article;

	public LigneRecollement() {
		super();
	}

	public LigneRecollement(Long quantiteLigneRecollement, Long pULigneRecollement, String observationLigneRecollement,
			Recollement recollement, Article article) {
		super();
		this.quantiteLigneRecollement = quantiteLigneRecollement;
		PULigneRecollement = pULigneRecollement;
		this.observationLigneRecollement = observationLigneRecollement;
		this.recollement = recollement;
		this.article = article;
	}

	/**
	 * @return the idLigneRecollement
	 */
	public Long getIdLigneRecollement() {
		return idLigneRecollement;
	}

	/**
	 * @param idLigneRecollement the idLigneRecollement to set
	 */
	public void setIdLigneRecollement(Long idLigneRecollement) {
		this.idLigneRecollement = idLigneRecollement;
	}

	/**
	 * @return the quantiteLigneRecollement
	 */
	public Long getQuantiteLigneRecollement() {
		return quantiteLigneRecollement;
	}

	/**
	 * @param quantiteLigneRecollement the quantiteLigneRecollement to set
	 */
	public void setQuantiteLigneRecollement(Long quantiteLigneRecollement) {
		this.quantiteLigneRecollement = quantiteLigneRecollement;
	}

	/**
	 * @return the pULigneRecollement
	 */
	public Long getPULigneRecollement() {
		return PULigneRecollement;
	}

	/**
	 * @param pULigneRecollement the pULigneRecollement to set
	 */
	public void setPULigneRecollement(Long pULigneRecollement) {
		PULigneRecollement = pULigneRecollement;
	}

	/**
	 * @return the observationLigneRecollement
	 */
	public String getObservationLigneRecollement() {
		return observationLigneRecollement;
	}

	/**
	 * @param observationLigneRecollement the observationLigneRecollement to set
	 */
	public void setObservationLigneRecollement(String observationLigneRecollement) {
		this.observationLigneRecollement = observationLigneRecollement;
	}

	/**
	 * @return the recollement
	 */
	public Recollement getRecollement() {
		return recollement;
	}

	/**
	 * @param recollement the recollement to set
	 */
	public void setRecollement(Recollement recollement) {
		this.recollement = recollement;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public int hashCode() {
		return Objects.hash(PULigneRecollement, article, idLigneRecollement, observationLigneRecollement,
				quantiteLigneRecollement, recollement);
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
		LigneRecollement other = (LigneRecollement) obj;
		return Objects.equals(PULigneRecollement, other.PULigneRecollement) && Objects.equals(article, other.article)
				&& Objects.equals(idLigneRecollement, other.idLigneRecollement)
				&& Objects.equals(observationLigneRecollement, other.observationLigneRecollement)
				&& Objects.equals(quantiteLigneRecollement, other.quantiteLigneRecollement)
				&& Objects.equals(recollement, other.recollement);
	}

	@Override
	public String toString() {
		return "LigneRecollement [idLigneRecollement=" + idLigneRecollement + ", quantiteLigneRecollement="
				+ quantiteLigneRecollement + ", PULigneRecollement=" + PULigneRecollement
				+ ", observationLigneRecollement=" + observationLigneRecollement + ", recollement=" + recollement
				+ ", article=" + article + "]";
	}
	
}
