package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AffectComptToCaisse {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAffectComptCai;

	private Date datDebAffComptCai;
	
	private Date datFinAffComptCai;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Compte.class)
	@JoinColumn(name="idCpte", referencedColumnName = "idCpte", nullable = false)
	private Compte compte;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Caisse.class)
	@JoinColumn(name="codeCaisse", referencedColumnName = "codeCaisse", nullable = false)
	private Caisse caisse;

	public AffectComptToCaisse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AffectComptToCaisse(Long idAffectComptCai, Date datDebAffComptCai, Date datFinAffComptCai, Compte compte,
			Caisse caisse) {
		super();
		this.idAffectComptCai = idAffectComptCai;
		this.datDebAffComptCai = datDebAffComptCai;
		this.datFinAffComptCai = datFinAffComptCai;
		this.compte = compte;
		this.caisse = caisse;
	}

	public Long getIdAffectComptCai() {
		return idAffectComptCai;
	}

	public void setIdAffectComptCai(Long idAffectComptCai) {
		this.idAffectComptCai = idAffectComptCai;
	}

	public Date getDatDebAffComptCai() {
		return datDebAffComptCai;
	}

	public void setDatDebAffComptCai(Date datDebAffComptCai) {
		this.datDebAffComptCai = datDebAffComptCai;
	}

	public Date getDatFinAffComptCai() {
		return datFinAffComptCai;
	}

	public void setDatFinAffComptCai(Date datFinAffComptCai) {
		this.datFinAffComptCai = datFinAffComptCai;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	@Override
	public String toString() {
		return "AffectComptToCaisse [idAffectComptCai=" + idAffectComptCai + ", datDebAffComptCai=" + datDebAffComptCai
				+ ", datFinAffComptCai=" + datFinAffComptCai + ", compte=" + compte + ", caisse=" + caisse + "]";
	}
	
	

}
