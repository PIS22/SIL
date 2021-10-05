package com.sil.gpc.domains;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class LignePvOp {

	private double qte;
	private double cump;
	private double mtt;
	@ManyToOne(targetEntity = OpCaisse.class, fetch = FetchType.EAGER)
	private OpCaisse opCaisse;
	@ManyToOne(targetEntity = Article.class, fetch = FetchType.EAGER)
	private Article article;

	public LignePvOp() {
		// TODO Auto-generated constructor stub
	}

	public LignePvOp(double qte, double cump, double mtt, OpCaisse opCaisse, Article article) {
		super();
		this.qte = qte;
		this.cump = cump;
		this.mtt = mtt;
		this.opCaisse = opCaisse;
		this.article = article;
	}

	public double getQte() {
		return qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

	public double getCump() {
		return cump;
	}

	public void setCump(double cump) {
		this.cump = cump;
	}

	public double getMtt() {
		return mtt;
	}

	public void setMtt(double mtt) {
		this.mtt = mtt;
	}

	public OpCaisse getOpCaisse() {
		return opCaisse;
	}

	public void setOpCaisse(OpCaisse opCaisse) {
		this.opCaisse = opCaisse;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
