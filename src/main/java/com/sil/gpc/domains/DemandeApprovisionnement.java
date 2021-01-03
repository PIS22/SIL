package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class DemandeApprovisionnement implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(length = 12)
	private String numDA;
	private Date dateDA;
	
	//Liaison avec Exercice
	@ManyToOne(cascade =CascadeType.ALL,targetEntity = Exercice.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice",nullable = false)
	public Exercice exercice;

	// Liaison à Utilisateur
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LigneDemandeAppro.class, fetch =FetchType.LAZY,mappedBy = "appro" )
	public List<LigneDemandeAppro> articlesDeLaDemande;

	public DemandeApprovisionnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandeApprovisionnement(String numDA, Date dateDA, Exercice exercice) {
		super();
		this.numDA = numDA;
		this.dateDA = dateDA;
		this.exercice = exercice;
	}

	/**
	 * @return the numDA
	 */
	public String getNumDA() {
		return numDA;
	}

	/**
	 * @param numDA the numDA to set
	 */
	public void setNumDA(String numDA) {
		this.numDA = numDA;
	}

	/**
	 * @return the dateDA
	 */
	public Date getDateDA() {
		return dateDA;
	}

	/**
	 * @param dateDA the dateDA to set
	 */
	public void setDateDA(Date dateDA) {
		this.dateDA = dateDA;
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

	@Override
	public int hashCode() {
		return Objects.hash(dateDA, exercice, numDA);
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
		DemandeApprovisionnement other = (DemandeApprovisionnement) obj;
		return Objects.equals(dateDA, other.dateDA) && Objects.equals(exercice, other.exercice)
				&& Objects.equals(numDA, other.numDA);
	}

}
