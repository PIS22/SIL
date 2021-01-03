package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Rp implements Serializable{

	@Id
	private String idRp;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity =Magasinier.class)
	@JoinColumn(name ="numMagasinier", referencedColumnName = "numMagasinier",nullable = false )
	private Magasinier magasinier;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity =Utilisateur.class)
	@JoinColumn(name ="idUtilisateur", referencedColumnName = "idUtilisateur",nullable = false )
	private Utilisateur utilisateur;
	
	public Rp(String idRp, Magasinier magasinier, Utilisateur utilisateur) {
		super();
		this.idRp = idRp;
		this.magasinier = magasinier;
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the idRp
	 */
	public String getIdRp() {
		return idRp;
	}

	/**
	 * @param idRp the idRp to set
	 */
	public void setIdRp(String idRp) {
		this.idRp = idRp;
	}

	/**
	 * @return the magasinier
	 */
	public Magasinier getMagasinier() {
		return magasinier;
	}

	/**
	 * @param magasinier the magasinier to set
	 */
	public void setMagasinier(Magasinier magasinier) {
		this.magasinier = magasinier;
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

	public Rp() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRp, magasinier, utilisateur);
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
		Rp other = (Rp) obj;
		return Objects.equals(idRp, other.idRp) && Objects.equals(magasinier, other.magasinier)
				&& Objects.equals(utilisateur, other.utilisateur);
	}

	@Override
	public String toString() {
		return "Rp [idRp=" + idRp + ", magasinier=" + magasinier + ", utilisateur=" + utilisateur + "]";
	}
	
}
