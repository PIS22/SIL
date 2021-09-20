package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Correspondant;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.PointVente;
import com.sil.gpc.domains.Regisseur;
import com.sil.gpc.repositories.PointVenteRepository;

@Service
public class PointVenteService {

	private final PointVenteRepository pointVenteRepository;

	public PointVenteService(PointVenteRepository pointVenteRepository) {
		this.pointVenteRepository = pointVenteRepository;
	}

	// Sauvegarder
	public PointVente save(PointVente pv) {
		pv.setValidePoint(true);

		Integer val = 1, nbrMaxCaract = 6;
		String code = "PV-";
		if (this.pointVenteRepository.findLastNumUsed(pv.getExercice().getCodeExercice()) != null) {
			val = this.pointVenteRepository.findLastNumUsed(pv.getExercice().getCodeExercice());
			val++;

		}

		pv.setValeur(val);

		code = code + pv.getExercice().getCodeExercice();

		for (int i = 0; i < nbrMaxCaract - (val + "").length(); i++) {
			code += "0";
		}

		pv.setNumPointVente(code + val);
		System.out.println(pv);
		return this.pointVenteRepository.save(pv);
	}

	// Editer
	public PointVente edit(String numPv, PointVente pv) {

		PointVente pvmod = this.pointVenteRepository.getOne(numPv);
		if (pvmod != null) {
			pvmod.setNumPointVente(pv.getNumPointVente());
			;
			pvmod.setPayerPoint(pv.isPayerPoint());
			pvmod.setDatePointVente(pv.getDatePointVente());
			pvmod.setExercice(pv.getExercice());
			pvmod.setCorrespondant(pv.getCorrespondant());
			pvmod.setRegisseur(pv.getRegisseur());
			pvmod.setOpCaisse(pv.getOpCaisse());
			pvmod.setValidePoint(pv.isValidePoint());

			return this.pointVenteRepository.save(pvmod);
		}
		return null;
	}

	// Supprimer
	public boolean delete(String id) {
		if (this.pointVenteRepository.existsById(id))
			this.pointVenteRepository.deleteById(id);

		return this.pointVenteRepository.existsById(id);
	}

	// Liste
	public List<PointVente> getAll() {
		return this.pointVenteRepository.findAll();
	}

	//
	public Optional<PointVente> findById(String numPointVente) {
		return this.pointVenteRepository.findById(numPointVente);
	}

	//
	// liste par code
	public List<PointVente> findByNumPointVente(String numPv) {

		return this.pointVenteRepository.findByNumPointVente(numPv);
	}

	// liste par libelle
	public List<PointVente> findBypayerPoint(boolean payerPV) {

		return this.pointVenteRepository.findBypayerPoint(payerPV);
	}

	//
	public List<PointVente> findByDatePv(Date datePayerPV) {

		return this.pointVenteRepository.findByDatePointVente(datePayerPV);
	}

	// Liste PointVente par exercice
	public List<PointVente> findByExercicePointVente(Exercice exo) {
		return this.pointVenteRepository.findByExercice(exo);
	}

	// Liste PointVente par correspondant
	public List<PointVente> findByCorrespondant(Correspondant corresp) {
		return this.pointVenteRepository.findByCorrespondant(corresp);
	}

	// Liste PointVente par Regisseur
	public List<PointVente> findByRegisseur(Regisseur reg) {
		return this.pointVenteRepository.findByRegisseur(reg);
	}

}
