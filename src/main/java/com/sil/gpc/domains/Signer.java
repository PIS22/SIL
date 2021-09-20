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

@SuppressWarnings("serial")
@Entity
public class Signer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSign;
	private Date datDeb;
	private Date datFin;
	@ManyToOne(targetEntity = Poste.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "poste", referencedColumnName = "idPost")
	private Poste poste;

	@ManyToOne(targetEntity = Rapport.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "rappor", referencedColumnName = "idRap")
	private Rapport rapport;

	public Signer() {
		// TODO Auto-generated constructor stub
	}

	public Signer(Date datDeb, Date datFin, Poste poste, Rapport rapport) {
		super();
		this.datDeb = datDeb;
		this.datFin = datFin;
		this.poste = poste;
		this.rapport = rapport;
	}

	public Long getIdSignature() {
		return idSign;
	}

	public void setIdSignature(Long idSignature) {
		this.idSign = idSignature;
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

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public Rapport getRapport() {
		return rapport;
	}

	public void setRapport(Rapport rapport) {
		this.rapport = rapport;
	}

	@Override
	public String toString() {
		return "Signer [idSignature=" + idSign + ", datDeb=" + datDeb + ", datFin=" + datFin + ", poste=" + poste
				+ ", rapport=" + rapport + "]";
	}

}
