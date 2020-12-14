package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Uniter {

	@Id
	private String codeUniter;
	private String libUniter;
	
	public Uniter() {
		super();
	}

	public Uniter(String codeUniter, String libUniter) {
		super();
		this.codeUniter = codeUniter;
		this.libUniter = libUniter;
	}

	public String getCodeUniter() {
		return codeUniter;
	}

	public void setCodeUniter(String codeUniter) {
		this.codeUniter = codeUniter;
	}

	public String getLibUniter() {
		return libUniter;
	}

	public void setLibUniter(String libUniter) {
		this.libUniter = libUniter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeUniter == null) ? 0 : codeUniter.hashCode());
		result = prime * result + ((libUniter == null) ? 0 : libUniter.hashCode());
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
		Uniter other = (Uniter) obj;
		if (codeUniter == null) {
			if (other.codeUniter != null)
				return false;
		} else if (!codeUniter.equals(other.codeUniter))
			return false;
		if (libUniter == null) {
			if (other.libUniter != null)
				return false;
		} else if (!libUniter.equals(other.libUniter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Uniter [codeUniter=" + codeUniter + ", libUniter=" + libUniter + "]";
	}
	
	
}
