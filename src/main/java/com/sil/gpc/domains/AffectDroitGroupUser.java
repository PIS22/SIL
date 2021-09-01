package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AffectDroitGroupUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAffectDroitGroup;
	//Liaison  avec Droits des Utilisateurs
		@ManyToOne(fetch = FetchType.EAGER,targetEntity = DroitUser.class)
		@JoinColumn(name="idDroitUser", referencedColumnName = "idDroitUser", nullable = false)
		private DroitUser droitUser;
	//Liaison  Groupe Utilisateur
		@ManyToOne(fetch = FetchType.EAGER,targetEntity = GroupUser.class)
		@JoinColumn(name="idGroupUser", referencedColumnName = "idGroupUser", nullable = false)
		private GroupUser groupUser ;
		
		public AffectDroitGroupUser() {
			super();
			// TODO Auto-generated constructor stub
		}

		public AffectDroitGroupUser(DroitUser droitUser, GroupUser groupUser) {
			super();
			this.droitUser = droitUser;
			this.groupUser = groupUser;
		}

		public Long getIdAffectDroitGroup() {
			return idAffectDroitGroup;
		}

		public void setIdAffectDroitGroup(Long idAffectDroitGroup) {
			this.idAffectDroitGroup = idAffectDroitGroup;
		}

		public DroitUser getDroitUser() {
			return droitUser;
		}

		public void setDroitUser(DroitUser droitUser) {
			this.droitUser = droitUser;
		}

		public GroupUser getGroupUser() {
			return groupUser;
		}

		public void setGroupUser(GroupUser groupUser) {
			this.groupUser = groupUser;
		}

		@Override
		public String toString() {
			return "AffectDroitGroupUser [idAffectDroitGroup=" + idAffectDroitGroup + ", droitUser=" + droitUser
					+ ", groupUser=" + groupUser + "]";
		}
		
	
	

}
