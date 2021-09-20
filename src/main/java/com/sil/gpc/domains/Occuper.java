package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Occuper implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idOccu;
	private Date datDeb;
	private Date datFin;
	@ManyToOne(targetEntity = Personne.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "personne", referencedColumnName = "idPers")
	private Personne personne;

	@ManyToOne(targetEntity = Poste.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "poste", referencedColumnName = "idPost")
	private Poste post;

	public Occuper() {
		// TODO Auto-generated constructor stub
	}

	public Occuper(Date datDeb, Date datFin, Personne personne, Poste post) {
		super();
		this.datDeb = datDeb;
		this.datFin = datFin;
		this.personne = personne;
		this.post = post;
	}

	public Long getIdOccuper() {
		return idOccu;
	}

	public void setIdOccuper(Long idOccuper) {
		this.idOccu = idOccuper;
	}

	public Date getDatDeb() {
		return datDeb;
	}

	public void setDatDeb(Date datDeb) {
		this.datDeb = datDeb;
	}

	public Date getDatFin() {
		return datFin;
	}

	public void setDatFin(Date datFin) {
		this.datFin = datFin;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Poste getPost() {
		return post;
	}

	public void setPost(Poste post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Occuper [idOccuper=" + idOccu + ", datDeb=" + datDeb + ", datFin=" + datFin + ", personne=" + personne
				+ ", post=" + post + "]";
	}

}
