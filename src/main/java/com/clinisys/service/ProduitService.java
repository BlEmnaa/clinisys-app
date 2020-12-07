package com.clinisys.service;

import java.util.Collection;

import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinisys.entities.Acheter;
import com.clinisys.entities.Fournisseur;
import com.clinisys.entities.Produit;
import com.clinisys.repositories.ProduitRepository;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private FournisseurService fournisseurService;
    
    public Collection findProduit (Long idProduit) {
    	return produitRepository.findByidProduit(idProduit).getAcheter();
        
    }

    public Produit saveProduit(Produit produit) {
        Produit newProduit = new Produit();
        newProduit.setDesprod(produit.getDesprod());
        newProduit.setCatprod(produit.getCatprod());
        newProduit.getAcheter().addAll((produit.getAcheter()
        		.stream()
                .map(acheter -> {
                    Fournisseur fournisseur = fournisseurService.findFournisseurById(acheter.getFournisseur().getIdFRS());
                    Acheter newAcheter = new Acheter();
                    newAcheter.setFournisseur(fournisseur);
                    newAcheter.setProduit(newProduit);
                    newAcheter.setPrixAchat(acheter.getPrixAchat());
                    return newAcheter;
                })
                .collect(Collectors.toList())
        ));
        return produitRepository.save(newProduit);
    }
    
    public Produit findProduitById(Long idProduit) {
        return produitRepository.findByidProduit(idProduit
        		);
    }
}
