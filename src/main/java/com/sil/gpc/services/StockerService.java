package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Magasin;
import com.sil.gpc.domains.Stocker;
import com.sil.gpc.repositories.StockerRepository;

@Service
public class StockerService {

	// @Autowired
	private final StockerRepository stockerRepository;

	public StockerService(StockerRepository stockerRepository) {
		this.stockerRepository = stockerRepository;
	}

	// Sauvegarder
	public Stocker save(Stocker stock) {
		return this.stockerRepository.save(stock);
	}

	// Editer
	public Stocker edit(Long idStocker, Stocker stock) {

		Stocker stockmod = this.stockerRepository.getOne(idStocker);
		if (stockmod != null) {
			stockmod.setQuantiterStocker(stock.getQuantiterStocker());
			stockmod.setStockDeSecuriter(stock.getStockDeSecuriter());
			stockmod.setstockMinimal(stock.getStockMinimal());
			stockmod.setCmup(stock.getCmup());
			stockmod.setArticle(stock.getArticle());
			stockmod.setMagasin(stock.getMagasin());
			return this.stockerRepository.save(stockmod);
		}
		return null;
	}

	// Supprimer
	public boolean delete(Long id) {
		if (this.stockerRepository.existsById(id))
			this.stockerRepository.deleteById(id);

		return this.stockerRepository.existsById(id);
	}

	//
	public Optional<Stocker> findById(Long idStocker) {
		return this.stockerRepository.findById(idStocker);
	}

	// Liste
	public List<Stocker> getAll() {
		return this.stockerRepository.findAll();
	}

	//
	public List<Stocker> findByIdStocker(Long IdStocker) {

		return this.stockerRepository.findByIdStocker(IdStocker);
	}

	//
	public List<Stocker> findByQuantiterStocker(Long QuantiterStocker) {

		return this.stockerRepository.findByQuantiterStocker(QuantiterStocker);
	}

	//
	public List<Stocker> findByStockDeSecuriter(Long StockDeSecuriter) {

		return this.stockerRepository.findByStockDeSecuriter(StockDeSecuriter);
	}

	//
	public List<Stocker> findByStockMinimal(Long StockMinimal) {

		return this.stockerRepository.findByStockMinimal(StockMinimal);
	}

	//
	public List<Stocker> findByCmup(Long Cmup) {

		return this.stockerRepository.findByCmup(Cmup);
	}

	//
	public List<Stocker> findByStockerArticle(Article art) {

		return this.stockerRepository.findByArticle(art);
	}

	//
	public List<Stocker> findByStockerMagasin(Magasin mag) {

		return this.stockerRepository.findByMagasin(mag);
	}

	public Stocker ligneStocker(Article a, String cMag) {
		return stockerRepository.ligneStocker(a.getCodeArticle(), cMag);
	}

}
