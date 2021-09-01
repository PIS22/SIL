package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class LigneAppro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneAppro;
	private Long quantiteLigneAppro;
	private Long PULigneAppro;

	//Liaison avec Approvisionnement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Approvisionnement.class)
	@JoinColumn(name = "numAppro", referencedColumnName = "numAppro",nullable = false)
	public Approvisionnement appro;

	//Liaison avec LigneDemmandeAppro
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = LigneDemandeAppro.class)
	@JoinColumn(name = "numidDA", referencedColumnName = "idLigneDA",nullable = false)
	public LigneDemandeAppro ligneDA;	
	
	public LigneAppro() {
		super();
	}


	public LigneAppro(Long quantiteLigneAppro, Long pULigneAppro, LigneDemandeAppro ligneDA) {
		super();
		this.quantiteLigneAppro = quantiteLigneAppro;
		PULigneAppro = pULigneAppro;
		this.ligneDA = ligneDA;
	}


	public Long getIdLigneAppro() {
		return idLigneAppro;
	}

	public void setIdLigneAppro(Long idLigneAppro) {
		this.idLigneAppro = idLigneAppro;
	}

	public Long getQuantiteLigneAppro() {
		return quantiteLigneAppro;
	}

	public void setQuantiteLigneAppro(Long quantiteLigneAppro) {
		this.quantiteLigneAppro = quantiteLigneAppro;
	}

	public Long getPULigneAppro() {
		return PULigneAppro;
	}

	public void setPULigneAppro(Long pULigneAppro) {
		PULigneAppro = pULigneAppro;
	}
	

	public Approvisionnement getAppro() {
		return appro;
	}


	public void setAppro(Approvisionnement appro) {
		this.appro = appro;
	}


	public LigneDemandeAppro getLigneDA() {
		return ligneDA;
	}


	public void setLigneDA(LigneDemandeAppro ligneDA) {
		this.ligneDA = ligneDA;
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
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
