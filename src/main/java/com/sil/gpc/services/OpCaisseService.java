package com.sil.gpc.services;

import java.util.List;

import com.sil.gpc.domains.OpCaisse;
import com.sil.gpc.repositories.OpCaisseRepository;

public class OpCaisseService {

	private final OpCaisseRepository ocr;

	/**
	 * @param opcr
	 */
	public OpCaisseService(OpCaisseRepository opcr) {
		this.ocr = opcr;
	}

	public OpCaisse modifieOpCaisse(OpCaisse oc, String num){
		OpCaisse opc=ocr.getOne(num);
		opc.setCaisse(oc.getCaisse());
		opc.setContribuable(oc.getContribuable());
		opc.setDateOpCaisse(oc.getDateOpCaisse());
		opc.setDateSaisie(oc.getDateSaisie());
		opc.setModePaiement(oc.getModePaiement());
		opc.setObservation(oc.getObservation());
		opc.setTypeRecette(oc.getTypeRecette());
		opc.setValideOpCaisse(oc.isValideOpCaisse());
		return ocr.save(opc);
	}

	public OpCaisse ajouteOpCaisse(OpCaisse oc){
		return ocr.save(oc);
	}

	public List<OpCaisse> supprimeOpCaisse(String num){
		ocr.deleteById(num);
		return ocr.findAll();
	}
	
	public OpCaisse rechercheOpCaisse(String num){
		return ocr.getOne(num);
	}
	
}
