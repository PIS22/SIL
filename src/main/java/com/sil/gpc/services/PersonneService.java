package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Personne;
import com.sil.gpc.repositories.PersonneRepository;

@Service
public class PersonneService {
	private final PersonneRepository repo;

	public PersonneService(PersonneRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Personne> getAll() {
		return repo.findAll();
	}

	public Personne getById(Long id) {
		return repo.findById(id).get();
	}

	public Personne add(Personne corp) {
		return repo.save(corp);
	}

	public Personne edit(Long id, Personne corps) {
		if (repo.existsById(id)) {
			Personne cib = repo.findById(id).get();
			cib.setNomPers(corps.getNomPers());
			cib.setPrenomPers(corps.getPrenomPers());
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
