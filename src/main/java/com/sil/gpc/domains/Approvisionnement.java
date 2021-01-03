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
public class Approvisionnement implements Serializable {

	@Id
	private String numAppro;
	private String descriptionAppro;
	private Date dateAppro;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = true)
	private Exercice exercice;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LigneAppro.class,fetch = FetchType.EAGER,mappedBy = "appro")
	public List<LigneAppro> lignesDunAppro;
	
	public Approvisionnement() {
		super();
	}

	public Approvisionnement(String numAppro, String descriptionAppro, Date dateAppro, Exercice exercice) {
		super();
		this.numAppro = numAppro;
		this.descriptionAppro = descriptionAppro;
		this.dateAppro = dateAppro;
		this.exercice = exercice;
	}

	public String getNumAppro() {
		return numAppro;
	}

	public void setNumAppro(String numAppro) {
		this.numAppro = numAppro;
	}

	public String getDescriptionAppro() {
		return descriptionAppro;
	}

	public void setDescriptionAppro(String descriptionAppro) {
		this.descriptionAppro = descriptionAppro;
	}

	public Date getDateAppro() {
		return dateAppro;
	}

	public void setDateAppro(Date dateAppro) {
		this.dateAppro = dateAppro;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateAppro, descriptionAppro, exercice, numAppro);
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
		Approvisionnement other = (Approvisionnement) obj;
		return Objects.equals(dateAppro, other.dateAppro) && Objects.equals(descriptionAppro, other.descriptionAppro)
				&& Objects.equals(exercice, other.exercice) && Objects.equals(numAppro, other.numAppro);
	}

	@Override
	public String toString() {
		return "Approvisionnement [numAppro=" + numAppro + ", descriptionAppro=" + descriptionAppro + ", dateAppro="
				+ dateAppro + ", exercice=" + exercice + ", lignesDunAppro=" + lignesDunAppro + "]";
	}
	
}