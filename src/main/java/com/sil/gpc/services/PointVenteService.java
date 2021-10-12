package com.sil.gpc.services;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sil.gpc.domains.*;
import org.springframework.stereotype.Service;

import com.sil.gpc.repositories.PointVenteRepository;

@Service
public class PointVenteService {

	private final OpCaisseService opc;
	private final PointVenteRepository pointVenteRepository;
	private final LignePointVenteService lpv;
	private final LigneOpCaisseService lopc;

	public PointVenteService(OpCaisseService opc, PointVenteRepository pointVenteRepository, LignePointVenteService lpv,
			LigneOpCaisseService lopc) {
		super();
		this.opc = opc;
		this.pointVenteRepository = pointVenteRepository;
		this.lpv = lpv;
		this.lopc = lopc;
	}

	public PointVente imputPoint(OpPointBlock pb) {
		PointVente pv = pb.getPv();
		pv.setOpCaisse(opc.save(pb.getOpc()));
		return pointVenteRepository.save(pv);

	}

	public LignePointVente imputLignePoint(LignePointBlock lpb) {
		LigneOpCaisse lop = new LigneOpCaisse();
		lop.setArticle(lpb.getLpv().getArticle());
		lop.setCommentaireLigneOperCaisse("");
		lop.setLivre(true);
		lop.setMagasin(lpb.getMg());
		lop.setOpCaisse(lpb.getLpv().getPointVente().getOpCaisse());
		lop.setPrixLigneOperCaisse(lpb.getLpv().getPULignePointVente());
		lop.setQteLigneOperCaisse(lpb.getLpv().getQuantiteLignePointVente());
		lopc.save(lop);
		return lpv.saveAndFlush(lpb.getLpv(), lpb.getMg().getCodeMagasin());
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
	public Optional<PointVente> findByNumPointVente(String numPv) {

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

	/*
	 * public List<LignePointVente> pointOp(String numop) { List<String> nums =
	 * pointVenteRepository.pointByOp(numop); lpv = null; for (String num : nums) {
	 * for (LignePointVente l : pointVenteRepository.ligneByPv(num)) { lpv.(l); } }
	 * return lpv; }
	 */

	//Léo
	public  List<PointVente> getAllByIdCorrespondantAndPayerFalse(String codeCorres){
		return  pointVenteRepository.findAllByCorrespondant_IdCorrespondantAndPayerPointIsFalse(codeCorres);
	}

	//Léo
	public Boolean addAndUpdatedFotImputation(OpCaisse op, String numPointVente){
		Optional<PointVente> pvActu = pointVenteRepository.findByNumPointVente(numPointVente);
		PointVente actuPV = pvActu.get();

		boolean check = false;

		if(pvActu.isPresent()){

			OpCaisse opCaisseActu = opc.save(op);
			actuPV.setPayerPoint(true);
			actuPV.setOpCaisse(opCaisseActu);
			edit(actuPV.getNumPointVente(), actuPV);
			check = true;

		}

		return  check;

	}

	//Léo
	public List<LignePointVente> find(LocalDateTime startDate, LocalDateTime endDate){
		List<LignePointVente> lignePointVente = new ArrayList<>();
		//Pvente = pointVenteRepository.findAllByPayerPointIsTrueAndDateSaisieBetween(startDate, endDate);
		for (PointVente pv : pointVenteRepository.findAllByPayerPointIsTrueAndDateSaisieBetween(startDate, endDate)){
			lignePointVente.add((LignePointVente) lpv.findAllLignePointVenteByNumPointVente(pv.getNumPointVente()));

		}
		return  lignePointVente;

	}
}
