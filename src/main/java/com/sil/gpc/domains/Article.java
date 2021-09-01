package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity

public class Article implements Serializable {

	@Id
	private String codeArticle;
	private String libArticle;
	private boolean stockerArticle;
	private boolean numSerieArticle;
	private boolean livrableArticle;
	private boolean consommableArticle;
	private Long prixVenteArticle;
	private String couleurArticle;
	private double qteStIniTres;;
	private double puStIniTres;
	private Date datStInitArtTres;

	//Migration de la clé de l'exercice
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "ExoStInit", referencedColumnName = "codeExercice",nullable = true)
	public Exercice exo;
		
	//Migration du code de la famille vers l'article
	@ManyToOne(targetEntity = Famille.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "famille",referencedColumnName = "codeFamille")
	private Famille famille;

	//Migration de la clé de l'unité vers l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Uniter.class)
	@JoinColumn(name = "unite", referencedColumnName = "codeUniter",nullable = false)
	public Uniter unite;
	
	public Article() {
		super();
	}

	public Article(String codeArticle, String libArticle, boolean stockerArticle, boolean numSerieArticle,
			boolean livrableArticle, boolean consommableArticle, Long prixVenteArticle, String couleurArticle,
			Famille famille, Uniter uniter) {
		super();
		this.codeArticle = codeArticle;
		this.libArticle = libArticle;
		this.stockerArticle = stockerArticle;
		this.numSerieArticle = numSerieArticle;
		this.livrableArticle = livrableArticle;
		this.consommableArticle = consommableArticle;
		this.prixVenteArticle = prixVenteArticle;
		this.couleurArticle = couleurArticle;
		this.famille = famille;
		this.unite = uniter;
		this.qteStIniTres =0;
		this.puStIniTres = 0;
		this.datStInitArtTres = null;
		this.exo = null;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getLibArticle() {
		return libArticle;
	}

	public void setLibArticle(String libArticle) {
		this.libArticle = libArticle;
	}

	public boolean isStockerArticle() {
		return stockerArticle;
	}

	public void setStockerArticle(boolean stockerArticle) {
		this.stockerArticle = stockerArticle;
	}

	public boolean isNumSerieArticle() {
		return numSerieArticle;
	}

	public void setNumSerieArticle(boolean numSerieArticle) {
		this.numSerieArticle = numSerieArticle;
	}

	public boolean isLivrableArticle() {
		return livrableArticle;
	}

	public void setLivrableArticle(boolean livrableArticle) {
		this.livrableArticle = livrableArticle;
	}

	public boolean isConsommableArticle() {
		return consommableArticle;
	}

	public void setConsommableArticle(boolean consommableArticle) {
		this.consommableArticle = consommableArticle;
	}

	public Long getPrixVenteArticle() {
		return prixVenteArticle;
	}

	public void setPrixVenteArticle(Long prixVenteArticle) {
		this.prixVenteArticle = prixVenteArticle;
	}

	public String getCouleurArticle() {
		return couleurArticle;
	}

	public void setCouleurArticle(String couleurArticle) {
		this.couleurArticle = couleurArticle;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public Uniter getUnite() {
		return unite;
	}

	public void setUnite(Uniter unite) {
		this.unite = unite;
	}

	/**
	 * @return the qteStIniTres
	 */
	public double getQteStIniTres() {
		return qteStIniTres;
	}

	/**
	 * @param qteStIniTres the qteStIniTres to set
	 */
	public void setQteStIniTres(double qteStIniTres) {
		this.qteStIniTres = qteStIniTres;
	}

	/**
	 * @return the puStIniTres
	 */
	public double getPuStIniTres() {
		return puStIniTres;
	}

	/**
	 * @param puStIniTres the puStIniTres to set
	 */
	public void setPuStIniTres(double puStIniTres) {
		this.puStIniTres = puStIniTres;
	}

	/**
	 * @return the datStInitArtTres
	 */
	public Date getDatStInitArtTres() {
		return datStInitArtTres;
	}

	/**
	 * @param datStInitArtTres the datStInitArtTres to set
	 */
	public void setDatStInitArtTres(Date datStInitArtTres) {
		this.datStInitArtTres = datStInitArtTres;
	}

	/**
	 * @return the exo
	 */
	public Exercice getExo() {
		return exo;
	}

	/**
	 * @param exo the exo to set
	 */
	public void setExo(Exercice exo) {
		this.exo = exo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeArticle, consommableArticle, couleurArticle, famille, libArticle, livrableArticle,
				numSerieArticle, prixVenteArticle, stockerArticle, unite);
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
		Article other = (Article) obj;
		return Objects.equals(codeArticle, other.codeArticle) && consommableArticle == other.consommableArticle
				&& Objects.equals(couleurArticle, other.couleurArticle) && Objects.equals(famille, other.famille)
				&& Objects.equals(libArticle, other.libArticle) && livrableArticle == other.livrableArticle
				&& numSerieArticle == other.numSerieArticle && Objects.equals(prixVenteArticle, other.prixVenteArticle)
				&& stockerArticle == other.stockerArticle && Objects.equals(unite, other.unite);
	}

	@Override
	public String toString() {
		return "Article [codeArticle=" + codeArticle + ", libArticle=" + libArticle + ", stockerArticle="
				+ stockerArticle + ", numSerieArticle=" + numSerieArticle + ", livrableArticle=" + livrableArticle
				+ ", consommableArticle=" + consommableArticle + ", prixVenteArticle=" + prixVenteArticle
				+ ", couleurArticle=" + couleurArticle + ", famille=" + famille + ", unite=" + unite + "]";
	}
	 
}
