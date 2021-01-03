package com.sil.gpc.domains;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reception {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 12)
	private String numReception;
	@Column(length = 150)
	private String observation;
	private Date DateReception;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = LigneReception.class, mappedBy = "reception")
	public List<Reception> lignesParReception;
	
	//L'attribut exercice ou code exercice à été ignoré
	
	public Reception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reception(String numReception, String observation, Date dateReception, List<Reception> lignesParReception) {
		super();
		this.numReception = numReception;
		this.observation = observation;
		DateReception = dateReception;
		this.lignesParReception = lignesParReception;
	}

	public String getNumReception() {
		return numReception;
	}

	public void setNumReception(String numReception) {
		this.numReception = numReception;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getDateReception() {
		return DateReception;
	}

	public void setDateReception(Date dateReception) {
		DateReception = dateReception;
	}

	public List<Reception> getLignesParReception() {
		return lignesParReception;
	}

	public void setLignesParReception(List<Reception> lignesParReception) {
		this.lignesParReception = lignesParReception;
	}
	
	
}
