package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.TresCom;

@Repository
public interface TresComRepository extends JpaRepository<TresCom, String> {
	
	public List<TresCom> findByIdRp(String idRp);


}
