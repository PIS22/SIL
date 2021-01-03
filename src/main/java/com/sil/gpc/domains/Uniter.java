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
public class Uniter implements Serializable{

	@Id
	private String codeUniter;
	private String libUniter;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Article.class,mappedBy = "unite")
	public List<Article> articleParUniter;
	
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
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public String toString() {
		return "Uniter [codeUniter=" + codeUniter + ", libUniter=" + libUniter + "]";
	}
	
	
}
