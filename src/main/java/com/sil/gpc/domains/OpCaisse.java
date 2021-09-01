package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author YVES DJOS
 *
 */
@SuppressWarnings("serial")
@Entity(name = "OpCaisse")
public class OpCaisse implements Serializable {
	@Id
	@Column(name = "numOpCaisse", length = 20)
	private String numOpCaisse;
	
	private Timestamp dateOpCaisse;
	@Column(length = 50)
	private String contribuable;
	private boolean valideOpCaisse;
	@Column(length = 150)
	private String obsOpCaisse;
	private Timestamp dateSaisie;
	private int valeur;
	private double mttRem;
	private double monnai;
	private double reliquat;

	//Liaison à la caisse
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Caisse.class)
	@JoinColumn(name = "codeCaisse", referencedColumnName = "codeCaisse", nullable = false)
	private Caisse caisse;

	//Liaison au type de recette
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeRecette.class)
	@JoinColumn(name = "codeTypRec", referencedColumnName = "codeTypRec", nullable = false)
	private TypeRecette typeRecette;

	//Liaison à la table "ModePaiementRepository"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ModePaiement.class)
	@JoinColumn(name = "codeModPay", referencedColumnName = "codeModPay", nullable = false)
	private ModePaiement modePaiement;

	//Liaison au type de recette
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = true)
	private Exercice exercice;

	//Liaison à la table "ModePaiementRepository"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur", nullable = true)
	private Utilisateur utilisateur;

	public OpCaisse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpCaisse(String numOpCaisse, Timestamp dateOpCaisse, String contribuable, String obsOpCaisse,
			Timestamp dateSaisie, Caisse caisse, TypeRecette typeRecette, ModePaiement modePaiement, Exercice exercice,
			Double mttRem, Double monnai, Double reliquat, Utilisateur utilisateur) {
		this.numOpCaisse = numOpCaisse;
		this.dateOpCaisse = dateOpCaisse;
		this.contribuable = contribuable;
		this.obsOpCaisse = obsOpCaisse;
		this.dateSaisie = (Timestamp) new Date();
		this.caisse = caisse;
		this.typeRecette = typeRecette;
		this.modePaiement = modePaiement;
		this.exercice = exercice;
		this.utilisateur = utilisateur;
		this.mttRem = mttRem;
		this.monnai = monnai;
		this.reliquat = reliquat;
	}

	public String getNumOpCaisse() {
		return numOpCaisse;
	}

	public void setNumOpCaisse(String numOpCaisse) {
		this.numOpCaisse = numOpCaisse;
	}

	public Timestamp getDateOpCaisse() {
		return dateOpCaisse;
	}

	public void setDateOpCaisse(Timestamp dateOpCaisse) {
		this.dateOpCaisse = dateOpCaisse;
	}

	public String getContribuable() {
		return contribuable;
	}

	public void setContribuable(String contribuable) {
		this.contribuable = contribuable;
	}

	public boolean isValideOpCaisse() {
		return valideOpCaisse;
	}

	public void setValideOpCaisse(boolean valideOpCaisse) {
		this.valideOpCaisse = valideOpCaisse;
	}

	public String getObsOpCaisse() {
		return obsOpCaisse;
	}

	public void setObsOpCaisse(String obsOpCaisse) {
		this.obsOpCaisse = obsOpCaisse;
	}

	public Timestamp getDateSaisie() {
		return dateSaisie;
	}

	public void setDateSaisie(Timestamp dateSaisie) {
		this.dateSaisie = dateSaisie;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	public TypeRecette getTypeRecette() {
		return typeRecette;
	}

	public void setTypeRecette(TypeRecette typeRecette) {
		this.typeRecette = typeRecette;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public double getMttRem() {
		return mttRem;
	}

	public void setMttRem(double mttRem) {
		this.mttRem = mttRem;
	}

	public double getMonnai() {
		return monnai;
	}

	public void setMonnai(double monnai) {
		this.monnai = monnai;
	}

	public double getReliquat() {
		return reliquat;
	}

	public void setReliquat(double reliquat) {
		this.reliquat = reliquat;
	}

	@Override
	public String toString() {
		return "OpCaisse [numOpCaisse=" + numOpCaisse + ", dateOpCaisse=" + dateOpCaisse + ", contribuable="
				+ contribuable + ", valideOpCaisse=" + valideOpCaisse + ", obsOpCaisse=" + obsOpCaisse + ", dateSaisie="
				+ dateSaisie + ", valeur=" + valeur + ", mttRem=" + mttRem + ", monnai=" + monnai + ", reliquat="
				+ reliquat + ", caisse=" + caisse + ", typeRecette=" + typeRecette + ", modePaiement=" + modePaiement
				+ ", exercice=" + exercice + ", utilisateur=" + utilisateur + "]";
	}


}