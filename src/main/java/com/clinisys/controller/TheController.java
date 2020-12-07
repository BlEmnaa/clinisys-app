package com.clinisys.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clinisys.entities.Fournisseur;
import com.clinisys.entities.Produit;
import com.clinisys.repositories.FournisseurRepository;
import com.clinisys.repositories.ProduitRepository;
import com.clinisys.service.ProduitService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TheController {
	

	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	FournisseurRepository fournisseurRepository;
	
	
    @Autowired
    private ProduitService produitService;

	@GetMapping("products/getAll")
	 public List<Produit> getAllProducts() {
	    System.out.println(" la liste de tous les produits...");
	 
	    List<Produit> products = new ArrayList<>();
	    produitRepository.findAll().forEach(products::add);
	 
	    return products;
	  }
	
	@GetMapping("providers/getAll")
	public List<Fournisseur> getAllProviders() {
		System.out.println(" la liste de tous les fournisseurs...");
		
		List<Fournisseur> providers = new ArrayList<>();
		fournisseurRepository.findAll().forEach(providers::add);
		return providers;
	}
	
	@GetMapping("products/getByProductID/{id_produit}")
	public Produit getByProductId(@PathVariable("id_produit") long idProduit) {
		return produitRepository.findByidProduit(idProduit);
	}
	
	@GetMapping("products/getProductByProductID/{id_produit}")
	public Collection getProductById(@PathVariable("id_produit") long idProduit) {
		System.out.println("la liste des fournisseurs et les prix ...");
		return produitService.findProduit(idProduit);
	}
	
    @PostMapping("products/addProduct")
    public ResponseEntity<?> saveProduit(@RequestBody Produit produit) {
        return new ResponseEntity<>(produitService.saveProduit(produit), HttpStatus.CREATED);
    }
}
