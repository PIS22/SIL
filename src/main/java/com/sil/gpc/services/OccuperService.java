package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Occuper;
import com.sil.gpc.repositories.OccuperRepository;

@Service
public class OccuperService {
	private final OccuperRepository repo;

	public OccuperService(OccuperRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Occuper> getAll() {
		return repo.findAll();
	}

	public List<Occuper> getOccupActu() {
		return repo.occupantsActuels();
	}

	public Occuper getById(Long id) {
		return repo.findById(id).get();
	}

	public Occuper add(Occuper corp) {
		return repo.save(corp);
	}

	public Occuper edit(Long id, Occuper corps) {
		if (repo.existsById(id)) {
			Occuper cib = repo.findById(id).get();
			cib.setDatDeb(corps.getDatDeb());
			cib.setDatFin(corps.getDatFin());
			cib.setPersonne(corps.getPersonne());
			cib.setPost(corps.getPost());
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
