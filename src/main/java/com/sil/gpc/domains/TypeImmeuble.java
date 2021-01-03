package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class TypeImmeuble implements Serializable {

	@Id
	private String codeTypIm;
	private String libTypIm;

	// Liaison avec Immeuble
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Immeuble.class, mappedBy = "typeImmeuble")
	public List<Immeuble> immeublesParType;

	public TypeImmeuble() {
		super();
	}

	public TypeImmeuble(String codeTypIm, String libTypIm) {
		super();
		this.codeTypIm = codeTypIm;
		this.libTypIm = libTypIm;
	}

	public String getCodeTypIm() {
		return codeTypIm;
	}

	public void setCodeTypIm(String codeTypIm) {
		this.codeTypIm = codeTypIm;
	}

	public String getLibTypIm() {
		return libTypIm;
	}

	public void setLibTypIm(String libTypIm) {
		this.libTypIm = libTypIm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeTypIm == null) ? 0 : codeTypIm.hashCode());
		result = prime * result + ((libTypIm == null) ? 0 : libTypIm.hashCode());
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
		TypeImmeuble other = (TypeImmeuble) obj;
		if (codeTypIm == null) {
			if (other.codeTypIm != null)
				return false;
		} else if (!codeTypIm.equals(other.codeTypIm))
			return false;
		if (libTypIm == null) {
			if (other.libTypIm != null)
				return false;
		} else if (!libTypIm.equals(other.libTypIm))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TypeImmeuble [codeTypIm=" + codeTypIm + ", libTypIm=" + libTypIm + "]";
	}

}
