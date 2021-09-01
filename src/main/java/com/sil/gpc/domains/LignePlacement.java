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
public class LignePlacement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLignePlacement;
	private Long quantiteLignePlacement;
	private Long PULignePlacement;

	//Liaison à la table Placement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Placement.class)
	@JoinColumn(name = "numPlacement", nullable = false, referencedColumnName = "numPlacement")
	public Placement placement;

	//Liaison à la table Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", nullable = false, referencedColumnName = "codeArticle")
	public Article article;

	public LignePlacement() {
		super();
	}

	public LignePlacement(Long quantiteLignePlacement, Long pULignePlacement, Placement placement, Article article) {
		super();
		this.quantiteLignePlacement = quantiteLignePlacement;
		PULignePlacement = pULignePlacement;
		this.placement = placement;
		this.article = article;
	}

	/**
	 * @return the idLignePlacement
	 */
	public Long getIdLignePlacement() {
		return idLignePlacement;
	}

	/**
	 * @param idLignePlacement the idLignePlacement to set
	 */
	public void setIdLignePlacement(Long idLignePlacement) {
		this.idLignePlacement = idLignePlacement;
	}

	/**
	 * @return the quantiteLignePlacement
	 */
	public Long getQuantiteLignePlacement() {
		return quantiteLignePlacement;
	}

	/**
	 * @param quantiteLignePlacement the quantiteLignePlacement to set
	 */
	public void setQuantiteLignePlacement(Long quantiteLignePlacement) {
		this.quantiteLignePlacement = quantiteLignePlacement;
	}

	/**
	 * @return the pULignePlacement
	 */
	public Long getPULignePlacement() {
		return PULignePlacement;
	}

	/**
	 * @param pULignePlacement the pULignePlacement to set
	 */
	public void setPULignePlacement(Long pULignePlacement) {
		PULignePlacement = pULignePlacement;
	}

	/**
	 * @return the placement
	 */
	public Placement getPlacement() {
		return placement;
	}

	/**
	 * @param placement the placement to set
	 */
	public void setPlacement(Placement placement) {
		this.placement = placement;
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
		return Objects.hash(PULignePlacement, article, idLignePlacement, placement, quantiteLignePlacement);
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
		LignePlacement other = (LignePlacement) obj;
		return Objects.equals(PULignePlacement, other.PULignePlacement) && Objects.equals(article, other.article)
				&& Objects.equals(idLignePlacement, other.idLignePlacement)
				&& Objects.equals(placement, other.placement)
				&& Objects.equals(quantiteLignePlacement, other.quantiteLignePlacement);
	}

	@Override
	public String toString() {
		return "LignePlacement [idLignePlacement=" + idLignePlacement + ", quantiteLignePlacement="
				+ quantiteLignePlacement + ", PULignePlacement=" + PULignePlacement + ", placement=" + placement
				+ ", article=" + article + "]";
	}

}
