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
public class PlageNumDispo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codePlageDispo;
	private Long numDebPlage; // Le premier numéro réceptionné dans l'année
	private Long numDebPlageDispo; // le premier numero disponible
	private Long numFinPlage;// Le dernier numéro réceptionné dans l'année
	private Long numFinPlageDispo; // Le dernier numéro réceptionné dans l'année

	@ManyToOne(targetEntity = Exercice.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	public Exercice exercice;

	@ManyToOne(targetEntity = Article.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeArticle", referencedColumnName = "codeArticle", nullable = false)
	public Article article;

	@ManyToOne(targetEntity = Magasin.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeMagasin", referencedColumnName = "codeMagasin", nullable = false)
	public Magasin magasin;

	@ManyToOne(targetEntity = Reception.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numReception", referencedColumnName = "numReception", nullable = true)
	public Reception Reception;

	@ManyToOne(targetEntity = Approvisionnement.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numAppro", referencedColumnName = "numAppro", nullable = true)
	public Approvisionnement appro;

	@ManyToOne(targetEntity = Recollement.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numRecollement", referencedColumnName = "numRecollement", nullable = true)
	public Recollement recollement;

	@ManyToOne(targetEntity = Placement.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numPlacement", referencedColumnName = "numPlacement", nullable = true)
	public Placement placement;

	public PlageNumDispo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlageNumDispo(Long numDebPlage, Long numDebPlageDispo, Long numFinPlage, Long numFinPlageDispo,
			Exercice exercice, Article article, Magasin magasin, com.sil.gpc.domains.Reception reception,
			Approvisionnement appro, Recollement recollement, Placement placement) {
		super();
		this.numDebPlage = numDebPlage;
		this.numDebPlageDispo = numDebPlageDispo;
		this.numFinPlage = numFinPlage;
		this.numFinPlageDispo = numFinPlageDispo;
		this.exercice = exercice;
		this.article = article;
		this.magasin = magasin;
		Reception = reception;
		this.appro = appro;
		this.recollement = recollement;
		this.placement = placement;
	}

	public Long getCodePlageDispo() {
		return codePlageDispo;
	}

	public void setCodePlageDispo(Long codePlageDispo) {
		this.codePlageDispo = codePlageDispo;
	}

	public Long getNumDebPlage() {
		return numDebPlage;
	}

	public void setNumDebPlage(Long numDebPlage) {
		this.numDebPlage = numDebPlage;
	}

	public Long getNumDebPlageDispo() {
		return numDebPlageDispo;
	}

	public void setNumDebPlageDispo(Long numDebPlageDispo) {
		this.numDebPlageDispo = numDebPlageDispo;
	}

	public Long getNumFinPlage() {
		return numFinPlage;
	}

	public void setNumFinPlage(Long numFinPlage) {
		this.numFinPlage = numFinPlage;
	}

	public Long getNumFinPlageDispo() {
		return numFinPlageDispo;
	}

	public void setNumFinPlageDispo(Long numFinPlageDispo) {
		this.numFinPlageDispo = numFinPlageDispo;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public Reception getReception() {
		return Reception;
	}

	public void setReception(Reception reception) {
		Reception = reception;
	}

	public Approvisionnement getAppro() {
		return appro;
	}

	public void setAppro(Approvisionnement appro) {
		this.appro = appro;
	}

	public Recollement getRecollement() {
		return recollement;
	}

	public void setRecollement(Recollement recollement) {
		this.recollement = recollement;
	}

	public Placement getPlacement() {
		return placement;
	}

	public void setPlacement(Placement placement) {
		this.placement = placement;
	}

	@Override
	public String toString() {
		return "PlageNumDispo [codePlageDispo=" + codePlageDispo + ", numDebPlage=" + numDebPlage
				+ ", numDebPlageDispo=" + numDebPlageDispo + ", numFinPlage=" + numFinPlage + ", numFinPlageDispo="
				+ numFinPlageDispo + ", exercice=" + exercice + ", article=" + article + ", magasin=" + magasin
				+ ", Reception=" + Reception + ", appro=" + appro + ", recollement=" + recollement + ", placement="
				+ placement + "]";
	}

}
