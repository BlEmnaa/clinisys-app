package com.clinisys.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    
    public List<LinkedHashMap<String,String>> findProduit (Long idProduit) {
    	List<LinkedHashMap<String,String>> data = new ArrayList<>();
    	 produitRepository.findByidProduit(idProduit).getAcheter().forEach(element-> {
    		LinkedHashMap<String,String> map=new LinkedHashMap();
    		map.put("Fournisseur",element.getFournisseur().getNomFRS());
    		map.put("Prix",element.getPrixAchat());
    		data.add(map);
 
    	});;
    	 return data;
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
