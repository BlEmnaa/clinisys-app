package com.clinisys.entities;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;
import com.clinisys.entities.Acheter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idFRS;

    public String nomFRS;
    
    public String villFRS;

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL)
    @JsonIgnore
    Collection<Acheter> acheter = new ArrayList<>();


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
