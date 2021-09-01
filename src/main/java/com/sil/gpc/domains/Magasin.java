package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Magasin implements Serializable{

	@Id
	private String codeMagasin;
	private String libMagasin;
	
	public Magasin() {
		super();
	}

	public Magasin(String codeMagasin, String libMagasin) {
		super();
		this.codeMagasin = codeMagasin;
		this.libMagasin = libMagasin;
	}

	public String getCodeMagasin() {
		return codeMagasin;
	}

	public void setCodeMagasin(String codeMagasin) {
		this.codeMagasin = codeMagasin;
	}

	public String getLibMagasin() {
		return libMagasin;
	}

	public void setLibMagasin(String libMagasin) {
		this.libMagasin = libMagasin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeMagasin == null) ? 0 : codeMagasin.hashCode());
		result = prime * result + ((libMagasin == null) ? 0 : libMagasin.hashCode());
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
		Magasin other = (Magasin) obj;
		if (codeMagasin == null) {
			if (other.codeMagasin != null)
				return false;
		} else if (!codeMagasin.equals(other.codeMagasin))
			return false;
		if (libMagasin == null) {
			if (other.libMagasin != null)
				return false;
		} else if (!libMagasin.equals(other.libMagasin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Magasin [codeMagasin=" + codeMagasin + ", libMagasin=" + libMagasin + "]";
	}
	
}
