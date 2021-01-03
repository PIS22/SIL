package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Famille implements Serializable {

	@Id
	private String codeFamille;
	private String libFamille;
	
	//List des article d'une famille
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Article.class, mappedBy = "famille")
	List<Article> articlesDuneFamille;
	
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
		return "Famille [codeFamille=" + codeFamille + ", libFamille=" + libFamille + ", articlesDuneFamille="
				+ articlesDuneFamille + "]";
	}

}
