
package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Stocker;

@Repository
public interface StockerRepository extends JpaRepository<Stocker, Long> {

}
