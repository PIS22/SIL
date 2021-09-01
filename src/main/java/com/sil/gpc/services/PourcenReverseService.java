package com.sil.gpc.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.PourcenReverse;
import com.sil.gpc.repositories.PourcenReverseRepository;

@Service
public class PourcenReverseService {

	private final PourcenReverseRepository repo;

	public PourcenReverseService(PourcenReverseRepository repo) {
		super();
		this.repo = repo;
	}
	

    // Sauvegarder 
    public PourcenReverse save(PourcenReverse pore) {
        return   this.repo.save(pore);
    }
    
    // Editer 
    public PourcenReverse edit(Long id, PourcenReverse pore) {
       	if(repo.existsById(id)) {
   			PourcenReverse por=repo.getOne(id);
   			por.setArticle(pore.getArticle());
   			por.setInstituReverse(pore.getInstituReverse());
   			por.setValPourcenRevers(pore.getValPourcenRevers());
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
    public Optional<PourcenReverse> findById(Long id) {
        return this.repo.findById(id);
    }
   
    // Liste 
    public List<PourcenReverse> getAll() {
        return  this.repo.findAll();
    }
    	
}
