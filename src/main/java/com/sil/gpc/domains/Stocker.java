package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
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
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle",referencedColumnName = "codeArticle",nullable = false)
	private Article article;

	//Liaison à l'article
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Magasin.class)
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
