package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

@SuppressWarnings("serial")
@Entity
public class Echeance implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEcheance;
	private String moisEcheance;
	private int annee;
	private Date dateEcheance;
	private boolean payeEcheance;
	private double prix;
	@ColumnDefault(value = "1")
	private double superficie;
	@ColumnDefault(value = "1")
	private double nbrPlace;
	@ColumnDefault(value = "1")
	private double nbrFace;
	private Date datPaiement;
	private Date datDebPeri;
	private Date datFinPeri;
	private String typPaiement;
	@ManyToOne(targetEntity = Contrat.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "numContrat",referencedColumnName = "numContrat", nullable = false)
	private Contrat contrat;

	//Liaison avec la table OpCaisse
	@ManyToOne(targetEntity = OpCaisse.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "numOpCaisse", referencedColumnName = "numOpCaisse",nullable = true)
	private OpCaisse opCaisse ;

	public Echeance() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Echeance(Long idEcheance, String moisEcheance, int annee, Date dateEcheance, boolean payeEcheance,
			double prix, double superficie, double nbrPlace, double nbrFace, Date datPaiement, Date datDebPeri,
			Date datFinPeri, String typPaiement, Contrat contrat, OpCaisse opCaisse) {
		super();
		this.idEcheance = idEcheance;
		this.moisEcheance = moisEcheance;
		this.annee = annee;
		this.dateEcheance = dateEcheance;
		this.payeEcheance = payeEcheance;
		this.prix = prix;
		this.superficie = superficie;
		this.nbrPlace = nbrPlace;
		this.nbrFace = nbrFace;
		this.datPaiement = datPaiement;
		this.datDebPeri = datDebPeri;
		this.datFinPeri = datFinPeri;
		this.typPaiement = typPaiement;
		this.contrat = contrat;
		this.opCaisse = opCaisse;
	}



	public String getMoisEcheance() {
		return moisEcheance;
	}

	public void setMoisEcheance(String moisEcheance) {
		this.moisEcheance = moisEcheance;
	}

	public void setIdEcheance(Long idEcheance) {
		this.idEcheance = idEcheance;
	}

	public Date getDatPaiement() {
		return datPaiement;
	}

	public void setDatPaiement(Date datPaiement) {
		this.datPaiement = datPaiement;
	}

	public String getTypPaiement() {
		return typPaiement;
	}

	public void setTypPaiement(String typPaiement) {
		this.typPaiement = typPaiement;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	/**
	 * @param dateEcheance the dateEcheance to set
	 */
	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	/**
	 * @return the payeEcheance
	 */
	public boolean isPayeEcheance() {
		return payeEcheance;
	}

	/**
	 * @param payeEcheance the payeEcheance to set
	 */
	public void setPayeEcheance(boolean payeEcheance) {
		this.payeEcheance = payeEcheance;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the contrat
	 */
	public Contrat getContrat() {
		return contrat;
	}

	/**
	 * @param contrat the contrat to set
	 */
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	/**
	 * @return the opCaisse
	 */
	public OpCaisse getOpCaisse() {
		return opCaisse;
	}

	/**
	 * @param opCaisse the opCaisse to set
	 */
	public void setOpCaisse(OpCaisse opCaisse) {
		this.opCaisse = opCaisse;
	}

	/**
	 * @return the idEcheance
	 */
	public Long getIdEcheance() {
		return idEcheance;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public double getNbrPlace() {
		return nbrPlace;
	}

	public void setNbrPlace(double nbrPlace) {
		this.nbrPlace = nbrPlace;
	}

	public double getNbrFace() {
		return nbrFace;
	}

	public void setNbrFace(double nbrFace) {
		this.nbrFace = nbrFace;
	}

	public Date getDatDebPeri() {
		return datDebPeri;
	}

	public void setDatDebPeri(Date datDebPeri) {
		this.datDebPeri = datDebPeri;
	}

	public Date getDatFinPeri() {
		return datFinPeri;
	}

	public void setDatFinPeri(Date datFinPeri) {
		this.datFinPeri = datFinPeri;
	}

	@Override
	public String toString() {
		return "Echeance [idEcheance=" + idEcheance + ", moisEcheance=" + moisEcheance + ", annee=" + annee
				+ ", dateEcheance=" + dateEcheance + ", payeEcheance=" + payeEcheance + ", prix=" + prix
				+ ", superficie=" + superficie + ", nbrPlace=" + nbrPlace + ", nbrFace=" + nbrFace + ", datPaiement="
				+ datPaiement + ", datDebPeri=" + datDebPeri + ", datFinPeri=" + datFinPeri + ", typPaiement="
				+ typPaiement + ", contrat=" + contrat + ", opCaisse=" + opCaisse + "]";
	}


}