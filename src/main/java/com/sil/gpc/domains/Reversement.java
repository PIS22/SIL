package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateVersement == null) ? 0 : dateVersement.hashCode());
		result = prime * result + ((numReversement == null) ? 0 : numReversement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reversement other = (Reversement) obj;
		if (dateVersement == null) {
			if (other.dateVersement != null)
				return false;
		} else if (!dateVersement.equals(other.dateVersement))
			return false;
		if (numReversement == null) {
			if (other.numReversement != null)
				return false;
		} else if (!numReversement.equals(other.numReversement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reversement [numReversement=" + numReversement + ", dateVersement=" + dateVersement + "]";
	}
	
}
