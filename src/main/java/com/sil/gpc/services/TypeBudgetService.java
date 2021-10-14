package com.sil.gpc.services;

import com.sil.gpc.domains.TypeBudget;
import com.sil.gpc.repositories.TypBdgRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeBudgetService {

        private final TypBdgRepository repo;

    public TypeBudgetService(TypBdgRepository repo) {
        this.repo = repo;
    }

    public List<TypeBudget> getAll(){
            return repo.findAll();
        }

        public TypeBudget getById(Long id) {
            return repo.findById(id).get();
        }

        public TypeBudget add(TypeBudget tBdg) {
            return repo.save(tBdg);
        }

        public TypeBudget edit(Long id, TypeBudget tBdg) {

            if(repo.existsById(id)) {
                TypeBudget entiter = repo.getOne(id);
                entiter.setCodTypBudg(tBdg.getCodTypBudg());
                entiter.setLibTypBudg(tBdg.getLibTypBudg());

                return repo.save(entiter);
            }
            return null;
        }

        public boolean delete (Long id) {
            repo.deleteById(id);
            return !repo.existsById(id);
        }

}
