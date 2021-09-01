package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Incineration;
import com.sil.gpc.repositories.IncinerationRepository;

@Service
public class IncinerationService {
	private final IncinerationRepository repos;

	public IncinerationService(IncinerationRepository repos) {
		super();
		this.repos = repos;
	}
	
	public Incineration save(Incineration inc) {
		String cod=inc.getExercice().getCodeExercice();
		int l=repos.dernièreValeur(cod);
		for(int i=0; i< (6-String.valueOf(	l+1).length()); i++) {
			cod+="0";
		}
		cod="INC"+cod+l;
		System.out.println(cod);
		return repos.save(inc);
	}
	 
	public Incineration edit(String cod, Incineration inc) {
		Incineration cib = repos.findById(cod).get();
		if(cib != null) {
			cib.setDateIncine(inc.getDateIncine());
			cib.setExercice(inc.getExercice());
			cib.setObservationIncine(inc.getObservationIncine());
			cib.setValideIncine(inc.isValideIncine());
			return repos.save(cib);
		}
		else 
			return null;
	}
	
	public Incineration getById(String cod) {
		return repos.findById(cod).get();
	}
	
	public List<Incineration> getAll(){
		return repos.findAll();
	}
	
	public boolean delete(String cod) {
		if(repos.existsById(cod)){
			repos.deleteById(cod);
			return !repos.existsById(cod);
		}
		else
			return false;
	}

}
