package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Signer;
import com.sil.gpc.repositories.SignerRepository;

@Service
public class SignerService {
	private final SignerRepository repo;

	public SignerService(SignerRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Signer> getAll() {
		return repo.findAll();
	}

	public Signer getById(Long id) {
		return repo.findById(id).get();
	}

	public Signer add(Signer corp) {
		return repo.save(corp);
	}

	public List<Signer> SignatairesActuels() {
		return repo.signatairesActuel();
	}

	public Signer edit(Long id, Signer corps) {
		if (repo.existsById(id)) {
			Signer cib = repo.findById(id).get();
			cib.setDatDeb(corps.getDatDeb());
			cib.setDatFin(corps.getDatFin());
			cib.setPoste(corps.getPoste());
			cib.setRapport(corps.getRapport());
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
