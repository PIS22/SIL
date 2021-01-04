package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LigneOpCaisse;

public interface LigneOpCaisseRepository extends JpaRepository<LigneOpCaisse, Long> {

	public List<LigneOpCaisse> findByArticle(Article article);

	public List<LigneOpCaisse> findByQteLigneOperCaisse(double qte);

	public List<LigneOpCaisse> findByPrix(double prix);

}
