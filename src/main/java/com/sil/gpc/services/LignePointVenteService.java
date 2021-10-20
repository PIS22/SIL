package com.sil.gpc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sil.gpc.dto.SearchLinesOpCaisseDTO;
import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LignePointVente;
import com.sil.gpc.repositories.LignePointVenteRepository;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LignePointVenteService {

	private final LignePointVenteRepository repos;

	/**
	 * @param repos
	 */
	public LignePointVenteService(LignePointVenteRepository lpvr) {
		this.repos = lpvr;
	}

	public Optional<LignePointVente> findById(Long id) {
		return repos.findById(id);
	}

	public List<LignePointVente> findAll() {
		return repos.findAll();
	}

	public List<LignePointVente> findByArticle(Article article) {
		return repos.findByArticle(article);
	}

	public List<LignePointVente> findByQte(double qte) {
		return repos.findByQuantiteLignePointVente(qte);
	}

	public List<LignePointVente> findByPrix(double prix) {
		return repos.findByPULignePointVente(prix);
	}

	public LignePointVente save(LignePointVente ligne) {
		return repos.save(ligne);
		// return repos.findAll();
	}

	public LignePointVente saveAndFlush(LignePointVente ligne, String mg) {
		LignePointVente l = repos.save(ligne);
		if (l != null) {
			if (repos.ajusterQuantite(l.getQuantiteLignePointVente(), mg, l.getArticle().getCodeArticle()) == null) {
				repos.ajouteLigne(l.getArticle().getCodeArticle(), l.getPULignePointVente(), mg,
						l.getQuantiteLignePointVente());
			}
		}
		return l;
	}

	public LignePointVente edit(LignePointVente ligne, Long id) {
		LignePointVente cible = repos.getOne(id);
		if (cible != null) {
			cible.setArticle(ligne.getArticle());
			cible.setPULignePointVente(ligne.getPULignePointVente());
			cible.setQuantiteLignePointVente(ligne.getQuantiteLignePointVente());
			return repos.save(cible);
		} else
			return null;
	}

	public boolean delete(Long id) {
		repos.deleteById(id);
		return repos.existsById(id);
	}

	public List<LignePointVente> pointByOp(String numop) {
		return repos.ligneByOp(numop);
	}

	//Léo
	public  List<LignePointVente> findAllLignePointVenteByNumPointVente(String numPointVente){
		return repos.findAllByPointVente_NumPointVente(numPointVente);
	}

	//Léo
	public  List<LignePointVente> findPointVenteImputGroupByArticle(@RequestBody SearchLinesOpCaisseDTO searchLinesOpCaisseDTO){

		List<LignePointVente> lignePointVenteGroupList = new ArrayList<>();

		List<LignePointVente> lignePointVenteList = repos.getAllLignePvImput(searchLinesOpCaisseDTO.getStartDateTime(), searchLinesOpCaisseDTO.getEndDateTime(), searchLinesOpCaisseDTO.getCodeCaisse());
		System.out.println("taille"+lignePointVenteList.size());
		System.out.println("taille Groupe"+lignePointVenteGroupList.size());
		lignePointVenteGroupList.add(lignePointVenteList.get(0));


		for ( int i = 1; i < lignePointVenteList.size() ; i++){
			System.out.println("ele"+lignePointVenteList.get(i));

				for ( int p = 0; p <= lignePointVenteGroupList.size() ; p++ ){
					System.out.println("element"+lignePointVenteList.get(i).getArticle().getCodeArticle());


					if(lignePointVenteList.get(i).getArticle().getCodeArticle() == lignePointVenteGroupList.get(p).getArticle().getCodeArticle()){

						lignePointVenteGroupList.get(p).setQuantiteLignePointVente(lignePointVenteGroupList.get(p).getQuantiteLignePointVente()+ lignePointVenteList.get(i).getQuantiteLignePointVente());
						//break;
					}
					else {
						lignePointVenteGroupList.add(lignePointVenteList.get(i));
					}

				}


		}

		return  lignePointVenteGroupList;


	}
}
