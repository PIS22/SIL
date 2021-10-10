package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Reception;
import com.sil.gpc.repositories.ReceptionRepository;

@Service
public class ReceptionService {

	private final ReceptionRepository receptionRepository;

	public ReceptionService(ReceptionRepository receptionRepository) {
		this.receptionRepository = receptionRepository;
	}

	// Sauvegarder
	public Reception save(Reception rep) {
		rep.setValideRecep(true);
		Integer val = 1, nbrMaxCaract = 6;
		String code = "RC-";
		if (this.receptionRepository.findLastNumUsed(rep.getExercice().getCodeExercice()) != null) {
			val = this.receptionRepository.findLastNumUsed(rep.getExercice().getCodeExercice());
			val++;

		}

		rep.setValeur(val);

		code = code + rep.getExercice().getCodeExercice();

		for (int i = 0; i < nbrMaxCaract - (val + "").length(); i++) {
			code += "0";
		}

		rep.setNumReception(code + val);

		if (receptionRepository.existsById(rep.getNumReception()) == false)
			return this.receptionRepository.save(rep);

		return null;

	}

	// Editer
	public Reception edit(String numReception, Reception recept) {

		Reception receptmod = this.receptionRepository.getOne(numReception);
		if (receptmod != null) {
			receptmod.setObservation(recept.getObservation());
			receptmod.setDateReception(recept.getDateReception());
			receptmod.setValideRecep(recept.isValideRecep());
			receptmod.setExercice(recept.exercice);
			receptmod.setObservation(recept.getObservation());
			return this.receptionRepository.save(receptmod);
		}
		return null;
	}

	// Supprimer
	public boolean delete(String id) {
		if (this.receptionRepository.existsById(id))
			this.receptionRepository.deleteById(id);

		return this.receptionRepository.existsById(id);
	}

	//
	public Optional<Reception> findById(String numReception) {
		return this.receptionRepository.findById(numReception);
	}

	// Liste
	public List<Reception> getAll() {
		return this.receptionRepository.findAll();
	}

	//
	public List<Reception> findByNumReception(String NumReception) {

		return this.receptionRepository.findByNumReception(NumReception);
	}

	//
	public List<Reception> findByObservation(String Observation) {

		return this.receptionRepository.findByObservation(Observation);
	}

	//
	public List<Reception> findByDateReception(Date DateReception) {

		return this.receptionRepository.findByDateReception(DateReception);
	}

}
