package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Poste;
import com.sil.gpc.repositories.PosteRepository;

@Service
public class PosteService {
	private final PosteRepository repo;

	public PosteService(PosteRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Poste> getAll() {
		return repo.findAll();
	}

	public Poste getById(Long id) {
		return repo.findById(id).get();
	}

	public Poste add(Poste corp) {
		System.out.println(corp);
		return repo.save(corp);
	}

	public Poste edit(Long id, Poste corps) {
		if (repo.existsById(id)) {
			Poste cib = repo.findById(id).get();
			cib.setCodPost(corps.getCodPost());
			cib.setLibPost(corps.getLibPost());
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
