package com.sil.gpc.domains;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inventaire {

	@Id
	private String numInv;
	private Timestamp dateInv;
	private String descrInv;
	private boolean valideInve;
	private int valeur;
	private Timestamp dateSaisie;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUser", referencedColumnName = "idUtilisateur")
	public Utilisateur utlisateur;
	
	@ManyToOne(targetEntity = Exercice.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice")
	private Exercice exercice;
	
	@ManyToOne(targetEntity = Magasin.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeMagasin", referencedColumnName = "codeMagasin")
	private Magasin magasin;

	public Inventaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventaire(String numInv, Timestamp dateInv, String descrInv, Exercice exercice, Magasin magasin) {
		this.numInv = numInv;
		this.dateInv = dateInv;
		this.descrInv = descrInv;
		this.exercice = exercice;
		this.magasin = magasin;
	}

	public boolean isValideInve() {
		return valideInve;
	}

	public void setValideInve(boolean valideInve) {
		this.valideInve = valideInve;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getNumInv() {
		return numInv;
	}

	public void setNumInv(String numInv) {
		this.numInv = numInv;
	}

	public Timestamp getDateInv() {
		return dateInv;
	}

	public void setDateInv(Timestamp dateInv) {
		this.dateInv = dateInv;
	}

	public String getDescrInv() {
		return descrInv;
	}

	public void setDescrInv(String descrInv) {
		this.descrInv = descrInv;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
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

	@Override
	public String toString() {
		return "Inventaire [numInv=" + numInv + ", dateInv=" + dateInv + ", descrInv=" + descrInv + ", exo=" + exercice
				+ ", magasin=" + magasin + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateInv, descrInv, exercice, magasin, numInv);
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
		Inventaire other = (Inventaire) obj;
		return Objects.equals(dateInv, other.dateInv) && Objects.equals(descrInv, other.descrInv)
				&& Objects.equals(exercice, other.exercice) && Objects.equals(magasin, other.magasin)
				&& Objects.equals(numInv, other.numInv);
	}
	
}
