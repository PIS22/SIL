package com.sil.gpc.repositories;

import com.sil.gpc.domains.LigneBudgetaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneBudgetRepository extends JpaRepository<LigneBudgetaire, Long> {
}
