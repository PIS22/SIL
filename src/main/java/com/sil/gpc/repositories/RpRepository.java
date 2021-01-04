package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Rp;

@Repository
public interface RpRepository extends JpaRepository<Rp, String> {
	
	public List<Rp> findByIdRp(String idRp);


}
