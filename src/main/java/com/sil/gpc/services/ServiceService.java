package com.sil.gpc.services;


import com.sil.gpc.domains.Service;
import com.sil.gpc.repositories.ServiceRepository;
import java.util.List;

public class ServiceService {

	// @Autowired
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    // Liste Uniter
    public List<Service> findAll() {
        return  this.serviceRepository.findAll();
    }
    
    // Renvoie un Service par son code
    public Service findById(String codeService) {
        return this.serviceRepository.getOne(codeService);
    }
    
    // Sauvegarder un Service
    public Service save(Service service) {
    	//quartier.setCodeQuartier(quartier.getCodeQuartier());
        return   this.serviceRepository.save(service);
    }
    
    // Editer un Service
 public Service edit(String codeService,Service sev) {
    	
    	Service sevmod = this.serviceRepository.getOne(codeService);
		if(sevmod != null) {
			sevmod.setCodeService(sevmod.getCodeService());
			sevmod.setLibService(sevmod.getLibService());
			
			return this.serviceRepository.save(sevmod);
    }
		return null;
    }
 
    
    // Supprimer un Service
    public void delete(Service service) {;
         this.serviceRepository.delete(service);
    }   
    
    
    ////
    //liste par libelle
    public List<Service> findBylibelle(String libService){
		
		return this.serviceRepository.findByLibService(libService);
	}

}
