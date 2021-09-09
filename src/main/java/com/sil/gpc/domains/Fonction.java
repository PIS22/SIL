package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fonction implements Serializable {
	@Id
	private String codeFonction;
	private String libFonction;

	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fonction(String codeFonction, String libFonction) {
		super();
		this.codeFonction = codeFonction;
		this.libFonction = libFonction;
	}

	public String getCodeFonction() {
		return codeFonction;
	}

	public void setCodeFonction(String codeFonction) {
		this.codeFonction = codeFonction;
	}

	public String getLibFonction() {
		return libFonction;
	}

	public void setLibFonction(String libFonction) {
		this.libFonction = libFonction;
	}

	@Override
	public String toString() {
		return "Fonction [codeFonction=" + codeFonction + ", libFonction=" + libFonction + "]";
	}

}
