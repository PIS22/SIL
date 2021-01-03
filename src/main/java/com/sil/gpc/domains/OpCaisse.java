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
@Entity(name = "OpCaisse")
public class OpCaisse implements Serializable {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numOpCaisse", length = 20)
	private String numOpCaisse;
	private Date dateOpCaisse;
	@Column(length = 50)
	private String contribuable;
	private boolean valideOpCaisse;
	@Column(length = 150)
	private String ObservationOpCaisse;
	private Date dateSaisie;

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
	
	//Liaison à l'exercice
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;

	//Liaison à la table "Utilisateur"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur", nullable = false)
	private Utilisateur utilisateur;

	// Liaison avec la table OpCaisse
	@OneToMany( cascade = CascadeType.ALL,targetEntity = PointVente.class, mappedBy = "opCaisse")
	private List<PointVente> PointsDuneOpCaisse;

	// Liaison avec la table Echeance
	@OneToMany( cascade = CascadeType.ALL,targetEntity = Echeance.class, mappedBy = "opCaisse")
	private List<Echeance> echeancesOpCaisse;
	
	//Liaison à la table Ligne opération
	@OneToMany(targetEntity = LigneOpCaisse.class, mappedBy = "opCaisse")
	List<LigneOpCaisse> lignesDuneOperationDeCaisse;

	public OpCaisse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNumOpCaisse() {
		return numOpCaisse;
	}

	public void setNumOpCaisse(String numOpCaisse) {
		this.numOpCaisse = numOpCaisse;
	}

	public Date getDateOpCaisse() {
		return dateOpCaisse;
	}

	public void setDateOpCaisse(Date dateOpCaisse) {
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

	public String getObservation() {
		return ObservationOpCaisse;
	}

	public void setObservation(String observation) {
		ObservationOpCaisse = observation;
	}

	public Date getDateSaisie() {
		return dateSaisie;
	}

	public void setDateSaisie(Date dateSaisie) {
		this.dateSaisie = dateSaisie;
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

	@Override
	public String toString() {
		return "OpCaisse [numOpCaisse=" + numOpCaisse + ", dateOpCaisse=" + dateOpCaisse + ", contribuable="
				+ contribuable + ", valideOpCaisse=" + valideOpCaisse + ", Observation=" + ObservationOpCaisse + ", dateSaisie="
				+ dateSaisie + ", caisse=" + caisse + ", typeRecette=" + typeRecette + ", modePaiement=" + modePaiement
				+ ", exercice=" + exercice + ", utilisateur=" + utilisateur + ", echeancesOpCaisse=" + echeancesOpCaisse
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ObservationOpCaisse, caisse, contribuable, dateOpCaisse, dateSaisie, echeancesOpCaisse,
				exercice, modePaiement, numOpCaisse, typeRecette, utilisateur, valideOpCaisse);
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
		OpCaisse other = (OpCaisse) obj;
		return Objects.equals(ObservationOpCaisse, other.ObservationOpCaisse) && Objects.equals(caisse, other.caisse)
				&& Objects.equals(contribuable, other.contribuable) && Objects.equals(dateOpCaisse, other.dateOpCaisse)
				&& Objects.equals(dateSaisie, other.dateSaisie)
				&& Objects.equals(echeancesOpCaisse, other.echeancesOpCaisse)
				&& Objects.equals(exercice, other.exercice) && Objects.equals(modePaiement, other.modePaiement)
				&& Objects.equals(numOpCaisse, other.numOpCaisse) && Objects.equals(typeRecette, other.typeRecette)
				&& Objects.equals(utilisateur, other.utilisateur) && valideOpCaisse == other.valideOpCaisse;
	}

}