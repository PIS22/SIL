package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeAmort implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTypAmo;
	private String libTypAmo;
	
	public TypeAmort() {
		// TODO Auto-generated constructor stub
	}

	public TypeAmort(Long idTypAmo, String libTypAmo) {
		super();
		this.idTypAmo = idTypAmo;
		this.libTypAmo = libTypAmo;
	}

	public Long getIdTypAmo() {
		return idTypAmo;
	}

	public void setIdTypAmo(Long idTypAmo) {
		this.idTypAmo = idTypAmo;
	}

	public String getLibTypAmo() {
		return libTypAmo;
	}

	public void setLibTypAmo(String libTypAmo) {
		this.libTypAmo = libTypAmo;
	}

	@Override
	public String toString() {
		return "TypeAmort [idTypAmo=" + idTypAmo + ", libTypAmo=" + libTypAmo + "]";
	}
	
	

}
