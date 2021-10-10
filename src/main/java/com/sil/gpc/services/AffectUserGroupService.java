package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.AffectUserGroup;
import com.sil.gpc.domains.GroupUser;
import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.repositories.AffectUserGroupRepository;

@Service
public class AffectUserGroupService {

	private final AffectUserGroupRepository repo;

	public AffectUserGroupService(AffectUserGroupRepository repo) {
		super();
		this.repo = repo;
	}

    // Sauvegarder 
    public AffectUserGroup save(AffectUserGroup guser) {
    	return repo.save(guser);
    }
    
    // Editer 
    public AffectUserGroup edit(Long id, AffectUserGroup guser) {
       	if(repo.existsById(id)) {
   			AffectUserGroup por=repo.getOne(id);
   			por.setUtilisateur(guser.getUtilisateur());
   			por.setGroupUser(guser.getGroupUser());
   			return this.repo.save(por);
       }
   		return null;
       }
    
    // Supprimer 
    public boolean delete(Long  id) {
    	if(this.repo.existsById(id))
            this.repo.deleteById(id);
    	
    return !this.repo.existsById(id);
    }
    
    // 
    public Optional<AffectUserGroup> findById(Long id) {
        return this.repo.findById(id);
    }
    
    // 
    public List<AffectUserGroup> findByGroups(GroupUser g) {
        return this.repo.findByGroupUser(g);
    }
    
    // 
    public List<AffectUserGroup> findByUser(Utilisateur u) {
        return this.repo.findByUtilisateur(u);
    }
   
    // Liste 
    public List<AffectUserGroup> getAll() {
        return  this.repo.findAll();
    }
    
}
