package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.DroitUser;

@Repository
public interface DroitUserRepository extends JpaRepository<DroitUser, Long> {

	List<DroitUser> findByIdDroitUser(Long idDroitUser);
	List<DroitUser> findByCodeDroitUser(String codeDroitUser);
	List<DroitUser> findByLibDroitUser(String libDroitUser);
	
}
