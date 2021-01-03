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
public class Reversement implements Serializable{

	@Id
	private String numReversement;
	private Date dateVersement;
	
	//Liaison avec Exercice
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice",referencedColumnName = "codeExercice",nullable = false)
	private Exercice exercice;
	
	//************************************Liste des lignes reversements
	// Liaison à la table LigneRecollement
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = LigneReversement.class, mappedBy = "numReversement")
	public List<LigneRecollement> ArticleDunreversement;

	
	public Reversement() {
		super();
	}

	public Reversement(String numReversement, Date dateVersement) {
		super();
		this.numReversement = numReversement;
		this.dateVersement = dateVersement;
	}

	public String getNumReversement() {
		return numReversement;
	}

	public void setNumReversement(String numReversement) {
		this.numReversement = numReversement;
	}

	public Date getDateVersement() {
		return dateVersement;
	}

	public void setDateVersement(Date dateVersement) {
		this.dateVersement = dateVersement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateVersement, exercice, numReversement);
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
		Reversement other = (Reversement) obj;
		return Objects.equals(dateVersement, other.dateVersement) && Objects.equals(exercice, other.exercice)
				&& Objects.equals(numReversement, other.numReversement);
	}

	@Override
	public String toString() {
		return "Reversement [numReversement=" + numReversement + ", dateVersement=" + dateVersement + ", exercice="
				+ exercice + ", ArticleDunreversement=" + ArticleDunreversement + "]";
	}


	
}
