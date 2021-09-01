package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Contrat;
import com.sil.gpc.domains.Immeuble;
import com.sil.gpc.domains.Locataire;
import com.sil.gpc.repositories.ContratRepository;

@Service
public class ContratService {

	private final ContratRepository repo;

	private final LocataireService los;

	
	/**
	 * @param repo
	 * @param los
	 */
	public ContratService(ContratRepository repo, LocataireService los) {
		this.repo = repo;
		this.los = los;
	}

	public Contrat save(Contrat contrat) {
		if(!repo.existsById(contrat.getNumContrat())) {
			return this.repo.save(contrat);
		}
		return null;
	}
	
	public Contrat edit(String id, Contrat contrat) {
		
		Contrat entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setAvanceContrat(contrat.getAvanceContrat());
			entiter.setCautionContrat(contrat.getCautionContrat());
			entiter.setDateEffetContrat(contrat.getDateEffetContrat());
			entiter.setDateSignatureContrat(contrat.getDateSignatureContrat());
			entiter.setImmeuble(contrat.getImmeuble());
			entiter.setLocataire(contrat.getLocataire());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public Optional<Contrat> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Contrat> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Contrat> findByNumContrat(String numContrat){
		
		return this.repo.findByNumContrat(numContrat);
	}
	
	public List<Contrat> findByDateSignatureContrat(Date dateSignatureContrat){
		
		return this.repo.findByDateSignatureContrat(dateSignatureContrat);
	}
	
	public List<Contrat> findByDateEffetContrat(Date dateEffetContrat){
		
		return this.repo.findByDateEffetContrat(dateEffetContrat);
	}
	
	public List<Contrat> findByAvanceContrat(double avanceContrat){
		
		return this.repo.findByAvanceContrat(avanceContrat);
	}
	
	public List<Contrat> findByCautionContrat(double cautionContrat){
		
		return this.repo.findByCautionContrat(cautionContrat);
	}
	
	public List<Contrat> findByImmeuble(Immeuble immeuble){
		
		return this.repo.findByImmeuble(immeuble);
	}
	

	public List<Contrat> getContratByLocataire(Long idLoc){
		Locataire loc=los.trouveUn(idLoc);
		System.out.println("Locataire: "+loc);
		List<Contrat> con= findByLocataire(loc);
		System.out.print("Nombre de contrats: "+con.size());
		return con;
	}
	
	public List<Contrat> findByLocataire(Locataire locataire){
		
		return this.repo.findByLocataire(locataire);
	}
}
