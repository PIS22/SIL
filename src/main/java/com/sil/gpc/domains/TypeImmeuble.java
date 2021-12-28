package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class TypeImmeuble implements Serializable {

	@Id
	private String codeTypIm;
	private String libTypIm;
	private boolean valUnit;
	private boolean valSuperfi;
	private boolean valFace;
	private boolean valPlace;
	private double periodiciterJrs;
	private String nomUnePeriode;

	public TypeImmeuble() {
		super();
	}


	

	public TypeImmeuble(String codeTypIm, String libTypIm, boolean valUnit, boolean valSuperfi, boolean valFace,
			boolean valPlace, double periodiciterJrs, String nomUnePeriode) {
		super();
		this.codeTypIm = codeTypIm;
		this.libTypIm = libTypIm;
		this.valUnit = valUnit;
		this.valSuperfi = valSuperfi;
		this.valFace = valFace;
		this.valPlace = valPlace;
		this.periodiciterJrs = periodiciterJrs;
		this.nomUnePeriode = nomUnePeriode;
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




	public boolean isValUnit() {
		return valUnit;
	}




	public void setValUnit(boolean valUnit) {
		this.valUnit = valUnit;
	}




	public boolean isValSuperfi() {
		return valSuperfi;
	}




	public void setValSuperfi(boolean valSuperfi) {
		this.valSuperfi = valSuperfi;
	}




	public boolean isValFace() {
		return valFace;
	}




	public void setValFace(boolean valFace) {
		this.valFace = valFace;
	}




	public boolean isValPlace() {
		return valPlace;
	}




	public void setValPlace(boolean valPlace) {
		this.valPlace = valPlace;
	}




	public double getPeriodiciterJrs() {
		return periodiciterJrs;
	}




	public void setPeriodiciterJrs(double periodiciterJrs) {
		this.periodiciterJrs = periodiciterJrs;
	}




	public String getNomUnePeriode() {
		return nomUnePeriode;
	}




	public void setNomUnePeriode(String nomUnePeriode) {
		this.nomUnePeriode = nomUnePeriode;
	}


	@Override
	public String toString() {
		return "TypeImmeuble [codeTypIm=" + codeTypIm + ", libTypIm=" + libTypIm + ", valUnit=" + valUnit
				+ ", valSuperfi=" + valSuperfi + ", valFace=" + valFace + ", valPlace=" + valPlace
				+ ", periodiciterJrs=" + periodiciterJrs + ", nomUnePeriode=" + nomUnePeriode + "]";
	}
	
	

}
