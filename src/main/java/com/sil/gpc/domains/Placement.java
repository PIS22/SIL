package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Placement implements Serializable{

	@Id
	private String numPlacement;
	private Date datePlacement;

	//Liaison avec correspondatnt
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Correspondant.class)
	@JoinColumn(name = "idCorrespondant",referencedColumnName = "idCorrespondant",nullable = false)
	private Correspondant correspondant;

	//Liaison avec Exercice
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice",referencedColumnName = "codeExercice",nullable = false)
	private Exercice exercice;
	
	//*************************************Il reste l'attribut qui concerne le correspondant

	//Liaison à la table LignPlacement
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = LignePlacement.class,mappedBy = "placement")
	public List<LignePlacement> articlesParPlacement;
	
	public Placement() {
		super();
	}

	public Placement(String numPlacement, Date datePlacement, Exercice exercice,
			List<LignePlacement> articlesParPlacement) {
		super();
		this.numPlacement = numPlacement;
		this.datePlacement = datePlacement;
		this.exercice = exercice;
		this.articlesParPlacement = articlesParPlacement;
	}

	/**
	 * @return the numPlacement
	 */
	public String getNumPlacement() {
		return numPlacement;
	}

	/**
	 * @param numPlacement the numPlacement to set
	 */
	public void setNumPlacement(String numPlacement) {
		this.numPlacement = numPlacement;
	}

	/**
	 * @return the datePlacement
	 */
	public Date getDatePlacement() {
		return datePlacement;
	}

	/**
	 * @param datePlacement the datePlacement to set
	 */
	public void setDatePlacement(Date datePlacement) {
		this.datePlacement = datePlacement;
	}

	/**
	 * @return the exercice
	 */
	public Exercice getExercice() {
		return exercice;
	}

	/**
	 * @param exercice the exercice to set
	 */
	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	/**
	 * @return the articlesParPlacement
	 */
	public List<LignePlacement> getArticlesParPlacement() {
		return articlesParPlacement;
	}

	/**
	 * @param articlesParPlacement the articlesParPlacement to set
	 */
	public void setArticlesParPlacement(List<LignePlacement> articlesParPlacement) {
		this.articlesParPlacement = articlesParPlacement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(articlesParPlacement, datePlacement, exercice, numPlacement);
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
		Placement other = (Placement) obj;
		return Objects.equals(articlesParPlacement, other.articlesParPlacement)
				&& Objects.equals(datePlacement, other.datePlacement) && Objects.equals(exercice, other.exercice)
				&& Objects.equals(numPlacement, other.numPlacement);
	}

	@Override
	public String toString() {
		return "Placement [numPlacement=" + numPlacement + ", datePlacement=" + datePlacement + ", exercice=" + exercice
				+ ", articlesParPlacement=" + articlesParPlacement + "]";
	}


}
