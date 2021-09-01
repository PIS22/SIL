package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.AffectDroitGroupUser;
import com.sil.gpc.domains.DroitUser;
import com.sil.gpc.domains.GroupUser;

@Repository
public interface AffectDroitGroupUserRepository extends JpaRepository<AffectDroitGroupUser, Long>{

	List<AffectDroitGroupUser> findByGroupUser(GroupUser groupUser);
	List<AffectDroitGroupUser> findByDroitUser(DroitUser droitUser);
}
