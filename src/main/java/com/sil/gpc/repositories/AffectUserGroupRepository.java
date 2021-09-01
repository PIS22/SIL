package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.AffectUserGroup;
import com.sil.gpc.domains.GroupUser;
import com.sil.gpc.domains.Utilisateur;

@Repository
public interface AffectUserGroupRepository extends JpaRepository<AffectUserGroup, Long>{

	List<AffectUserGroup> findByGroupUser(GroupUser groupUser);
	List<AffectUserGroup> findByUtilisateur(Utilisateur utilisateur);
}
