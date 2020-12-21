package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class LigneAppro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long idLigneAppro;
	private Long quantiteLigneAppro;
	private Long PULigneAppro;
	
	//Liaison avec Article
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", referencedColumnName = "codeArticle",nullable = false)
	public Article article;

	//Liaison avec Approvisionnement
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Approvisionnement.class)
	@JoinColumn(name = "numAppro", referencedColumnName = "numAppro",nullable = false)
	public Approvisionnement appro;

	//Liaison avec LigneDemmandeAppro
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = LigneDemandeAppro.class)
	@JoinColumn(name = "numidDA", referencedColumnName = "idLigneDA",nullable = false)
	public LigneDemandeAppro ligneDA;
	
	public LigneAppro() {
		super();
	}

	public LigneAppro(Long idLigneAppro, Long quantiteLigneAppro, Long pULigneAppro, Article article,
			Approvisionnement appro) {
		super();
		this.idLigneAppro = idLigneAppro;
		this.quantiteLigneAppro = quantiteLigneAppro;
		PULigneAppro = pULigneAppro;
		this.article = article;
		this.appro = appro;
	}

	public Long getIdLigneAppro() {
		return idLigneAppro;
	}

	public void setIdLigneAppro(Long idLigneAppro) {
		this.idLigneAppro = idLigneAppro;
	}

	public Long getQuantiteLigneAppro() {
		return quantiteLigneAppro;
	}

	public void setQuantiteLigneAppro(Long quantiteLigneAppro) {
		this.quantiteLigneAppro = quantiteLigneAppro;
	}

	public Long getPULigneAppro() {
		return PULigneAppro;
	}

	public void setPULigneAppro(Long pULigneAppro) {
		PULigneAppro = pULigneAppro;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Approvisionnement getAppro() {
		return appro;
	}

	public void setAppro(Approvisionnement appro) {
		this.appro = appro;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
