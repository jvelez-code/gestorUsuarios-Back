package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "ciclo_de_vida")
public class CicloDeVida implements Serializable {	

	private static final long serialVersionUID = -3959169846310148995L;

	@Id
	@Column(name = "id_ciclo")
	private Integer idCiclo;	
	
	@Column(name = "nombre")
	private String nombre;
	
//	@OneToMany(mappedBy = "cicloVida", cascade = { CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<SeguimientoCicloVida> listaSeguimiento;

	public CicloDeVida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CicloDeVida(Integer idCiclo, String nombre, List<SeguimientoCicloVida> listaSeguimiento) {
		super();
		this.idCiclo = idCiclo;
		this.nombre = nombre;
	}

	public Integer getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(Integer idCiclo) {
		this.idCiclo = idCiclo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
