package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.PlageNumDispo;
import com.sil.gpc.repositories.PlageNumDispoRepository;

@Service
public class PlageNumDispoService {

	private final PlageNumDispoRepository repos;

	/**
	 * @param plager
	 */
	public PlageNumDispoService(PlageNumDispoRepository plager) {
		this.repos = plager;
	}

	public List<PlageNumDispo> premieresPlageDispoMag(String cArt, String cMag) {
		return repos.premiersNumerosParArticle(cArt, cMag);
	}

	public Optional<PlageNumDispo> findById(Long cp) {
		return repos.findById(cp);
	}

	public List<PlageNumDispo> findByArticle(String codArt) {
		return repos.findByArticle(codArt);
	}

	public List<PlageNumDispo> findByNumFinDispo(String num) {
		return repos.findByNumFinPlageDispo(num);
	}

	public List<PlageNumDispo> findByNumDebDispo(String num) {
		return repos.findByNumDebPlageDispo(num);
	}

	public List<PlageNumDispo> findByNumDeb(String num) {
		return repos.findByNumDebPlage(num);
	}

	public List<PlageNumDispo> findByNumFin(String num) {
		return repos.findByNumFinPlage(num);
	}

	public List<PlageNumDispo> findAll() {
		return repos.findAll();
	}

	public PlageNumDispo save(PlageNumDispo pd) {
		return repos.save(pd);
	}

	public PlageNumDispo edit(PlageNumDispo pd, Long codeplage) {
		PlageNumDispo pnd = repos.getOne(codeplage);
		if (pnd != null) {
			pnd.setExercice(pd.getExercice());
			pnd.setAppro(pd.getAppro());
			pnd.setArticle(pd.getArticle());
			pnd.setNumDebPlage(pd.getNumDebPlage());
			pnd.setNumDebPlageDispo(pd.getNumDebPlageDispo());
			pnd.setNumFinPlage(pd.getNumFinPlage());
			pnd.setNumFinPlageDispo(pd.getNumFinPlageDispo());
			pnd.setMagasin(pd.getMagasin());
			pnd.setPlacement(pd.getPlacement());
			pnd.setReception(pd.getReception());
			pnd.setRecollement(pd.getRecollement());
			return repos.save(pnd);
		} else
			return null;
	}

	public boolean delete(Long cp) {
		repos.deleteById(cp);
		return repos.existsById(cp);
	}
}
