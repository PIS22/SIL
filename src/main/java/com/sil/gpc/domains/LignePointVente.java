package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class LignePointVente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLignePointVente;
	private double quantiteLignePointVente;
	private double PULignePointVente;
	@Column(nullable = true)
	private int numDebLignePointVente;
	@Column(nullable = true)
	private int numFinLignePointVente;
	
	//Liaison avec Point vente
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = PointVente.class)
	@JoinColumn(name = "numPointVente", referencedColumnName = "numPointVente")
	PointVente pointVente;
	
	//Liaison avec Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity =Article.class)
	@JoinColumn(name = "codeArticle", referencedColumnName = "codeArticle")
	Article article;

	public LignePointVente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param quantiteLignePointVente
	 * @param pULignePointVente
	 * @param numDebLignePointVente
	 * @param numFinLignePointVente
	 * @param pointVente
	 * @param article
	 */
	public LignePointVente(double quantiteLignePointVente, double pULignePointVente, int numDebLignePointVente,
			int numFinLignePointVente, PointVente pointVente, Article article) {
		this.quantiteLignePointVente = quantiteLignePointVente;
		PULignePointVente = pULignePointVente;
		this.numDebLignePointVente = numDebLignePointVente;
		this.numFinLignePointVente = numFinLignePointVente;
		this.pointVente = pointVente;
		this.article = article;
	}

	/**
	 * @return the idLignePointVente
	 */
	public Long getIdLignePointVente() {
		return idLignePointVente;
	}

	/**
	 * @param idLignePointVente the idLignePointVente to set
	 */
	public void setIdLignePointVente(Long idLignePointVente) {
		this.idLignePointVente = idLignePointVente;
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
	 * @return the pointVente
	 */
	public PointVente getPointVente() {
		return pointVente;
	}

	/**
	 * @param pointVente the pointVente to set
	 */
	public void setPointVente(PointVente pointVente) {
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

	@Override
	public int hashCode() {
		return Objects.hash(PULignePointVente, article, idLignePointVente, numDebLignePointVente, numFinLignePointVente,
				pointVente, quantiteLignePointVente);
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
		LignePointVente other = (LignePointVente) obj;
		return Double.doubleToLongBits(PULignePointVente) == Double.doubleToLongBits(other.PULignePointVente)
				&& Objects.equals(article, other.article) && Objects.equals(idLignePointVente, other.idLignePointVente)
				&& numDebLignePointVente == other.numDebLignePointVente
				&& numFinLignePointVente == other.numFinLignePointVente && Objects.equals(pointVente, other.pointVente)
				&& Double.doubleToLongBits(quantiteLignePointVente) == Double
						.doubleToLongBits(other.quantiteLignePointVente);
	}

	/**
	 * @param idLignePointVente
	 * @param quantiteLignePointVente
	 * @param pULignePointVente
	 * @param numDebLignePointVente
	 * @param numFinLignePointVente
	 * @param pointVente
	 * @param article
	 */
	public LignePointVente(Long idLignePointVente, double quantiteLignePointVente, double pULignePointVente,
			int numDebLignePointVente, int numFinLignePointVente, PointVente pointVente, Article article) {
		this.idLignePointVente = idLignePointVente;
		this.quantiteLignePointVente = quantiteLignePointVente;
		PULignePointVente = pULignePointVente;
		this.numDebLignePointVente = numDebLignePointVente;
		this.numFinLignePointVente = numFinLignePointVente;
		this.pointVente = pointVente;
		this.article = article;
	}

}
