package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activite implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAct;
	@Column(unique = true)
	private String codeAct;
	private String libAct;
	
	public Activite() {
		// TODO Auto-generated constructor stub
	}

	public Activite(Long idAct, String codeAct, String libAct) {
		super();
		this.idAct = idAct;
		this.codeAct = codeAct;
		this.libAct = libAct;
	}

	public Long getIdAct() {
		return idAct;
	}

	public void setIdAct(Long idAct) {
		this.idAct = idAct;
	}

	public String getCodeAct() {
		return codeAct;
	}

	public void setCodeAct(String codeAct) {
		this.codeAct = codeAct;
	}

	public String getLibAct() {
		return libAct;
	}

	public void setLibAct(String libAct) {
		this.libAct = libAct;
	}

	@Override
	public String toString() {
		return "Activite [idAct=" + idAct + ", codeAct=" + codeAct + ", libAct=" + libAct + "]";
	}
	
	

}
