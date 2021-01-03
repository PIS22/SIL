package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class PlageNumDispo implements Serializable {

	@Id
	private String codePlageDispo; 
	private String numDebPlage; //Le premier numéro réceptionné dans l'année
	private String numDebPlageDispo; //le premier numero disponible
	private String numFinPlage;//Le dernier numéro réceptionné dans l'année
	private String numFinPlageDispo; //Le dernier numéro réceptionné dans l'année
	private int annee;

	@ManyToOne(cascade = CascadeType.DETACH,targetEntity = Article.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "codeArticle",referencedColumnName = "codeArticle",nullable = false)
	public Article article;
		
	public PlageNumDispo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlageNumDispo(String codePlageDispo, String numDebPlage, String numDebPlageDispo, String numFinPlage,
			String numFinPlageDispo, int exercice, Article article) {
		super();
		this.codePlageDispo = codePlageDispo;
		this.numDebPlage = numDebPlage;
		this.numDebPlageDispo = numDebPlageDispo;
		this.numFinPlage = numFinPlage;
		this.numFinPlageDispo = numFinPlageDispo;
		this.annee = exercice;
		this.article = article;
	}

	/**
	 * @return the codePlageDispo
	 */
	public String getCodePlageDispo() {
		return codePlageDispo;
	}

	/**
	 * @param codePlageDispo the codePlageDispo to set
	 */
	public void setCodePlageDispo(String codePlageDispo) {
		this.codePlageDispo = codePlageDispo;
	}

	/**
	 * @return the numDebPlage
	 */
	public String getNumDebPlage() {
		return numDebPlage;
	}

	/**
	 * @param numDebPlage the numDebPlage to set
	 */
	public void setNumDebPlage(String numDebPlage) {
		this.numDebPlage = numDebPlage;
	}

	/**
	 * @return the numDebPlageDispo
	 */
	public String getNumDebPlageDispo() {
		return numDebPlageDispo;
	}

	/**
	 * @param numDebPlageDispo the numDebPlageDispo to set
	 */
	public void setNumDebPlageDispo(String numDebPlageDispo) {
		this.numDebPlageDispo = numDebPlageDispo;
	}

	/**
	 * @return the numFinPlage
	 */
	public String getNumFinPlage() {
		return numFinPlage;
	}

	/**
	 * @param numFinPlage the numFinPlage to set
	 */
	public void setNumFinPlage(String numFinPlage) {
		this.numFinPlage = numFinPlage;
	}

	/**
	 * @return the numFinPlageDispo
	 */
	public String getNumFinPlageDispo() {
		return numFinPlageDispo;
	}

	/**
	 * @param numFinPlageDispo the numFinPlageDispo to set
	 */
	public void setNumFinPlageDispo(String numFinPlageDispo) {
		this.numFinPlageDispo = numFinPlageDispo;
	}

	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
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
		return Objects.hash(annee, article, codePlageDispo, numDebPlage, numDebPlageDispo, numFinPlage,
				numFinPlageDispo);
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
		PlageNumDispo other = (PlageNumDispo) obj;
		return annee == other.annee && Objects.equals(article, other.article)
				&& Objects.equals(codePlageDispo, other.codePlageDispo)
				&& Objects.equals(numDebPlage, other.numDebPlage)
				&& Objects.equals(numDebPlageDispo, other.numDebPlageDispo)
				&& Objects.equals(numFinPlage, other.numFinPlage)
				&& Objects.equals(numFinPlageDispo, other.numFinPlageDispo);
	}

}
