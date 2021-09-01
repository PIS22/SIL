package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneIncineration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneIncine;
	private Long quantiteLigneIncine;
	private Long PULigneIncine;
	private String obsLigneIncine;
	
	//Liaison à la table Incinération
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Incineration.class)
	@JoinColumn(name = "numIncine", nullable = false, referencedColumnName = "numIncine")
	public Incineration incineration;

	//Liaison à la table Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", nullable = false, referencedColumnName = "codeArticle")
	public Article article;

	/**
	 * 
	 */
	public LigneIncineration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param quantiteLigneIncine
	 * @param pULigneIncine
	 * @param obsLigneIncine
	 * @param incineration
	 * @param article
	 */
	public LigneIncineration(Long quantiteLigneIncine, Long pULigneIncine, String obsLigneIncine,
			Incineration incineration, Article article) {
		this.quantiteLigneIncine = quantiteLigneIncine;
		PULigneIncine = pULigneIncine;
		this.obsLigneIncine = obsLigneIncine;
		this.incineration = incineration;
		this.article = article;
	}

	/**
	 * @return the quantiteLigneIncine
	 */
	public Long getQuantiteLigneIncine() {
		return quantiteLigneIncine;
	}

	/**
	 * @param quantiteLigneIncine the quantiteLigneIncine to set
	 */
	public void setQuantiteLigneIncine(Long quantiteLigneIncine) {
		this.quantiteLigneIncine = quantiteLigneIncine;
	}

	/**
	 * @return the pULigneIncine
	 */
	public Long getPULigneIncine() {
		return PULigneIncine;
	}

	/**
	 * @param pULigneIncine the pULigneIncine to set
	 */
	public void setPULigneIncine(Long pULigneIncine) {
		PULigneIncine = pULigneIncine;
	}

	/**
	 * @return the obsLigneIncine
	 */
	public String getObsLigneIncine() {
		return obsLigneIncine;
	}

	/**
	 * @param obsLigneIncine the obsLigneIncine to set
	 */
	public void setObsLigneIncine(String obsLigneIncine) {
		this.obsLigneIncine = obsLigneIncine;
	}

	/**
	 * @return the incineration
	 */
	public Incineration getIncineration() {
		return incineration;
	}

	/**
	 * @param incineration the incineration to set
	 */
	public void setIncineration(Incineration incineration) {
		this.incineration = incineration;
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

	/**
	 * @return the idLigneIncine
	 */
	public Long getIdLigneIncine() {
		return idLigneIncine;
	}

	@Override
	public String toString() {
		return "LigneIncinération [idLigneIncine=" + idLigneIncine + ", quantiteLigneIncine=" + quantiteLigneIncine
				+ ", PULigneIncine=" + PULigneIncine + ", obsLigneIncine=" + obsLigneIncine + ", incineration="
				+ incineration + ", article=" + article + "]";
	}
	
	

}
