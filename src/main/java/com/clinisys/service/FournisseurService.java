package com.clinisys.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.clinisys.entities.Fournisseur;
import com.clinisys.repositories.FournisseurRepository;

@Service
public class FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    public Fournisseur findFournisseurById(Long idFRS) {
        return fournisseurRepository.findByidFRS(idFRS);
    }
}
