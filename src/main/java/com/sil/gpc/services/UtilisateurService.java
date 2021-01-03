package com.sil.gpc.services;


import com.sil.gpc.domains.Utilisateur;

import com.sil.gpc.repositories.UtilisateurRepository;
import java.util.List;

public class UtilisateurService {

	private final UtilisateurRepository userRepository;

    public UtilisateurService(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Liste Uniter
    public List<Utilisateur> findAll() {
        return  this.userRepository.findAll();
    }
    
    // Renvoie un Uniter par son code
    public Utilisateur findById(Long Utilisateur) {
        return this.userRepository.getOne(Utilisateur);
    }
    
    // Sauvegarder un Uniter
    public Utilisateur save(Utilisateur user) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.userRepository.save(user);
    }
    
    // Editer un Uniter
    public Utilisateur edit(Utilisateur user) {
        return   this.userRepository.save(user);
    }
    
    // Supprimer un Uniter
    public void delete(Utilisateur  receptPercep) {
         this.userRepository.delete(receptPercep);
    }   

}
