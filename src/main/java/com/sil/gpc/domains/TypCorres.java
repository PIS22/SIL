package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class TypCorres implements Serializable {

	@Id
	private String codeTypCorres;
	private String libTypeCorres;
	
	public TypCorres() {
		super();
	}

	public TypCorres(String codeTypCorres, String libTypeCorres) {
		super();
		this.codeTypCorres = codeTypCorres;
		this.libTypeCorres = libTypeCorres;
	}

	public String getCodeTypCorres() {
		return codeTypCorres;
	}

	public void setCodeTypCorres(String codeTypCorres) {
		this.codeTypCorres = codeTypCorres;
	}

	public String getLibTypeCorres() {
		return libTypeCorres;
	}

	public void setLibTypeCorres(String libTypeCorres) {
		this.libTypeCorres = libTypeCorres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeTypCorres == null) ? 0 : codeTypCorres.hashCode());
		result = prime * result + ((libTypeCorres == null) ? 0 : libTypeCorres.hashCode());
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
		TypCorres other = (TypCorres) obj;
		if (codeTypCorres == null) {
			if (other.codeTypCorres != null)
				return false;
		} else if (!codeTypCorres.equals(other.codeTypCorres))
			return false;
		if (libTypeCorres == null) {
			if (other.libTypeCorres != null)
				return false;
		} else if (!libTypeCorres.equals(other.libTypeCorres))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TypCorres [codeTypCorres=" + codeTypCorres + ", libTypeCorres=" + libTypeCorres + "]";
	}
	
	
}
