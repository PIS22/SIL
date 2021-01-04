package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LignePointVente;

@Repository
public interface LignePointVenteRepository extends JpaRepository<LignePointVente, Long>{

	public List<LignePointVente> findByArticle(Article article);
	public List<LignePointVente> findByQte(double qte);
	public List<LignePointVente> findByPrix(double prix); 
}
