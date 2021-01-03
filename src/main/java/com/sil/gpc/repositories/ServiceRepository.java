package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {
	
	public List<Service> findByLibService(String libSer);

}
