
package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Magasin;
import com.sil.gpc.domains.Stocker;

@Repository
public interface StockerRepository extends JpaRepository<Stocker, Long> {

	public List<Stocker> findByIdStocker(Long IdStocker);

	public List<Stocker> findByQuantiterStocker(Long QuantiterStocker);

	public List<Stocker> findByStockDeSecuriter(Long StockDeSecuriter);

	public List<Stocker> findByStockMinimal(Long StockMinimal);

	public List<Stocker> findByCmup(Long Cmup);

	public List<Stocker> findByArticle(Article art);

	public List<Stocker> findByMagasin(Magasin mag);

	@Query(value = "SELECT * FROM Stocker WHERE codeArticle=?1 AND codeMagasin=?2", nativeQuery = true)
	public Stocker ligneStocker(String cArt, String cMag);

}
