package com.jaimetorres.model;

import javax.persistence.*;
@Entity
@Table(name = "tipo_documento")
public class TipoDocumento {
	
	@Id
	@SequenceGenerator(name = "TipoDocumento.sequence", sequenceName = "tipo_documento_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TipoDocumento.sequence")	
	@Column(name = "tipo_doc")
	private String valor;
	
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "empresas")
	private String empresas;
	
	

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmpresas() {
		return empresas;
	}

	public void setEmpresas(String empresas) {
		this.empresas = empresas;
	}
	
	

	
	

}
