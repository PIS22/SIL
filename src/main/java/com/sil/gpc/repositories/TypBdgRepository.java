package com.sil.gpc.repositories;

import com.sil.gpc.domains.TypeBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypBdgRepository extends JpaRepository<TypeBudget, Long> {
}
