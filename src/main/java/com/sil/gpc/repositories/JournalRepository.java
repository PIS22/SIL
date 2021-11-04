package com.sil.gpc.repositories;

import com.sil.gpc.domains.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Journal;

import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
    @Query(value="select * FROM compte WHERE typ_cpte like 'E' AND num_cpte like ?", nativeQuery=true)
    public List<Compte> eligible(String nCpte);

    @Query(value="select * from journal where cod_jrn not like ?", nativeQuery=true)
    public List<Journal> autreJrn(String cjrn);
}
