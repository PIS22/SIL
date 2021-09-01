
package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.TypCorres;

@Repository
public interface TypCorresRepository extends JpaRepository<TypCorres, String> {
	
	public List<TypCorres> findByCodeTypCorres(String TypCorres);
	
	public List<TypCorres> findByLibTypeCorres(String libelleTypCorres);

}
