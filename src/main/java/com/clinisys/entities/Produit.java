package com.clinisys.entities;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

import com.clinisys.entities.Acheter;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idProduit;
    
    public String catprod;
    
    public String desprod;
    
    @OneToMany(mappedBy="produit",cascade=CascadeType.ALL)
    Collection<Acheter> acheter= new ArrayList<>(); ;



	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesprod() {
		return desprod;
	}

	public void setDesprod(String desprod) {
		this.desprod = desprod;
	}

	public String getCatprod() {
		return catprod;
	}

	public void setCatprod(String catprod) {
		this.catprod = catprod;
	}

	public Collection<Acheter> getAcheter() {
		return acheter;
	}

	public void setAcheter(Collection<Acheter> acheter) {
		this.acheter = acheter;
	}


    
}
