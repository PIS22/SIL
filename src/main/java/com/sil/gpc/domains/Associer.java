package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Associer {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idComArt;
	private Date debComArt;
	private Date finComArt;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Article.class)
	@JoinColumn(name = "article", nullable = false, referencedColumnName = "codeArticle")
	private Article article;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Compte.class)
	@JoinColumn(name = "compte", nullable = false, referencedColumnName = "idCpte")
	private Compte compte;
	
	public Associer() {
		// TODO Auto-generated constructor stub
	}

	public Associer(Long idComArt, Date debComArt, Date finComArt, Article article, Compte compte) {
		super();
		this.idComArt = idComArt;
		this.debComArt = debComArt;
		this.finComArt = finComArt;
		this.article = article;
		this.compte = compte;
	}

	public Long getIdComArt() {
		return idComArt;
	}

	public void setIdComArt(Long idComArt) {
		this.idComArt = idComArt;
	}

	public Date getDebComArt() {
		return debComArt;
	}

	public void setDebComArt(Date debComArt) {
		this.debComArt = debComArt;
	}

	public Date getFinComArt() {
		return finComArt;
	}

	public void setFinComArt(Date finComArt) {
		this.finComArt = finComArt;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Associer [idComArt=" + idComArt + ", debComArt=" + debComArt + ", finComArt=" + finComArt + ", article="
				+ article + ", compte=" + compte + "]";
	}
	
	

}
