package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class LigneDemandeAppro implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneDA;
	private Long quantiteDemandee;

	
	//Liaison avec Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", referencedColumnName = "codeArticle",nullable = false)
	public Article article;

	//Liaison avec Demande Appro Approvisionnement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = DemandeApprovisionnement.class)
	@JoinColumn(name = "numDA", referencedColumnName = "numDA",nullable = false)
	public DemandeApprovisionnement appro;
	
	public LigneDemandeAppro() {
		super();
	}

	public LigneDemandeAppro(Long idLigneDA, Long quantiteDemandee, Article article, DemandeApprovisionnement appro,
			List<LigneAppro> ligneApproParDA) {
		super();
		this.idLigneDA = idLigneDA;
		this.quantiteDemandee = quantiteDemandee;
		this.article = article;
		this.appro = appro;
	}

	/**
	 * @return the idLigneDA
	 */
	public Long getIdLigneDA() {
		return idLigneDA;
	}

	/**
	 * @param idLigneDA the idLigneDA to set
	 */
	public void setIdLigneDA(Long idLigneDA) {
		this.idLigneDA = idLigneDA;
	}

	/**
	 * @return the quantiteDemandee
	 */
	public Long getQuantiteDemandee() {
		return quantiteDemandee;
	}

	/**
	 * @param quantiteDemandee the quantiteDemandee to set
	 */
	public void setQuantiteDemandee(Long quantiteDemandee) {
		this.quantiteDemandee = quantiteDemandee;
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
	 * @return the appro
	 */
	public DemandeApprovisionnement getAppro() {
		return appro;
	}

	/**
	 * @param appro the appro to set
	 */
	public void setAppro(DemandeApprovisionnement appro) {
		this.appro = appro;
	}

	@Override
	public String toString() {
		return "LigneDemandeAppro [idLigneDA=" + idLigneDA + ", quantiteDemandee=" + quantiteDemandee + ", article="
				+ article + ", appro=" + appro + "]";
	}

}
