package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Pays implements Serializable{

	@Id
	private String codePays;
	private String nomPays;
	private String nomCompletPays;
	
	public Pays() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pays(String codePays, String nomPays, String nomCompletPays) {
		super();
		
		this.codePays = codePays;
		this.nomPays = nomPays;
		this.nomCompletPays = nomCompletPays;
	}
	public String getCodePays() {
		return codePays;
	}
	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}
	public String getNomPays() {
		return nomPays;
	}
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
	public String getNomCompletPays() {
		return nomCompletPays;
	}
	public void setNomCompletPays(String nomCompletPays) {
		this.nomCompletPays = nomCompletPays;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePays == null) ? 0 : codePays.hashCode());
		result = prime * result + ((nomCompletPays == null) ? 0 : nomCompletPays.hashCode());
		result = prime * result + ((nomPays == null) ? 0 : nomPays.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pays other = (Pays) obj;
		if (codePays == null) {
			if (other.codePays != null)
				return false;
		} else if (!codePays.equals(other.codePays))
			return false;
		if (nomCompletPays == null) {
			if (other.nomCompletPays != null)
				return false;
		} else if (!nomCompletPays.equals(other.nomCompletPays))
			return false;
		if (nomPays == null) {
			if (other.nomPays != null)
				return false;
		} else if (!nomPays.equals(other.nomPays))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pays [codePays=" + codePays + ", nomPays=" + nomPays + ", nomCompletPays=" + nomCompletPays + "]";
	}
	
}
