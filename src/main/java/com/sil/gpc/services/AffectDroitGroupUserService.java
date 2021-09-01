package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.AffectDroitGroupUser;
import com.sil.gpc.domains.DroitUser;
import com.sil.gpc.domains.GroupUser;
import com.sil.gpc.repositories.AffectDroitGroupUserRepository;

@Service
public class AffectDroitGroupUserService {

	private final AffectDroitGroupUserRepository repo;

	public AffectDroitGroupUserService(AffectDroitGroupUserRepository repo) {
		super();
		this.repo = repo;
	}


    // Sauvegarder 
    public AffectDroitGroupUser save(AffectDroitGroupUser dguser) {
    	return repo.save(dguser);
    }
    
    // Editer 
    public AffectDroitGroupUser edit(Long id, AffectDroitGroupUser dguser) {
       	if(repo.existsById(id)) {
   			AffectDroitGroupUser por=repo.getOne(id);
   			por.setGroupUser(dguser.getGroupUser());
   			por.setDroitUser(dguser.getDroitUser());
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
    public Optional<AffectDroitGroupUser> findById(Long id) {
        return this.repo.findById(id);
    }
    
    // 
    public List<AffectDroitGroupUser> findByDroit(DroitUser du) {
        return this.repo.findByDroitUser(du);
    }
    
    // 
    public List<AffectDroitGroupUser> findByGroup(GroupUser gu) {
        return this.repo.findByGroupUser(gu);
    }
   
    // Liste 
    public List<AffectDroitGroupUser> getAll() {
        return  this.repo.findAll();
    }
    
}
