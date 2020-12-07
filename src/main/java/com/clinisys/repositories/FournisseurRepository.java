package com.clinisys.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.clinisys.entities.Fournisseur;


public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {
	
	List<Fournisseur> findAll();
	
	Fournisseur findByidFRS(Long idFRS) ;

}
