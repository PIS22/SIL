package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GroupUser {

	@Id
	private String idGroupUser;
	private String libGroupUser;
	
	public GroupUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupUser(String idGroupUser, String libGroupUser) {
		super();
		this.idGroupUser = idGroupUser;
		this.libGroupUser = libGroupUser;
	}

	public String getIdGroupUser() {
		return idGroupUser;
	}

	public void setIdGroupUser(String idGroupUser) {
		this.idGroupUser = idGroupUser;
	}

	public String getLibGroupUser() {
		return libGroupUser;
	}

	public void setLibGroupUser(String libGroupUser) {
		this.libGroupUser = libGroupUser;
	}

	@Override
	public String toString() {
		return "GroupUser [idGroupUser=" + idGroupUser + ", libGroupUser=" + libGroupUser + "]";
	}
	
	
}
