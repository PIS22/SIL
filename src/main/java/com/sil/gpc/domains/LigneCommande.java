package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;

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
public class LigneCommande implements Serializable{



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneCommande;
	private double qteLigneCommande;
	private double PULigneCommande;
	private double remise;
	private double TVA;

	//Liaison à la table Commande
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Commande.class)
	@JoinColumn(name = "numCommande", nullable = false, referencedColumnName = "numCommande")
	public Commande numCommande;

	//Liaison à la table Article
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", nullable = false, referencedColumnName = "codeArticle")
	public Article article;
	
	//Liaison à la LigneReception
	@OneToMany(cascade = CascadeType.ALL, targetEntity = LigneReception.class,fetch = FetchType.EAGER,mappedBy ="ligneCommande" )
	public List<LigneReception> lignReceptionParCommande;
	
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommande(Long idLigneCommande, double qteLigneCommande, double pULigneCommande, double remise,
			double tVA, Commande cmde, String codeArticle) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.qteLigneCommande = qteLigneCommande;
		PULigneCommande = pULigneCommande;
		this.remise = remise;
		TVA = tVA;
		this.numCommande = cmde;
	}

	public Long getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(Long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public double getQteLigneCommande() {
		return qteLigneCommande;
	}

	public void setQteLigneCommande(double qteLigneCommande) {
		this.qteLigneCommande = qteLigneCommande;
	}

	public double getPULigneCommande() {
		return PULigneCommande;
	}

	public void setPULigneCommande(double pULigneCommande) {
		PULigneCommande = pULigneCommande;
	}

	/**
	 * @return the remise
	 */
	public double getRemise() {
		return remise;
	}

	/**
	 * @param remise the remise to set
	 */
	public void setRemise(double remise) {
		this.remise = remise;
	}

	public double getTVA() {
		return TVA;
	}

	public void setTVA(double tVA) {
		TVA = tVA;
	}

	public Commande getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(Commande numCommande) {
		this.numCommande = numCommande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
