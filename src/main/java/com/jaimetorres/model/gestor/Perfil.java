package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "perfil")
public class Perfil implements Serializable{
	


	private static final long serialVersionUID = -7000204128201892625L;

	@Id	
	@SequenceGenerator(name = "Perfil.sequence", sequenceName = "perfil_id_perfil_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Perfil.sequence")	
	@Column(name = "id_perfil")
	private Integer idPerfil;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "cod_perfil")
	private String codPerfil;

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}

	
	
	
	

}
