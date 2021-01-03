package com.sil.gpc.services;


import com.sil.gpc.domains.Stocker;

import com.sil.gpc.repositories.StockerRepository;
import java.util.List;

public class StockerService {

	// @Autowired
    private final StockerRepository stockerRepository;

    public StockerService(StockerRepository stockerRepository) {
        this.stockerRepository = stockerRepository;
    }

    // Liste Uniter
    public List<Stocker> findAll() {
        return  this.stockerRepository.findAll();
    }
    
    // Renvoie un Uniter par son code
    public Stocker findById(Long idStocker) {
        return this.stockerRepository.getOne(idStocker);
    }
    
    // Sauvegarder un Uniter
    public Stocker save(Stocker stock) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.stockerRepository.save(stock);
    }
    
    // Editer un Uniter
    public Stocker edit(Stocker stock) {
        return   this.stockerRepository.save(stock);
    }
    
    // Supprimer un Uniter
    public void delete(Stocker stock) {
         this.stockerRepository.delete(stock);
    }   

}
