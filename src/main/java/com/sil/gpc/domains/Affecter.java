package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Affecter implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAffecter;
	private Date dateDebAffecter;
	private Date dateFinAffecter;
	
	//Liaison à la caisse
	@ManyToOne(targetEntity = Caisse.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeCaisse", referencedColumnName = "codeCaisse", nullable = false)
	private Caisse caisse;
	
	//Liaison à l'utilisateur
	@ManyToOne(targetEntity = Utilisateur.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur", nullable = false)
	private Utilisateur utilisateur;
	
	public Affecter() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**@author LISA
	 * @param idAffecter
	 * @param dateDebAffecter
	 * @param dateFinAffecter
	 * @param caisse
	 * @param utilisateur
	 */
	public Affecter(Long idAffecter, Date dateDebAffecter, Date dateFinAffecter, Caisse caisse,
			Utilisateur utilisateur) {
		this.idAffecter = idAffecter;
		this.dateDebAffecter = dateDebAffecter;
		this.dateFinAffecter = dateFinAffecter;
		this.caisse = caisse;
		this.utilisateur = utilisateur;
	}


	public Date getDateDebAffecter() {
		return dateDebAffecter;
	}
	public void setDateDebAffecter(Date dateDebAffecter) {
		this.dateDebAffecter = dateDebAffecter;
	}
	
	public Date getDateFinAffecter() {
		return dateFinAffecter;
	}
	public void setDateFinAffecter(Date dateFinAffecter) {
		this.dateFinAffecter = dateFinAffecter;
	}
	
	public Caisse getCaisse() {
		return caisse;
	}
	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}
	
	/**
	 * @return the idAffecter
	 */
	public Long getIdAffecter() {
		return idAffecter;
	}
	/**
	 * @param idAffecter the idAffecter to set
	 */
	public void setIdAffecter(Long idAffecter) {
		this.idAffecter = idAffecter;
	}
	
	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caisse, dateDebAffecter, dateFinAffecter, idAffecter, utilisateur);
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
		Affecter other = (Affecter) obj;
		return Objects.equals(caisse, other.caisse) && Objects.equals(dateDebAffecter, other.dateDebAffecter)
				&& Objects.equals(dateFinAffecter, other.dateFinAffecter)
				&& Objects.equals(idAffecter, other.idAffecter) && Objects.equals(utilisateur, other.utilisateur);
	}

	@Override
	public String toString() {
		return "Affecter [idAffecter=" + idAffecter + ", dateDebAffecter=" + dateDebAffecter + ", dateFinAffecter="
				+ dateFinAffecter + ", caisse=" + caisse + ", utilisateur=" + utilisateur + "]";
	}
	
}
