package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Rapport;
import com.sil.gpc.repositories.RapportRepository;

@Service
public class RapportService {
	private final RapportRepository repo;

	public RapportService(RapportRepository repo) {
		super();
		this.repo = repo;
		if (repo.findAll().size() == 0) {
			this.add(new Rapport("BC", "Bon de commande"));
			this.add(new Rapport("PR", "PV de réception"));
			this.add(new Rapport("BA", "Bon d'approvisionnement"));
			this.add(new Rapport("BP", "Bon de placement"));
			this.add(new Rapport("ER", "Etat de reversement"));
			// this.add(new Rapport("PV de recollement"));
			this.add(new Rapport("PVR", "PV de reconduction"));
		}
	}

	public List<Rapport> getAll() {
		return repo.findAll();
	}

	public List<Rapport> getByLib(String lib) {
		return repo.findByLibRap(lib);
	}

	public Rapport getById(Long id) {
		return repo.findById(id).get();
	}

	public Rapport add(Rapport corp) {
		return repo.save(corp);
	}

	public Rapport edit(Long id, Rapport corps) {
		if (repo.existsById(id)) {
			Rapport cib = repo.findById(id).get();
			cib.setLibRap(corps.getLibRap());
			return repo.save(cib);
		}
		return null;
	}

	public boolean delete(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return !repo.existsById(id);
		}
		return false;
	}

}
