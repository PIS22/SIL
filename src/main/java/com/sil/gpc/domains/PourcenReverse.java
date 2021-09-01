package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PourcenReverse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPourcenRevers;
	private double valPourcenRevers;
	
	//Liaison  avec Institution de reversement
			@ManyToOne(fetch = FetchType.EAGER,targetEntity = InstituReverse.class)
			@JoinColumn(name="codeInstRevers", referencedColumnName = "codeInstRevers", nullable = false)
			private InstituReverse instituReverse;
	//Liaison  avec article
			@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
			@JoinColumn(name="codeArticle", referencedColumnName = "codeArticle", nullable = false)
			private Article article ;
			
	public PourcenReverse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PourcenReverse(Long idPourcenRevers, double valPourcenRevers, InstituReverse instituReverse,
			Article article) {
		super();
		this.idPourcenRevers = idPourcenRevers;
		this.valPourcenRevers = valPourcenRevers;
		this.instituReverse = instituReverse;
		this.article = article;
	}

	public Long getIdPourcenRevers() {
		return idPourcenRevers;
	}

	public void setIdPourcenRevers(Long idPourcenRevers) {
		this.idPourcenRevers = idPourcenRevers;
	}

	public double getValPourcenRevers() {
		return valPourcenRevers;
	}

	public void setValPourcenRevers(double valPourcenRevers) {
		this.valPourcenRevers = valPourcenRevers;
	}

	public InstituReverse getInstituReverse() {
		return instituReverse;
	}

	public void setInstituReverse(InstituReverse instituReverse) {
		this.instituReverse = instituReverse;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "PourcenReverse [idPourcenRevers=" + idPourcenRevers + ", valPourcenRevers=" + valPourcenRevers
				+ ", instituReverse=" + instituReverse + ", article=" + article + "]";
	}
			
		
	
	
}
