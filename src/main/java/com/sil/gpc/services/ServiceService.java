package com.sil.gpc.services;


import com.sil.gpc.domains.Service;
import com.sil.gpc.repositories.ServiceRepository;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

	// @Autowired
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    
 // Sauvegarder un Service
    public Service save(Service service) {
    	if(!serviceRepository.existsById(service.getCodeService()))
    		return   this.serviceRepository.save(service);
		return null;
    }
    
    // Editer un Service
 public Service edit(String codeService, Service sev) {
    	
    	Service sevmod = this.serviceRepository.getOne(codeService);
		if(sevmod != null) {
			sevmod.setCodeService(sev.getCodeService());
			sevmod.setLibService(sev.getLibService());
			
			return this.serviceRepository.save(sevmod);
    }
		return null;
    }
 
    
 // Supprimer un Service
 public boolean delete(String id) {
	 if(this.serviceRepository.existsById(id))
         this.serviceRepository.deleteById(id);
	 
	return this.serviceRepository.existsById(id);
 }   
 
 // Renvoie un Service par son id
 public Optional <Service> findById(String id) {
     return this.serviceRepository.findById(id);
 }
 
 
 
    // Liste 
    public List<Service> getAll() {
        return  this.serviceRepository.findAll();
    }
    
  //liste par code
    public List<Service> findByCodeService(String CodeService){
		
		return this.serviceRepository.findByCodeService(CodeService);
	}
    
  //liste par libelle
    public List<Service> findByLibelleServicer(String LibelleService){
		
		return this.serviceRepository.findByLibService(LibelleService);
	}
    
}
