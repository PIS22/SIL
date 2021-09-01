package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.InstituReverse;
import com.sil.gpc.repositories.InstituReverseRepository;

@Service
public class InstituReverseService {
	
	private final InstituReverseRepository repos;

	/**
	 * @param repos
	 */
	public InstituReverseService(InstituReverseRepository repos) {
		this.repos = repos;
	}
	
	public List<InstituReverse> findAll(){
		return repos.findAll();
	}
	
	public InstituReverse getByCod(String cod) {
		return repos.getOne(cod);
	}
	
	public List<InstituReverse> getByLib(String lib) {
		return repos.findByLibInstRevers(lib);
	}
	
	public InstituReverse saveInst(InstituReverse inst) {
		if(!repos.existsById(inst.getCodeInstRevers())) {
			return repos.save(inst);
		}
		return null;
	}
	
	public InstituReverse editInst(String cod, InstituReverse inst) {
		if(repos.existsById(cod)) {
			InstituReverse in=repos.getOne(cod);
			//in.setCodeInstRevers(inst.getCodeInstRevers());
			in.setLibInstRevers(inst.getLibInstRevers());
			return repos.save(in);
		}
		return null;
	}
	
	public boolean delIntByCod(String cod) {
		if(repos.existsById(cod)) {
			repos.deleteById(cod);
			return !repos.existsById(cod);
		}
		return false;
	}

}
