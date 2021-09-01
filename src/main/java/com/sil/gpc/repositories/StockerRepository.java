
package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
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

}
