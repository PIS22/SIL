package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AffectUserGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAffectUserGroup;
	
	//Liaison  avec Utilisateur
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Utilisateur.class)
	@JoinColumn(name="idUtilisateur", referencedColumnName = "idUtilisateur", nullable = false)
	private Utilisateur utilisateur;
	
//Liaison  Groupe Utilisateur
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = GroupUser.class)
	@JoinColumn(name="idGroupUser", referencedColumnName = "idGroupUser", nullable = false)
	private GroupUser groupUser ;
	
	public AffectUserGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AffectUserGroup(Utilisateur utilisateur, GroupUser groupUser) {
		super();
		this.utilisateur = utilisateur;
		this.groupUser = groupUser;
	}

	public Long getIdAffectUserGroup() {
		return idAffectUserGroup;
	}

	public void setIdAffectUserGroup(Long idAffectUserGroup) {
		this.idAffectUserGroup = idAffectUserGroup;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public GroupUser getGroupUser() {
		return groupUser;
	}

	public void setGroupUser(GroupUser groupUser) {
		this.groupUser = groupUser;
	}

	@Override
	public String toString() {
		return "AffectUserGroup [idAffectUserGroup=" + idAffectUserGroup + ", utilisateur=" + utilisateur
				+ ", groupUser=" + groupUser + "]";
	}
	
		
}
