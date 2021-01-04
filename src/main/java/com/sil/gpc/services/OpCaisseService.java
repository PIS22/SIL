package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.sil.gpc.domains.OpCaisse;
import com.sil.gpc.repositories.OpCaisseRepository;

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
		if (opc!=null) {
		opc.setCaisse(oc.getCaisse());
		opc.setContribuable(oc.getContribuable());
		opc.setDateOpCaisse(oc.getDateOpCaisse());
		opc.setDateSaisie(oc.getDateSaisie());
		opc.setModePaiement(oc.getModePaiement());
		opc.setObservation(oc.getObservation());
		opc.setTypeRecette(oc.getTypeRecette());
		opc.setValideOpCaisse(oc.isValideOpCaisse());
		return repos.save(opc);
		}else
			return null;
	}

	public OpCaisse save(OpCaisse oc){
		return repos.save(oc);
	}

	public List<OpCaisse> delete(String num){
		repos.deleteById(num);
		return repos.findAll();
	}
	
}
