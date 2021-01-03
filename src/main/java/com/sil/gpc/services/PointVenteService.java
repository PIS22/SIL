package com.sil.gpc.services;


import com.sil.gpc.domains.PointVente;

import com.sil.gpc.repositories.PointVenteRepository;
import java.util.List;

public class PointVenteService {

	private final PointVenteRepository pointVenteRepository;

    public PointVenteService(PointVenteRepository pointVenteRepository) {
        this.pointVenteRepository = pointVenteRepository;
    }

    // Liste Uniter
    public List<PointVente> findAll() {
        return  this.pointVenteRepository.findAll();
    }
    
    // Renvoie un Uniter par son code
    public PointVente findById(String numPointVente) {
        return this.pointVenteRepository.getOne(numPointVente);
    }
    
    // Sauvegarder un Uniter
    public PointVente save(PointVente pv) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.pointVenteRepository.save(pv);
    }
    
    // Editer un Uniter
    public PointVente edit(PointVente pv) {
        return   this.pointVenteRepository.save(pv);
    }
    
    // Supprimer un Uniter
    public void delete(PointVente  pv) {
         this.pointVenteRepository.delete(pv);
    }   

}
