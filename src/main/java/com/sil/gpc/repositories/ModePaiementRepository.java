package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.ModePaiement;

@Repository
public interface ModePaiementRepository extends JpaRepository<ModePaiement, String>{

	List<ModePaiement> findByLibeModPay(String libeModPay);
	List<ModePaiement> findByCodeModPay(String codeModPay);
}
