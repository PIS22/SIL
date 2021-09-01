package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Correspondant implements Serializable {

	@Id
	private String idCorrespondant;
	private boolean imputableCorres;
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Magasinier.class)
	@JoinColumn(name = "numMagasinier", referencedColumnName = "numMagasinier", nullable = false)
	private Magasinier magasinier;

	// Liaison à typeCorresspondant
	@ManyToOne(targetEntity = TypCorres.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeTypCorres", referencedColumnName = "codeTypCorres", nullable = false)
	public TypCorres typecorres;

	// Liaison à Utilisateur
	@OneToOne(targetEntity = Utilisateur.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur", nullable = true)
	public Utilisateur utilisateur;

	public Correspondant() {
		super();
	}

	public Correspondant(String idCorrespondant, boolean imputableCorres, Magasinier magasinier, TypCorres typecorres,
			Utilisateur utilisateur) {
		super();
		this.idCorrespondant = idCorrespondant;
		this.imputableCorres = imputableCorres;
		this.magasinier = magasinier;
		//this.typecorres = typecorres;
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the idCorrespondant
	 */
	public String getIdCorrespondant() {
		return idCorrespondant;
	}

	/**
	 * @param idCorrespondant the idCorrespondant to set
	 */
	public void setIdCorrespondant(String idCorrespondant) {
		this.idCorrespondant = idCorrespondant;
	}

	/**
	 * @return the imputableCorres
	 */
	public boolean isImputableCorres() {
		return imputableCorres;
	}

	/**
	 * @param imputableCorres the imputableCorres to set
	 */
	public void setImputableCorres(boolean imputableCorres) {
		this.imputableCorres = imputableCorres;
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
	 * @return the typecorres
	 */
	public TypCorres getTypecorres() {
		return typecorres;
	}

	/**
	 * @param typecorres the typecorres to set
	 */
	public void setTypecorres(TypCorres typecorres) {
		this.typecorres = typecorres;
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
		return Objects.hash(idCorrespondant, imputableCorres, magasinier, typecorres, utilisateur);
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
		Correspondant other = (Correspondant) obj;
		return Objects.equals(idCorrespondant, other.idCorrespondant) && imputableCorres == other.imputableCorres
				&& Objects.equals(magasinier, other.magasinier) && Objects.equals(typecorres, other.typecorres)
				&& Objects.equals(utilisateur, other.utilisateur);
	}

	@Override
	public String toString() {
		return "Correspondant [idCorrespondant=" + idCorrespondant + ", imputableCorres=" + imputableCorres
				+ ", magasinier=" + magasinier + ", typecorres=" + typecorres + ", utilisateur=" + utilisateur + "]";
	}

}
