package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Approvisionnement implements Serializable {

	@Id
	private String numAppro;
	private String descriptionAppro;
	private Date dateAppro;
	@Column()
	private boolean valideAppro;
	private int valeur;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = true)
	private Exercice exercice;
	
	public Approvisionnement() {
		super();
	}

	/**
	 * @param numAppro
	 * @param descriptionAppro
	 * @param dateAppro
	 * @param valideAppro
	 * @param exercice
	 */
	public Approvisionnement(String numAppro, String descriptionAppro, Date dateAppro, boolean valideAppro,
			Exercice exercice) {
		this.numAppro = numAppro;
		this.descriptionAppro = descriptionAppro;
		this.dateAppro = dateAppro;
		this.valideAppro = valideAppro;
		this.exercice = exercice;
		valideAppro=true;
		valeur =  0;
	}

	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the numAppro
	 */
	public String getNumAppro() {
		return numAppro;
	}

	/**
	 * @param numAppro the numAppro to set
	 */
	public void setNumAppro(String numAppro) {
		this.numAppro = numAppro;
	}

	/**
	 * @return the descriptionAppro
	 */
	public String getDescriptionAppro() {
		return descriptionAppro;
	}

	/**
	 * @param descriptionAppro the descriptionAppro to set
	 */
	public void setDescriptionAppro(String descriptionAppro) {
		this.descriptionAppro = descriptionAppro;
	}

	/**
	 * @return the dateAppro
	 */
	public Date getDateAppro() {
		return dateAppro;
	}

	/**
	 * @param dateAppro the dateAppro to set
	 */
	public void setDateAppro(Date dateAppro) {
		this.dateAppro = dateAppro;
	}

	/**
	 * @return the valideAppro
	 */
	public boolean isValideAppro() {
		return valideAppro;
	}

	/**
	 * @param valideAppro the valideAppro to set
	 */
	public void setValideAppro(boolean valideAppro) {
		this.valideAppro = valideAppro;
	}

	/**
	 * @return the exercice
	 */
	public Exercice getExercice() {
		return exercice;
	}

	/**
	 * @param exercice the exercice to set
	 */
	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	@Override
	public String toString() {
		return "Approvisionnement [numAppro=" + numAppro + ", descriptionAppro=" + descriptionAppro + ", dateAppro="
				+ dateAppro + ", valideAppro=" + valideAppro + ", exercice=" + exercice + "]";
	}



}