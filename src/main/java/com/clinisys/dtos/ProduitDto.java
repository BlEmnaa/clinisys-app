package com.clinisys.dtos;

import java.util.ArrayList;
import java.util.Collection;

import com.clinisys.entities.Acheter;

public class ProduitDto {
	
    public Long idProduit;
    
    public String catprod;
    
    public String desprod;
    
    Collection<Acheter> acheter= new ArrayList<>();
    
    

	public ProduitDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProduitDto(Long idProduit, String catprod, String desprod, Collection<Acheter> acheter) {
		super();
		this.idProduit = idProduit;
		this.catprod = catprod;
		this.desprod = desprod;
		this.acheter = acheter;
	}
	
	

	public ProduitDto(Long idProduit, String catprod, String desprod) {
		super();
		this.idProduit = idProduit;
		this.catprod = catprod;
		this.desprod = desprod;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getCatprod() {
		return catprod;
	}

	public void setCatprod(String catprod) {
		this.catprod = catprod;
	}

	public String getDesprod() {
		return desprod;
	}

	public void setDesprod(String desprod) {
		this.desprod = desprod;
	}

	public Collection<Acheter> getAcheter() {
		return acheter;
	}

	public void setAcheter(Collection<Acheter> acheter) {
		this.acheter = acheter;
	} 
    
    

}
