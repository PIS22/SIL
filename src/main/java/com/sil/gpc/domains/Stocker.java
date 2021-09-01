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
public class Stocker implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idStocker;
	private Long quantiterStocker;
	private Long stockDeSecuriter;
	private Long stockMinimal;
	private Long cmup;

	//Liaison à l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle",referencedColumnName = "codeArticle",nullable = false)
	private Article article;

	//Liaison à l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Magasin.class)
	@JoinColumn(name = "codeMagasin",referencedColumnName = "codeMagasin",nullable = false)
	private Magasin magasin;
	
	public Stocker() {
		super();
	}

	public Stocker(Long idStocker, Long quantiterStocker, Long stockDeSecuriter, Long stockMinimal, Long cmup,
			Article article, Magasin magasin) {
		super();
		this.idStocker = idStocker;
		this.quantiterStocker = quantiterStocker;
		this.stockDeSecuriter = stockDeSecuriter;
		this.stockMinimal = stockMinimal;
		this.cmup = cmup;
		this.article = article;
		this.magasin = magasin;
	}
	
	/**
	 * @return the numRecollement
	 */
	public Long getIdStocker() {
		return idStocker;
	}

	/**
	 * @param
	 */
	public void setIdStocker(Long idStocker) {
		this.idStocker = idStocker;
	}
	
	
	/**
	 * @return 
	 */
	public Long getStockDeSecuriter() {
		return stockDeSecuriter;
	}

	/**
	 * @param 
	 */
	public void setStockDeSecuriter(Long stockDeSecuriter) {
		this.stockDeSecuriter = stockDeSecuriter;
	}
	
	/**
	 * @return 
	 */
	public Long getCmup() {
		return cmup;
	}

	/**
	 * @param 
	 */
	public void setCmup(Long cmup) {
		this.cmup = cmup;
	}
	
	/**
	 * @return 
	 */
	public Long getStockMinimal() {
		return stockMinimal;
	}

	/**
	 * @param 
	 */
	public void setstockMinimal(Long stockMinimal) {
		this.stockMinimal = stockDeSecuriter;
	}
	
	/**
	 * @return 
	 */
	public Long getQuantiterStocker() {
		return quantiterStocker;
	}

	/**
	 * @param 
	 */
	public void setQuantiterStocker(Long quantiterStocker) {
		this.quantiterStocker = quantiterStocker;
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
	
	//
	public Article getArticle() {
		return article;
	}
	
	//
	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(article, cmup, idStocker, magasin, quantiterStocker, stockDeSecuriter, stockMinimal);
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
		Stocker other = (Stocker) obj;
		return Objects.equals(article, other.article) && Objects.equals(cmup, other.cmup)
				&& Objects.equals(idStocker, other.idStocker) && Objects.equals(magasin, other.magasin)
				&& Objects.equals(quantiterStocker, other.quantiterStocker)
				&& Objects.equals(stockDeSecuriter, other.stockDeSecuriter)
				&& Objects.equals(stockMinimal, other.stockMinimal);
	}

	@Override
	public String toString() {
		return "Stocker [idStocker=" + idStocker + ", quantiterStocker=" + quantiterStocker + ", stockDeSecuriter="
				+ stockDeSecuriter + ", stockMinimal=" + stockMinimal + ", cmup=" + cmup + ", article=" + article
				+ ", magasin=" + magasin + "]";
	}

}
