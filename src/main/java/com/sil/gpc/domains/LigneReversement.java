package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class LigneReversement implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneReversement;
	//private String codeArticle;
	//private String numReversement;
	private Long quantiteLigneReversement;
	private Long PULigneReversement;
	private String quittanceReversement;
	private Date dateQuittanceReversement;
	private String beneficiaire;
	private String observation;

	//Liaison à la table Reversement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Reversement.class)
	@JoinColumn(name = "numReversement", nullable = false, referencedColumnName = "numReversement")
	public Reversement numReversement;

	//Liaison à la table Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", nullable = false, referencedColumnName = "codeArticle")
	public Article article;

	public LigneReversement() {
		super();
	}

	public LigneReversement(Long quantiteLigneReversement, Long pULigneReversement, Date dateQuittanceReversement,
			String quittanceReversement,String beneficiaire, String observation, Reversement numReversement, Article article) {
		super();
		this.quantiteLigneReversement = quantiteLigneReversement;
		PULigneReversement = pULigneReversement;
		this.dateQuittanceReversement = dateQuittanceReversement;
		this.quittanceReversement=quittanceReversement;
		this.beneficiaire = beneficiaire;
		this.observation = observation;
		this.numReversement = numReversement;
		this.article = article;
	}
	

	/**
	 * @return the idLigneReversement
	 */
	public Long getIdLigneReversement() {
		return idLigneReversement;
	}

	/**
	 * @param idLigneReversement the idLigneReversement to set
	 */
	public void setIdLigneReversement(Long idLigneReversement) {
		this.idLigneReversement = idLigneReversement;
	}

	/**
	 * @return the quantiteLigneReversement
	 */
	public Long getQuantiteLigneReversement() {
		return quantiteLigneReversement;
	}

	/**
	 * @param quantiteLigneReversement the quantiteLigneReversement to set
	 */
	public void setQuantiteLigneReversement(Long quantiteLigneReversement) {
		this.quantiteLigneReversement = quantiteLigneReversement;
	}

	/**
	 * @return the pULigneReversement
	 */
	public Long getPULigneReversement() {
		return PULigneReversement;
	}

	/**
	 * @param pULigneReversement the pULigneReversement to set
	 */
	public void setPULigneReversement(Long pULigneReversement) {
		PULigneReversement = pULigneReversement;
	}

	/**
	 * @return the dateQuittanceReversement
	 */
	public Date getDateQuittanceReversement() {
		return dateQuittanceReversement;
	}

	/**
	 * @param dateQuittanceReversement the dateQuittanceReversement to set
	 */
	public void setDateQuittanceReversement(Date dateQuittanceReversement) {
		this.dateQuittanceReversement = dateQuittanceReversement;
	}

	/**
	 * @return the quittanceReversement
	 */
	public String getQuittanceReversement() {
		return quittanceReversement;
	}

	/**
	 * @param quittanceReversement the quittanceReversement to set
	 */
	public void setQuittanceReversement(String quittanceReversement) {
		this.quittanceReversement = quittanceReversement;
	}

	/**
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	/**
	 * @return the observation
	 */
	public String getObservation() {
		return observation;
	}

	/**
	 * @param observation the observation to set
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}

	/**
	 * @return the numReversement
	 */
	public Reversement getNumReversement() {
		return numReversement;
	}

	/**
	 * @param numReversement the numReversement to set
	 */
	public void setNumReversement(Reversement numReversement) {
		this.numReversement = numReversement;
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
	public String toString() {
		return "LigneReversementService [idLigneReversement=" + idLigneReversement + ", quantiteLigneReversement="
				+ quantiteLigneReversement + ", PULigneReversement=" + PULigneReversement
				+ ", dateQuittanceReversement=" + dateQuittanceReversement + ", beneficiaire=" + beneficiaire
				+ ", observation=" + observation + ", numReversement=" + numReversement + ", article=" + article
				+ "]";
	}

}
