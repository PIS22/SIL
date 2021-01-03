
package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.sil.gpc.domains.TypeImmeuble;

@Repository
public interface TypeImmeubleRepository extends JpaRepository<TypeImmeuble, String> {
	public List<TypeImmeuble> findByLibeTypIm(String libTypIM);

}
