package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class PlageNumArticle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlage;
	private Long numDebPlage;
	private Long numFinPlage;
	/*
	 * @ManyToOne(targetEntity = Article.class,fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "codeArticle",referencedColumnName =
	 * "codeArticle",nullable = false) public Article article;
	 */
	// private String numRecollement;//*****************************Liaison à
	// effectuer
	// Liaison à la table "Recollement"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = LigneRecollement.class)
	@JoinColumn(name = "idLigneRecollement", referencedColumnName = "idLigneRecollement", nullable = true)
	private LigneRecollement ligneRecollement;

	// private String numPlacement;//*****************************Liaison à
	// effectuer
	// Liaison à la table "ligneplacement"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = LignePlacement.class)
	@JoinColumn(name = "idLignePlacement", referencedColumnName = "idLignePlacement", nullable = true)
	private LignePlacement lignePlacement;

	// private String numAppro;//*****************************Liaison à effectuer
	// Liaison à la table "Utilisateur"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = LigneAppro.class)
	@JoinColumn(name = "idLigneAppro", referencedColumnName = "idLigneAppro", nullable = true)
	private LigneAppro ligneAppro;

	public PlageNumArticle() {
		super();
	}

	/**
	 * @param numDebPlage
	 * @param numFinPlage
	 * @param ligneRecollement
	 * @param lignePlacement
	 * @param ligneAppro
	 */
	public PlageNumArticle(Long numDebPlage, Long numFinPlage, LigneRecollement ligneRecollement,
			LignePlacement lignePlacement, LigneAppro ligneAppro) {
		this.numDebPlage = numDebPlage;
		this.numFinPlage = numFinPlage;
		this.ligneRecollement = ligneRecollement;
		this.lignePlacement = lignePlacement;
		this.ligneAppro = ligneAppro;
	}

	/**
	 * @return the idPlage
	 */
	public Long getIdPlage() {
		return idPlage;
	}

	/**
	 * @param idPlage the idPlage to set
	 */
	public void setIdPlage(Long idPlage) {
		this.idPlage = idPlage;
	}

	/**
	 * @return the numDebPlage
	 */
	public Long getNumDebPlage() {
		return numDebPlage;
	}

	/**
	 * @param numDebPlage the numDebPlage to set
	 */
	public void setNumDebPlage(Long numDebPlage) {
		this.numDebPlage = numDebPlage;
	}

	/**
	 * @return the numFinPlage
	 */
	public Long getNumFinPlage() {
		return numFinPlage;
	}

	/**
	 * @param numFinPlage the numFinPlage to set
	 */
	public void setNumFinPlage(Long numFinPlage) {
		this.numFinPlage = numFinPlage;
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
	public String toString() {
		return "PlageNumArticle [idPlage=" + idPlage + ", numDebPlage=" + numDebPlage + ", numFinPlage=" + numFinPlage
				+ ", ligneRecollement=" + ligneRecollement + ", lignePlacement=" + lignePlacement + ", ligneAppro="
				+ ligneAppro + "]";
	}

}
