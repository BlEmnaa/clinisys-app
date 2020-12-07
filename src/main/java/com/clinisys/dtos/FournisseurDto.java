package com.clinisys.dtos;

import java.util.ArrayList;
import java.util.Collection;

import com.clinisys.entities.Acheter;

public class FournisseurDto {
	 public Long idFRS;

	 public String nomFRS;
	    
	 public String villFRS;
	 
	 Collection<Acheter> acheter = new ArrayList<>();

	public FournisseurDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FournisseurDto(Long idFRS, String nomFRS, String villFRS, Collection<Acheter> acheter) {
		super();
		this.idFRS = idFRS;
		this.nomFRS = nomFRS;
		this.villFRS = villFRS;
		this.acheter = acheter;
	}

	public FournisseurDto(Long idFRS, String nomFRS, String villFRS) {
		super();
		this.idFRS = idFRS;
		this.nomFRS = nomFRS;
		this.villFRS = villFRS;
	}

	public Long getIdFRS() {
		return idFRS;
	}

	public void setIdFRS(Long idFRS) {
		this.idFRS = idFRS;
	}

	public String getNomFRS() {
		return nomFRS;
	}

	public void setNomFRS(String nomFRS) {
		this.nomFRS = nomFRS;
	}

	public String getVillFRS() {
		return villFRS;
	}

	public void setVillFRS(String villFRS) {
		this.villFRS = villFRS;
	}

	public Collection<Acheter> getAcheter() {
		return acheter;
	}

	public void setAcheter(Collection<Acheter> acheter) {
		this.acheter = acheter;
	}
	 
	 



}
