package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Inventaire;
import com.sil.gpc.repositories.InventaireRepository;

@Service
public class InventaireService {

	private final InventaireRepository repos;

	public InventaireService(InventaireRepository repos) {
		super();
		this.repos = repos;
	}

	public Optional<Inventaire> findById(String num){
		return repos.findById(num);
	}
	
	public List<Inventaire> findAll(){
		return repos.findAll();
	}
	
	public Inventaire edit(Inventaire inv, String num){
		Inventaire opc=repos.getOne(num);
		if (opc!=null) {
		opc.setDateInv(inv.getDateInv());
		opc.setDescrInv(inv.getDescrInv());
		opc.setExercice(inv.getExercice());
		opc.setMagasin(inv.getMagasin());
		opc.setValideInve(inv.isValideInve());
		return repos.save(opc);
		}else
			return null;
	}

	public Inventaire save(Inventaire inv){
		Integer val = 1, nbrMaxCaract = 6;
		String code = "INV-"+inv.getExercice().getCodeExercice();
		if(this.repos.findLastNumUsed(inv.getExercice().getCodeExercice()) != null) {
			val = this.repos.findLastNumUsed(inv.getExercice().getCodeExercice());
			val++;
		}
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		inv.setNumInv(code+val);
		inv.setValeur(val); 
		if(repos.existsById(inv.getNumInv())==false) return repos.save(inv);
		return null;
	}

	public boolean delete(String num){
		repos.deleteById(num);
		return !repos.existsById(num);
	}
	
}
