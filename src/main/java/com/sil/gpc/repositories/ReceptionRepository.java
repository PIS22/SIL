
package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Reception;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception, String> {

}
