package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Echeance implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEcheance;
	private String moisEcheance;
	private Date dateEcheance;
	private boolean payeEcheance;
	@ManyToOne(targetEntity = Contrat.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "numContrat",referencedColumnName = "numContrat", nullable = false)
	private Contrat contrat;

	// Migration de lab clé du contrat vers l'échéance
	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Contrat.class)
//	@JoinColumn(name = "numContra", referencedColumnName = "numContrat", nullable = false)
	//private Contrat contrat;

	//Liaison avec la table OpCaisse
	@ManyToOne(targetEntity = OpCaisse.class,fetch = FetchType.EAGER,cascade = CascadeType.REFRESH,optional = true)
	@JoinColumn(name = "numOpCaisse", referencedColumnName = "numOpCaisse",nullable = true)
	private OpCaisse opCaisse ;

	public Echeance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Echeance(String mois, Date dateEcheance, boolean payeEcheance, Contrat contrat) {
		super();
		this.moisEcheance = mois;
		this.dateEcheance = dateEcheance;
		this.payeEcheance = payeEcheance;
		//this.contrat = contrat;
	}

	public Long getIdEcheance() {
		return idEcheance;
	}

	public void setIdEcheance(Long idEcheance) {
		this.idEcheance = idEcheance;
	}

	public String getMois() {
		return moisEcheance;
	}

	public void setMois(String mois) {
		this.moisEcheance = mois;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public boolean isPayeEcheance() {
		return payeEcheance;
	}

	public void setPayeEcheance(boolean payeEcheance) {
		this.payeEcheance = payeEcheance;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contrat, dateEcheance, idEcheance, moisEcheance, opCaisse, payeEcheance);
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
		Echeance other = (Echeance) obj;
		return Objects.equals(contrat, other.contrat) && Objects.equals(dateEcheance, other.dateEcheance)
				&& Objects.equals(idEcheance, other.idEcheance) && Objects.equals(moisEcheance, other.moisEcheance)
				&& Objects.equals(opCaisse, other.opCaisse) && payeEcheance == other.payeEcheance;
	}

	@Override
	public String toString() {
		return "Echeance [idEcheance=" + idEcheance + ", moisEcheance=" + moisEcheance + ", dateEcheance="
				+ dateEcheance + ", payeEcheance=" + payeEcheance + ", contrat=" + contrat + ", opCaisse=" + opCaisse
				+ "]";
	}

}