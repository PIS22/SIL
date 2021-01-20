package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.GroupUser;

@Repository
public interface GroupUserRepository extends JpaRepository<GroupUser, String> {

	
}
