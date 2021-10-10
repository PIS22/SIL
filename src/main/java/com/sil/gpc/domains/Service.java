package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Service implements Serializable {

	@Id
	private String codeService;
	private String libService;
	
	public Service() {
		super();
	}

	public Service(String codeService, String libService) {
		super();
		this.codeService = codeService;
		this.libService = libService;
	}

	public String getCodeService() {
		return codeService;
	}

	public void setCodeService(String codeService) {
		this.codeService = codeService;
	}

	public String getLibService() {
		return libService;
	}

	public void setLibService(String libService) {
		this.libService = libService;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeService == null) ? 0 : codeService.hashCode());
		result = prime * result + ((libService == null) ? 0 : libService.hashCode());
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
		Service other = (Service) obj;
		if (codeService == null) {
			if (other.codeService != null)
				return false;
		} else if (!codeService.equals(other.codeService))
			return false;
		if (libService == null) {
			if (other.libService != null)
				return false;
		} else if (!libService.equals(other.libService))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Service [codeService=" + codeService + ", libService=" + libService + "]";
	}
	
	
}
