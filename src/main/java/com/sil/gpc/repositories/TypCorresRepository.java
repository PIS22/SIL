
package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.TypCorres;

@Repository
public interface TypCorresRepository extends JpaRepository<TypCorres, String> {

}
