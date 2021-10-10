package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstituReverse {
	
	@Id
	private String codeInstRevers;
	private String libInstRevers;
	
	public InstituReverse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstituReverse(String codeInstRevers, String libInstRevers) {
		super();
		this.codeInstRevers = codeInstRevers;
		this.libInstRevers = libInstRevers;
	}

	public String getCodeInstRevers() {
		return codeInstRevers;
	}

	public void setCodeInstRevers(String codeInstRevers) {
		this.codeInstRevers = codeInstRevers;
	}

	public String getLibInstRevers() {
		return libInstRevers;
	}

	public void setLibInstRevers(String libInstRevers) {
		this.libInstRevers = libInstRevers;
	}

	@Override
	public String toString() {
		return "InstituReverse [codeInstRevers=" + codeInstRevers + ", libInstRevers=" + libInstRevers + "]";
	}
	
	

}
