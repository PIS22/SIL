package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity(name = "Commande")
public class Commande implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)//*******************************Pourquoi ça ?
	@Column(name = "numCommande", length = 8, updatable = false)
	private String numCommande;
	private Date dateCommande;
	private String description;
	private int delaiLivraison;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity =Fournisseur.class)
	private Fournisseur frs;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LigneCommande.class,fetch = FetchType.EAGER,mappedBy = "numCommande")
	public List<LigneCommande> lignesDuneCommande;
	
	//Liaison avec la table Exercice
	@ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(String numCommande, Date dateCommande, String description, int delaiLivraison, Fournisseur frs,
			Exercice exercice) {
		super();
		this.numCommande = numCommande;
		this.dateCommande = dateCommande;
		this.description = description;
		this.delaiLivraison = delaiLivraison;
		this.frs = frs;
		this.exercice = exercice;
	}

	public String getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(String numCommande) {
		this.numCommande = numCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDelaiLivraison() {
		return delaiLivraison;
	}

	public void setDelaiLivraison(int delaiLivraison) {
		this.delaiLivraison = delaiLivraison;
	}

	public Fournisseur getFrs() {
		return frs;
	}

	public void setFrs(Fournisseur frs) {
		this.frs = frs;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateCommande, delaiLivraison, description, exercice, frs, numCommande);
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
		Commande other = (Commande) obj;
		return Objects.equals(dateCommande, other.dateCommande) && delaiLivraison == other.delaiLivraison
				&& Objects.equals(description, other.description) && Objects.equals(exercice, other.exercice)
				&& Objects.equals(frs, other.frs) && Objects.equals(numCommande, other.numCommande);
	}


}