package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class LigneOpCaisse implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneOperCaisse;
	private Long qteLigneOperCaisse;
	private Long prixLigneOperCaisse;
	private String CommentaireLigneOperCaisse;
	private boolean livre;

	//Liaison à la table OpCaisse
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = OpCaisse.class)
	@JoinColumn(name = "numOpCaisse", nullable = false, referencedColumnName = "numOpCaisse")
	public OpCaisse opCaisse;

	//Liaison à la table Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", nullable = false, referencedColumnName = "codeArticle")
	public Article article;

	//Liaison à la table Magasin
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Magasin.class)
	@JoinColumn(name = "codeMagasin", nullable = true, referencedColumnName = "codeMagasin")
	public Magasin magasin;

	public LigneOpCaisse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneOpCaisse(Long qteLigneOperCaisse, Long prixLigneOperCaisse,
			String commentaireLigneOperCaisse, OpCaisse opCaisse, Article article) {
		this.qteLigneOperCaisse = qteLigneOperCaisse;
		this.prixLigneOperCaisse = prixLigneOperCaisse;
		CommentaireLigneOperCaisse = commentaireLigneOperCaisse;
		this.opCaisse = opCaisse;
		this.article = article;
		this.livre = false;
		this.magasin=null;
	}

	/**
	 * @return the idLigneOperCaisse
	 */
	public Long getIdLigneOperCaisse() {
		return idLigneOperCaisse;
	}

	/**
	 * @param idLigneOperCaisse the idLigneOperCaisse to set
	 */
	public void setIdLigneOperCaisse(Long idLigneOperCaisse) {
		this.idLigneOperCaisse = idLigneOperCaisse;
	}

	/**
	 * @return the qteLigneOperCaisse
	 */
	public Long getQteLigneOperCaisse() {
		return qteLigneOperCaisse;
	}

	/**
	 * @param qteLigneOperCaisse the qteLigneOperCaisse to set
	 */
	public void setQteLigneOperCaisse(Long qteLigneOperCaisse) {
		this.qteLigneOperCaisse = qteLigneOperCaisse;
	}

	/**
	 * @return the prixLigneOperCaisse
	 */
	public Long getPrixLigneOperCaisse() {
		return prixLigneOperCaisse;
	}

	/**
	 * @param prixLigneOperCaisse the prixLigneOperCaisse to set
	 */
	public void setPrixLigneOperCaisse(Long prixLigneOperCaisse) {
		this.prixLigneOperCaisse = prixLigneOperCaisse;
	}

	/**
	 * @return the commentaireLigneOperCaisse
	 */
	public String getCommentaireLigneOperCaisse() {
		return CommentaireLigneOperCaisse;
	}

	/**
	 * @return the livre
	 */
	public boolean isLivre() {
		return livre;
	}

	/**
	 * @param livre the livre to set
	 */
	public void setLivre(boolean livre) {
		this.livre = livre;
	}

	/**
	 * @param commentaireLigneOperCaisse the commentaireLigneOperCaisse to set
	 */
	public void setCommentaireLigneOperCaisse(String commentaireLigneOperCaisse) {
		CommentaireLigneOperCaisse = commentaireLigneOperCaisse;
	}

	/**
	 * @return the opCaisse
	 */
	public OpCaisse getOpCaisse() {
		return opCaisse;
	}

	/**
	 * @param opCaisse the opCaisse to set
	 */
	public void setOpCaisse(OpCaisse opCaisse) {
		this.opCaisse = opCaisse;
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
		return Objects.hash(CommentaireLigneOperCaisse, article, idLigneOperCaisse, opCaisse, prixLigneOperCaisse,
				qteLigneOperCaisse);
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
		LigneOpCaisse other = (LigneOpCaisse) obj;
		return Objects.equals(CommentaireLigneOperCaisse, other.CommentaireLigneOperCaisse)
				&& Objects.equals(article, other.article) && Objects.equals(idLigneOperCaisse, other.idLigneOperCaisse)
				&& Objects.equals(opCaisse, other.opCaisse)
				&& Objects.equals(prixLigneOperCaisse, other.prixLigneOperCaisse)
				&& Objects.equals(qteLigneOperCaisse, other.qteLigneOperCaisse);
	}

	@Override
	public String toString() {
		return "LigneOpCaisseRepository [idLigneOperCaisse=" + idLigneOperCaisse + ", qteLigneOperCaisse=" + qteLigneOperCaisse
				+ ", prixLigneOperCaisse=" + prixLigneOperCaisse + ", CommentaireLigneOperCaisse="
				+ CommentaireLigneOperCaisse + ", opCaisse=" + opCaisse + ", article=" + article + "]";
	}

}
