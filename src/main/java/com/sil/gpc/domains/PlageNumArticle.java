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
public class PlageNumArticle implements Serializable {

	@Id
	@GeneratedValue
	private Long idPlage;
	private String numDebPlage;
	private String numFinPlage;

	@ManyToOne(cascade = CascadeType.DETACH,targetEntity = Article.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "codeArticle",referencedColumnName = "codeArticle",nullable = false)
	public Article article;
	
	//private String numRecollement;//*****************************Liaison à effectuer
	//Liaison à la table "Recollement"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity =LigneRecollement.class)
	@JoinColumn(name = "idLigneRecollement", referencedColumnName = "idLigneRecollement", nullable = true)
	private LigneRecollement ligneRecollement;

	//private String numPlacement;//*****************************Liaison à effectuer
	//Liaison à la table "ligneplacement"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = LignePlacement.class)
	@JoinColumn(name = "idLignePlacement", referencedColumnName = "idLignePlacement", nullable = true)
	private LignePlacement lignePlacement;

	//private String numAppro;//*****************************Liaison à effectuer
	//Liaison à la table "Utilisateur"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = LigneAppro.class)
	@JoinColumn(name = "idLigneAppro", referencedColumnName = "idLigneAppro", nullable = true)
	private LigneAppro ligneAppro;

	
	public PlageNumArticle() {
		super();
	}

	public PlageNumArticle(Long idPlage, String numDebPlage, String numFinPlage) {
		super();
		this.idPlage = idPlage;
		this.numDebPlage = numDebPlage;
		this.numFinPlage = numFinPlage;
	}

	public Long getIdPlage() {
		return idPlage;
	}

	public void setIdPlage(Long idPlage) {
		this.idPlage = idPlage;
	}

	public String getNumDebPlage() {
		return numDebPlage;
	}

	public void setNumDebPlage(String numDebPlage) {
		this.numDebPlage = numDebPlage;
	}

	public String getNumFinPlage() {
		return numFinPlage;
	}

	public void setNumFinPlage(String numFinPlage) {
		this.numFinPlage = numFinPlage;
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
	 * @return the ligneRecollement
	 */
	public LigneRecollement getLigneRecollement() {
		return ligneRecollement;
	}

	/**
	 * @param ligneRecollement the ligneRecollement to set
	 */
	public void setLigneRecollement(LigneRecollement ligneRecollement) {
		this.ligneRecollement = ligneRecollement;
	}

	/**
	 * @return the lignePlacement
	 */
	public LignePlacement getLignePlacement() {
		return lignePlacement;
	}

	/**
	 * @param lignePlacement the lignePlacement to set
	 */
	public void setLignePlacement(LignePlacement lignePlacement) {
		this.lignePlacement = lignePlacement;
	}

	/**
	 * @return the ligneAppro
	 */
	public LigneAppro getLigneAppro() {
		return ligneAppro;
	}

	/**
	 * @param ligneAppro the ligneAppro to set
	 */
	public void setLigneAppro(LigneAppro ligneAppro) {
		this.ligneAppro = ligneAppro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPlage == null) ? 0 : idPlage.hashCode());
		result = prime * result + ((numDebPlage == null) ? 0 : numDebPlage.hashCode());
		result = prime * result + ((numFinPlage == null) ? 0 : numFinPlage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlageNumArticle other = (PlageNumArticle) obj;
		if (idPlage == null) {
			if (other.idPlage != null)
				return false;
		} else if (!idPlage.equals(other.idPlage))
			return false;
		if (numDebPlage == null) {
			if (other.numDebPlage != null)
				return false;
		} else if (!numDebPlage.equals(other.numDebPlage))
			return false;
		if (numFinPlage == null) {
			if (other.numFinPlage != null)
				return false;
		} else if (!numFinPlage.equals(other.numFinPlage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlageNumArticle [idPlage=" + idPlage + ", numDebPlage=" + numDebPlage + ", numFinPlage=" + numFinPlage
				+ "]";
	}
	
}
