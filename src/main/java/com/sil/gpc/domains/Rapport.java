package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Rapport implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long idRap;
	@Column(unique = true)
	private String codRap;
	private String libRap;

	public Rapport() {
		// TODO Auto-generated constructor stub
	}

	public Rapport(String codRap, String libRap) {
		super();
		this.codRap = codRap;
		this.libRap = libRap;
	}

	public Long getIdRap() {
		return idRap;
	}

	public void setIdRap(Long idRap) {
		this.idRap = idRap;
	}

	public String getCodRap() {
		return codRap;
	}

	public void setCodRap(String codRap) {
		this.codRap = codRap;
	}

	public String getLibRap() {
		return libRap;
	}

	public void setLibRap(String libRap) {
		this.libRap = libRap;
	}

	@Override
	public String toString() {
		return "Rapport [idRap=" + idRap + ", codRap=" + codRap + ", libRap=" + libRap + "]";
	}

}
