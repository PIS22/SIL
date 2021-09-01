package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.OpCaisse;
import com.sil.gpc.repositories.OpCaisseRepository;

@Service
public class OpCaisseService {

	private final OpCaisseRepository repos;

	/**
	 * @param repos
	 */
	public OpCaisseService(OpCaisseRepository opcr) {
		this.repos = opcr;
	}
	
	public Optional<OpCaisse> findById(String num){
		return repos.findById(num);
	}
	
	public List<OpCaisse> findAll(){
		return repos.findAll();
	}
	
	public List<OpCaisse> findByContribuale(String contribuable){
		return repos.findByContribuable(contribuable);
	}
	
	public List<OpCaisse> findByDateOpCaisse(Date dateOp){
		return repos.findByDateOpCaisse(dateOp);
	}
	
	public List<OpCaisse> findByModePaiement(String codMP){
		return repos.findByModePaiement(codMP);
	}
	
	public List<OpCaisse> findByCaisse(String codCai){
		return repos.findByCaisse(codCai);
	}
	
	public List<OpCaisse> findByTypeRecette(String codTR){
		return repos.findByTypeRecette(codTR);
	}

	public OpCaisse edit(OpCaisse oc, String num){
		OpCaisse opc=repos.getOne(num);
		System.out.println(oc.getNumOpCaisse().substring(0, 4));
		if (opc!=null) {
		opc.setCaisse(oc.getCaisse());
		opc.setContribuable(oc.getContribuable());
		opc.setDateOpCaisse(oc.getDateOpCaisse());
		opc.setDateSaisie(oc.getDateSaisie());
		opc.setModePaiement(oc.getModePaiement());
		opc.setTypeRecette(oc.getTypeRecette());
		opc.setValideOpCaisse(oc.isValideOpCaisse());
		opc.setMttRem(oc.getMttRem());
		opc.setMonnai(oc.getMonnai());
		opc.setReliquat(oc.getReliquat());
		return repos.save(opc);
		}else
			return null;
	}

	public OpCaisse save(OpCaisse oc){
		Integer val = 1, nbrMaxCaract = 6;
		String code = oc.getCaisse().getCodeCaisse()+"-"+oc.getExercice().getCodeExercice();
		if(this.repos.findLastNumUsed(oc.getCaisse().getCodeCaisse(), oc.getExercice().getCodeExercice()) != null) {
			val = this.repos.findLastNumUsed(oc.getCaisse().getCodeCaisse(), oc.getExercice().getCodeExercice());
			val++;
		}
		System.out.println(val);
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		oc.setNumOpCaisse(code+val);
		System.out.println(oc.getNumOpCaisse());
		oc.setValeur(val); 
		if(repos.existsById(oc.getNumOpCaisse())==false) return repos.save(oc);
			return null;
	}

	public boolean delete(String num){
		repos.deleteById(num);
		return !repos.existsById(num);
	}

	public List<OpCaisse> opOfDayAndCais(List<String> listcodCai, Date dat){
		return repos.OpcOfDay(listcodCai, dat);
	}

	public List<OpCaisse> userOp(Long user){
		return repos.userOpc(user);
	}

	public List<OpCaisse> userOpOfDayAndCais(Long user, Date dat){
		return repos.userOpcOfDay(user, dat);
	}
	
}
