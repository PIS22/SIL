package com.sil.gpc.services;

import com.sil.gpc.domains.LigneBudgetaire;
import com.sil.gpc.domains.TypeBudget;
import com.sil.gpc.repositories.LigneBudgetRepository;
import com.sil.gpc.repositories.TypBdgRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneBudgetaireService {

    private final LigneBudgetRepository repo;

    public LigneBudgetaireService(LigneBudgetRepository repo) {
        this.repo = repo;
    }

    public List<LigneBudgetaire> getAll(){
        return repo.findAll();
    }

    public LigneBudgetaire getById(Long id) {
        return repo.findById(id).get();
    }

    public LigneBudgetaire add(LigneBudgetaire lBdg) {
        return repo.save(lBdg);
    }

    public LigneBudgetaire edit(Long id, LigneBudgetaire lBdg) {

        if(repo.existsById(id)) {
            LigneBudgetaire entiter = repo.getOne(id);
            entiter.setCredit(lBdg.getCredit());
            entiter.setDebit(lBdg.getCredit());
            entiter.setBdg(lBdg.getBdg());
            entiter.setCpte(lBdg.getCpte());

            return repo.save(entiter);
        }
        return null;
    }

    public boolean delete (Long id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }
}
