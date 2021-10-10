package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DroitUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDroitUser;
	private String codeDroitUser;
	private String libDroitUser;
	private String descriDroitUser;
	
	public DroitUser() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param codeDroitUser
	 * @param libDroitUser
	 * @param descriDroitUser
	 */
	public DroitUser(String codeDroitUser, String libDroitUser, String descriDroitUser) {
		this.codeDroitUser = codeDroitUser;
		this.libDroitUser = libDroitUser;
		this.descriDroitUser = descriDroitUser;
	}


	/**
	 * @return the idDroitUser
	 */
	public Long getIdDroitUser() {
		return idDroitUser;
	}


	/**
	 * @param idDroitUser the idDroitUser to set
	 */
	public void setIdDroitUser(Long idDroitUser) {
		this.idDroitUser = idDroitUser;
	}


	/**
	 * @return the codeDroitUser
	 */
	public String getCodeDroitUser() {
		return codeDroitUser;
	}


	/**
	 * @param codeDroitUser the codeDroitUser to set
	 */
	public void setCodeDroitUser(String codeDroitUser) {
		this.codeDroitUser = codeDroitUser;
	}


	/**
	 * @return the libDroitUser
	 */
	public String getLibDroitUser() {
		return libDroitUser;
	}


	/**
	 * @param libDroitUser the libDroitUser to set
	 */
	public void setLibDroitUser(String libDroitUser) {
		this.libDroitUser = libDroitUser;
	}


	/**
	 * @return the descriDroitUser
	 */
	public String getDescriDroitUser() {
		return descriDroitUser;
	}


	/**
	 * @param descriDroitUser the descriDroitUser to set
	 */
	public void setDescriDroitUser(String descriDroitUser) {
		this.descriDroitUser = descriDroitUser;
	}


	@Override
	public String toString() {
		return "DroitUser [idDroitUser=" + idDroitUser + ", codeDroitUser=" + codeDroitUser + ", libDroitUser="
				+ libDroitUser + ", descriDroitUser=" + descriDroitUser + "]";
	}


	
}
