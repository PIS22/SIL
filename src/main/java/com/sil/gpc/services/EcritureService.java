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
		int mois= new Date().getMonth()+1;
		String chain;
		if(String.valueOf(mois).length() == 1){
			chain = ecriture.getExo()+"0"+String.valueOf(mois)+ecriture.getJournal().getIdJrn();
		}
		else
			chain = ecriture.getExo().getCodeExercice()+String.valueOf(mois)+ecriture.getJournal().getIdJrn();

		int ordre=1;
		Ecriture dernier =repo.ordre(ecriture.getExo().getCodeExercice(),ecriture.getJournal().getIdJrn());
		if(dernier != null){
			ordre = dernier.getOrdre()+1;
		}
		String od= String.valueOf(ordre);
		while (od.length()<4){
			od="0"+od;
		}
		chain+="-"+od;
		System.out.println(chain);
		ecriture.setNumEcri(chain);
		ecriture.setOrdre(ordre);
		ecriture.setValide(true);
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
			entiter.setValide(ecriture.isValide());
			
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
	
	public Ecriture editBloc(EcritureBlock obj){
		Ecriture e = edit(obj.getE().getNumEcri(), obj.getE());
		repoL.deleteAll(repoL.linesOf(e.getNumEcri()));
		repoL.saveAll(obj.getLines());
		return e;
	}

}
