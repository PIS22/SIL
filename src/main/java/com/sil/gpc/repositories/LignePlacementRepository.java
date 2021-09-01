package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LignePlacement;

@Repository
public interface LignePlacementRepository extends JpaRepository<LignePlacement, Long>{

	public List<LignePlacement> findByArticle(Article article);
	public List<LignePlacement> findByQuantiteLignePlacement(double qte);
	public List<LignePlacement> findByPULignePlacement(double prix);
	}
