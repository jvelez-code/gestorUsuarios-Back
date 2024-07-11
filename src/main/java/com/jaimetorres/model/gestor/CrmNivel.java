package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "crm_nivel")
public class CrmNivel implements Serializable {
	

	private static final long serialVersionUID = -6634462048218341113L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_nivel")
	private Integer idNivel;	

    @Column(name = "nombre_nivel", length = 32, nullable = false)
	private String nombreNivel;

	public Integer getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public String getNombreNivel() {
		return nombreNivel;
	}

	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}

	

    

}
