package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class LigneOpCaisse implements Serializable {
	
	@Id
	private Long idLigneOperCaisse;
	private Long qteLigneOperCaisse;
	private Long prixLigneOperCaisse;
	private String CommentaireLigneOperCaisse;

	//Liaison à la table OpCaisse
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = OpCaisse.class)
	@JoinColumn(name = "numOpCaisse", nullable = false, referencedColumnName = "numOpCaisse")
	public OpCaisse opCaisse;

	//Liaison à la table Article
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", nullable = false, referencedColumnName = "codeArticle")
	public Article article;

	/**
	 * 
	 */
	public LigneOpCaisse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idLigneOperCaisse
	 * @param qteLigneOperCaisse
	 * @param prixLigneOperCaisse
	 * @param commentaireLigneOperCaisse
	 * @param opCaisse
	 * @param article
	 */
	public LigneOpCaisse(Long idLigneOperCaisse, Long qteLigneOperCaisse, Long prixLigneOperCaisse,
			String commentaireLigneOperCaisse, OpCaisse opCaisse, Article article) {
		this.idLigneOperCaisse = idLigneOperCaisse;
		this.qteLigneOperCaisse = qteLigneOperCaisse;
		this.prixLigneOperCaisse = prixLigneOperCaisse;
		CommentaireLigneOperCaisse = commentaireLigneOperCaisse;
		this.opCaisse = opCaisse;
		this.article = article;
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
		return "LigneOpCaisse [idLigneOperCaisse=" + idLigneOperCaisse + ", qteLigneOperCaisse=" + qteLigneOperCaisse
				+ ", prixLigneOperCaisse=" + prixLigneOperCaisse + ", CommentaireLigneOperCaisse="
				+ CommentaireLigneOperCaisse + ", opCaisse=" + opCaisse + ", article=" + article + "]";
	}

}
