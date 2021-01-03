package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class LigneDemandeAppro implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneDA;
	private Long quantiteDemandee;

	
	//Liaison avec Article
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", referencedColumnName = "codeArticle",nullable = false)
	public Article article;

	//Liaison avec Approvisionnement
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = DemandeApprovisionnement.class)
	@JoinColumn(name = "numDA", referencedColumnName = "numDA",nullable = false)
	public DemandeApprovisionnement appro;

	//Liaison avec LigneAppro
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = LigneAppro.class,mappedBy = "ligneDA")
	public List<LigneAppro> ligneDA;
	
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
	public int hashCode() {
		return Objects.hash(appro, article, idLigneDA, ligneDA, quantiteDemandee);
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
		LigneDemandeAppro other = (LigneDemandeAppro) obj;
		return Objects.equals(appro, other.appro) && Objects.equals(article, other.article)
				&& Objects.equals(idLigneDA, other.idLigneDA) && Objects.equals(ligneDA, other.ligneDA)
				&& Objects.equals(quantiteDemandee, other.quantiteDemandee);
	}

	/**
	 * @return the ligneApproParDA
	 */
	//public List<LigneAppro> getLigneApproParDA() {
//		return ligneApproParDA;
//	}

	/**
	 * @param ligneApproParDA the ligneApproParDA to set
	 */
	//public void setLigneApproParDA(List<LigneAppro> ligneApproParDA) {
//		this.ligneApproParDA = ligneApproParDA;
//	}



}
