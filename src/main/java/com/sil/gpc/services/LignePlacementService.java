package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LignePlacement;
import com.sil.gpc.domains.Magasin;
import com.sil.gpc.domains.PlageNumArticle;
import com.sil.gpc.domains.PlageNumDispo;
import com.sil.gpc.repositories.GererRepository;
import com.sil.gpc.repositories.LignePlacementRepository;
import com.sil.gpc.repositories.PlageNumDispoRepository;

@Service
public class LignePlacementService {

	private final LignePlacementRepository repos;
	private static PlageNumDispoRepository p;
	private static PlageNumArticleService pas;
	private static GererRepository ger;

	/**
	 * @param repos
	 */
	public LignePlacementService(LignePlacementRepository lpr) {
		this.repos = lpr;
	}

	public Optional<LignePlacement> findById(Long id) {
		return repos.findById(id);
	}

	public List<LignePlacement> findAll() {
		return repos.findAll();
	}

	public List<LignePlacement> findByArticle(Article art) {
		return repos.findByArticle(art);
	}

	public List<LignePlacement> findByPrix(double prix) {
		return repos.findByPULignePlacement(prix);
	}

	public LignePlacement save(LignePlacement ligne) {
		LignePlacement lp = repos.save(ligne);
		Magasin maga = ger.mag(lp.getPlacement().getCorrespondant().getMagasinier().getNumMAgasinier());
		if (lp != null && lp.getArticle().isNumSerieArticle()) {
			List<PlageNumDispo> plage = p.premiersNumerosParArticle(lp.article.getCodeArticle(), "CM");
			Long qte = lp.getQuantiteLignePlacement();
			if (qte > 0) {
				long qt = plage.get(0).getNumFinPlageDispo() - plage.get(0).getNumDebPlageDispo() + 1;
				if (qte < qt) {
					PlageNumDispo pla = plage.get(0);
					PlageNumArticle pplace = new PlageNumArticle();
					pplace.setLigneAppro(null);
					pplace.setLignePlacement(lp);
					pplace.setLigneRecollement(null);
					pplace.setNumDebPlage(pla.getNumDebPlageDispo());
					pplace.setNumFinPlage(pla.getNumDebPlageDispo() + qte - 1);
					if (pas.save(pplace) != null) {
						PlageNumDispo npd = new PlageNumDispo();
						npd.setPlacement(pplace.getLignePlacement().getPlacement());
						npd.setExercice(pla.getExercice());
						npd.setNumDebPlage(pplace.getNumDebPlage());
						npd.setNumDebPlageDispo(pplace.getNumDebPlage());
						npd.setNumFinPlage(pplace.getNumFinPlage());
						npd.setNumFinPlageDispo(pplace.getNumFinPlage());
						npd.setMagasin(maga);
						if (p.save(npd) != null) {
							pla.setNumDebPlageDispo(npd.getNumFinPlage() + 1);
							p.save(pla);
						}
					}
				} else {
					int i = 0;
					while (qte >= 0) {
						PlageNumDispo pla = plage.get(i);
						qt = pla.getNumFinPlageDispo() - pla.getNumDebPlageDispo() + 1;
						PlageNumArticle pplace = new PlageNumArticle();
						pplace.setLigneAppro(null);
						pplace.setLignePlacement(lp);
						pplace.setLigneRecollement(null);
						pplace.setNumDebPlage(pla.getNumDebPlageDispo());
						pplace.setNumFinPlage(pla.getNumDebPlageDispo() + qte - 1);
						if (qte >= qt) {
							if (pas.save(pplace) != null) {
								pla.setMagasin(maga);
								p.saveAndFlush(pla);
							}
						} else {
							if (pas.save(pplace) != null) {
								PlageNumDispo npd = new PlageNumDispo();
								npd.setExercice(pla.getExercice());
								npd.setNumDebPlage(pplace.getNumDebPlage());
								npd.setNumDebPlageDispo(pplace.getNumDebPlage());
								npd.setNumFinPlage(pplace.getNumFinPlage());
								npd.setNumFinPlageDispo(pplace.getNumFinPlage());
								npd.setMagasin(maga);
								if (p.save(npd) != null) {
									pla.setNumDebPlageDispo(npd.getNumFinPlage() + 1);
									p.save(pla);
								}
							}

						}
					}
				}
			}
		}
		return lp;
	}

	public LignePlacement edit(LignePlacement ligne, Long id) {
		LignePlacement lp = repos.getOne(id);
		lp.setArticle(ligne.getArticle());
		lp.setPULignePlacement(ligne.getPULignePlacement());
		lp.setQuantiteLignePlacement(ligne.getQuantiteLignePlacement());
		return repos.save(lp);
	}

	public boolean delete(Long id) {
		repos.deleteById(id);
		return repos.existsById(id);
	}

}
