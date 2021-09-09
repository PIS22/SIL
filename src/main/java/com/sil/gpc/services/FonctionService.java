package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Fonction;
import com.sil.gpc.repositories.FonctionRepository;

@Service
public class FonctionService {
	private final FonctionRepository repos;

	public FonctionService(FonctionRepository repos) {
		super();
		this.repos = repos;
	}

	public Fonction find(String cod) {
		return repos.findById(cod).get();
	}

	public List<Fonction> getAll() {
		if (repos.findAll().size() == 0) {
			repos.saveAndFlush(new Fonction("S1", "Caissier"));
			repos.saveAndFlush(new Fonction("S2", "Regisseur"));
			repos.saveAndFlush(new Fonction("S3", "Livreur"));
			repos.saveAndFlush(new Fonction("S4", "Admin"));
		}
		return repos.findAll();
	}

}
