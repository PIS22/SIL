package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EtatImmo implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEtatImmo;
	private String codeEtatImo;
	private String libEtatImo;
	
	public EtatImmo() {
		// TODO Auto-generated constructor stub
	}

	public EtatImmo(Long idEtatImmo, String libEtatImo, String codeEtatImo) {
		super();
		this.idEtatImmo = idEtatImmo;
		this.codeEtatImo = codeEtatImo;
		this.libEtatImo = libEtatImo;
	}

	public Long getIdEtatImmo() {
		return idEtatImmo;
	}

	public void setIdEtatImmo(Long idEtatImmo) {
		this.idEtatImmo = idEtatImmo;
	}

	public String getCodeEtatImo() {
		return codeEtatImo;
	}

	public void setCodeEtatImo(String codeEtatImo) {
		this.codeEtatImo = codeEtatImo;
	}

	public String getLibEtatImo() {
		return libEtatImo;
	}

	public void setLibEtatImo(String libEtatImo) {
		this.libEtatImo = libEtatImo;
	}

	@Override
	public String toString() {
		return "EtatImmo{" +
				"idEtatImmo=" + idEtatImmo +
				", codeEtatImo='" + codeEtatImo + '\'' +
				", libEtatImo='" + libEtatImo + '\'' +
				'}';
	}
}
