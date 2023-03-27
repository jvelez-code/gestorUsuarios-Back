package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name = "tipo_documento")
public class TipoDocumento implements Serializable {
	
	private static final long serialVersionUID = 1169207976147876168L;

	@Id
	@SequenceGenerator(name = "TipoDocumento.sequence", sequenceName = "tipo_documento_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TipoDocumento.sequence")	
	@Column(name = "tipo_doc")
	private String tipoDoc;	
	
	@Column(name = "id")
	private Integer id;	
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "empresas")
	private String empresas;	


	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
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
