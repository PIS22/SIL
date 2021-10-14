package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.TypeAmort;
import com.sil.gpc.repositories.TypeAmortRepository;

@Service
public class TypeAmortService {
	
	private final TypeAmortRepository repo;

	public TypeAmortService(TypeAmortRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<TypeAmort> getAll(){
		return repo.findAll();
	}
	
	public TypeAmort getById(Long id) {
		return repo.findById(id).get();
	}
	
	public TypeAmort add(TypeAmort typeAmort) {
		return repo.save(typeAmort);
	}
	
	public TypeAmort edit(Long id, TypeAmort typeAmort) {
		
		if(repo.existsById(id)) {
			TypeAmort entiter = repo.getOne(id);
			
			entiter.setLibTypAmo(typeAmort.getLibTypAmo());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
}
