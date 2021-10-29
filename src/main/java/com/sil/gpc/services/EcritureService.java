package com.sil.gpc.services;

import java.util.Date;
import java.util.List;

import com.sil.gpc.domains.EcritureBlock;
import com.sil.gpc.domains.LigneEcriture;
import com.sil.gpc.repositories.LigneEcritureRepository;
import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Ecriture;
import com.sil.gpc.repositories.EcritureRepository;

@Service
public class EcritureService {

	private final EcritureRepository repo;
	private  final LigneEcritureRepository repoL;

	public EcritureService(EcritureRepository repo, LigneEcritureRepository repoL) {
		this.repo = repo;
		this.repoL = repoL;
	}

	public List<Ecriture> getAll(){
		return repo.findAll();
	}
	
	public Ecriture getById(String id) {
		return repo.findById(id).get();
	}
	
	public Ecriture add(Ecriture ecriture) {
		ecriture.setDatSaisie(new Date());
		int mois= new Date().getMonth();
		String chain;
		if(String.valueOf(mois).length() == 1){
			chain = ecriture.getExo()+"0"+String.valueOf(mois)+ecriture.getJournal().getIdJrn();
		}
		else
			chain = ecriture.getExo()+String.valueOf(mois)+ecriture.getJournal().getIdJrn();

		String num=chain;
		System.out.println("Année: "+ecriture.getExo().getCodeExercice()+"\nMois: "+mois);
		Ecriture dernier = repo.ordre(ecriture.getExo().getCodeExercice(),mois);
		System.out.println("ddd: "+dernier);
		int ordre;
		if(dernier == null){
			ordre=1;
		}
		else{
			ordre = dernier.getOrdre()+1;
		}
		String od= String.valueOf(ordre);
		while (od.length()<4){
			od="0"+od;
		}
		chain+="-"+od;
		ecriture.setNumEcri(chain);
		ecriture.setOrdre(ordre);
		return repo.save(ecriture);
	}
	
	public Ecriture edit(String id, Ecriture ecriture) {
		
		if(repo.existsById(id)) {
			Ecriture entiter = repo.getOne(id);
			
			entiter.setDatEcri(ecriture.getDatEcri());
			entiter.setDescipt(ecriture.getDescipt());
			entiter.setExo(ecriture.getExo());
			entiter.setJournal(ecriture.getJournal());
			entiter.setRefExtern(ecriture.getRefExtern());
			entiter.setRefIntern(ecriture.getRefIntern());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (String id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

	public Ecriture addEriture(EcritureBlock obj){
		Ecriture e = add(obj.getE());
		if(e.getNumEcri()!=null){
			for(LigneEcriture l : obj.getLines()){
				l.setEcriture(e);
			}
			repoL.saveAll(obj.getLines());
		}
		return e;
	}

}
