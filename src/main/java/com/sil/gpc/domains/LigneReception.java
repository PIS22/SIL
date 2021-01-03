package com.sil.gpc.domains;

import java.io.Serializable;

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

public class LigneReception implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneReception;
	private double quantiteLigneReception;
	private double PULigneReception;
	private String observationLigneReception;
	private Long numSerieDebLigneReception;
	private Long numSerieFinLigneReception;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = LigneCommande.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "idLigneCmde",referencedColumnName = "idLigneCommande")
	private LigneCommande ligneCommande;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Reception.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "numReception", referencedColumnName = "numReception")
	private Reception reception;
	
	public LigneReception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneReception(Long idLigneReception, double quantiteLigneReception, double pULigneReception,
			String observationLigneReception, Long numSerieDebLigneReception, Long numSerieFinLigneReception,
			LigneCommande ligneCommande) {
		super();
		this.idLigneReception = idLigneReception;
		this.quantiteLigneReception = quantiteLigneReception;
		PULigneReception = pULigneReception;
		this.observationLigneReception = observationLigneReception;
		this.numSerieDebLigneReception = numSerieDebLigneReception;
		this.numSerieFinLigneReception = numSerieFinLigneReception;
		this.ligneCommande = ligneCommande;
	}

	public Long getIdLigneReception() {
		return idLigneReception;
	}

	public void setIdLigneReception(Long idLigneReception) {
		this.idLigneReception = idLigneReception;
	}

	public double getQuantiteLigneReception() {
		return quantiteLigneReception;
	}

	public void setQuantiteLigneReception(double quantiteLigneReception) {
		this.quantiteLigneReception = quantiteLigneReception;
	}

	public double getPULigneReception() {
		return PULigneReception;
	}

	public void setPULigneReception(double pULigneReception) {
		PULigneReception = pULigneReception;
	}

	public String getObservationLigneReception() {
		return observationLigneReception;
	}

	public void setObservationLigneReception(String observationLigneReception) {
		this.observationLigneReception = observationLigneReception;
	}

	public Long getNumSerieDebLigneReception() {
		return numSerieDebLigneReception;
	}

	public void setNumSerieDebLigneReception(Long numSerieDebLigneReception) {
		this.numSerieDebLigneReception = numSerieDebLigneReception;
	}

	public Long getNumSerieFinLigneReception() {
		return numSerieFinLigneReception;
	}

	public void setNumSerieFinLigneReception(Long numSerieFinLigneReception) {
		this.numSerieFinLigneReception = numSerieFinLigneReception;
	}

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
