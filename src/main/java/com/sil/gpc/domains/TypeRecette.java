package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class TypeRecette implements Serializable{
	
	@Id
	private String codeTypRec;
	private String libeTypRec;
	
	public TypeRecette() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeRecette(String codeTypRec, String libeTypRec) {
		super();
		this.codeTypRec = codeTypRec;
		this.libeTypRec = libeTypRec;
	}

	public String getCodeTypRec() {
		return codeTypRec;
	}

	public void setCodeTypRec(String codeTypRec) {
		this.codeTypRec = codeTypRec;
	}

	public String getLibeTypRec() {
		return libeTypRec;
	}

	public void setLibeTypRec(String libeTypRec) {
		this.libeTypRec = libeTypRec;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeTypRec, libeTypRec);
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
		TypeRecette other = (TypeRecette) obj;
		return Objects.equals(codeTypRec, other.codeTypRec) && Objects.equals(libeTypRec, other.libeTypRec);
	}

	@Override
	public String toString() {
		return "TypeRecette [codeTypRec=" + codeTypRec + ", libeTypRec=" + libeTypRec + "]";
	}
	
}
