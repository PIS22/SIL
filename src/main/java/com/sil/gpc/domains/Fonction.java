package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Fonction implements Serializable {
	@Id
	private String codFonction;
	private String libFonction;

	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fonction(String codeFonction, String libFonction) {
		super();
		this.codFonction = codeFonction;
		this.libFonction = libFonction;
	}

	public String getCodeFonction() {
		return codFonction;
	}

	public void setCodeFonction(String codeFonction) {
		this.codFonction = codeFonction;
	}

	public String getLibFonction() {
		return libFonction;
	}

	public void setLibFonction(String libFonction) {
		this.libFonction = libFonction;
	}

	@Override
	public String toString() {
		return "Fonction [codeFonction=" + codFonction + ", libFonction=" + libFonction + "]";
	}

}
