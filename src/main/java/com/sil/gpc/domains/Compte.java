package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compte implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCpte;
	@Column(unique = true)
	private String numCpte;
	private String libCpte;
	private String collectif;
	@Column(length = 1)
	private String typCpte;

	public Compte() {
		// TODO Auto-generated constructor stub
	}

	public Compte(Long idCpte, String numCpte, String libCpte, String collectif, String typ) {
		super();
		this.idCpte = idCpte;
		this.numCpte = numCpte;
		this.libCpte = libCpte;
		this.collectif = collectif;
		this.typCpte=typ;
	}

	public Long getIdCpte() {
		return idCpte;
	}

	public void setIdCpte(Long idCpte) {
		this.idCpte = idCpte;
	}

	public String getNumCpte() {
		return numCpte;
	}

	public void setNumCpte(String numCpte) {
		this.numCpte = numCpte;
	}

	public String getLibCpte() {
		return libCpte;
	}

	public void setLibCpte(String libCpte) {
		this.libCpte = libCpte;
	}

	public String getCollectif() {
		return collectif;
	}

	public void setCollectif(String collectif) {
		this.collectif = collectif;
	}

	public String getTypCpte() {
		return typCpte;
	}

	public void setTypCpte(String typCpte) {
		this.typCpte = typCpte;
	}

	public String toString() {
		return "Compte{" +
				"idCpte=" + idCpte +
				", numCpte='" + numCpte + '\'' +
				", libCpte='" + libCpte + '\'' +
				", collectif='" + collectif + '\'' +
				", typCpte=" + typCpte +
				'}';
	}
}
