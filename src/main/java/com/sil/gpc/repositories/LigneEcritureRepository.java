package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneEcriture;

import java.util.List;

@Repository
public interface LigneEcritureRepository extends JpaRepository<LigneEcriture, Long> {

    @Query(value = "SELECT * FROM ligne_ecriture WHERE num_ecri = ? ", nativeQuery = true)
    public List<LigneEcriture> linesOf(String num);

}
