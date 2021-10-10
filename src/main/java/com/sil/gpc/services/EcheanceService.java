package com.sil.gpc.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Contrat;
import com.sil.gpc.domains.Echeance;
import com.sil.gpc.domains.OpCaisse;
import com.sil.gpc.repositories.EcheanceRepository;

@Service
public class EcheanceService {

	private final EcheanceRepository repo;

	public EcheanceService(EcheanceRepository repo) {
		super();
		this.repo = repo;
	}

	public Echeance save(Echeance echeance) {

		return this.repo.save(echeance);
	}

	public List<Echeance> saving(List<Echeance> echeances) {
		return repo.saveAll(echeances);
	}

	public Echeance edit(Long id, Echeance echeance) {

		Echeance entiter = this.repo.getOne(id);
		if (entiter != null) {
			entiter.setContrat(echeance.getContrat());
			entiter.setDateEcheance(echeance.getDateEcheance());
			entiter.setMoisEcheance(echeance.getMoisEcheance());
			entiter.setPayeEcheance(echeance.isPayeEcheance());
			entiter.setContrat(echeance.getContrat());

			this.repo.save(entiter);
		}

		return null;
	}

	public boolean delete(Long id) {

		if (this.repo.existsById(id) == true)
			this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

	public Optional<Echeance> getById(Long id) {

		return this.repo.findById(id);
	}

	public List<Echeance> getAll() {

		return this.repo.findAll();
	}

	public List<Echeance> getEchenceValide() {

		return this.repo.echeancesAnnules();
	}

	public List<Echeance> getEchencesAnnulees() {

		return this.repo.echeancesAnnules();
	}

	public List<Echeance> findByIdEcheance(Long idEcheance) {

		return this.repo.findByIdEcheance(idEcheance);
	}

	public List<Echeance> findByDateEcheance(Date dateEcheance) {

		return this.findByDateEcheance(dateEcheance);
	}

	public List<Echeance> findByMoisEcheance(String moisEcheance) {

		return this.repo.findByMoisEcheance(moisEcheance);
	}

	public List<Echeance> findByContrat(Contrat contrat) {

		return this.repo.findByContrat(contrat);
	}

	public List<Echeance> findByOpCaisse(OpCaisse opCaisse) {

		return this.repo.findByOpCaisse(opCaisse);
	}

	public List<Echeance> findByPayeEcheance(boolean payeEcheance) {

		return this.repo.findByPayeEcheance(payeEcheance);
	}

	public double caisseLocMode(String caisse, String mode, String deb, String fin) {
		// String dDeb= Base64.decode(deb).toString();
		System.out.print(deb);

		// Timestamp d1=(Timestamp)Date.valueOf(dDeb).toLocalDate();
		return repo.caisseModLoca(mode, caisse, Timestamp.valueOf(deb), Timestamp.valueOf(fin));
	}

	public double arrLocMode(String caisse, String mode, String deb, String fin) {

		return repo.arrModLoca(mode, caisse, Timestamp.valueOf(deb), Timestamp.valueOf(fin));
	}

	public List<Echeance> echeanceByOp(String num) {
		return repo.lignesOP(num);
	}

}
