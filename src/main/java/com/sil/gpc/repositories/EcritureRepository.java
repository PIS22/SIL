package com.sil.gpc.repositories;

import com.sil.gpc.domains.OpCaisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Ecriture;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EcritureRepository extends JpaRepository<Ecriture, String> {
    @Query(value = "SELECT * FROM ecriture WHERE id_utilisateur = :userId AND id_jrn = :jrnId and dat_saisie>=current_Date ", nativeQuery = true)
    List<Ecriture> getAllEcritureOfDay(@Param("userId") Long userId, @Param("jrnId") Long jrnId);

    @Query(value = "SELECT * FROM ecriture WHERE code_exercice like ? AND id_jrn=? AND \n" +
            "\textract(month from dat_saisie) = extract(month from current_date ) \n" +
            "\torder by ordre DESC;", nativeQuery = true)
    public Ecriture ordre(String exo, int jrn);


}
