package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class LignePointVente implements Serializable{

	@Id
	@GeneratedValue
	private Long idLignePointVente;
	private double quantiteLignePointVente;
	private double PULignePointVente;
	private int numDebLignePointVente;
	private int numFinLignePointVente;
	
	//Liaison avec Point vente
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity = PointVente.class)
	@JoinColumn(name = "numPointVente", referencedColumnName = "numPointVente")
	PointVente pointVente;
	
	//Liaison avec Article
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity =Article.class)
	@JoinColumn(name = "codeArticle", referencedColumnName = "codeArticle")
	Article article;

	public LignePointVente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LignePointVente(Long idLignePointVente, double quantiteLignePointVente, double pULignePointVente,
			int numDebLignePointVente, int numFinLignePointVente, PointVente pontVente, Article article) {
		super();
		this.idLignePointVente = idLignePointVente;
		this.quantiteLignePointVente = quantiteLignePointVente;
		PULignePointVente = pULignePointVente;
		this.numDebLignePointVente = numDebLignePointVente;
		this.numFinLignePointVente = numFinLignePointVente;
		this.pointVente = pontVente;
		this.article = article;
	}

	/**
	 * @return the quantiteLignePointVente
	 */
	public double getQuantiteLignePointVente() {
		return quantiteLignePointVente;
	}

	/**
	 * @param quantiteLignePointVente the quantiteLignePointVente to set
	 */
	public void setQuantiteLignePointVente(double quantiteLignePointVente) {
		this.quantiteLignePointVente = quantiteLignePointVente;
	}

	/**
	 * @return the pULignePointVente
	 */
	public double getPULignePointVente() {
		return PULignePointVente;
	}

	/**
	 * @param pULignePointVente the pULignePointVente to set
	 */
	public void setPULignePointVente(double pULignePointVente) {
		PULignePointVente = pULignePointVente;
	}

	/**
	 * @return the numDebLignePointVente
	 */
	public int getNumDebLignePointVente() {
		return numDebLignePointVente;
	}

	/**
	 * @param numDebLignePointVente the numDebLignePointVente to set
	 */
	public void setNumDebLignePointVente(int numDebLignePointVente) {
		this.numDebLignePointVente = numDebLignePointVente;
	}

	/**
	 * @return the numFinLignePointVente
	 */
	public int getNumFinLignePointVente() {
		return numFinLignePointVente;
	}

	/**
	 * @param numFinLignePointVente the numFinLignePointVente to set
	 */
	public void setNumFinLignePointVente(int numFinLignePointVente) {
		this.numFinLignePointVente = numFinLignePointVente;
	}

	/**
	 * @return the pontVente
	 */
	public PointVente getPontVente() {
		return pointVente;
	}

	/**
	 * @param pontVente the pontVente to set
	 */
	public void setPontVente(PointVente pointVente) {
		this.pointVente = pointVente;
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
	
}
