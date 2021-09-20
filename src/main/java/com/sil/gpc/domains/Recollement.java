package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Recollement implements Serializable {

	@Id
	private String numRecollement;
	private String descriptionRecollement;
	private Timestamp dateRecollement;
	private boolean valideRecol;
	private int valeur;
	private Timestamp dateSaisie;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUser", referencedColumnName = "idUtilisateur", nullable = true)
	public Utilisateur utlisateur;

	// Liaison avec Magasin
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Magasin.class)
	@JoinColumn(name = "magasinsource", referencedColumnName = "codeMagasin", nullable = false)
	private Magasin magasinsource;

	// Liaison avec Magasin
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Magasin.class)
	@JoinColumn(name = "codeDestination", referencedColumnName = "codeMagasin", nullable = false)
	private Magasin magasinDestination;

	// Liaison avec Correspondant
	// @ManyToOne(fetch = FetchType.EAGER, targetEntity = Correspondant.class)
	// @JoinColumn(name = "idCorrespondant", referencedColumnName =
	// "idCorrespondant", nullable = true)
	// private Correspondant corres;

	// Liaison avec Regisseur
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Regisseur.class)
	@JoinColumn(name = "idRegisseur", referencedColumnName = "idRegisseur", nullable = true)
	private Regisseur regisseur;

	// Liaison avec Exercice
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;

	public Recollement() {
		super();
	}

	public Recollement(String numRecollement, String descriptionRecollement, Timestamp dateRecollement,
			Magasin magasinsource, Magasin magasinDestination, Exercice exercice, Utilisateur utlisateur,
			boolean valRec) {
		super();
		this.numRecollement = numRecollement;
		this.descriptionRecollement = descriptionRecollement;
		this.dateRecollement = dateRecollement;
		this.utlisateur = utlisateur;
		this.magasinsource = magasinsource;
		this.magasinDestination = magasinDestination;
		this.valideRecol = valRec;
		this.exercice = exercice;
	}

	public String getNumRecollement() {
		return numRecollement;
	}

	public void setNumRecollement(String numRecollement) {
		this.numRecollement = numRecollement;
	}

	public String getDescriptionRecollement() {
		return descriptionRecollement;
	}

	public void setDescriptionRecollement(String descriptionRecollement) {
		this.descriptionRecollement = descriptionRecollement;
	}

	public Timestamp getDateRecollement() {
		return dateRecollement;
	}

	public void setDateRecollement(Timestamp dateRecollement) {
		this.dateRecollement = dateRecollement;
	}

	public boolean isValideRecol() {
		return valideRecol;
	}

	public void setValideRecol(boolean valideRecol) {
		this.valideRecol = valideRecol;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Timestamp getDateSaisie() {
		return dateSaisie;
	}

	public void setDateSaisie(Timestamp dateSaisie) {
		this.dateSaisie = dateSaisie;
	}

	public Utilisateur getUtlisateur() {
		return utlisateur;
	}

	public void setUtlisateur(Utilisateur utlisateur) {
		this.utlisateur = utlisateur;
	}

	public Magasin getMagasinsource() {
		return magasinsource;
	}

	public void setMagasinsource(Magasin magasinsource) {
		this.magasinsource = magasinsource;
	}

	public Magasin getMagasinDestination() {
		return magasinDestination;
	}

	public void setMagasinDestination(Magasin magasinDestination) {
		this.magasinDestination = magasinDestination;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	@Override
	public String toString() {
		return "Recollement [numRecollement=" + numRecollement + ", descriptionRecollement=" + descriptionRecollement
				+ ", dateRecollement=" + dateRecollement + ", valideRecol=" + valideRecol + ", valeur=" + valeur
				+ ", dateSaisie=" + dateSaisie + ", utlisateur=" + utlisateur + ", magasinsource=" + magasinsource
				+ ", magasinDestination=" + magasinDestination + ", exercice=" + exercice + "]";
	}
}
