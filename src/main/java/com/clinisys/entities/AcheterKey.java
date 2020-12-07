package com.clinisys.entities;

import java.io.Serializable;


import javax.persistence.*;

@Embeddable
public class AcheterKey implements Serializable {
	
    @Column(name = "id_produit")
    Long idProduit;

    @Column(name = "id_frs")
    Long idFrs;

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public Long getIdFrs() {
		return idFrs;
	}

	public void setIdFrs(Long idFrs) {
		this.idFrs = idFrs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFrs == null) ? 0 : idFrs.hashCode());
		result = prime * result + ((idProduit == null) ? 0 : idProduit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcheterKey other = (AcheterKey) obj;
		if (idFrs == null) {
			if (other.idFrs != null)
				return false;
		} else if (!idFrs.equals(other.idFrs))
			return false;
		if (idProduit == null) {
			if (other.idProduit != null)
				return false;
		} else if (!idProduit.equals(other.idProduit))
			return false;
		return true;
	}

}
