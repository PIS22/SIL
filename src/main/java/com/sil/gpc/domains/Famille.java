package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Famille implements Serializable {

	@Id
	private String codeFamille;
	private String libFamille;

	public Famille() {
		super();
	}

	public Famille(String codeFamille, String libFamille) {
		super();
		this.codeFamille = codeFamille;
		this.libFamille = libFamille;
	}

	public String getCodeFamille() {
		return codeFamille;
	}

	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}

	public String getLibFamille() {
		return libFamille;
	}

	public void setLibFamille(String libFamille) {
		this.libFamille = libFamille;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeFamille, libFamille);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Famille other = (Famille) obj;
		return Objects.equals(codeFamille, other.codeFamille) && Objects.equals(libFamille, other.libFamille);
	}

	@Override
	public String toString() {
		return "Famille [codeFamille=" + codeFamille + ", libFamille=" + libFamille + "]";
	}

}
