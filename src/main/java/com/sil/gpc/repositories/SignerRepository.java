package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Signer;

@Repository
public interface SignerRepository extends JpaRepository<Signer, Long> {
	@Query(value = "Select * from signer WHERE dat_fin=null", nativeQuery = true)
	public List<Signer> signatairesActuel();

}
