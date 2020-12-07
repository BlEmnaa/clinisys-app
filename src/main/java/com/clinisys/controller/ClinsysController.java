package com.clinisys.controller;

import java.util.ArrayList;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.clinisys.dtos.FournisseurDto;
import com.clinisys.dtos.ProduitDto;
import com.clinisys.entities.Fournisseur;
import com.clinisys.entities.Produit;
import com.clinisys.repositories.FournisseurRepository;
import com.clinisys.repositories.ProduitRepository;
import com.clinisys.service.ProduitService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ClinsysController {
	

	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	FournisseurRepository fournisseurRepository;
	
	
    @Autowired
    private ProduitService produitService;

	@GetMapping("products/getAll")
	 public List<ProduitDto> getAllProducts() {
	    System.out.println(" la liste de tous les produits...");
	 
	    List<ProduitDto> products = new ArrayList<>();
	    produitRepository.findAll().forEach(product -> products.add(new ProduitDto(product.getIdProduit(),product.getDesprod(),product.getCatprod())) );
	 
	    return products;
	  }
	
	@GetMapping("providers/getAll")
	public List<FournisseurDto> getAllProviders() {
		System.out.println(" la liste de tous les fournisseurs...");
		
		List<FournisseurDto> providers = new ArrayList<>();
		fournisseurRepository.findAll().forEach(provider-> providers.add(new FournisseurDto(provider.getIdFRS(),provider.getNomFRS(),provider.getVillFRS())));
		return providers;
	}
	
//	@GetMapping("products/getByProductID/{id_produit}")
//	public Produit getByProductId(@PathVariable("id_produit") long idProduit) {
//		return produitRepository.findByidProduit(idProduit);
//	}
	
	@GetMapping("products/getProductByProductID/{id_produit}")
	public List<LinkedHashMap<String,String>> getProductById(@PathVariable("id_produit") long idProduit) {
		System.out.println("la liste des fournisseurs et les prix ...");
		return produitService.findProduit(idProduit);
	}
	
    @PostMapping("products/addProduct")
    public ResponseEntity<?> saveProduit(@RequestBody Produit produit) {
        return new ResponseEntity<>(produitService.saveProduit(produit), HttpStatus.CREATED);
    }
}
