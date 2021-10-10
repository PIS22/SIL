package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class TresCom implements Serializable{

	@Id
	private String idRp;

	@OneToOne(fetch = FetchType.EAGER,targetEntity =Magasinier.class)
	@JoinColumn(name ="numMagasinier", referencedColumnName = "numMagasinier",nullable = false )
	private Magasinier magasinier;

	@OneToOne(fetch = FetchType.EAGER,targetEntity =Utilisateur.class)
	@JoinColumn(name ="idUtilisateur", referencedColumnName = "idUtilisateur",nullable = true )
	private Utilisateur utilisateur;


	public TresCom(String idRp, Magasinier magasinier, Utilisateur utilisateur) {
		this.idRp = idRp;
		this.magasinier = magasinier;
		this.utilisateur = utilisateur;
	}

	public String getIdRp() {
		return idRp;
	}

	public void setIdRp(String idRp) {
		this.idRp = idRp;
	}

	public Magasinier getMagasinier() {
		return magasinier;
	}

	public void setMagasinier(Magasinier magasinier) {
		this.magasinier = magasinier;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public TresCom() {
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
		TresCom other = (TresCom) obj;
		return Objects.equals(idRp, other.idRp) && Objects.equals(magasinier, other.magasinier)
				&& Objects.equals(utilisateur, other.utilisateur);
	}

	@Override
	public String toString() {
		return "TresCom [idRp=" + idRp + ", magasinier=" + magasinier + ", utilisateur=" + utilisateur + "]";
	}
	
}
