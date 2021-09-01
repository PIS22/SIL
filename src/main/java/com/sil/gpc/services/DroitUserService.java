package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.DroitUser;
import com.sil.gpc.repositories.DroitUserRepository;

@Service
public class DroitUserService {

	private final DroitUserRepository repo;

	public DroitUserService(DroitUserRepository repo) {
		super();
		this.repo = repo;
	}

    // Sauvegarder 
    public DroitUser save(DroitUser duser) {
    	return repo.save(duser);
    }
    
    // Editer 
    public DroitUser edit(Long id, DroitUser duser) {
       	if(repo.existsById(id)) {
   			DroitUser por=repo.getOne(id);
   			por.setCodeDroitUser(duser.getCodeDroitUser());
   			por.setLibDroitUser(duser.getLibDroitUser());
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
    public Optional<DroitUser> findById(Long id) {
        return this.repo.findById(id);
    }
    
    // 
    public List<DroitUser> findByCodedroit(String cdu) {
        return this.repo.findByCodeDroitUser(cdu);
    }
    
    // 
    public List<DroitUser> findByLibDroitId(String libDroit) {
        return this.repo.findByLibDroitUser(libDroit);
    }
   
    // Liste 
    public List<DroitUser> getAll() {
        return  this.repo.findAll();
    }
    
}
