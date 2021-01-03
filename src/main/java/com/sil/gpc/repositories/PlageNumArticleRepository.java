package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.PlageNumArticle;

@Repository
public interface PlageNumArticleRepository extends JpaRepository<PlageNumArticle, Long>{

}
