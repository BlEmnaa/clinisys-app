package com.clinisys.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.clinisys.entities.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

	List<Produit> findAll();
	Produit findByidProduit(Long idProduit);
}
