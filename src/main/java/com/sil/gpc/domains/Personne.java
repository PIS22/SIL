package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Personne implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPers;
	private String nomPers;
	private String prenomPers;

	public Personne() {
		// TODO Auto-generated constructor stub
	}

	public Personne(String nomPers, String prenomPers) {
		super();
		this.nomPers = nomPers;
		this.prenomPers = prenomPers;
	}

	public Long getIdPers() {
		return idPers;
	}

	public void setIdPers(Long idPers) {
		this.idPers = idPers;
	}

	public String getNomPers() {
		return nomPers;
	}

	public void setNomPers(String nomPers) {
		this.nomPers = nomPers;
	}

	public String getPrenomPers() {
		return prenomPers;
	}

	public void setPrenomPers(String prenomPers) {
		this.prenomPers = prenomPers;
	}

	@Override
	public String toString() {
		return "Personne [idPers=" + idPers + ", nomPers=" + nomPers + ", prenomPers=" + prenomPers + "]";
	}

}
