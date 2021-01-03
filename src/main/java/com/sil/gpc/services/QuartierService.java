package com.sil.gpc.services;


import com.sil.gpc.domains.Quartier;
import com.sil.gpc.repositories.QuartierRepository;
import java.util.List;

public class QuartierService {

	// @Autowired
    private final QuartierRepository quartierRepository;

    public QuartierService(QuartierRepository quartierRepository) {
        this.quartierRepository = quartierRepository;
    }

    // Liste des Quartier
    public List<Quartier> findAll() {
        return  this.quartierRepository.findAll();
    }
    
    // Renvoie un Quartier par son code
    public Quartier findById(String codeQuartier) {
        return this.quartierRepository.getOne(codeQuartier);
    }
    
    // Sauvegarder un Quartier
    public Quartier save(Quartier quartier) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.quartierRepository.save(quartier);
    }
    
    // Editer un Quartier
    public Quartier edit(Quartier quartier) {
        return   this.quartierRepository.save(quartier);
    }
    
    // Supprimer un Quartier
    public void delete(Quartier quartier) {
         this.quartierRepository.delete(quartier);
    }   
    
    //liste par libelle
    public List<Quartier> findBylibelle(String libQuartier){
		
		return this.quartierRepository.findBylibQuartier(libQuartier);
	}

}
