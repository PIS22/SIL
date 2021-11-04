package com.sil.gpc.repositories;

import com.sil.gpc.domains.LigneEcriture;
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

    @Query(value = "SELECT * FROM ecriture WHERE code_exercice like ? AND id_jrn=? AND" +
            "\textract(month from dat_saisie) = extract(month from current_date ) \n" +
            "\torder by ordre DESC LIMIT 1;", nativeQuery = true)
    public Ecriture ordre(String exo, Long jrn);

    @Query(value="SELECT distinct ecriture.* FROM ecriture inner join ligne_ecriture on ecriture.num_ecri = \n" +
            "\tligne_ecriture.num_ecri inner join compte on ligne_ecriture.id_cpte = compte.id_cpte\n" +
            "WHERE ecriture.id_jrn= :jrn and ecriture.id_utilisateur= :user AND (ecriture.descript like '%?%' OR \n" +
            "\tecriture.num_ecri like :val OR ecriture.ref_extern like :val \n" +
            "\tOR ligne_ecriture.observation like :val OR  compte.lib_cpte like :val)", nativeQuery=true)
    public List<Ecriture> getEcriUserByVal(Long jrn, Long user, String val);


}
