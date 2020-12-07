package com.clinisys.entities;

import javax.persistence.*;

import com.clinisys.entities.AcheterKey;
import com.clinisys.entities.Fournisseur;
import com.clinisys.entities.Produit;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Acheter")
public class Acheter {

	@EmbeddedId
	AcheterKey acheterKey = new AcheterKey();
	
	@ManyToOne
	@MapsId("idProduit")
    @JoinColumn(name ="id_produit")
	@JsonIgnore
	Produit produit;
	
	@ManyToOne
	@MapsId("idFrs")
    @JoinColumn(name ="id_frs")
	Fournisseur fournisseur;
	
	public String prixAchat;

	public AcheterKey getAcheterKey() {
		return acheterKey;
	}

	public void setAcheterKey(AcheterKey acheterKey) {
		this.acheterKey = acheterKey;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public String getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(String prixAchat) {
		this.prixAchat = prixAchat;
	}

	
	
}
